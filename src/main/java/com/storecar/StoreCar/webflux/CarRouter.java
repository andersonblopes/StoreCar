package com.storecar.StoreCar.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

/**
 * The type Car router.
 */
//@Configuration
public class CarRouter {

    /**
     * Route router function.
     *
     * @param handler the handler
     * @return the router function
     */
    @Bean
    public RouterFunction<ServerResponse> route(CarHandler handler) {
        return RouterFunctions.route(GET("/car").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
                .andRoute(GET("/car/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::findById)
                .andRoute(POST("/car").and(accept(MediaType.APPLICATION_JSON)), handler::save);
    }
}
