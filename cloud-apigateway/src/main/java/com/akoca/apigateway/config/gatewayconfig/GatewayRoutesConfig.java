package com.akoca.apigateway.config.gatewayconfig;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class GatewayRoutesConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder routeLocatorBuilder) {

        // @formatter:off
        return routeLocatorBuilder
                .routes()
                .route(route ->
                        route
                            .method(HttpMethod.GET)
                            .and()
                            .path("/containerManager/getAllContainers")
                            .uri("lb://CONTAINER-SERVICE"))

                .route(route ->
                        route
                            .method(HttpMethod.POST)
                            .and()
                            .path("/containerManager/addContainer")
                            .uri("lb://CONTAINER-SERVICE"))

                .route(route ->
                        route
                            .method(HttpMethod.DELETE)
                            .and()
                            .path("/containerManager/deleteContainer")
                            .uri("lb://CONTAINER-SERVICE"))

                .route(route ->
                        route
                            .method(HttpMethod.GET)
                            .and()
                            .path("/devices/getAllDevice")
                            .uri("lb://DEVICE-SERVICE"))

                .route(route ->
                        route
                            .method(HttpMethod.DELETE)
                            .and()
                            .path("/devices/deleteDevice")
                            .uri("lb://DEVICE-SERVICE"))

                .route(route ->
                        route
                            .method(HttpMethod.POST)
                            .and()
                            .path("/devices/addDevice")
                            .uri("lb://DEVICE-SERVICE"))

                .route(route ->
                        route
                            .method(HttpMethod.GET)
                            .and()
                            .path("/devices/getDevice")
                            .uri("lb://DEVICE-SERVICE"))

                .route(route ->
                        route
                            .method(HttpMethod.PUT)
                            .and()
                            .path("/devices/updateDevice")
                            .uri("lb://DEVICE-SERVICE"))

                .route(route ->
                        route
                            .method(HttpMethod.POST)
                            .and()
                            .path("/log/logadd")
                            .uri("lb://LOG-SERVICE"))

                .route(route ->
                        route
                            .method(HttpMethod.GET)
                            .and()
                            .path("/log/getLog")
                            .uri("lb://LOG-SERVICE"))
                .build();
        // @formatter:on
    }
}
