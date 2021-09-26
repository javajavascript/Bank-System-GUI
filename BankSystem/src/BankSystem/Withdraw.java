package BankSystem;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

/**
 * Allows the user to withdraw money
 */
public class Withdraw
{
    JFrame frame = new JFrame(); 
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Amount");
    JTextField input = new JTextField(10);
    JButton button = new JButton("Withdraw");
    JLabel success = new JLabel("");
    JCheckBox toChecking = new JCheckBox("Withdraw from checking account");
    JCheckBox toSavings = new JCheckBox("Withdraw from savings account");
    
    /**
     * Creates the window to withdraw money
     */
    public Withdraw()
    {
        frame.setTitle("Login GUI");
        frame.add(panel);
        panel.setLayout(new GridLayout(0,1));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        Color customColor = new Color(100, 200, 255);
        panel.setBackground(customColor);

        panel.add(label);
        panel.add(input);
        panel.add(toChecking);
        panel.add(toSavings);

        panel.add(success);
        success.setForeground(Color.BLUE);
        panel.add(button);

        frame.pack();
        frame.setVisible(true);
        button.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e) 
                { 
                    withdraw(); 
                }
            });
    }
    
    /**
     * Verifies that a string is an integer
     */
    public boolean isInt(String s)
    {
    	try
    	{
    		Integer.parseInt(s);
    		return true; 
    	}
    	catch (NumberFormatException e)
    	{
    		return false;
    	}
    }
    
    /**
     * Withdraws money from account and updates balances accordingly
     * Verifies that user input is not blank and is an integer
     */
    public void withdraw()
    {
    	String userInput = input.getText();
    	if (userInput.equals(""))
    	{
    		success.setText("Input is blank");
            success.setForeground(Color.RED);
    	}
    	else if (!toChecking.isSelected() && !toSavings.isSelected())
    	{
   		 	success.setText("No selection made");
            success.setForeground(Color.RED);
    	}
    	else if (isInt(userInput))
    	{
			int amount = Integer.parseInt(userInput);
    		if (toChecking.isSelected() && !toSavings.isSelected())
    		{
    			if (BankSystem.getCheckingBalance() >= amount)
    			{
    				BankSystem.addCheckingBalance(-amount);
	       	    	success.setText("Withdrew $" + amount + " from checking");
	       	    	success.setForeground(Color.GREEN);
    			}
    			else
    			{
    				success.setText("Checking doesn't have enough $");
    				success.setForeground(Color.RED);
    			}
    		}
    		else if (toSavings.isSelected() && !toChecking.isSelected())
            {
    			if (BankSystem.getSavingsBalance() >= amount)
    			{
    				BankSystem.addSavingsBalance(-amount);
    				success.setText("Withdrew $" + amount + " from savings");
    				success.setForeground(Color.GREEN);
    			}
    			else
    			{
    				success.setText("Savings doesn't have enough $");
    				success.setForeground(Color.RED);
    			}
            }
    		else
    		{
    			success.setText("Select one account");
				success.setForeground(Color.RED);
    		}
    	}
    	else
    	{
    		success.setText("Input is not a number");
			success.setForeground(Color.RED);
    	}
    }
}

