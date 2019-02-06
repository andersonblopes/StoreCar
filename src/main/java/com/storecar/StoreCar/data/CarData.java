package com.storecar.StoreCar.data;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.storecar.StoreCar.document.Car;
import com.storecar.StoreCar.repository.CarRepository;

import reactor.core.publisher.Flux;

@Component
public class CarData implements CommandLineRunner {
	private final CarRepository carRepository;

	CarData(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		carRepository.deleteAll()
				.thenMany(Flux.just("BMW", "Honda", "Fiat", "Ferrari", "Audi", "Kya", "Hyunday")
						.map(model -> new Car(UUID.randomUUID().toString(), model)).flatMap(carRepository::save))
				.subscribe(System.out::println);
	}

}
