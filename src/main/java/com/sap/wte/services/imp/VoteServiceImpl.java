package com.sap.wte.services.imp;

import com.sap.wte.daos.VoteDao;
import com.sap.wte.models.Poll;
import com.sap.wte.models.Restaurant;
import com.sap.wte.models.User;
import com.sap.wte.models.Vote;
import com.sap.wte.services.PollService;
import com.sap.wte.services.SecurityService;
import com.sap.wte.services.UserService;
import com.sap.wte.services.VoteService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by I863273 on 09/08/2017.
 */
@Transactional
public class VoteServiceImpl implements VoteService {

    @Resource
    SecurityService securityService;

    @Resource
    PollService pollService;

    @Resource
    VoteDao voteDao;

    @Override
    public boolean vote(Restaurant restaurant) {
        User currentUser = securityService.getCurrentUser();
        Poll currentPoll = pollService.getCurrentPoll();

        Vote vote = new Vote();
        vote.setUser(currentUser);
        vote.setPoll(currentPoll);

        Vote previousVote = findPreviousVote(currentUser, currentPoll);

        if ( previousVote != null){
            vote = previousVote;
        }

        //changes restaurant option
        vote.setRestaurant(restaurant);

        voteDao.saveOrUpdate(vote);

        return true;
    }

    @Override
    public Vote findPreviousVote(User user, Poll currentPoll) {
        Vote vote = new Vote();
        vote.setPoll(currentPoll);
        vote.setUser(user);

        return voteDao.findVote(vote);
    }
}
