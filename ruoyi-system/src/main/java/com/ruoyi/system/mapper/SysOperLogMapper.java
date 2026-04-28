package com.ruoyi.system.mapper;

import com.mybatisflex.core.BaseMapper;
import com.ruoyi.system.domain.SysOperLog;

import java.util.List;

/**
 * 操作日志 数据层
 *
 * @author ruoyi
 */
public interface SysOperLogMapper extends BaseMapper<SysOperLog> {

    /**
     * 查询系统操作日志集合
     *
     * @param operLog 操作日志对象
     * @return 操作日志集合
     */
    List<SysOperLog> selectOperLogList(SysOperLog operLog);


    void cleanOperLog();
}
