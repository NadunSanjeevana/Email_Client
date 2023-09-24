package com.mailClient;

public class OfficialFriend extends Official implements Wishable {
    private String birth_day;
    private final String wish = "Wish you a Happy Birthday!. Nadun";
    public OfficialFriend(String[] arr) {
        super(arr);
        this.birth_day = arr[4];
    }

    public String getBirthday() {
        return birth_day;
    }

    @Override
    public String birthday_wish() {
        return wish;
    }

}
