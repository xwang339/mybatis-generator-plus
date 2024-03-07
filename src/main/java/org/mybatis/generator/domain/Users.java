package org.mybatis.generator.domain;

import java.io.Serializable;
import java.util.Date;
import org.mybatis.mybatisGenerator.annotation.ColumnGeneratorDoc;
import org.mybatis.mybatisGenerator.annotation.TableGeneratorDoc;

/**
 * Database Table Remarks:用于存储用户的基本信息
 * table name:Users
 * @author lixin
 * @date 2024-03-07 17:22:11
 * modelBaseRecordClassGenerated
 */
@TableGeneratorDoc(remark = "用于存储用户的基本信息",name = "Users")
public class Users implements Serializable {
    /**
     * Database Column Remarks:用户唯一标识符（主键）
     * Actual Column Name: user_id, JDBC Type: 4, Nullable: false, Length: 10, Scale: 0, Identity: false
     * this column typeName: INTEGER
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    @ColumnGeneratorDoc(typeName = "INTEGER",name = "user_id", jdbcType = 4, isNull = false, length = 10, Scale = 0, Identity = false, type = 1, remark = "用户唯一标识符（主键）",isPrimaryKey = true,isAuto = true)
    private Integer userId;

    /**
     * Database Column Remarks:用户名
     * Actual Column Name: username, JDBC Type: 12, Nullable: false, Length: 50, Scale: 0, Identity: false
     * this column typeName: VARCHAR
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    @ColumnGeneratorDoc(typeName = "VARCHAR",name = "username", jdbcType = 12, isNull = false, length = 50, Scale = 0, Identity = false, type = 1, remark = "用户名")
    private String username;

    /**
     * Database Column Remarks:电子邮箱
     * Actual Column Name: email, JDBC Type: 12, Nullable: false, Length: 100, Scale: 0, Identity: false
     * this column typeName: VARCHAR
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    @ColumnGeneratorDoc(typeName = "VARCHAR",name = "email", jdbcType = 12, isNull = false, length = 100, Scale = 0, Identity = false, type = 1, remark = "电子邮箱")
    private String email;

    /**
     * Database Column Remarks:密码（加密存储）
     * Actual Column Name: password, JDBC Type: 12, Nullable: false, Length: 100, Scale: 0, Identity: false
     * this column typeName: VARCHAR
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    @ColumnGeneratorDoc(typeName = "VARCHAR",name = "password", jdbcType = 12, isNull = false, length = 100, Scale = 0, Identity = false, type = 1, remark = "密码（加密存储）")
    private String password;

    /**
     * Actual Column Name: char_test, JDBC Type: 1, Nullable: true, Length: 0, Scale: 0, Identity: false
     * this column typeName: CHAR
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    @ColumnGeneratorDoc(typeName = "CHAR",name = "char_test", jdbcType = 1, isNull = true, length = 0, Scale = 0, Identity = false, type = 1, remark = "")
    private String charTest;

    /**
     * Actual Column Name: timestamp_test, JDBC Type: 93, Nullable: true, Length: 19, Scale: 0, Identity: false
     * this column typeName: TIMESTAMP
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    @ColumnGeneratorDoc(typeName = "TIMESTAMP",name = "timestamp_test", jdbcType = 93, isNull = true, length = 19, Scale = 0, Identity = false, type = 1, remark = "")
    private Date timestampTest;

    /**
     * Actual Column Name: datetime_test, JDBC Type: 93, Nullable: true, Length: 19, Scale: 0, Identity: false
     * this column typeName: TIMESTAMP
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    @ColumnGeneratorDoc(typeName = "TIMESTAMP",name = "datetime_test", jdbcType = 93, isNull = true, length = 19, Scale = 0, Identity = false, type = 1, remark = "")
    private Date datetimeTest;

    /**
     * Actual Column Name: type, JDBC Type: 12, Nullable: true, Length: 20, Scale: 0, Identity: false
     * this column typeName: VARCHAR
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    @ColumnGeneratorDoc(typeName = "VARCHAR",name = "type", jdbcType = 12, isNull = true, length = 20, Scale = 0, Identity = false, type = 1, remark = "")
    private String type;

    /**
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Users.user_id
     *
     * @return the value of Users.user_id
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Users.user_id
     *
     * @param userId the value for Users.user_id
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Users.username
     *
     * @return the value of Users.username
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Users.username
     *
     * @param username the value for Users.username
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Users.email
     *
     * @return the value of Users.email
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Users.email
     *
     * @param email the value for Users.email
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Users.password
     *
     * @return the value of Users.password
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Users.password
     *
     * @param password the value for Users.password
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Users.char_test
     *
     * @return the value of Users.char_test
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    public String getCharTest() {
        return charTest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Users.char_test
     *
     * @param charTest the value for Users.char_test
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    public void setCharTest(String charTest) {
        this.charTest = charTest == null ? null : charTest.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Users.timestamp_test
     *
     * @return the value of Users.timestamp_test
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    public Date getTimestampTest() {
        return timestampTest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Users.timestamp_test
     *
     * @param timestampTest the value for Users.timestamp_test
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    public void setTimestampTest(Date timestampTest) {
        this.timestampTest = timestampTest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Users.datetime_test
     *
     * @return the value of Users.datetime_test
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    public Date getDatetimeTest() {
        return datetimeTest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Users.datetime_test
     *
     * @param datetimeTest the value for Users.datetime_test
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    public void setDatetimeTest(Date datetimeTest) {
        this.datetimeTest = datetimeTest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Users.type
     *
     * @return the value of Users.type
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Users.type
     *
     * @param type the value for Users.type
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}