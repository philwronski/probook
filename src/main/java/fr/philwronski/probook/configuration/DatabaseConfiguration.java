package fr.philwronski.probook.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "fr.philwronski.probook")
@EnableJpaAuditing(auditorAwareRef = "springSecurityAuditorAware")
public class DatabaseConfiguration {
}
