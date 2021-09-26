package BankSystem;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.*; 

/**
 * Allows the user to calculate the future value of their balance
 */
public class FutureValue
{
    JFrame frame = new JFrame(); 
    JPanel panel = new JPanel();
    JLabel label2 = new JLabel("Principal is savings balance");
    JLabel label3 = new JLabel("Interest rate is 5%, compounded daily");
    JLabel label1 = new JLabel("Enter days from now:");
    JTextField username = new JTextField(10);
    JButton button = new JButton("Calculate Future Value");
    JLabel success = new JLabel("");
    
    /**
     * Creates the window to calculate future value
     */
    public FutureValue()
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
     * Calculates the future value using the future value formula
     */
    public void calculate()
    {
    	String userInput = username.getText();//this has to be inside a method
        double amount = 0; 
        double principal = BankSystem.getSavingsBalance(); 
        double rate = 0.05;
        if (!userInput.equals(""))
        {
        	int time = Integer.parseInt(userInput);
        	amount = principal*Math.pow(1+rate/365, time);//really is n*t/n
        	success.setText(String.format("Future value is: $%.2f", amount));
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

