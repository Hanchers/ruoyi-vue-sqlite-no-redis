package com.ruoyi.framework.config.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Date <-> yyyy-MM-dd HH:mm:ss 字符串 类型转换器
 * <p>
 * 解决 SQLite 不支持日期类型，Java Date 被存储为时间戳整型的问题。
 * 将 Date 在读写数据库时自动转为 "yyyy-MM-dd HH:mm:ss" 格式字符串，
 * 使 SQLite 的 strftime 等函数可以正常使用。
 *
 * @author ruoyi
 */
@MappedTypes(Date.class)
public class DateStringTypeHandler extends BaseTypeHandler<Date> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, format(parameter));
    }

    @Override
    public Date getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return parse(rs.getString(columnName));
    }

    @Override
    public Date getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return parse(rs.getString(columnIndex));
    }

    @Override
    public Date getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return parse(cs.getString(columnIndex));
    }

    private String format(Date date) {
        if (date == null) {
            return null;
        }
        LocalDateTime ldt = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return ldt.format(FORMATTER);
    }

    private Date parse(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }
        try {
            // 兼容整数时间戳（旧数据）
            if (value.matches("^\\d+$")) {
                long timestamp = Long.parseLong(value);
                // 秒级时间戳（10位）
                if (value.length() <= 10) {
                    return new Date(timestamp * 1000);
                }
                // 毫秒级时间戳（13位）
                return new Date(timestamp);
            }
            LocalDateTime ldt = LocalDateTime.parse(value, FORMATTER);
            return Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
        } catch (Exception e) {
            return null;
        }
    }
}
