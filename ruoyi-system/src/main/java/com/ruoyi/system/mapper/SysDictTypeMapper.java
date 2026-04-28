package com.ruoyi.system.mapper;

import com.mybatisflex.core.BaseMapper;
import com.ruoyi.common.core.domain.entity.SysDictType;

import java.util.List;

/**
 * 字典表 数据层
 *
 * @author ruoyi
 */
public interface SysDictTypeMapper extends BaseMapper<SysDictType> {

    /**
     * 根据条件分页查询字典类型
     *
     * @param dictType 字典类型信息
     * @return 字典类型集合信息
     */
    List<SysDictType> selectDictTypeList(SysDictType dictType);

    /**
     * 查询所有字典类型
     *
     * @return 字典类型集合信息
     */
    List<SysDictType> selectDictTypeAll();

    /**
     * 根据字典类型查询信息
     *
     * @param dictType 字典类型
     * @return 字典类型
     */
    SysDictType selectDictTypeByType(String dictType);

    /**
     * 校验字典类型称是否唯一
     *
     * @param dictType 字典类型
     * @return 结果
     */
    SysDictType checkDictTypeUnique(String dictType);
}
