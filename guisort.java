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
public class guisort {
    private JButton button1;
    private JProgressBar progressBar1;
    private JTextField mainTextField;
    private JLabel infoLabel;
    private JPanel mainPanel1;
    Integer barValue = 0;
    String infoLabelText = "";
    String result = "";


    public void maintestspeed(int[] list) {
        TimeTracker[] algs = new TimeTracker[]{
                //new TimeTracker(new YuliaSort.Comb(), "Yulia.CombSort"),
                //new TimeTracker(new YuliaSort.Insertion(), "Yulia.Insertionsort"),
                //new TimeTracker(new YuliaSort.Bubble(), "Yulia.BubbleSort"),
                //new TimeTracker(new YuliaSort.Gnome(), "Yulia.GnomeSort"),
                //new TimeTracker(new YuliaSort.Selection(), "Yulia.SelectionSort"),
                new TimeTracker(new Sort.cocktailsort(), "Lee.cocktailsort"),
                new TimeTracker(new Sort.bubblesort(), "Lee.bubblesort"),
                new TimeTracker(new Sort.monkeysort(), "Lee.monkeysort"),
                new TimeTracker(new Sort.selectionsort(), "Lee.selectionsort"),
                new TimeTracker(new Sort.combsort(), "Lee.combsort")
        };

        for (TimeTracker alg : algs) {
            int[] toSort = list.clone();
            System.out.println(alg.name);
            infoLabelText = alg.name;
            alg.sort(toSort);
            result = result + alg.name + ":  " + String.valueOf(alg.result) + "\n";
            barValue += 100/(algs.length);
        }
    }


    public guisort() {
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
                progressBar1.setMaximum(100);
                barValue = 0;
                result = "";
                Thread one = new Thread(() -> {
                    try {
                        while (barValue < 100) {
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
                                    barValue = 100;
                                    result = "Error";

                                }
                            } catch (Exception ex) {
                                infoLabelText = "Error";
                                barValue = 100;
                                result = "Error";
                            }
                            Thread.sleep(1);
                            JOptionPane.showMessageDialog(null, result, "Result",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    }  catch(InterruptedException v) {
                        System.out.println(v.getMessage());
                    }
                });
                one.start();
                Thread two = new Thread(() -> {
                    try {
                        while (barValue <= 100) {
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
        frame.setContentPane(new guisort().mainPanel1);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


}