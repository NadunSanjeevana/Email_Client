package com.mailClient;

import java.io.Serializable;

public class Status implements Serializable {
    private  long numberOfRecipients;
    private  String wishedDate;

    public Status(long numberOfRecipients,String  wishedDate){
        this.numberOfRecipients = numberOfRecipients;
        this. wishedDate =  wishedDate;
    }
    public String getWishedDate() {
        return  wishedDate;
    }

    public long getNumberOfRecipients() {
        return numberOfRecipients;
    }

    public void setWishedDate(String strdate) {
        wishedDate = strdate;
    }

    public void setNumberOfRecipients(long numberOfRecipients) {
        this.numberOfRecipients = numberOfRecipients;
    }
}
