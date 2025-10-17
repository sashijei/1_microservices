package com.mercy.__spring_cloud_config_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Main application class for the Spring Cloud Config Server.
 *
 * <p>This Spring Boot application serves as a centralized Configuration Server
 * that reads configuration properties such as "minimum" and "maximum" from a 
 * local Git repository. It exposes these configurations over HTTP endpoints 
 * for client microservices to dynamically fetch and refresh their configuration 
 * without needing redeployment.</p>
 *
 * <p>The application is enabled as a Config Server by annotating with 
 * {@link EnableConfigServer}. It bootstraps the Config Server infrastructure 
 * required by Spring Cloud ecosystem.</p>
 *
 * <p>Important Properties to Configure in <code>application.properties</code> or 
 * <code>application.yml</code> for local Git usage:</p>
 *
 * <ul>
 *   <li><code>spring.cloud.config.server.git.uri</code>: The file URI pointing to 
 *   the local Git repository holding config files.</li>
 *   <li><code>spring.cloud.config.server.git.default-label</code>: The Git branch 
 *   or tag to fetch configurations from (e.g., "master" or "main").</li>
 * </ul>
 * 
 * <p>Clients request property sets by app name and profile, e.g., 
 * <code>http://localhost:8888/limits-service/default</code> to fetch limits 
 * configuration based on the current Git repository contents.</p>
 * 
 * @author Sasi Kumar
 */
@EnableConfigServer
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
