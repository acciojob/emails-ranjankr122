package com.driver;

import java.util.Date;

public class mails {
    Date date;
    String senderId;
    String message;

    public mails(Date date, String senderId, String message) {
        this.date = date;
        this.senderId = senderId;
        this.message = message;
    }
}
