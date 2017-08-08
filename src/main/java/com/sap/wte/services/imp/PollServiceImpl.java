package com.sap.wte.services.imp;

import com.sap.wte.daos.PollDao;
import com.sap.wte.models.Poll;
import com.sap.wte.pojos.PollForm;
import com.sap.wte.services.PollService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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
}
