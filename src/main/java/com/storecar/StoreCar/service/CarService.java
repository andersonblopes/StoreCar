package com.storecar.StoreCar.service;

import com.storecar.StoreCar.document.Car;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The interface Car service.
 */
public interface CarService {

    /**
     * Find all flux.
     *
     * @return the flux
     */
    Flux<Car> findAll();

    /**
     * Find by id mono.
     *
     * @param id the id
     * @return the mono
     */
    Mono<Car> findById(String id);

    /**
     * Save mono.
     *
     * @param car the car
     * @return the mono
     */
    Mono<Car> save(Car car);

}
