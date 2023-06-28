package com.example.gatewayclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayClientApplication.class, args);
    }

//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("path_route", r -> r.path("/messages")
//                        .filters(GatewayFilterSpec::tokenRelay)
//                        .uri("http://localhost:8082/messages")
//
//                ).route("blog", r -> r.path("/blog")
//                        .filters(GatewayFilterSpec::tokenRelay)
//                        .uri("http://localhost:8085/main")
//                )
//                .build();
//    }

}
