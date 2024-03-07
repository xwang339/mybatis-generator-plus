package org.mybatis.generator.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.generator.domain.Groupmember;
import org.mybatis.generator.domain.GroupmemberExample;

public interface GroupmemberMapper {
    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    long countByExample(GroupmemberExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int deleteByExample(GroupmemberExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int insert(Groupmember record);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int insertSelective(Groupmember record);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    List<Groupmember> selectByExample(GroupmemberExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    Groupmember selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByExampleSelective(@Param("record") Groupmember record, @Param("example") GroupmemberExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByExample(@Param("record") Groupmember record, @Param("example") GroupmemberExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByPrimaryKeySelective(Groupmember record);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByPrimaryKey(Groupmember record);
}