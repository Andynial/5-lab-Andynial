package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class InsertForm extends JFrame {
    private JButton compute_bt;
    private JPanel panel1;
    private JTextArea txt;
    private JButton form_bt;
    private JButton add_bt;

    public InsertForm() {
        super("Insert Form");
        setBounds(550, 200, 650, 400);
        setContentPane(panel1);
        setVisible(true);

        ArrayList<String> instruments = new ArrayList<>();
        add_bt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if (txt.getText() == ""){
                    JOptionPane.showMessageDialog(null, "Введите название инструмента!");
                } else {
                    String instrument = txt.getText();
                    instruments.add(instrument);
                    txt.setText("");
                }
            }
        });

        ArrayList<Request> requests = new ArrayList<>();
        form_bt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if (instruments.size() == 0)
                    JOptionPane.showMessageDialog(null, "Вы не добавили ни одного инструмента!");
                else{
                    int req_number = 4;
                    for (int i = 0; i < req_number; i++) {
                        Request request = new Request();
                        for (int j = 0; j < instruments.size(); j++) {
                            Random rnd = new Random();
                            int index = rnd.nextInt(instruments.size());
                            Part part = new Part(instruments.get(index), rnd.nextInt(19) + 1);
                            request.AddPart(part);
                        }
                        requests.add(request);
                    }

                    String text = "Поступающие запросы:";
                    for (Request req : requests){
                        text += " " + req.PrintRequest() + " ";
                        text += "||";
                    }
                    txt.setText(text);
                }
            }
        });

        compute_bt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if (instruments.size() == 0 || requests.size() == 0)
                    JOptionPane.showMessageDialog(null, "Вы не добавили ни одного инструмента, либо не сформировали запросы.");
                else {
                    int min = Main.ComputeMinTime(instruments, requests);
                    txt.setText("Минимальное время выполнения: " + min + " часов.");
                }
            }
        });
    }

}
