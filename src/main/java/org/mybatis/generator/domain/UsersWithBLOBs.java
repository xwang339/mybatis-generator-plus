package org.mybatis.generator.domain;

import java.io.Serializable;
import org.mybatis.mybatisGenerator.annotation.ColumnGeneratorDoc;

/**
 * Database Table Remarks:用于存储用户的基本信息
 * table name:Users
 * @author lixin
 * @date 2024-03-07 17:22:11
 * modelRecordWithBLOBsClassGenerated
 */
public class UsersWithBLOBs extends Users implements Serializable {
    /**
     * Actual Column Name: blob_test, JDBC Type: -4, Nullable: false, Length: 65535, Scale: 0, Identity: false
     * this column typeName: LONGVARBINARY
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    @ColumnGeneratorDoc(typeName = "LONGVARBINARY",name = "blob_test", jdbcType = -4, isNull = false, length = 65535, Scale = 0, Identity = false, type = 1, remark = "")
    private byte[] blobTest;

    /**
     * Actual Column Name: text_test, JDBC Type: -1, Nullable: true, Length: 65535, Scale: 0, Identity: false
     * this column typeName: LONGVARCHAR
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    @ColumnGeneratorDoc(typeName = "LONGVARCHAR",name = "text_test", jdbcType = -1, isNull = true, length = 65535, Scale = 0, Identity = false, type = 1, remark = "")
    private String textTest;

    /**
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Users.blob_test
     *
     * @return the value of Users.blob_test
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    public byte[] getBlobTest() {
        return blobTest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Users.blob_test
     *
     * @param blobTest the value for Users.blob_test
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    public void setBlobTest(byte[] blobTest) {
        this.blobTest = blobTest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Users.text_test
     *
     * @return the value of Users.text_test
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    public String getTextTest() {
        return textTest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Users.text_test
     *
     * @param textTest the value for Users.text_test
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    public void setTextTest(String textTest) {
        this.textTest = textTest == null ? null : textTest.trim();
    }
}