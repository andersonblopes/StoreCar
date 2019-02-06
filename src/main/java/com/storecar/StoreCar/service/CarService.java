package com.storecar.StoreCar.service;

import com.storecar.StoreCar.document.Car;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CarService {

	Flux<Car> findAll();

	Mono<Car> findById(String id);

	Mono<Car> save(Car car);

}
