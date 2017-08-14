package com.sap.wte.daos;

import com.sap.wte.models.Poll;

import java.sql.Date;
import java.util.List;

/**
 * Created by I863273 on 08/08/2017.
 */
public interface PollDao {
    void save(Poll poll);

    void saveOrUpdate(Poll poll);

    Poll getCurrentPoll();

    Poll getPoll(Date date);

    Poll getPoll(int id);

    void closePolls();

    List<Poll> listPolls();

    void closePollBeforeDate(Date date);

    Poll getPollBeforeDate(Date date);

}
