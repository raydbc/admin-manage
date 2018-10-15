package org.dbc.admin.secure.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ray, liu.
 * @Date: 2018/10/4 16:52
 */
@Service("customUserServiceImpl")
public class CustomUserService implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("用户的用户名: {}", username);

        if (null == username || "".equals(username)){
            throw new UsernameNotFoundException("用户名不能为空");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        if (true) {
            grantedAuthorities.add(new SimpleGrantedAuthority(Authority.ADMIN));
        } else {
            grantedAuthorities.add(new SimpleGrantedAuthority(Authority.USER));
        }

        org.springframework.security.core.userdetails.User userdetail = new org.springframework.security.core.userdetails.User(
                "admin", encoder.encode("ray2018"), true, true, true, true,
                grantedAuthorities);

        return userdetail;
    }

}
