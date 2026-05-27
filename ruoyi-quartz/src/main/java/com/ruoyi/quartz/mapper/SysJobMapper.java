package com.ruoyi.quartz.mapper;

import com.mybatisflex.core.BaseMapper;
import com.ruoyi.quartz.domain.SysJob;

import java.util.List;

/**
 * 调度任务信息 数据层
 * 
 * @author ruoyi
 */
public interface SysJobMapper extends BaseMapper<SysJob>
{
    /**
     * 查询调度任务日志集合
     * 
     * @param job 调度信息
     * @return 操作日志集合
     */
    public List<SysJob> selectJobList(SysJob job);

}
