package RDBAC.util;

import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.datasource.DataSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "classpath:db.properties")
public class ServerRuntimeCreator {

    @Autowired
    private Environment environment;

    @Bean
    public ServerRuntime getServerRuntime() {
        return ServerRuntime.builder()
                .addConfig("cayenne-project.xml")
                .dataSource(
                        DataSourceBuilder
                                .url(environment.getProperty("db.url"))
                                .driver(environment.getProperty("db.driver"))
                                .userName(environment.getProperty("db.uname"))
                                .password(environment.getProperty("db.password"))
                                .build()
                )
                .build();

    }
}
