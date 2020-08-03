package com.storecar.StoreCar.repository;

import com.storecar.StoreCar.document.Car;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * The interface Car repository.
 */
public interface CarRepository extends ReactiveMongoRepository<Car, String> {

}
