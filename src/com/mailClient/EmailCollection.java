package com.mailClient;

import java.io.*;

public class EmailCollection {

    // creating object of File class
    private static final File f = new File("emailList.ser");


    //read and get emails on given date
    public static void readFile(String date) throws IOException {


        try {
            f.createNewFile();
        }

        catch (Exception ignored) {
            ignored.printStackTrace();
        }

        // If the file is empty
        if (f.length() != 0) {

            FileInputStream fis = null;
            ObjectInputStream ois = null;

            try {

                fis = new FileInputStream(
                        "emailList.ser");
                ois = new ObjectInputStream(fis);


                Email email;
                while (fis.available() != 0) {
                    email = (Email) ois.readObject();


                    if (date.equals(email.getdate())) {
                        System.out.println("To:- " + email.getReciver());
                        System.out.println("Subject:-" + email.getSubject());
                        System.out.println("Message:- " + email.getMessage());
                        System.out.println("");
                    }
                }
            } catch (StreamCorruptedException | FileNotFoundException | ClassNotFoundException e) {

                System.out.println("Error Occurred");
            }
            finally {
                if(ois != null){
                    try{
                        ois.close();
                        fis = null;
                    }catch (Exception ignoreMe){}
                    ois = null;
                }
                if(fis != null){
                    try{
                        fis.close();
                    }catch (Exception ignoreMe){}
                    fis = null;
                }
            }

        }

    }




    //creat new mail object
    public static void creatMail(Email newMail)
    {

        // If email is not present
        if (newMail != null) {

            try {

                FileOutputStream fos;


                fos = new FileOutputStream("emailList.ser", true);

                // If there is nothing to write in the file
                if (f.length() == 0) {
                    ObjectOutputStream oos
                            = new ObjectOutputStream(fos);
                    oos.writeObject(newMail);
                    oos.close();
                }

                // write the content on the file
                else {

                    MyObjectOutputStream oos;
                    oos = new MyObjectOutputStream(fos);
                    oos.writeObject(newMail);


                    oos.close();
                }

                fos.close();
            }

            catch (Exception e) {
                System.out.println("Error Occurred" + e);
            }

        }

    }
}
