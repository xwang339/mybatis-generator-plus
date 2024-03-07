package org.mybatis.generator.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.generator.domain.Friendships;
import org.mybatis.generator.domain.FriendshipsExample;

public interface FriendshipsMapper {
    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    long countByExample(FriendshipsExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int deleteByExample(FriendshipsExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int deleteByPrimaryKey(Integer friendshipId);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int insert(Friendships record);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int insertSelective(Friendships record);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    List<Friendships> selectByExample(FriendshipsExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    Friendships selectByPrimaryKey(Integer friendshipId);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByExampleSelective(@Param("record") Friendships record, @Param("example") FriendshipsExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByExample(@Param("record") Friendships record, @Param("example") FriendshipsExample example);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByPrimaryKeySelective(Friendships record);

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    int updateByPrimaryKey(Friendships record);
}