package org.dbc.admin.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: ray, liu.
 * @Date: 2018/10/10 17:08
 * <p>基于mysql
 */
@Transactional(readOnly = false)
public interface BaseCrudService<T, ID> {

    /**
     * 主键查询entity
     **/
    T selectByPrimaryKey(ID id);

    /**
     * 主键删除entity
     **/
    int deleteByPrimaryKey(ID id);

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
     * 修 改entity（匹配有值的字段）
     **/
    int updateByPrimaryKeySelective(T t);

    /**
     * 修 改entity全修改
     **/
    int updateByPrimaryKey(T t);

}
