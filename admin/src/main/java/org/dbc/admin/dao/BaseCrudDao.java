package org.dbc.admin.dao;

import java.io.Serializable;

/**
 * @Author: ray, liu.
 * @Date: 2018/10/9 15:17
 * <p> mysql basic operation.
 */
public interface BaseCrudDao<T, ID extends Serializable> extends Serializable {

    /**
     * 添加entity 返回记录条数
     **/
    int insert(T t);

    /**
     * 添加entity 返回主键Id
     **/
    ID insertGetId(T t);

    /**
     * 添加entity 返回添加之后的对象
     **/
    T insertGetObject(T t);

    /**
     * 主键查询entity
     **/
    T selectByPrimaryKey(ID id);

    /**
     * 修改entity（匹配有值的字段）
     **/
    int updateByPrimaryKeySelective(T t);

    /**
     * 修 改entity全修改
     **/
    int updateByPrimaryKey(T t);

    /**
     * 主键删除entity
     **/
    int deleteByPrimaryKey(ID id);

}
