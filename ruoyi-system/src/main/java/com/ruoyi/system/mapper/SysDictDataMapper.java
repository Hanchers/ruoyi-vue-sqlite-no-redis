package com.ruoyi.system.mapper;

import com.mybatisflex.core.BaseMapper;
import com.ruoyi.common.core.domain.entity.SysDictData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 字典表 数据层
 *
 * @author ruoyi
 */
public interface SysDictDataMapper extends BaseMapper<SysDictData> {

    /**
     * 根据条件分页查询字典数据
     *
     * @param dictData 字典数据信息
     * @return 字典数据集合信息
     */
    List<SysDictData> selectDictDataList(SysDictData dictData);

    /**
     * 根据字典类型查询字典数据
     *
     * @param dictType 字典类型
     * @return 字典数据集合信息
     */
    List<SysDictData> selectDictDataByType(String dictType);

    /**
     * 根据字典类型和字典键值查询字典数据信息
     *
     * @param dictType 字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    String selectDictLabel(@Param("dictType") String dictType, @Param("dictValue") String dictValue);

    /**
     * 查询字典数据
     *
     * @param dictType 字典类型
     * @return 字典数据
     */
    int countDictDataByType(String dictType);

    /**
     * 同步修改字典类型
     *
     * @param oldDictType 旧字典类型
     * @param newDictType 新旧字典类型
     * @return 结果
     */
    int updateDictDataType(@Param("oldDictType") String oldDictType, @Param("newDictType") String newDictType);
}
