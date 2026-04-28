package com.ruoyi.system.mapper;

import com.mybatisflex.core.BaseMapper;
import com.ruoyi.system.domain.SysNotice;

import java.util.List;

/**
 * 通知公告表 数据层
 *
 * @author ruoyi
 */
public interface SysNoticeMapper extends BaseMapper<SysNotice> {

    /**
     * 查询公告列表
     *
     * @param notice 公告信息
     * @return 公告集合
     */
    List<SysNotice> selectNoticeList(SysNotice notice);
}
