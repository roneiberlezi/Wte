package com.sap.wte.services.imp;

import com.sap.wte.daos.PollDao;
import com.sap.wte.models.Poll;
import com.sap.wte.pojos.PollForm;
import com.sap.wte.services.PollService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by I863273 on 08/08/2017.
 */
@Transactional
public class PollServiceImpl implements PollService {

    @Resource
    PollDao pollDao;

    @Override
    public void create(Poll poll) {
        pollDao.save(poll);
    }

    @Override
    public void create(PollForm poll) {
        Poll p = new Poll();
        p.setDate(poll.getDate());
        p.setTitle(poll.getTitle());

        pollDao.save(p);
    }

    @Override
    public Poll getCurrentPoll() {
        Date today;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        today = Date.valueOf(localDate);

        Poll poll = pollDao.getPoll(today);

        if (poll == null){
            poll = new Poll();
            poll.setDate(today);
            poll.setTitle("Poll of " + today);

            create(poll);
        }

        return poll;
    }
}
