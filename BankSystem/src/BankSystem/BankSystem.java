package BankSystem;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * The main page of the program after logging in
 */
public class BankSystem
{
    static JFrame frame = new JFrame(); 
    static JPanel panel1 = new JPanel();
    static JPanel panel2 = new JPanel();
    static JPanel panel3 = new JPanel();
    static ImageIcon bank = new ImageIcon("src/bank.png");
    /**
     * Creates a GUI with buttons for various actions
     * Actions include transfer, deposit, and withdraw money
     * Actions include view balance, scan check, calculate future/present value 
     */
    public BankSystem()
    {
        frame.setLayout(new BorderLayout());
        frame.add(panel1, BorderLayout.PAGE_START);
        frame.add(panel2, BorderLayout.CENTER);
        frame.add(panel3, BorderLayout.PAGE_END);
        //top, left, bottom, right
        panel1.setBorder(BorderFactory.createEmptyBorder(30, 20, 0, 20));
        panel2.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
        panel3.setBorder(BorderFactory.createEmptyBorder(0, 20, 30, 20));

        panel1.setLayout(new FlowLayout());
        JButton transfer = new JButton("Transfer Money");
        panel3.add(transfer);
        JButton deposit = new JButton("Deposit Money");
        panel3.add(deposit);
        JButton withdraw = new JButton("Withdraw Money");
        panel3.add(withdraw);

        JLabel bankLabel = new JLabel(bank);
        panel2.add(bankLabel);  

        panel3.setLayout(new FlowLayout());

        JButton view = new JButton("View Balance");
        panel1.add(view);
        JButton scan = new JButton("Scan Check");
        panel1.add(scan);
        JButton futureValue = new JButton("Future Value");
        panel1.add(futureValue);
        JButton presentValue = new JButton("Present Value");
        panel1.add(presentValue);

        Color customColor = new Color(100, 200, 255);
        panel1.setBackground(customColor);
        panel2.setBackground(customColor);
        panel3.setBackground(customColor);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.pack();
        frame.setVisible(true);

        transfer.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e) 
                { 
                    transfer(); 
                }
            });

        deposit.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e) 
                { 
                    deposit(); 
                }
            });
        withdraw.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e) 
                { 
                    withdraw(); 
                }
            });
        view.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e) 
                { 
                    view(); 
                }
            });
        scan.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e) 
                { 
                    try {
						scan();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
                }
            });
        futureValue.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e) 
                { 
                    futureValue(); 
                }
            });
        presentValue.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            { 
                presentValue(); 
            }
        });
    }

    /**
     * Creates a window to transfer money
     */
    public static void transfer()
    {
    	Transfer transfer = new Transfer(); 
    }
    
    /**
     * Creates a window to deposit money
     */
    public static void deposit()
    {
    	Deposit deposit = new Deposit();
    }
    
    /**
     * Creates a window to withdraw money
     */
    public static void withdraw()
    {
    	Withdraw withdraw = new Withdraw();
    }

	static double checkingBalance = 10.00;
	static double savingsBalance = 10.00;
	
    /**
     * Display balance to 2 decimal places
     */
    public static void view()
    {
        System.out.printf("Checking Balance: $%.2f\n", checkingBalance);
        System.out.printf("Savings Balance: $%.2f\n", savingsBalance);
        System.out.println();
    }
    
    public static double getSavingsBalance()
    {
    	return savingsBalance;
    }
    
    public static double getCheckingBalance()
    {
    	return checkingBalance;
    }
    
    public static void addSavingsBalance(double s)
    {
    	savingsBalance += s; 
    }
    
    public static void addCheckingBalance(double c)
    {
    	checkingBalance += c; 
    }

    /**
     * Currently not in use due to directory limitation
     */
    public static final String DIR = "C:\\Users\\dan lu\\Desktop\\workplace - eclipse\\BankSystem\\";
    
    /**
     * Parses a text file to read the numeric value and add it to the user's balance
     */
    public static void scan() throws IOException
    {
    	BufferedWriter bw = new BufferedWriter(new FileWriter(DIR + "Check"));
        int x = (int)(Math.random()*100); 
        bw.write("Check Amount: $");
        bw.write(String.valueOf(x));
        bw.close();
        
        File file = new File(DIR + "Check");
		Scanner scanner = new Scanner(file);
		int checkAmount = 0;
		while(scanner.hasNext())
		{
			String next = scanner.next();//necessary
			if (next.indexOf("$") == 0)//the indexes move because of scanner.next
			{
				checkAmount = Integer.valueOf(next.substring(next.indexOf("$")+1));
			}
		}
		scanner.close();
		System.out.println("Check successfully scanned");
		System.out.println("Check for $" + checkAmount + " saved into checking account");
		checkingBalance += checkAmount;
		System.out.println();
    }

    /**
     * Creates a window to calculate future value
     */
    public static void futureValue()
    {
    	FutureValue future = new FutureValue();
    }
    
    /**
     * Creates a window to calculate present value
     */
    public static void presentValue()
    {
    	PresentValue present = new PresentValue();
    }
}
