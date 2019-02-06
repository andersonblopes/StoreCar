package com.storecar.StoreCar.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.storecar.StoreCar.document.Car;

public interface CarRepository extends ReactiveMongoRepository<Car, String> {

}
