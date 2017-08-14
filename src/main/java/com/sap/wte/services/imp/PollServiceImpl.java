package com.sap.wte.services.imp;

import com.sap.wte.comparators.PollComparator;
import com.sap.wte.daos.PollDao;
import com.sap.wte.models.Poll;
import com.sap.wte.models.Restaurant;
import com.sap.wte.services.PollService;
import com.sap.wte.services.RestaurantService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by I863273 on 08/08/2017.
 */
@Transactional
public class PollServiceImpl implements PollService {

    @Resource
    PollDao pollDao;

    @Resource
    RestaurantService restaurantService;

    @Override
    public void create(Poll poll) {
        pollDao.save(poll);
    }

    @Override
    public Poll getCurrentPoll() {
        Date today;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        today = Date.valueOf(localDate);

        Poll poll = pollDao.getPoll(today);

        if (poll == null){
            closePreviousPoll();
            poll = new Poll();
            poll.setDate(today);
            poll.setTitle("Poll of " + today);

            create(poll);
        }

        return poll;
    }

    @Override
    public void closePolls() {
        pollDao.closePolls();
    }

    @Override
    public List<Poll> listPolls() {
        List<Poll> polls = pollDao.listPolls();
        polls.sort(new PollComparator());
        return polls;
    }

    @Override
    public Poll getPoll(int id) {
        return pollDao.getPoll(id);
    }

    @Override
    public void closePreviousPoll() {
        LocalDate localDate = LocalDate.now();
        Date today = Date.valueOf(localDate);
        Poll poll = pollDao.getPollBeforeDate(today);

        if (poll != null){
            List<Restaurant> restaurant = restaurantService.listRestaurants(poll);
            poll.setRestaurant(restaurant.get(0));
            poll.setState('C');
            pollDao.saveOrUpdate(poll);
        }

    }
}
