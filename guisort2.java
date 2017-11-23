package com.company;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

/**
 * @author Lee
 */
public class guisort2 {
    private JButton button1;
    private JProgressBar progressBar1;
    private JTextField mainTextField;
    private JLabel infoLabel;
    private JPanel mainPanel1;
    Integer barValue = 0;
    String infoLabelText = "";
    String result = "";

    TimeTracker[] algs = new TimeTracker[]{
        new TimeTracker(new JuliaSort.Comb(), "Yulia.CombSort"),
                new TimeTracker(new JuliaSort.Insertion(), "Yulia.Insertionsort"),
                new TimeTracker(new JuliaSort.Bubble(), "Yulia.BubbleSort"),
                new TimeTracker(new JuliaSort.Gnome(), "Yulia.GnomeSort"),
                new TimeTracker(new JuliaSort.Selection(), "Yulia.SelectionSort"),
                new TimeTracker(new JuliaSort.Stupid(), "Yulia.StupidSort"),
                new TimeTracker(new ArtemsSorts.Bubble(), "Artem.BubleSort"),
                new TimeTracker(new ArtemsSorts.Counting(), "Artem.CountingSort"),
                new TimeTracker(new ArtemsSorts.Selection(), "Artem.SelectionSort"),
                new TimeTracker(new ArtemsSorts.Comb(), "Artem.CombSort"),
                new TimeTracker(new ArtemsSorts.Insertion(), "Artem.InsertionSort"),
                new TimeTracker(new Sort.cocktailsort(), "Lee.cocktailsort"),
                new TimeTracker(new Sort.bubblesort(), "Lee.bubblesort"),
                new TimeTracker(new Sort.selectionsort(), "Lee.selectionsort"),
                new TimeTracker(new Sort.combsort(), "Lee.combsort"),
                new TimeTracker(new Sort.monkeysort(), "Lee.monkeysort")
    };

    public void maintestspeed(int[] list) {


        for(TimeTracker alg : algs) {
            int[] toSort = list.clone();
            System.out.println(alg.name);
            infoLabelText = alg.name;
            alg.sort(toSort);
            result = result + alg.name + ":  " + String.valueOf(alg.result) + "\n";
            barValue += 1;
        }
    }


    public guisort2() {
        mainTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                progressBar1.setValue(0);
                infoLabel.setText("");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progressBar1.setValue(0);
                infoLabel.setText("");
                progressBar1.setMaximum(algs.length);
                barValue = 0;
                result = "";
                Thread one = new Thread(() -> {
                    try {
                        while (barValue < algs.length) {
                            try {
                                if (Integer.parseInt(mainTextField.getText()) > 0) {
                                    Integer length = Integer.parseInt(mainTextField.getText());
                                    Integer range = 10000;
                                    System.out.println("Creating array");
                                    infoLabel.setText("Creating array");
                                    infoLabelText = "Creating array";
                                    int[] list = ArrayTools.getRandomArray(length, range);
                                    maintestspeed(list);
                                } else {
                                    infoLabelText = "Error";
                                    barValue = algs.length;
                                    result = "Error";

                                }
                            } catch (Exception ex) {
                                infoLabelText = "Error";
                                barValue = algs.length;
                                result = "Error";
                            }
                            Thread.sleep(1);
                        }
                        JOptionPane.showMessageDialog(null, result, "Result",
                                JOptionPane.INFORMATION_MESSAGE);
                    }  catch(InterruptedException v) {
                        System.out.println(v.getMessage());
                    }
                });
                one.start();
                Thread two = new Thread(() -> {
                    try {
                        while (barValue <= algs.length) {
                            infoLabel.setText(infoLabelText);
                            progressBar1.setValue(barValue);
                            Thread.sleep(1);
                        }
                    } catch (InterruptedException v) {
                        System.out.println(v.getMessage());
                    }
                });
                two.start();
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new guisort2().mainPanel1);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


}