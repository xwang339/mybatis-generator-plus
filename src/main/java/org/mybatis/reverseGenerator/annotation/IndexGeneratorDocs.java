package org.mybatis.reverseGenerator.annotation;

import java.lang.annotation.*;

/**
 * Description:
 * Copyright:   Copyright (c)2024
 * Company:
 *
 * @author: 张李鑫
 * @version: 1.0
 * Create at:   2024-03-08 13:56:07
 * <p>
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2024-03-08     张李鑫                     1.0         1.0 Version
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface IndexGeneratorDocs {
    IndexGeneratorDoc[]value();
}
