package com.company.work.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Reader extends JFrame {
    JButton clear, calculate;
    JLabel l1, l2, l3, l4;
    JTextField t1, t2;
    int i, k;
    String a, b;
    eHandler handler = new eHandler();

    public Reader(String s) {
        super(s);
        setLayout(new FlowLayout());
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        l2 = new JLabel("Введите второе число:");
        l1 = new JLabel("Введите перове число:");
        l3 = new JLabel("");
        l4 = new JLabel("");
        clear = new JButton("Clear");
        calculate = new JButton("Calculate");
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(calculate);
        add(clear);
        add(l3);
        add(l4);
        calculate.addActionListener(handler);
        clear.addActionListener(handler);
    }

    public class eHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource() == calculate) {
                    i = Integer.parseInt(t1.getText());
                    k = Integer.parseInt(t2.getText());
                    i++;
                    k++;
                    a = "Ваше первое число теперь = " + i;
                    b = "Ваше второе число теперь = " + k;
                    l3.setText(a);
                    l4.setText(b);
                }
                if (e.getSource() == clear) {
                    t1.setText(null);
                    t2.setText(null);
                    l3.setText("");
                    l4.setText("");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Введите в поле число");
            }
        }
    }
}
