package com.appstream.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("file:///${user.home}/Documents/configdoc/cloudstream2/application-dev.properties")
//@Profile("dev")
public class DevPropertyConfiguration {
}
