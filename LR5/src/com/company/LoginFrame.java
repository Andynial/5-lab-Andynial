package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginFrame extends JFrame {

    private JTextArea login, password;
    private JButton b;
    private JLabel label;

    public LoginFrame(){
        super("Log in");
        Font font = new Font("TimesNewRoman", Font.PLAIN, 14);
        b = new JButton("Log in");
        b.setBounds(95, 140, 100, 25);
        b.setFont(font);

        login = new JTextArea();
        login.setBounds(70, 70, 150, 20);
        login.setFont(font);

        password = new JTextArea();
        password.setBounds(70, 105, 150, 20);
        password.setFont(font);

        label = new JLabel("Введите логин и пароль:");
        label.setSize(label.getPreferredSize());
        label.setLocation(70, 40);

        String path = "C:\\Users\\User\\Desktop\\Everlasting Hug\\Java\\LR5\\";
        String filename = "Users.txt";

        LoginFrame frame = this;
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Main.Login(login.getText(), password.getText(), path + filename, frame);
                } catch (IOException e){
                    System.out.println(e.getMessage());
                }
            }
        });

        add(b);
        add(login);
        add(password);
        add(label);

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(550, 200, 300, 300);
        setVisible(true);

    }

    void SetInvisible(){
        setVisible(false);
    }
}
