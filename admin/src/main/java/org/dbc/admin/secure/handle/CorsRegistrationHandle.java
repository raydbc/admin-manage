package org.dbc.admin.secure.handle;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistration;

/**
 * @Author: ray, liu.
 * @Date: 2018/10/6 17:51
 */
public class CorsRegistrationHandle extends CorsRegistration {

    public CorsRegistrationHandle(String pathPattern) {
        super(pathPattern);
    }

    @Override
    public CorsConfiguration getCorsConfiguration() {
        return super.getCorsConfiguration();
    }
}