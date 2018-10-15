//package org.dbc.admin.service.impl;
//
//import org.apache.commons.collections.CollectionUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.dbc.admin.dao.AccountDao;
//import org.dbc.admin.domain.Account;
//import org.dbc.admin.param.AccountQueryParam;
//import org.dbc.admin.service.AccountService;
//import org.dbc.admin.service.UserService;
//import org.dbc.admin.utils.CryptAESUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.math.BigDecimal;
//import java.util.List;
//
///**
// * @Author: ray, liu.
// * @Date: 2018/10/13 01:38
//<p>
// *         AccountMapper基本业务实现类
// **/
//
//@Service
//public class AccountServiceImpl extends BaseCrudServiceImpl<AccountDao, Account, Integer> implements AccountService {
//
//    @Override
//    public List<Account> find(AccountQueryParam accountQueryParam) {
//        return getDao().find(accountQueryParam);
//    }
//
//    @Override
//    public Account findOne(AccountQueryParam accountQueryParam) {
//        Account account = null;
//        List<Account> accountList = getDao().find(accountQueryParam);
//        if (CollectionUtils.isNotEmpty(accountList)) {
//            account = accountList.get(0);
//        }
//        return account;
//    }
//
//    @Override
//    public Account findByUserIdAndCurrencyType(String userId, Integer currencyType) {
//        return getDao().findByUserIdAndCurrencyType(userId, currencyType);
//    }
//
//    @Override
//    public BigDecimal queryTotalCurrencyByType(Integer currencyType) {
//        return getDao().queryTotalAmountOfCurrency(currencyType);
//    }
//
//    @Override
//    public List<Account> selectByCondition(AccountQueryParam accountQueryParam) {
//        BigDecimal minUnit = BigDecimal.valueOf(Math.pow(10, 8));
//        BigDecimal balanceStart = accountQueryParam.getBalanceStart();
//        BigDecimal balanceEnd = accountQueryParam.getBalanceEnd();
//
//        // 如果查询条件[开始余额，结束余额] 不空，需要除10^8
//        if (!(balanceStart == null || "".equals(balanceStart))) {
//            accountQueryParam.setBalanceStart(balanceStart.multiply(minUnit));
//        }
//        if (!(balanceEnd == null || "".equals(balanceEnd))) {
//            accountQueryParam.setBalanceEnd(balanceEnd.multiply(minUnit));
//        }
//
//        if(StringUtils.isNotEmpty(accountQueryParam.getUserId())){
//            accountQueryParam.setUserId(CryptAESUtils.getInstance().encryption(accountQueryParam.getUserId()));
//        }
//
//        List<Account> accountList = getDao().selectByCondition(accountQueryParam);
//
//        // 返回的用户id需要解密返回；返回的余额要乘10^8返回
//        if (CollectionUtils.isNotEmpty(accountList)) {
//            for (Account account : accountList) {
//                try {
//                    account.setUserId(CryptAESUtils.getInstance().decryption(account.getUserId()));
//                    account.setBalance(account.getBalance().divide(minUnit));
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        return accountList;
//    }
//
//}
