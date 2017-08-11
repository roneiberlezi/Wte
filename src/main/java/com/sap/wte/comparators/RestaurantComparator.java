package com.sap.wte.comparators;

import com.sap.wte.models.Restaurant;

import java.util.Comparator;

/**
 * Created by I863273 on 10/08/2017.
 */
public class RestaurantComparator implements Comparator<Restaurant> {
    @Override
    public int compare(Restaurant o1, Restaurant o2) {
        int value1 = o2.getVotes().size() - o1.getVotes().size();

        if (value1 == 0){
            int value2 = o1.getName().compareToIgnoreCase(o2.getName());
            return value2;
        }

        return value1;
    }
}
