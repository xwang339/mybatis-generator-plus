package org.mybatis.generator.domain;

import java.io.Serializable;
import java.util.Date;
import org.mybatis.mybatisGenerator.annotation.ColumnGeneratorDoc;
import org.mybatis.mybatisGenerator.annotation.TableGeneratorDoc;

/**
 * Database Table Remarks:群组信息表
 * table name:group_info
 * @author lixin
 * @date 2024-03-06 18:10:37
 * modelBaseRecordClassGenerated
 */
@TableGeneratorDoc(remark = "群组信息表",name = "group_info")
public class Groupinfo implements Serializable {
    /**
     * Database Column Remarks:群组ID，主键
     * Actual Column Name: group_id, JDBC Type: 4, Nullable: false, Length: 10, Scale: 0, Identity: false
     * this column typeName: INTEGER
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    @ColumnGeneratorDoc(typeName = "INTEGER",name = "group_id", jdbcType = 4, isNull = false, length = 10, Scale = 0, Identity = false, type = 1, remark = "群组ID，主键",isPrimaryKey = true,isAuto = true)
    private Integer groupId;

    /**
     * Database Column Remarks:群组名称
     * Actual Column Name: group_name, JDBC Type: 12, Nullable: false, Length: 100, Scale: 0, Identity: false
     * this column typeName: VARCHAR
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    @ColumnGeneratorDoc(typeName = "VARCHAR",name = "group_name", jdbcType = 12, isNull = false, length = 100, Scale = 0, Identity = false, type = 1, remark = "群组名称")
    private String groupName;

    /**
     * Database Column Remarks:群组创建者的用户ID
     * Actual Column Name: created_by, JDBC Type: 4, Nullable: false, Length: 10, Scale: 0, Identity: false
     * this column typeName: INTEGER
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    @ColumnGeneratorDoc(typeName = "INTEGER",name = "created_by", jdbcType = 4, isNull = false, length = 10, Scale = 0, Identity = false, type = 1, remark = "群组创建者的用户ID")
    private Integer createdBy;

    /**
     * Database Column Remarks:群组创建时间
     * Actual Column Name: created_at, JDBC Type: 93, Nullable: true, Length: 19, Scale: 0, Identity: false
     * this column typeName: TIMESTAMP
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    @ColumnGeneratorDoc(typeName = "TIMESTAMP",name = "created_at", jdbcType = 93, isNull = true, length = 19, Scale = 0, Identity = false, type = 1, remark = "群组创建时间")
    private Date createdAt;

    /**
     * Database Column Remarks:群组描述
     * Actual Column Name: description, JDBC Type: -1, Nullable: true, Length: 65535, Scale: 0, Identity: false
     * this column typeName: LONGVARCHAR
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    @ColumnGeneratorDoc(typeName = "LONGVARCHAR",name = "description", jdbcType = -1, isNull = true, length = 65535, Scale = 0, Identity = false, type = 1, remark = "群组描述")
    private String description;

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column group_info.group_id
     *
     * @return the value of group_info.group_id
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column group_info.group_id
     *
     * @param groupId the value for group_info.group_id
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column group_info.group_name
     *
     * @return the value of group_info.group_name
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column group_info.group_name
     *
     * @param groupName the value for group_info.group_name
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column group_info.created_by
     *
     * @return the value of group_info.created_by
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    public Integer getCreatedBy() {
        return createdBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column group_info.created_by
     *
     * @param createdBy the value for group_info.created_by
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column group_info.created_at
     *
     * @return the value of group_info.created_at
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column group_info.created_at
     *
     * @param createdAt the value for group_info.created_at
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column group_info.description
     *
     * @return the value of group_info.description
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column group_info.description
     *
     * @param description the value for group_info.description
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}