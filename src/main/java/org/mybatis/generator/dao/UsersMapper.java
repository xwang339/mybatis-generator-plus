package org.mybatis.generator.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.generator.domain.Users;
import org.mybatis.generator.domain.UsersExample;
import org.mybatis.generator.domain.UsersWithBLOBs;

public interface UsersMapper {
    /**
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    long countByExample(UsersExample example);

    /**
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    int deleteByExample(UsersExample example);

    /**
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    int insert(UsersWithBLOBs record);

    /**
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    int insertSelective(UsersWithBLOBs record);

    /**
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    List<UsersWithBLOBs> selectByExampleWithBLOBs(UsersExample example);

    /**
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    List<Users> selectByExample(UsersExample example);

    /**
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    UsersWithBLOBs selectByPrimaryKey(Integer userId);

    /**
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    int updateByExampleSelective(@Param("record") UsersWithBLOBs record, @Param("example") UsersExample example);

    /**
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    int updateByExampleWithBLOBs(@Param("record") UsersWithBLOBs record, @Param("example") UsersExample example);

    /**
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);

    /**
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    int updateByPrimaryKeySelective(UsersWithBLOBs record);

    /**
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    int updateByPrimaryKeyWithBLOBs(UsersWithBLOBs record);

    /**
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    int updateByPrimaryKey(Users record);
}