package com.wozu.todoApp.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@PropertySource("classpath:/application-secrets.properties")
@Configuration
public class PropConfig {

    @Autowired
    Environment env;

}
