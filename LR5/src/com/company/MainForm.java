package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainForm extends JFrame {

    private JPanel panel1;
    private JTextField txt;
    private JButton bt_output;
    private JButton go_to_bt;
    private JButton bt_calculate;


    public MainForm() {
        super("Main Form");

        setBounds(550, 200, 650, 200);
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        ArrayList<String> instruments = new ArrayList<String>();
        instruments.add("ключ");
        instruments.add("молоток");
        instruments.add("гвозди");

        ArrayList<Request> requests = Main.Generate(instruments);
        bt_output.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                String text = "Поступающие запросы:";
                for (Request request : requests){
                    text += " " + request.PrintRequest() + " ";
                    text += "||";
                }
                txt.setText(text);
            }
        });

        bt_calculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                int min = Main.ComputeMinTime(instruments, requests);
                txt.setText("Минимальное время выполнения: " + min + " часов.");
            }
        });

        go_to_bt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
                JFrame InsertForm = new InsertForm();
            }
        });
    }

}
