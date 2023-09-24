package com.mailClient;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Email implements Serializable {
    private String date;
    private String reciver;
    private String message;
    private String subject;

    public Email(String[] newMailArr){

        this.reciver = newMailArr[0];
        this.subject = newMailArr[1];
        this.message = newMailArr[2];
        DateFormat formatter=new SimpleDateFormat("yyyy/MM/dd");
        Date today=new Date();
        String  onlyDate = (formatter.format(today));
        this.date=onlyDate;
    }

    public String getMessage() {
        return message;
    }

    public String getReciver() {
        return reciver;
    }

    public String getSubject() {
        return subject;
    }


    public String  getdate(){
        return  date;
    }

}
