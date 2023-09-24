package com.mailClient;

import java.io.Serializable;

public abstract class Recipient implements Serializable {
    private String name;
    private String email;


    public Recipient(String[] arr){
        this.name = arr[1];
        this.email = arr[2];
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    public String getBirthday(){return null;}


}
