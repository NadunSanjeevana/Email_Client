package com.mailClient;

public class Official extends Recipient{
    private String designation;
    public Official(String[] arr) {
        super(arr);
        this.designation = arr[3];
    }


    public String getDesignation() {
        return designation;
    }
}
