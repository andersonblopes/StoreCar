package com.storecar.StoreCar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.storecar.StoreCar.document.Car;
import com.storecar.StoreCar.service.CarService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CarController {

	@Autowired
	private CarService service;

	@GetMapping(value = "/car")
	public Flux<Car> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/car/{id}")
	public Mono<Car> findById(@PathVariable String id) {
		return service.findById(id);
	}

	@PostMapping(value = "/car")
	public Mono<Car> save(@RequestBody Car car) {
		return service.save(car);
	}

}
