package org.mybatis.generator.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.generator.domain.Groupchatmessage;
import org.mybatis.generator.domain.GroupchatmessageExample;

public interface GroupchatmessageMapper {
    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    long countByExample(GroupchatmessageExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int deleteByExample(GroupchatmessageExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int insert(Groupchatmessage record);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int insertSelective(Groupchatmessage record);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    List<Groupchatmessage> selectByExampleWithBLOBs(GroupchatmessageExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    List<Groupchatmessage> selectByExample(GroupchatmessageExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    Groupchatmessage selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByExampleSelective(@Param("record") Groupchatmessage record, @Param("example") GroupchatmessageExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByExampleWithBLOBs(@Param("record") Groupchatmessage record, @Param("example") GroupchatmessageExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByExample(@Param("record") Groupchatmessage record, @Param("example") GroupchatmessageExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByPrimaryKeySelective(Groupchatmessage record);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByPrimaryKeyWithBLOBs(Groupchatmessage record);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByPrimaryKey(Groupchatmessage record);
}