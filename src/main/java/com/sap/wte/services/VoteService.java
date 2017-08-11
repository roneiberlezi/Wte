package com.sap.wte.services;

import com.sap.wte.models.Poll;
import com.sap.wte.models.Restaurant;
import com.sap.wte.models.User;
import com.sap.wte.models.Vote;

/**
 * Created by I863273 on 09/08/2017.
 */
public interface VoteService {
    boolean vote(Restaurant restaurant);

    Vote findPreviousVote(User user, Poll currentPoll);
}
