//package org.dbc.admin.service;
//
//import org.dbc.admin.domain.Account;
//import org.dbc.admin.param.AccountQueryParam;
//
//import java.math.BigDecimal;
//import java.util.List;
//
///**
// * @Author: ray, liu.
// * @Date: 2018/10/13 01:35
// *
// * <p> AccountMapper基本业务接口类(用户账户)
// */
//public interface AccountService extends BaseCrudService<Account, Integer> {
//
//    List<Account> find(AccountQueryParam accountQueryParam);
//
//    Account findOne(AccountQueryParam accountQueryParam);
//
//    List<Account> selectByCondition(AccountQueryParam accountQueryParam);
//
//    Account findByUserIdAndCurrencyType(String userId, Integer currencyType);
//
//    BigDecimal queryTotalCurrencyByType(Integer currencyType);
//
//}
