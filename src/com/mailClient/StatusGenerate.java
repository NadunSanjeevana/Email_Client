package com.mailClient;


import java.io.*;

public class StatusGenerate {

    private static final File f = new File("status.ser");

    //read the status from file
    public static Status readFile() {

        Status nstatus = null;

        try {

            f.createNewFile();
        }
        catch (Exception ignored) {
        }

        // If the file is empty
        if (f.length() != 0) {

            try {

                // If the file doesn't exists
                FileInputStream fis;

                fis = new FileInputStream("status.ser");
                ObjectInputStream ois
                        = new ObjectInputStream(fis);



                while (fis.available() != 0) {
                    nstatus = (Status) ois.readObject();

                }

                ois.close();
                fis.close();

            }


            catch (Exception e) {

                System.out.println("Error Occurred" + e);

                e.printStackTrace();
            }
        }
        return nstatus;
    }


        public static void newState(Status s){
            try {
                //Saving of object in a file
                FileOutputStream file = new FileOutputStream("status.ser");
                ObjectOutputStream out = new ObjectOutputStream(file);

                // Method for serialization of object
                out.writeObject(s);

                out.close();
                file.close();


            } catch (IOException ex) {
                System.out.println("IOException is caught");
            }
        }
}



