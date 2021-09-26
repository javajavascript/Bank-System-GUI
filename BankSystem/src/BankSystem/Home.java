package BankSystem;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;

/**
 * The Home page of the program (on startup)
 */
public class Home
{
    static JFrame frame = new JFrame(); 
    static JPanel panel1 = new JPanel();
    static JPanel panel2 = new JPanel();
    static JPanel panel3 = new JPanel();
    static ImageIcon bank = new ImageIcon("src/bank.png");
    /**
     * Starts the program and creates the GUI with a create account and login button.
     */
    public static void main(String[] args)
    {
        frame.setLayout(new BorderLayout());
        //top panel, middle panel, bottom panel
        frame.add(panel1, BorderLayout.PAGE_START);
        frame.add(panel2, BorderLayout.CENTER);
        frame.add(panel3, BorderLayout.PAGE_END);
        //top, left, bottom, right
        panel1.setBorder(BorderFactory.createEmptyBorder(30, 20, 0, 20));
        panel2.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
        panel3.setBorder(BorderFactory.createEmptyBorder(0, 20, 30, 20));

        JLabel ridgeLabel = new JLabel(bank);
        panel2.add(ridgeLabel);  

        panel3.setLayout(new FlowLayout());

        JButton create = new JButton("Create Account");
        panel1.add(create);
        
        JButton login = new JButton("Login");
        panel1.add(login);

        Color customColor = new Color(100, 200, 255);
        panel1.setBackground(customColor);
        panel2.setBackground(customColor);
        panel3.setBackground(customColor);

        frame.pack();
        frame.setVisible(true);

        create.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            { 
                create(); 
            }
        });
        
        login.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e) 
                { 
                    login(); 
                }
            });
    }

    /**
     * Creates a new account for the user
     */
    public static void create()
    {
        CreateAccount create = new CreateAccount(); 
    }

    /**
     * Creates a login screen for the user
     */
    public static void login()
    {
        Login login = new Login(); 
    }
    
    public static JFrame getFrame()
    {
    	return frame;
    }
}
