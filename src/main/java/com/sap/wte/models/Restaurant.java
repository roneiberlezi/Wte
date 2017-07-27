package com.sap.wte.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by I863273 on 26/07/2017.
 */

@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @NotNull
    private int id;

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "averagePrice")
    @Digits(integer = 3 /*precision*/, fraction = 2 /*scale*/, message = "Invalid value")
    @Min(1)
    private float averagePrice;

    @Column(name = "location")
    private String location;

    @Column(name = "isAleloAccepted")
    private boolean isAleloAccepted;

    @Column(name = "imageURL")
    private String imageURL;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(float averagePrice) {
        this.averagePrice = averagePrice;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isAleloAccepted() {
        return isAleloAccepted;
    }

    public void setAleloAccepted(boolean aleloAccepted) {
        isAleloAccepted = aleloAccepted;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
