package org.mybatis.reverseGenerator.annotation;


import com.lixin.db.index.IndexMethod;
import com.lixin.db.index.IndexType;

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
    String keyName() default "";


    IndexType indexType() default IndexType.NULL;
    IndexMethod indexMethod() default IndexMethod.NULL;

    String remark() default "";

    String column() default "";


}
