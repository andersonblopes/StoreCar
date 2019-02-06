package com.storecar.StoreCar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storecar.StoreCar.document.Car;
import com.storecar.StoreCar.repository.CarRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarRepository carRepository;

	@Override
	public Flux<Car> findAll() {
		return carRepository.findAll();
	}

	@Override
	public Mono<Car> findById(String id) {
		return carRepository.findById(id);
	}

	@Override
	public Mono<Car> save(Car car) {
		return carRepository.save(car);
	}

}
