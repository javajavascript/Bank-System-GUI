package BankSystem;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.util.*;  

/**
 * Allows the user to login by matching the credentials with the account's credentials 
 */
public class Login
{
    JFrame frame = new JFrame(); 
    JPanel panel = new JPanel();
    JLabel labelUser = new JLabel("Username");
    JTextField username = new JTextField(10);
    JLabel labelPass = new JLabel("Password");
    JPasswordField password = new JPasswordField(10);
    JButton button = new JButton("Login");
    JLabel success = new JLabel("");
    /**
     * Creates the login GUI with a username and password textbox
     */
    public Login()
    {
        frame.setTitle("Login GUI");
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
                login(); 
            }
        });
    }

    /**
     * Matches the username and password entered with the account's username and password.
     * Sets a green "correct" message if correct, otherwise, set a red "incorrect" message.
     */
    public void login()
    {
        String userInput = username.getText();
        //char[] passwordInput = password.getPassword();
        //String passwordInput2 = String.valueOf(passwordInput);
        String passwordInput = String.valueOf(password.getPassword());
        if (userInput.equals(CreateAccount.getUser()) && passwordInput.equals(CreateAccount.getPassword()))
        {
            success.setText("Correct");
            success.setForeground(Color.GREEN);
            createBankSystem(); 
        }
        else
        {
            success.setText("Incorrect login");
            success.setForeground(Color.RED);
        }
        frame.pack();
    }
    
    /**
     * Creates the GUI for the bank system (the page after loggin in)
     */
    public void createBankSystem()
    {
    	BankSystem bank = new BankSystem(); 
    	Home.getFrame().setVisible(false);
    	CreateAccount.getFrame().setVisible(false);
    	frame.setVisible(false);
    }
}

