package org.dbc.admin.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Author: ray, liu.
 * @Date: 2018/10/11 22:40
 *
 * The account information of the user corresponds to the user_account table in mysql.
 */
@Data
@ToString
@EqualsAndHashCode(callSuper=false)
public class Account extends BaseEntity {

    /** 用户Id **/
    private String userId;

    /** 钱包地址 **/
    private String walletAddress;

    /** 余额 **/
    private java.math.BigDecimal balance;

    /** 币种 0:dbc  1:dpt **/
    private Integer currencyType;

}