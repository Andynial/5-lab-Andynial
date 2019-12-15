package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        JFrame frame = new LoginFrame();
        String filename = "Users.txt";
        ArrayList<User> users = new ArrayList<User>();
        User user = new User("Howard", "howdy", "1234");
        users.add(user);

        File file = new File(filename);
        UserManager manager = new UserManager(file);
        manager.WriteCollectionToFile(users);
    }

    static int ComputeMinTime(ArrayList<String> instruments, ArrayList<Request> requests){
        ArrayList<Integer> times = new ArrayList<Integer>();
        for (int i = 0; i < instruments.size(); i++) {
            String inst = instruments.get(i);
            int time = 0;
            for (int j = 0; j < requests.size(); j++) {
                Request req = requests.get(j);
                for (int c = 0; c < req.parts.size(); c++) {
                    if (req.parts.get(c).GetInstrument() == inst)
                        time += req.parts.get(c).GetTime();
                }
            }
            times.add(time);
        }

        int max = -1;
        for (int j = 0; j < times.size(); j++){
            if (times.get(j) > max)
                max = times.get(j);
        }

        return max;
    }

    static ArrayList<Request> Generate(ArrayList<String> instruments){
        ArrayList<Request> requests = new ArrayList<Request>();
        int req_number = 4;
        for (int i = 0; i < req_number; i++){
            Request request = new Request();
            for (int j = 0; j < instruments.size(); j++) {
                Random rnd = new Random();
                int index = rnd.nextInt(instruments.size());
                Part part = new Part(instruments.get(index), rnd.nextInt(19) + 1);
                request.AddPart(part);
            }
            requests.add(request);
        }
        return requests;
    }


    static void Login(String login, String password, String filename, LoginFrame frame) throws IOException {
        UserManager manager = new UserManager(new File(filename));
        ArrayList<User> users = manager.ReadIntoCollection();
        for (User user : users){
            if (user.login.equals(login) && user.password.equals(password)){
                frame.setVisible(false);
                JFrame mainframe = new MainForm();
                break;
            }
        }
    }

}

