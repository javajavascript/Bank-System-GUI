package BankSystem;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

/**
 * Allows the user to deposit money
 */
public class Deposit 
{
    JFrame frame = new JFrame(); 
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Amount");
    JTextField input = new JTextField(10);
    JButton button = new JButton("Deposit");
    JLabel success = new JLabel("");
    JCheckBox toChecking = new JCheckBox("Deposit into checking account");
    JCheckBox toSavings = new JCheckBox("Deposit into savings account");
    
    /**
     * Creates the window to deposit money
     */
    public Deposit()
    {
        frame.setTitle("Deposit");
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
                    deposit(); 
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
     * Deposits money into account and updates balances accordingly
     * Verifies that user input is not blank and is an integer
     */
    public void deposit()
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
    			BankSystem.addCheckingBalance(amount);
	       	    success.setText("Deposited $" + amount + " to checking");
	       	    success.setForeground(Color.GREEN);
    		}
    		else if (toSavings.isSelected() && !toChecking.isSelected())
            {
    			BankSystem.addSavingsBalance(amount);
    			success.setText("Deposited $" + amount + " to savings");
    			success.setForeground(Color.GREEN);
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

