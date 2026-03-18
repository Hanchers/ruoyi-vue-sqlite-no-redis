package com.ruoyi.system.mapper;

import com.mybatisflex.core.BaseMapper;
import com.ruoyi.system.domain.SysConfig;

import java.util.List;

/**
 * 参数配置 数据层
 *
 * @author ruoyi
 */
public interface SysConfigMapper extends BaseMapper<SysConfig> {

    /**
     * 查询参数配置列表
     *
     * @param config 参数配置信息
     * @return 参数配置集合
     */
    public List<SysConfig> selectConfigList(SysConfig config);

}
