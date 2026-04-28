package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysLogininfor;
import com.mybatisflex.core.BaseMapper;

/**
 * 系统访问日志情况信息 数据层
 *
 * @author ruoyi
 */
public interface SysLogininforMapper extends BaseMapper<SysLogininfor>
{
    /**
     * 查询系统登录日志集合
     *
     * @param logininfor 访问日志对象
     * @return 登录记录集合
     */
    public List<SysLogininfor> selectLogininforList(SysLogininfor logininfor);

    /**
     * 清空系统登录日志
     *
     * @return 结果
     */
    public int cleanLogininfor();
}
