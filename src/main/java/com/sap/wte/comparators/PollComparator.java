package com.sap.wte.comparators;

import com.sap.wte.models.Poll;

import java.util.Comparator;

/**
 * Created by I863273 on 14/08/2017.
 */
public class PollComparator implements Comparator<Poll> {
    @Override
    public int compare(Poll o1, Poll o2) {
        return o2.getDate().compareTo(o1.getDate());
    }
}
