package org.dbc.admin.service;

import com.google.gson.Gson;
import org.dbc.admin.dao.AccountDao;
import org.dbc.admin.domain.Account;
import org.dbc.admin.domain.User;
import org.dbc.admin.utils.CryptAESUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ray, liu.
 * @Date: 2018/10/10 12:00
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Resource
    UserService userService;
    @Resource
    AccountDao accountDao;
    Gson gson = new Gson();
    @Autowired
    Environment env;

    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.username}")
    private String dbUsername;
    @Value("${spring.datasource.password}")
    private String dbPassword;
    @Value("${spring.datasource.driverclassname}")
    private String dbClassName;

    @Test
    public void findUserByMongoTest() throws Exception{
        try {
            String email = "webberic92@yahoo.com";
            String emailEncryption = CryptAESUtils.getInstance().encryption(email);
            User user = userService.findByEmail(emailEncryption);
            long count = userService.getCount();
            System.out.println("\n=======test======>" + gson.toJson(user));
            System.out.println("\n=======test======>" + count);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void findUserAccountByMysqlTest() throws Exception {
//        List<Account> accounts = accountDao.selectByAccounts();
//        System.out.println("\n\n------------>" + accounts);
        System.out.println("\n\n\n\n\n\n------------>" + Arrays.toString(env.getActiveProfiles()));
    }
}
