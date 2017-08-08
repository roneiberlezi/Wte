package com.sap.wte.pojos;

import java.security.PublicKey;
import java.sql.Date;

/**
 * Created by I863273 on 08/08/2017.
 */
public class PollForm {
    private Date date;
    private String title;

    public PollForm() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
