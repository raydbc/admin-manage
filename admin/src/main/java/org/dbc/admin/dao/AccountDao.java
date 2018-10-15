package org.dbc.admin.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.dbc.admin.domain.Account;
import org.dbc.admin.param.AccountQueryParam;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: ray, liu.
 * @Date: 2018/10/11 22:46
 *
 *  <p> AccountMapper数据库操作接口类
 */
@Mapper
public interface AccountDao {

    /**
     * 根据参数查找账户列表
     * @param
     * @return
     */
    List<Account> selectByAccounts();
}

