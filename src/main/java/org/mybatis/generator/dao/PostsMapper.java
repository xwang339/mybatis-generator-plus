package org.mybatis.generator.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.generator.domain.Posts;
import org.mybatis.generator.domain.PostsExample;

public interface PostsMapper {
    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    long countByExample(PostsExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int deleteByExample(PostsExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int deleteByPrimaryKey(Integer postId);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int insert(Posts record);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int insertSelective(Posts record);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    List<Posts> selectByExampleWithBLOBs(PostsExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    List<Posts> selectByExample(PostsExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    Posts selectByPrimaryKey(Integer postId);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByExampleSelective(@Param("record") Posts record, @Param("example") PostsExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByExampleWithBLOBs(@Param("record") Posts record, @Param("example") PostsExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByExample(@Param("record") Posts record, @Param("example") PostsExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByPrimaryKeySelective(Posts record);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByPrimaryKeyWithBLOBs(Posts record);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByPrimaryKey(Posts record);
}