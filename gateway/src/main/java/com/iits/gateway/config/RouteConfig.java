package com.iits.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/account/**")
                        .filters(f -> f.rewritePath("/account/(?<segment>.*)", "/account/${segment}"))
                        .uri("http://localhost:8081")
                        .id("account_service"))
                .route(r -> r.path("/user/**")
                        .filters(f -> f.rewritePath("/user/(?<segment>.*)", "/user/${segment}"))
                        .uri("http://localhost:8082")
                        .id("user_service"))
                .build();
    }
}
