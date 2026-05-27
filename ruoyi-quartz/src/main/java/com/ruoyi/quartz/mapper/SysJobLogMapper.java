package com.ruoyi.quartz.mapper;

import com.mybatisflex.core.BaseMapper;
import com.ruoyi.quartz.domain.SysJobLog;

import java.util.List;

/**
 * 调度任务日志信息 数据层
 * 
 * @author ruoyi
 */
public interface SysJobLogMapper extends BaseMapper<SysJobLog>
{
    /**
     * 获取quartz调度器日志的计划任务
     * 
     * @param jobLog 调度日志信息
     * @return 调度任务日志集合
     */
    public List<SysJobLog> selectJobLogList(SysJobLog jobLog);


    /**
     * 清空任务日志
     */
    public void cleanJobLog();
}
