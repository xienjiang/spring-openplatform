package com.spring.cloud.openplatform.getway.bootstrap;

import com.spring.cloud.openplatform.getway.filter.AccessPermissionFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
@EnableSidecar
public class Application {
    public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public AccessPermissionFilter accessFilter() {
		return new AccessPermissionFilter();
	}
}