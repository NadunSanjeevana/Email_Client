package com.mailClient;

public class Personal extends Recipient implements Wishable {
    private String nick_name;
    private String birthday;
    private final String wish = "Hugs and love on your Birthday!. Nadun";
    public Personal(String[] arr) {
        super(arr);
        this.nick_name = arr[3];
        this.birthday = arr[4];
    }

    public String getNick_name() {
        return nick_name;
    }

    public String getBirthday() {
        return birthday;
    }

    @Override
    public String birthday_wish() {
        return wish;
    }

}
