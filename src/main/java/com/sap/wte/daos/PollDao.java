package com.sap.wte.daos;

import com.sap.wte.models.Poll;

import java.sql.Date;

/**
 * Created by I863273 on 08/08/2017.
 */
public interface PollDao {
    void save(Poll poll);

    Poll getCurrentPoll();

    Poll getPoll(Date date);
}
