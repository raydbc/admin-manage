//package org.dbc.admin.secure.config;
//
//import com.zaxxer.hikari.HikariDataSource;
//import org.apache.commons.lang.StringUtils;
//import org.dbc.admin.AdminApplication;
//import org.mybatis.spring.annotation.MapperScan;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.ApplicationContextException;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.env.Environment;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.transaction.annotation.TransactionManagementConfigurer;
//
//import java.util.Arrays;
//
///**
// * @Author: ray, liu.
// * @Date: 2018/10/12 23:35
// */
//
//@Configuration
//@EnableTransactionManagement
//@MapperScan("org.dbc.admin.dao")
//public class DatabaseConfiguration implements TransactionManagementConfigurer {
//    private static final Logger log = LoggerFactory.getLogger(AdminApplication.class);
//    private final Environment env;
//    private final PropertiesConfig applicationProperties;
//    private final DataSourceProperties dataSourceProperties;
//
//    @Autowired
//    public DatabaseConfiguration(Environment env, PropertiesConfig applicationProperties,
//                                 DataSourceProperties dataSourceProperties) {
//        this.env = env;
//        this.applicationProperties = applicationProperties;
//        this.dataSourceProperties = dataSourceProperties;
//    }
//
//    @Bean(destroyMethod = "close")
//    @Primary
//    public HikariDataSource mysqlDataSource() {
//        HikariDataSource hikariDataSource = null;
//        try {
//            log.debug("================================Configuring MySQL datasource================================");
//            if (StringUtils.isEmpty(dataSourceProperties.getUrl())) {
//                log.error("Database connection pool configuration is incorrect! The application"
//                          + " cannot start. Please check your Spring profile, current profiles are: {}",
//                        Arrays.toString(env.getActiveProfiles()));
//                throw new ApplicationContextException("Database connection pool is not configured correctly");
//            }
//
//            hikariDataSource = (HikariDataSource) DataSourceBuilder.create(dataSourceProperties.getClassLoader())
//                    .type(HikariDataSource.class).driverClassName(dataSourceProperties.getDriverClassName())
//                    .url(dataSourceProperties.getUrl()).username(dataSourceProperties.getUsername())
//                    .password(dataSourceProperties.getPassword()).build();
//        } catch (Exception e) {
//            log.error("初始化dataSource失败，信息：" + e.getMessage(), e);
//            System.exit(0);
//        }
//        return hikariDataSource;
//    }
//
//    @Bean
//    public PlatformTransactionManager txManager() {
//        return new DataSourceTransactionManager(mysqlDataSource());
//    }
//
//    @Override
//    public PlatformTransactionManager annotationDrivenTransactionManager() {
//        return txManager();
//    }
//
////    @Bean
////    public Interceptor paginationInterceptor(){
////        PaginationInterceptor page = new PaginationInterceptor();
////        page.setProperties(null);
////        return page;
////    }
//}
