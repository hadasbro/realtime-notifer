package org.bitbucket.slawekhaa.realtimenotifer.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.bitbucket.slawekhaa.realtimenotifer.repository.DBRepository;
import org.bitbucket.slawekhaa.realtimenotifer.repository.UserSessionRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ConfigurationProperties
@EnableJpaRepositories
@SuppressWarnings({"unused","WeakerAccess","WeakAccess"})
public class MainConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/webjars/**",
                "/img/**",
                "/css/**",
                "/js/**")
                .addResourceLocations(
                        "classpath:/META-INF/resources/webjars/",
                        "classpath:/static/img/",
                        "classpath:/static/css/",
                        "classpath:/static/js/");
    }

    @Profile("prod")
    @Bean(name="DBKRepository" /* initMethod = "", destroyMethod = "" */)
    public UserSessionRepository createDBRepo() {
        return new DBRepository();
    }

    @Bean(name = "dataSourceMySql")
    @ConfigurationProperties(prefix="mysql.datasource")
    @Primary
    public DataSource dataSourceMySql(){
        return DataSourceBuilder.create().build();
    }

}
