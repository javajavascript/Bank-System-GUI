package BankSystem;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

/**
 * Allows the user to calculate the present value balance needed to reach a given future value
 */
public class PresentValue
{
    JFrame frame = new JFrame(); 
    JPanel panel = new JPanel();
    JLabel label2 = new JLabel("Principal is savings balance");
    JLabel label3 = new JLabel("Interest rate is 5%, compounded daily");
    JLabel label1 = new JLabel("Enter days from now:");
    JLabel label4 = new JLabel("Enter expected amount ($):");
    JTextField username = new JTextField(10);
    JTextField username2 = new JTextField(10);
    JButton button = new JButton("Calculate Present Value");
    JLabel success = new JLabel("");
    
    /**
     * Creates the window to calculate present value
     */
    public PresentValue()
    {
        frame.setTitle("Future Value");
        frame.add(panel);
        panel.setLayout(new GridLayout(0,1));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        Color customColor = new Color(100, 200, 255);
        panel.setBackground(customColor);

        panel.add(label2);
        panel.add(label3);
        panel.add(label1);
        panel.add(username);
        panel.add(label4);
        panel.add(username2);

        panel.add(success);
        success.setForeground(Color.BLUE);
        panel.add(button);

        frame.pack();
        frame.setVisible(true);
        button.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e) 
                { 
                    calculate(); 
                }
            });
    }

    /**
     * Calculates the present value using the present value formula
     */
    public void calculate()
    {
    	String userInput = username.getText();//this has to be inside a method
        String userInput2 = username2.getText();
    	double amount = 0; 
        //double principal = BankSystem.getSavingsBalance(); 
        double rate = 0.05;
        if (!userInput.equals(""))
        {
        	int time = Integer.parseInt(userInput);
            int expectedAmount = Integer.parseInt(userInput2);//future value
        	amount = expectedAmount/(Math.pow(1+rate/365, time));//really is n*t/n
        	success.setText(String.format("Present value is: $%.2f", amount));
            //success.setText("Future value is: " + amount);
            success.setForeground(Color.GREEN);
        }
        else
        {
            success.setText("Input is blank");
            success.setForeground(Color.RED);
        }
        frame.pack();
    }
}


