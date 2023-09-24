package com.mailClient;

public class Contact {
    public Recipient creatRecipient(String[] details){
        Recipient recipient = null;

        if(details[0].equals("official") && details.length ==4){
            Official o_recipient = new Official(details);
            recipient = o_recipient;

        }
        else if (details[0].equals("personal")) {
            Personal p_recipient = new Personal(details);
            recipient = p_recipient;

        } else if (details[0].equals("official_friend") && details.length ==5){
            OfficialFriend of_recipient = new OfficialFriend(details);
            recipient = of_recipient;
;
        }
        Status nS = StatusGenerate.readFile();
        long np = nS.getNumberOfRecipients()+1;
        nS.setNumberOfRecipients(np);
        StatusGenerate.newState(nS);
        return recipient;
    }

    //get wish from personal or official_friend object
    public String getWish(Wishable recipient){
        return recipient.birthday_wish();
    }
}
