package org.mybatis.generator.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.generator.domain.Likes;
import org.mybatis.generator.domain.LikesExample;

public interface LikesMapper {
    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    long countByExample(LikesExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int deleteByExample(LikesExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int deleteByPrimaryKey(Integer likeId);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int insert(Likes record);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int insertSelective(Likes record);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    List<Likes> selectByExample(LikesExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    Likes selectByPrimaryKey(Integer likeId);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByExampleSelective(@Param("record") Likes record, @Param("example") LikesExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByExample(@Param("record") Likes record, @Param("example") LikesExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByPrimaryKeySelective(Likes record);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByPrimaryKey(Likes record);
}