package com.company.ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class MyWindowApp extends JFrame {
    List<String> stringList = new ArrayList<String>();

    private JButton add;
    private JButton remove;
    private JButton sort;
    private JTextField wordToAdd;
    private JList<String> stringJList;
    private JScrollPane jScrollPane;

    public MyWindowApp() {
        super("Crow calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add = new JButton("Add");
        //add.setBounds();

        remove = new JButton("Remove");
        sort = new JButton("Sort");
        wordToAdd = new JTextField(20);

        stringJList = new JList<>();
        stringJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane = new JScrollPane(stringJList);

        JPanel buttonsPanel = new JPanel(new FlowLayout());
        JPanel textPanels = new JPanel(new FlowLayout());


        textPanels.add(wordToAdd);
        textPanels.add(jScrollPane);

        add(textPanels, BorderLayout.NORTH);

        buttonsPanel.add(add);
        buttonsPanel.add(remove);
        buttonsPanel.add(sort);
        add(buttonsPanel, BorderLayout.SOUTH);
        initListeners();
    }

    private void initListeners() {

        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stringList.add(wordToAdd.getText());
                wordToAdd.setText(null);
                update();
            }
        });
        remove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stringList.remove(stringList.size() - 1);
                update();
            }
        });
        sort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Collections.sort(stringList);
                update();
            }
        });
    }

    private void update() {
        stringJList.setListData(stringList.toArray(new String[stringList.size()]));
    }

    public static void main(String[] args) {
        MyWindowApp app = new MyWindowApp();
        app.setVisible(true);
        app.pack(); /* Эта команда подбирает оптимальный размер в зависимости от содержимого окна  */
        app.setLocationRelativeTo(null);
    }
}