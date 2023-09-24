package com.mailClient;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RecipientCollection {
    private static final File f = new File("clientList.txt");

    // Method 1
    // To read from the file
    public static ArrayList<String[]> readFile(String date) {
        ArrayList<String[]> cArr = new ArrayList<>();
        FileReader fr =null;
        try {
            fr = new FileReader(f);   //reads the file
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] pd = line.split("[:,]");
                if(!(pd[0].equals("official"))) {
                    if (pd[pd.length - 1].substring(5).equals(date.substring(5))) {
                        cArr.add(pd);
                    }
                }

            }

        } catch (IOException ignored) {
        }
        finally {
            if(fr != null){
                try{
                    fr.close();
                }catch (Exception ignoreMe){}
                fr =null;
            }
        }
        return cArr;
    }


    public static void AddNewRecipient(String detail) {
            FileWriter fWriter = null;
            // Create a FileWriter object
            // to write in the file
            try {
                fWriter = new FileWriter(
                        "clientList.txt", true);

                // Writing into file

                fWriter.write(detail + "\n");
            }catch (IOException e){
                System.out.println("Cannot save contact");
            }
            finally{
                if(fWriter != null){
                    try{
                        fWriter.close();
                    }catch (Exception ignoreMe){}
                    fWriter = null;
                }
            }

            // Closing the file writing connection


            // Display message for successful execution of
            // program on the console
            System.out.println(
                    "Contact saved successfully.");
            DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            Date today = new Date();
            String strDate = (formatter.format(today));
            String bday = strDate.substring(6);
            String[] td = detail.split("[:,]");



            if(!(td[0].equals("official"))) {
                if (td[td.length - 1].substring(6).equals(bday)) {
                    Contact mContact = new Contact();
                    send(mContact, td);
                }
            }
        }



    public static void sendBirthdayWish() {

        DateFormat formatter=new SimpleDateFormat("yyyy/MM/dd");
        Date today=new Date();
        String  strDate = (formatter.format(today));

        Contact nContact = new Contact();
        ArrayList<String[]>  today_Birthday_holders = RecipientCollection.readFile(strDate);

        for (String[] today_birthday_holder : today_Birthday_holders) {
            send(nContact, today_birthday_holder);
        }

    }

    private static void send(Contact nContact, String[] today_birthday_holder) {
        Recipient recipient = nContact.creatRecipient(today_birthday_holder);
        String wish = nContact.getWish((Wishable) recipient);
        String[] bMail = {recipient.getEmail(), "Birthday Wish", wish};
        Mailer email = new Mailer();
        email.sendEmail(bMail);
        Email new_email = new Email(bMail);
        EmailCollection.creatMail(new_email);
    }

    public static long getRecipientsNumber() throws IOException {
        try {
            long count = Files.lines(Paths.get("clientList.txt")).count();
            return count;
        } catch (FileNotFoundException | NoSuchFileException e) {
            return 0;
        }
    }
}

