package com.ruoyi.system.domain;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.xss.Xss;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serial;

/**
 * 通知公告表 sys_notice
 *
 * @author ruoyi
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data(staticConstructor = "create")
@Accessors(chain = true)
@Table(value = "sys_notice")
public class SysNotice extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 1L;

    /** 公告ID */
    @Excel(name = "公告序号", cellType = ColumnType.NUMERIC)
    @Id(keyType = KeyType.Auto)
    private Long noticeId;

    /** 公告标题 */
    @Excel(name = "公告标题")
    @Xss(message = "公告标题不能包含脚本字符")
    @NotBlank(message = "公告标题不能为空")
    @Size(min = 0, max = 50, message = "公告标题不能超过50个字符")
    private String noticeTitle;

    /** 公告类型（1通知 2公告） */
    @Excel(name = "公告类型", readConverterExp = "1=通知,2=公告")
    private String noticeType;

    /** 公告内容 */
    private String noticeContent;

    /** 公告状态（0正常 1关闭） */
    @Excel(name = "公告状态", readConverterExp = "0=正常,1=关闭")
    private String status;
}
