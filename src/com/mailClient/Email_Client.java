package com.mailClient;

// 200746U



import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Email_Client {

    public static void main(String[] args) throws IOException {
        Boolean run = true;
        while (run) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("""
                    Enter option type:\s
                    1 - Adding a new recipient
                    2 - Sending an email
                    3 - Printing out all the recipients who have birthdays
                    4 - Printing out details of all the emails sent
                    5 - Printing out the number of recipient objects in the application""");


            DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            Date today = new Date();
            String strDate = (formatter.format(today));
            Status pState = StatusGenerate.readFile();
            if (pState == null) {
                pState = new Status(RecipientCollection.getRecipientsNumber(), strDate);
                RecipientCollection.sendBirthdayWish();
                StatusGenerate.newState(pState);
            } else if (!(strDate.equals(pState.getWishedDate()))) {
                RecipientCollection.sendBirthdayWish();
                pState.setWishedDate(strDate);
                StatusGenerate.newState(pState);
            }

            int option = scanner.nextInt();
            Contact contact = new Contact();


            switch (option) {
                case 1 -> {
                    System.out.println("""
                            input format -\s
                            Official:        official:nimal,nimal@gmail.com,<designation>
                            personal:        personal:nimal,nimal@gmail.com,<nickname>,<birthday>
                            Official_friend: official_friend:nimal,nimal@gmail.com,<designation>,<birthday>""");
                    String details = scanner.next();
                    details += scanner.nextLine();
                    RecipientCollection.AddNewRecipient(details);

                }
                case 2 -> {
                    // input format - email, subject, content
                    // code to send an email
                    System.out.println("Enter Email (input format - email, subject, content)");
                    String dd = scanner.next();
                    dd += scanner.nextLine();
                    String[] message = dd.split(",");
                    Mailer email = new Mailer();
                    email.sendEmail(message);
                    Email new_email = new Email(message);
                    EmailCollection.creatMail(new_email);
                }
                case 3 -> {
                    // input format - yyyy/MM/dd (ex: 2018/09/17)
                    // code to print recipients who have birthdays on the given date
                    System.out.println("Enter Date (input format - yyyy/MM/dd (ex: 2018/09/17))");
                    String date1 = scanner.next();
                    ArrayList<String[]> birthday_holder = RecipientCollection.readFile(date1);
                    Contact newContact = new Contact();
                    for (String[] strings : birthday_holder) {
                        Recipient recipient = newContact.creatRecipient(strings);
                        System.out.println("Name: "+recipient.getName());
                        System.out.println("Birthday: "+recipient.getBirthday());
                        System.out.println();
                    }

                }
                case 4 -> {
                    // input format - yyyy/MM/dd (ex: 2018/09/17)
                    // code to print the details of all the emails sent on the input date
                    System.out.println("Enter Date (input format - yyyy/MM/dd (ex: 2018/09/17))");
                    String date2 = scanner.next();

                    EmailCollection.readFile(date2);
                }
                case 5 -> {
                    // code to print the number of recipient objects in the application
                    System.out.println("Number of Recipient: " + RecipientCollection.getRecipientsNumber());
                }
            }
            String choice;
            System.out.println("Do you run again?  (Y/N)");
            choice = scanner.next();
            if(choice.equals("N")){run = false;}

        }
    }
}


