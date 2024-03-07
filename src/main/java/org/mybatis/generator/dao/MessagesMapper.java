package org.mybatis.generator.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.generator.domain.Messages;
import org.mybatis.generator.domain.MessagesExample;

public interface MessagesMapper {
    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    long countByExample(MessagesExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int deleteByExample(MessagesExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int insert(Messages record);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int insertSelective(Messages record);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    List<Messages> selectByExample(MessagesExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    Messages selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByExampleSelective(@Param("record") Messages record, @Param("example") MessagesExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByExample(@Param("record") Messages record, @Param("example") MessagesExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByPrimaryKeySelective(Messages record);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByPrimaryKey(Messages record);
}