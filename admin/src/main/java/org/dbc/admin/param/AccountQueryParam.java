package org.dbc.admin.param;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Author: ray, liu.
 * @Date: 2018/10/11 22:47
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class AccountQueryParam extends BaseQueryParam implements Serializable {

    protected Integer id;

    /** 用户Id **/
    private String userId;

    /** 钱包地址 **/
    private String walletAddress;

    /** 币种 0:dbc **/
    private Integer currencyType;

    /** 大于当前的余额 **/
    private java.math.BigDecimal balanceStart;

    /** 小于当前的余额 **/
    private java.math.BigDecimal balanceEnd;

}