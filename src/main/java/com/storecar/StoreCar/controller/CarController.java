package com.storecar.StoreCar.controller;

import com.storecar.StoreCar.document.Car;
import com.storecar.StoreCar.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The type Car controller.
 */
//@RestController
public class CarController {

    /**
     * The Car service.
     */
    private final CarService carService;

    /**
     * Instantiates a new Car controller.
     *
     * @param carService the car service
     */
    public CarController(CarService carService) {
        this.carService = carService;
    }

    /**
     * Find all flux.
     *
     * @return the flux
     */
    @GetMapping("/car")
    public Flux<Car> findAll() {
        return carService.findAll();
    }

    /**
     * Find by id mono.
     *
     * @param id the id
     * @return the mono
     */
    @GetMapping("/car/{id}")
    public Mono<Car> findById(@PathVariable("id") String id) {
        return carService.findById(id);
    }

    /**
     * Save mono.
     *
     * @param car the car
     * @return the mono
     */
    @PostMapping("/car")
    public Mono<Car> save(@RequestBody Car car) {
        return carService.save(car);
    }

    /**
     * Delete response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/car/{id}")
    public ResponseEntity delete(@PathVariable("id") String id) {
        carService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
