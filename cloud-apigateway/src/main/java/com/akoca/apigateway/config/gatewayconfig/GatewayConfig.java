//package com.akoca.apigateway.gatewayconfig;
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//
//@Configuration
//public class GatewayConfig {
//
//    @Bean
//    public RouteLocator gatewayRoutes(RouteLocatorBuilder routeLocatorBuilder) {
//
//        // @formatter:off
//        return routeLocatorBuilder
//                .routes()
//                    .route(route ->
//                            route
//                                .method(HttpMethod.GET)
//                            .and()
//                                .path("/containerManager/getAllContainers")
//                                .filters(f -> f.addRequestHeader("fgdg" , "fdg")
//                                             .addResponseHeader("gdfgfd" , "yhtryt")
//                                             .circuitBreaker(config ->
//                                                   config.setName("Default Circuit Breaker Resilience4J Config")
//                                                        .setFallbackUri("http://httpbin.org:80")))
////                                           .requestRateLimiter().configure(c -> c.setRateLimiter(myRateLimiter))
///*                                           .rewritePath("/integration/(?<segment>.*)","/a-integration/${segment}"))
//                                .uri("http://httpbin.org:80")*/
//                                .uri("lb://CONTAINER-SERVICE")
//                                    .id("terte"))
//
//                    .route(route ->
//                            route
//                                .method(HttpMethod.GET)
//                            .and()
//                                .path("/containerManager/addContainer")
//                                .filters(f -> f.addRequestHeader("fgdg" , "fdg")
//                                             .addResponseHeader("gdfgfd" , "yhtryt")
////                                           .circuitBreaker()
////                                           .requestRateLimiter().configure(c -> c.setRateLimiter(myRateLimiter))
//                                             .rewritePath("/integration/(?<segment>.*)","/a-integration/${segment}"))
//                                .uri("http://httpbin.org:80")
//                                .uri("lb://DEVICE-SERVICE")
//                                    .id("gtdfgd"))
//
//                    .route("routeId" , route ->
//                                            route
//                                                .method(HttpMethod.GET)
//                                            .and()
//                                                .path("/containerManager/deleteContainer")
//                                            .and()
//                                                .host("{sub}.myhost.org")
//                                                .filters(f -> f.addRequestHeader("rfreer" , "dsfsdfsdf-{sub}")
//                                                             .addResponseHeader("fdfsddf" , "432424-{sub}")
////                                                           .circuitBreaker()
////                                                           .requestRateLimiter().configure(c -> c.setRateLimiter(myRateLimiter))
//                                                             .rewritePath("/integration/(?<segment>.*)","/a-integration/${segment}"))
//                                                .uri("lb://DEVICE-SERVICE")
//                                                .uri("http://httpbin.org:80")
//                                                    .id("gtdfgd"))
//
//                    .route("heritage" , route ->
//                            route
//                                    .method(HttpMethod.GET)
//                                    .and()
//                                    .path("/devices/getAllDevice")
//                                    .filters(f -> f.addRequestHeader("rfreer" , "dsfsdfsdf-{sub}")
//                                            .addResponseHeader("fdfsddf" , "432424-{sub}")
//                    //                                                      .circuitBreaker()
//                    //                                                      .requestRateLimiter().configure(c -> c.setRateLimiter(myRateLimiter))
//                                            .rewritePath("/integration/(?<segment>.*)","/a-integration/${segment}"))
//                                    .uri("lb://DEVICE-SERVICE")
//                                    .uri("lb://heritage"))
//
//                    .route("heritage" , route ->
//                            route
//                                    .method(HttpMethod.GET)
//                                    .and()
//                                    .path("/devices/deleteDevice")
//                                    .filters(f -> f.addRequestHeader("rfreer" , "dsfsdfsdf-{sub}")
//                                            .addResponseHeader("fdfsddf" , "432424-{sub}")
//                    //                                                      .circuitBreaker()
//                    //                                                      .requestRateLimiter().configure(c -> c.setRateLimiter(myRateLimiter))
//                                            .rewritePath("/integration/(?<segment>.*)","/a-integration/${segment}"))
//                                    .uri("lb://DEVICE-SERVICE")
//                                    .uri("lb://heritage"))
//
//                    .route("heritage" , route ->
//                            route
//                                    .method(HttpMethod.GET)
//                                    .and()
//                                    .path("/devices/addDevice")
//                                    .filters(f -> f.addRequestHeader("rfreer" , "dsfsdfsdf-{sub}")
//                                            .addResponseHeader("fdfsddf" , "432424-{sub}")
//                    //                                                      .circuitBreaker()
//                    //                                                      .requestRateLimiter().configure(c -> c.setRateLimiter(myRateLimiter))
//                                            .rewritePath("/integration/(?<segment>.*)","/a-integration/${segment}"))
//                                    .uri("lb://DEVICE-SERVICE")
//                                    .uri("lb://heritage"))
//
//
//                    .route("heritage" , route ->
//                            route
//                                    .method(HttpMethod.GET)
//                                    .and()
//                                    .path("/devices/getDevice")
//                                    .filters(f -> f.addRequestHeader("rfreer" , "dsfsdfsdf-{sub}")
//                                            .addResponseHeader("fdfsddf" , "432424-{sub}")
//                    //                                                      .circuitBreaker()
//                    //                                                      .requestRateLimiter().configure(c -> c.setRateLimiter(myRateLimiter))
//                                            .rewritePath("/integration/(?<segment>.*)","/a-integration/${segment}"))
//                                    .uri("lb://DEVICE-SERVICE")
//                                    .uri("lb://heritage"))
//
//
//                    .route("heritage" , route ->
//                            route
//                                    .method(HttpMethod.GET)
//                                    .and()
//                                    .path("/devices/updateDevice")
//                                    .filters(f -> f.addRequestHeader("rfreer" , "dsfsdfsdf-{sub}")
//                                            .addResponseHeader("fdfsddf" , "432424-{sub}")
//                    //                                                      .circuitBreaker()
//                    //                                                      .requestRateLimiter().configure(c -> c.setRateLimiter(myRateLimiter))
//                                            .rewritePath("/integration/(?<segment>.*)","/a-integration/${segment}"))
//                                    .uri("lb://DEVICE-SERVICE")
//                                    .uri("lb://heritage"))
//
//
//                    .route("heritage" , route ->
//                            route
//                                    .method(HttpMethod.GET)
//                                    .and()
//                                    .path("/**")
//                                    .filters(f -> f.addRequestHeader("rfreer" , "dsfsdfsdf-{sub}")
//                                            .addResponseHeader("fdfsddf" , "432424-{sub}")
//                    //                                                      .circuitBreaker()
//                    //                                                      .requestRateLimiter().configure(c -> c.setRateLimiter(myRateLimiter))
//                                            .rewritePath("/integration/(?<segment>.*)","/a-integration/${segment}"))
//                                    .uri("lb://DEVICE-SERVICE")
//                                    .uri("lb://heritage"))
//
//
//                    .route("heritage" , route ->
//                            route
//                                    .method(HttpMethod.GET)
//                                    .and()
//                                    .path("/log/logadd")
//                                    .filters(f -> f.addRequestHeader("rfreer" , "dsfsdfsdf-{sub}")
//                                            .addResponseHeader("fdfsddf" , "432424-{sub}")
//                    //                                                      .circuitBreaker()
//                    //                                                      .requestRateLimiter().configure(c -> c.setRateLimiter(myRateLimiter))
//                                            .rewritePath("/integration/(?<segment>.*)","/a-integration/${segment}"))
//                                    .uri("lb://DEVICE-SERVICE")
//                                    .uri("lb://heritage"))
//
//
//                    .route("heritage" , route ->
//                            route
//                                    .method(HttpMethod.GET)
//                                    .and()
//                                    .path("/log/getLog")
//                                    .filters(f -> f.addRequestHeader("rfreer" , "dsfsdfsdf-{sub}")
//                                            .addResponseHeader("fdfsddf" , "432424-{sub}")
//                    //                                                      .circuitBreaker()
//                    //                                                      .requestRateLimiter().configure(c -> c.setRateLimiter(myRateLimiter))
//                                            .rewritePath("/integration/(?<segment>.*)","/a-integration/${segment}"))
//                                    .uri("lb://DEVICE-SERVICE")
//                                    .uri("lb://heritage"))
//
//                    .route("websocketRouteId" , route ->
//                                                route
//                                                    .method(HttpMethod.GET)
//                                                .and()
//                                                    .path("/echo")
//                                                    .filters(f -> f.addRequestHeader("rfreer" , "dsfsdfsdf-{sub}")
//                                                            .addResponseHeader("fdfsddf" , "432424-{sub}")
//                    //                                                      .circuitBreaker()
//                    //                                                      .requestRateLimiter().configure(c -> c.setRateLimiter(myRateLimiter))
//                                                            .rewritePath("/integration/(?<segment>.*)","/a-integration/${segment}"))
//                                                    .uri("lb://DEVICE-SERVICE")
//                                                    .uri("ws://localhost:9000")
//                                                        .id("gtdfgd"))
//
//                    .route("heritage" , route ->
//                                            route
//                                                .method(HttpMethod.GET)
//                                            .and()
//                                                .path("/**")
//                                                .filters(f -> f.addRequestHeader("rfreer" , "dsfsdfsdf-{sub}")
//                                                        .addResponseHeader("fdfsddf" , "432424-{sub}")
////                                                      .circuitBreaker()
////                                                      .requestRateLimiter().configure(c -> c.setRateLimiter(myRateLimiter))
//                                                        .rewritePath("/integration/(?<segment>.*)","/a-integration/${segment}"))
//                                                .uri("lb://DEVICE-SERVICE")
//                                                .uri("lb://heritage"))
//
//                    .build();
//
//        // @formatter:on
//    }
//}
