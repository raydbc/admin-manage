package org.dbc.admin.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: ray, liu.
 * @Date: 2018/10/4 16:27
 *
 * The detailed information of the user corresponds to the user table in mongodb.
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Document(collection = "User")
public class User extends BaseModel implements Serializable {
    // 用户名
    public static final String FIELD_USER_NAME = "userName";
    public static final String FIELD_FIRST_NAME = "firstName";
    public static final String FIELD_LAST_NAME = "lastName";
    public static final String FIELD_LOGIN_NAME = "loginName";
    public static final String FIELD_MOBILE_NO = "mobileNo";
    // 登录账号
    public static final String FIELD_EMAIL = "email";
    public static final String FIELD_PASSWORD_HASH = "passwordHash";
    public static final String FIELD_ACTIVATED = "activated";
    public static final String FIELD_ACTIVATION_KEY = "activationKey";
    public static final String FIELD_RESET_KEY = "resetKey";
    public static final String FIELD_RESET_TIME = "resetTime";
    public static final String FIELD_INVITATION_CODE = "invitationCode";
    public static final String FIELD_OWN_INVITATION_CODE = "ownInvitationCode";

    public static final String FIELD_NEO_WALLET_ADDRESS = "neoWalletAddress";
    public static final String NEO_WALLET_ADDRESS_OF_COMPANY = "neoWalletAddressOfCompany";
    public static final String FIELD_NEO_WALLET_STATUS = "neoWalletStatus";


    public static final String FIELD_COUNTRY = "country";
    public static final String FIELD_CITY = "city";
    public static final String FIELD_ORIGINATION = "origination";
    public static final String FIELD_ADDRESS_DETAIL = "addressDetail";
    public static final String FIELD_ADDRESS_POSTCODE = "postcode";
    //验证钱包的金额
    public static final String VALIDATE_NEO_WALLET_AMOUNT = "validateNeoWalletAmount";
    //总共可修改的次数
    public static final String CHANGE_NEO_WALLET_TIMES_TOTAL = "changeNeoWalletTimesTotal";
    //还有可修改的次数
    public static final String CHANGE__NEO_WALLET_TIMES_LEFT = "changeNeoWalletTimesLeft";
    //第一次开始修改的时间 以后每个月可重新恢复验证次标识
    public static final String CHANGE__NEO_WALLET_FIRST_TIME = "changeNeoWalletFirstTime";
    public static final String CHANGE__NEO_WALLET_LAST_TIME = "changeNeoWalletLastTime";
    public static final String REGISTER_FROM = "registerFrom";

    public static final String ETH_WALLET_ADDRESS = "ethWalletAddress";

    private String userName;
    private String firstName;
    private String lastName;
    private String loginName;
    private String picture;
    private String email;
    private String walletType;
    private String neoWalletAddress;
    private String neoWalletAddressOfCompany;
    private String neoWalletStatus;
    private String country = "";
    private String city;
    private String mobileNo;
    //详细住址
    private String addressDetail;
    //邮政编码
    private String postcode;
    private String passwordHash;
    private Boolean activated;
    private String activationKey;
    private String resetKey;
    private String invitationCode;
    private String ownInvitationCode;
    private Date resetTime;
    private Boolean mailSubscribed;
    /**
     * 1 user,10 admin
     */
    private String role;
    /**
     * deepbrainchain/miner default：deepbrainchain
     */
    private String origination;
    //验证钱包的金额
    private BigDecimal validateNeoWalletAmount;
    //总共可修改的次数
    private int changeNeoWalletTimesTotal;
    //还有修改的次数
    private int changeNeoWalletTimesLeft;
    private Date changeNeoWalletFirstTime;
    private Date changeNeoWalletLastTime;
    //钱包验证开始时间
    private Date validateNeoWalletStartTime;

    private String registerFrom;

    private String ethWalletAddress;
}
