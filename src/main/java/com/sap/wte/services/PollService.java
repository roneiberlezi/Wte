package com.sap.wte.services;

import com.sap.wte.models.Poll;

import java.util.List;

/**
 * Created by I863273 on 08/08/2017.
 */
public interface PollService {
    void create(Poll poll);

    Poll getCurrentPoll();

    void closePolls();

    List<Poll> listPolls();

    Poll getPoll(int id);

    void closePreviousPoll();
}
