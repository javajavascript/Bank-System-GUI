package BankSystem;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.util.*;  

/**
 * Allows the user to create an account by setting a username and password
 */
public class CreateAccount
{
    static JFrame frame = new JFrame(); 
    JPanel panel = new JPanel();
    JLabel labelUser = new JLabel("Username");
    JTextField username = new JTextField(10);
    JLabel labelPass = new JLabel("Password");
    JPasswordField password = new JPasswordField(10);
    JButton button = new JButton("Create Account");
    JLabel success = new JLabel("");
    /**
     * Creates the create account GUI with a username and password textbox
     */
    public CreateAccount()
    {
        frame.setTitle("Create Account GUI");
        frame.add(panel);
        panel.setLayout(new GridLayout(0,1));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        Color customColor = new Color(100, 200, 255);
        panel.setBackground(customColor);

        panel.add(labelUser);
        panel.add(username);
        panel.add(labelPass);
        panel.add(password);

        panel.add(success);
        success.setForeground(Color.BLUE);
        panel.add(button);

        frame.pack();
        frame.setVisible(true);
        
        button.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e) 
                { 
                    create(); 
                }
            });
    }

    static String userInput = "";
    static String passwordInput = "";
    
    /**
     * Creates an account as long as the username and password are not blank
     */
    public void create()
    {
        userInput = username.getText();
        //char[] passwordInput = password.getPassword();
        //String passwordInput2 = String.valueOf(passwordInput);
        passwordInput = String.valueOf(password.getPassword());
        if (!userInput.equals("") && !passwordInput.equals(""))
        {
            success.setText("Account Created");
            success.setForeground(Color.GREEN);
        }
        else
        {
            success.setText("Username or Password blank");
            success.setForeground(Color.RED);
        }	
        frame.pack();
    }
    
    public static String getUser()
    {
    	return userInput;
    }
    
    public static String getPassword()
    {
    	return passwordInput; 
    }
    
    public static JFrame getFrame()
    {
    	return frame;
    }
}


