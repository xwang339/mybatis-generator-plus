package org.mybatis.reverseGenerator.annotation;


import com.lixin.db.model.IndexMethod;
import com.lixin.db.model.IndexType;

import java.lang.annotation.*;

/**
 * 还是决定不自动生成了
 * 暂时只提供这个注解并且通过这个注解进行逆向
 */
@Documented
@Target(ElementType.TYPE)
@Repeatable(IndexGeneratorDocs.class)//指定了IndexGeneratorDocs作为容器注解。
@Retention(RetentionPolicy.RUNTIME)
public @interface IndexGeneratorDoc {
    String indexName() default "";

    IndexType indexType() default IndexType.normal;

    IndexMethod indexMethod() default IndexMethod.BTREE;

//    List<String> columns() ;

    //    private String indexName;
    //    private IndexType indexType;
    //    private IndexMethod indexMethod;
    //    private List<String>columns;
    //    private String remark;


}
