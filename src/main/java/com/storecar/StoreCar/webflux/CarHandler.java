package com.storecar.StoreCar.webflux;

import com.storecar.StoreCar.document.Car;
import com.storecar.StoreCar.service.CarService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


/**
 * The type Car handler.
 */
@Component
public class CarHandler {

    /**
     * The Car service.
     */
    private final CarService carService;

    /**
     * Instantiates a new Car handler.
     *
     * @param carService the car service
     */
    public CarHandler(CarService carService) {
        this.carService = carService;
    }

    /**
     * Find all mono.
     *
     * @param request the request
     * @return the mono
     */
    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ok().contentType(MediaType.APPLICATION_JSON).body(carService.findAll(), Car.class);
    }

    /**
     * Find by id mono.
     *
     * @param request the request
     * @return the mono
     */
    public Mono<ServerResponse> findById(ServerRequest request) {
        String id = request.pathVariable("id");
        return ok().contentType(MediaType.APPLICATION_JSON).body(carService.findById(id), Car.class);
    }

    /**
     * Save mono.
     *
     * @param request the request
     * @return the mono
     */
    public Mono<ServerResponse> save(ServerRequest request) {
        final Mono<Car> car = request.bodyToMono(Car.class);
        return ok().contentType(MediaType.APPLICATION_JSON).body(fromPublisher(car.flatMap(carService::save), Car.class));
    }

}
