package com.storecar.StoreCar.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The type Car.
 */
@Document
public class Car {

    /**
     * The Id.
     */
    @Id
    private String id;
    /**
     * The Model.
     */
    private String model;

    /**
     * Instantiates a new Car.
     *
     * @param id    the id
     * @param model the model
     */
    public Car(String id, String model) {
        super();
        this.id = id;
        this.model = model;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets model.
     *
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets model.
     *
     * @param model the model
     */
    public void setModel(String model) {
        this.model = model;
    }
}
