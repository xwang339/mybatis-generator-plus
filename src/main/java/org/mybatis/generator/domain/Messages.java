package org.mybatis.generator.domain;

import java.io.Serializable;
import java.util.Date;
import org.mybatis.mybatisGenerator.annotation.ColumnGeneratorDoc;
import org.mybatis.mybatisGenerator.annotation.TableGeneratorDoc;

/**
 * Database Table Remarks:消息表
 * table name:messages
 * @author lixin
 * @date 2024-03-06 18:10:37
 * modelBaseRecordClassGenerated
 */
@TableGeneratorDoc(remark = "消息表",name = "messages")
public class Messages implements Serializable {
    /**
     * Database Column Remarks:消息ID
     * Actual Column Name: id, JDBC Type: 4, Nullable: false, Length: 10, Scale: 0, Identity: true
     * this column typeName: INTEGER
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    @ColumnGeneratorDoc(typeName = "INTEGER",name = "id", jdbcType = 4, isNull = false, length = 10, Scale = 0, Identity = true, type = 1, remark = "消息ID",isPrimaryKey = true,isAuto = false)
    private Integer id;

    /**
     * Database Column Remarks:发送者ID
     * Actual Column Name: sender_id, JDBC Type: 4, Nullable: false, Length: 10, Scale: 0, Identity: false
     * this column typeName: INTEGER
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    @ColumnGeneratorDoc(typeName = "INTEGER",name = "sender_id", jdbcType = 4, isNull = false, length = 10, Scale = 0, Identity = false, type = 1, remark = "发送者ID")
    private Integer senderId;

    /**
     * Database Column Remarks:接收者ID
     * Actual Column Name: recipient_id, JDBC Type: 4, Nullable: false, Length: 10, Scale: 0, Identity: false
     * this column typeName: INTEGER
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    @ColumnGeneratorDoc(typeName = "INTEGER",name = "recipient_id", jdbcType = 4, isNull = false, length = 10, Scale = 0, Identity = false, type = 1, remark = "接收者ID")
    private Integer recipientId;

    /**
     * Database Column Remarks:消息类型: 1-文本, 2-图片, 3-音频, 4-视频, ...
     * Actual Column Name: message_type, JDBC Type: -6, Nullable: false, Length: 3, Scale: 0, Identity: false
     * this column typeName: TINYINT
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    @ColumnGeneratorDoc(typeName = "TINYINT",name = "message_type", jdbcType = -6, isNull = false, length = 3, Scale = 0, Identity = false, type = 1, remark = "消息类型: 1-文本, 2-图片, 3-音频, 4-视频, ...")
    private Byte messageType;

    /**
     * Database Column Remarks:消息内容
     * Actual Column Name: content, JDBC Type: 12, Nullable: false, Length: 255, Scale: 0, Identity: false
     * this column typeName: VARCHAR
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    @ColumnGeneratorDoc(typeName = "VARCHAR",name = "content", jdbcType = 12, isNull = false, length = 255, Scale = 0, Identity = false, type = 1, remark = "消息内容")
    private String content;

    /**
     * Database Column Remarks:发送时间戳
     * Actual Column Name: timestamp, JDBC Type: 93, Nullable: false, Length: 19, Scale: 0, Identity: false
     * this column typeName: TIMESTAMP
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    @ColumnGeneratorDoc(typeName = "TIMESTAMP",name = "timestamp", jdbcType = 93, isNull = false, length = 19, Scale = 0, Identity = false, type = 1, remark = "发送时间戳")
    private Date timestamp;

    /**
     * Database Column Remarks:是否已归档
     * Actual Column Name: is_archived, JDBC Type: -7, Nullable: false, Length: 1, Scale: 0, Identity: false
     * this column typeName: BIT
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    @ColumnGeneratorDoc(typeName = "BIT",name = "is_archived", jdbcType = -7, isNull = false, length = 1, Scale = 0, Identity = false, type = 1, remark = "是否已归档")
    private Boolean isArchived;

    /**
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column messages.id
     *
     * @return the value of messages.id
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column messages.id
     *
     * @param id the value for messages.id
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column messages.sender_id
     *
     * @return the value of messages.sender_id
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    public Integer getSenderId() {
        return senderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column messages.sender_id
     *
     * @param senderId the value for messages.sender_id
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column messages.recipient_id
     *
     * @return the value of messages.recipient_id
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    public Integer getRecipientId() {
        return recipientId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column messages.recipient_id
     *
     * @param recipientId the value for messages.recipient_id
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    public void setRecipientId(Integer recipientId) {
        this.recipientId = recipientId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column messages.message_type
     *
     * @return the value of messages.message_type
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    public Byte getMessageType() {
        return messageType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column messages.message_type
     *
     * @param messageType the value for messages.message_type
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    public void setMessageType(Byte messageType) {
        this.messageType = messageType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column messages.content
     *
     * @return the value of messages.content
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column messages.content
     *
     * @param content the value for messages.content
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column messages.timestamp
     *
     * @return the value of messages.timestamp
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column messages.timestamp
     *
     * @param timestamp the value for messages.timestamp
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column messages.is_archived
     *
     * @return the value of messages.is_archived
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    public Boolean getIsArchived() {
        return isArchived;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column messages.is_archived
     *
     * @param isArchived the value for messages.is_archived
     *
     * @mbg.generated 2024-03-06 18:10:37
     */
    public void setIsArchived(Boolean isArchived) {
        this.isArchived = isArchived;
    }
}