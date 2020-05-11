//package com.akoca.apigateway.customfilters;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
//import org.springframework.stereotype.Component;
//import reactor.core.publisher.Mono;
//
//@Component
//public class CustomHeadersFilter extends AbstractGatewayFilterFactory<CustomHeadersFilter.HeaderFiltersConfig> {
//
//    private static final Logger logger = LoggerFactory.getLogger(CustomHeadersFilter.class);
//
//    @Override
//    public GatewayFilter apply(HeaderFiltersConfig headerFiltersConfig) {
//        // @formatter:off
//        return ((exchange, chain) -> {
//            logger.info("Custom Headers Filter Pre Stage Called");
//
//            return chain
//                    .filter(exchange)
//                    .then(Mono.fromRunnable(() -> {
//                        logger.info("Custom Headers Filter Post Stage Called");
//                    }));
//        });
//        // @formatter:on
//    }
//
//    public static class HeaderFiltersConfig {}
//}
