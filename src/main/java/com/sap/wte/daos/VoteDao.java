package com.sap.wte.daos;

import com.sap.wte.models.Vote;

/**
 * Created by I863273 on 09/08/2017.
 */
public interface VoteDao {
    void saveOrUpdate(Vote vote);

    Vote findVote(Vote vote);
}
