//package org.dbc.admin.service.impl;
//
//import lombok.Data;
//import org.dbc.admin.dao.BaseCrudDao;
//import org.dbc.admin.domain.BaseEntity;
//import org.dbc.admin.service.BaseCrudService;
//import org.dbc.admin.utils.BaseUtils;
//import org.dbc.admin.utils.CryptAESUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.io.Serializable;
//
///**
// * @Author: ray, liu.
// * @Date: 2018/10/13 01:39
//<p>
// *         抽象类BaseServiceImpl
// **/
//@Data
//public abstract class BaseCrudServiceImpl<Dao extends BaseCrudDao<T, ID>, T extends BaseEntity, ID extends Serializable>
//        implements BaseCrudService<T, ID> {
//
//    /********************************* 自动生成器代码start ******************************************/
//
//    @Autowired
//    private Dao dao;
//
//    /**
//     * 主键查询entity
//     **/
//    @Override
//    public T selectByPrimaryKey(ID id) {
//        return dao.selectByPrimaryKey(id);
//    }
//
//    /**
//     * 主键删除entity
//     **/
//    @Override
//    public int deleteByPrimaryKey(ID id) {
//        return dao.deleteByPrimaryKey(id);
//    }
//
//    /**
//     * 添加entity 返回记录条数
//     **/
//    @Override
//    public int insert(T t) {
//        t.setCreateBy(CryptAESUtils.getInstance().encryption(BaseUtils.getCurrentUser()));
//        return dao.insert(t);
//    }
//
//    /**
//     * 添加entity 返回主键Id
//     **/
//    @Override
//    public ID insertGetId(T t) {
//        t.setCreateBy(CryptAESUtils.getInstance().encryption(BaseUtils.getCurrentUser()));
//        dao.insertGetId(t);
//        return (ID) t.getId();
//    }
//
//    /**
//     * 添加entity 返回添加之后的对象
//     **/
//    @Override
//    public T insertGetObject(T t) {
//        t.setCreateBy(CryptAESUtils.getInstance().encryption(BaseUtils.getCurrentUser()));
//        dao.insertGetId(t);
//        return t;
//    }
//
//    /**
//     * 修 改entity（匹配有值的字段）
//     **/
//    @Override
//    public int updateByPrimaryKeySelective(T t) {
//        t.setModifiedBy(CryptAESUtils.getInstance().encryption(BaseUtils.getCurrentUser()));
//        return dao.updateByPrimaryKeySelective(t);
//    }
//
//    /**
//     * 修 改entity全修改
//     **/
//    @Override
//    public int updateByPrimaryKey(T t) {
//        t.setModifiedBy(CryptAESUtils.getInstance().encryption(BaseUtils.getCurrentUser()));
//        return dao.updateByPrimaryKey(t);
//    }
//
///********************************* 自动生成器代码end ******************************************/
//
//}
//
