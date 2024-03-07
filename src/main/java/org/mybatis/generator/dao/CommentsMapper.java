package org.mybatis.generator.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.generator.domain.Comments;
import org.mybatis.generator.domain.CommentsExample;

public interface CommentsMapper {
    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    long countByExample(CommentsExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int deleteByExample(CommentsExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int deleteByPrimaryKey(Integer commentId);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int insert(Comments record);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int insertSelective(Comments record);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    List<Comments> selectByExampleWithBLOBs(CommentsExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    List<Comments> selectByExample(CommentsExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    Comments selectByPrimaryKey(Integer commentId);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByExampleSelective(@Param("record") Comments record, @Param("example") CommentsExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByExampleWithBLOBs(@Param("record") Comments record, @Param("example") CommentsExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByExample(@Param("record") Comments record, @Param("example") CommentsExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByPrimaryKeySelective(Comments record);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByPrimaryKeyWithBLOBs(Comments record);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByPrimaryKey(Comments record);
}