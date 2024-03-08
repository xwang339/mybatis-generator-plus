package com.lixin.db.provider;


import com.lixin.db.model.MysqlColumn;

import java.text.SimpleDateFormat;

/**
 * 这个类目前来说好像没用了
 * 现在回去看过去的想法比较幼稚在sql插入这个部分 应该用占位符替代可能更好
 * 当时实现这个功能是基于一个爬虫需求
 * 我们的程序会在不同的页面爬取数据
 * 但是如果每个页面建一个表然后独立的写inset接口的话其实工作还是很繁琐的.
 * 基于上述场景 才产生这样的想法
 * 首先我们会配置每个爬取页面的字段信息 配置的同时会通过配置页面去建这张表
 *
 * 配置完成后会建立页面与表的映射关系
 * 然后在爬取的时候只需要给服务端投递映射关系以及爬取到的数据就可以生成对应的insert语句 进行数据录入
 * 因为投递的形式可能存在excel 或者json等形式 所以实现了两个部分内容 目前来看 这个功能对现在这个项目来说是一个荒废的类
 */
public interface  SqlProvider {

    /**
     * 获取值的方法
     * @param value 值
     * @param type 数据类型
     * @return
     */
    default String getValueString(Object value, int type) {
        if (type == (MysqlColumn.CHAR.getValue()) || type == MysqlColumn.VARCHAR.getValue()) {
            return "'" + value + "'";
        } else if (type == MysqlColumn.TIMESTAMP.getValue()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return "'" + dateFormat.format(value) + "'";
        } else {
            return value.toString();
        }
    }

}
