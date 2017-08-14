package com.sap.wte.pojos;

/**
 * Created by I863273 on 14/08/2017.
 */
public class RestaurantPojo {
    private int id;

    private int numberVotes;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberVotes() {
        return numberVotes;
    }

    public void setNumberVotes(int numberVotes) {
        this.numberVotes = numberVotes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
