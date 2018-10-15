package org.dbc.admin;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.dbc.admin.secure.config.PropertiesConfig;
import org.dbc.admin.utils.BaseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;
import java.net.UnknownHostException;
import java.text.MessageFormat;


//@EnableScheduling
@EnableTransactionManagement
@EnableMongoAuditing
@ComponentScan
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@EnableConfigurationProperties({PropertiesConfig.class})
@SpringBootApplication
public class AdminApplication {
	private static final Logger logger = LoggerFactory.getLogger(AdminApplication.class);

	public static void main(String[] args) throws IOException {
		SpringApplication app = new SpringApplication(AdminApplication.class);
//		SpringApplication.run(AdminApplication.class, args);
		logger.info("SpringBoot server stated on port: 8035");
		Environment env = app.run(args).getEnvironment();
		printServerInfo(env);
	}

	public static void printServerInfo(Environment env) throws UnknownHostException {
		String serverInfo = MessageFormat.format(
				"Application is running:\n"
						+ "------------------------------------------------------------------------\n\t"
						+ "Application:     {0}\n\t"
						+ "Local IP:        {1}://127.0.0.1:{2}{3}\n\t"
						+ "Public IP:       {4}://{5}:{6}{7}\n\t"
						+ "Profiles:        {8}\n\t"
						+ "PID:             {9}\n\t"
						+ "Log:             {10}\n"
						+ "------------------------------------------------------------------------",
				env.getProperty("spring.application.name"),
				StringUtils.isEmpty(env.getProperty("server.ssl.key-store")) ? "http" : "https",
				env.getProperty("server.port"),
				StringUtils.isEmpty(env.getProperty("server.context-path")) ? "" : env.getProperty("server.context-path"),
				StringUtils.isEmpty(env.getProperty("server.ssl.key-store")) ? "http" : "https",
				BaseUtils.getLocalIpv4(),
				env.getProperty("server.port"),
				StringUtils.isEmpty(env.getProperty("server.context-path")) ? "" : env.getProperty("server.context-path"),
				org.springframework.util.StringUtils.arrayToCommaDelimitedString(env.getActiveProfiles()),
				System.getProperty("PID"),
				System.getProperty("logging.path") + IOUtils.DIR_SEPARATOR + env.getProperty("info.artifact.id") + ".log");
		logger.warn(serverInfo);
	}

}
