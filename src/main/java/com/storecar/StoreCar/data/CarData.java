package com.storecar.StoreCar.data;

import com.storecar.StoreCar.document.Car;
import com.storecar.StoreCar.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import reactor.core.publisher.Flux;

import java.util.UUID;

/**
 * The type Car data.
 */
//@Component
public class CarData implements CommandLineRunner {

    /**
     * The Car repository.
     */
    private final CarRepository carRepository;

    /**
     * Instantiates a new Car data.
     *
     * @param carRepository the car repository
     */
    CarData(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    /**
     * Run.
     *
     * @param args the args
     * @throws Exception the exception
     */
    @Override
    public void run(String... args) throws Exception {

        carRepository.deleteAll()
                .thenMany(Flux.just("BMW", "Honda", "Fiat", "Ferrari", "Audi")
                        .map(model -> new Car(UUID.randomUUID().toString(), model)).flatMap(carRepository::save))
                .subscribe(System.out::println);
    }

}
