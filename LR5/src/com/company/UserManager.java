package com.company;

import java.io.*;
import java.util.ArrayList;

public class UserManager {
    File file;

    public UserManager(File file){
        this.file = file;
    }

    void WriteObjectToFile(User user){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(user);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    ArrayList<User> ReadIntoCollection() throws IOException {
        ArrayList<User> users = new ArrayList<>();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

        while (true) {
            try {
                User user = (User) ois.readObject();
                users.add(user);
            } catch (EOFException | ClassNotFoundException e){
                ois.close();
                break;
            }
        }
        return users;
    }

    void WriteCollectionToFile(ArrayList<User> users){
        for (User user : users){
            WriteObjectToFile(user);
        }
    }
}
