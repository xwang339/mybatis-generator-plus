package org.mybatis.generator.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.generator.domain.Groupinfo;
import org.mybatis.generator.domain.GroupinfoExample;

public interface GroupinfoMapper {
    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    long countByExample(GroupinfoExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int deleteByExample(GroupinfoExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int deleteByPrimaryKey(Integer groupId);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int insert(Groupinfo record);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int insertSelective(Groupinfo record);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    List<Groupinfo> selectByExampleWithBLOBs(GroupinfoExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    List<Groupinfo> selectByExample(GroupinfoExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    Groupinfo selectByPrimaryKey(Integer groupId);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByExampleSelective(@Param("record") Groupinfo record, @Param("example") GroupinfoExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByExampleWithBLOBs(@Param("record") Groupinfo record, @Param("example") GroupinfoExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByExample(@Param("record") Groupinfo record, @Param("example") GroupinfoExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByPrimaryKeySelective(Groupinfo record);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByPrimaryKeyWithBLOBs(Groupinfo record);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByPrimaryKey(Groupinfo record);
}