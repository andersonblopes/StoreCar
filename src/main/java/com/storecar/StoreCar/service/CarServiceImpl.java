package com.storecar.StoreCar.service;

import com.storecar.StoreCar.document.Car;
import com.storecar.StoreCar.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The type Car service.
 */
@Service
public class CarServiceImpl implements CarService {

    /**
     * The Car repository.
     */
    @Autowired
    private CarRepository carRepository;

    /**
     * Find all flux.
     *
     * @return the flux
     */
    @Override
    public Flux<Car> findAll() {
        return carRepository.findAll();
    }

    /**
     * Find by id mono.
     *
     * @param id the id
     * @return the mono
     */
    @Override
    public Mono<Car> findById(String id) {
        return carRepository.findById(id);
    }

    /**
     * Save mono.
     *
     * @param car the car
     * @return the mono
     */
    @Override
    public Mono<Car> save(Car car) {
        return carRepository.save(car);
    }

}
