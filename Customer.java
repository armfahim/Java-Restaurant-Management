import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.Dimension;
import javax.swing.SwingUtilities;

public class Customer extends JFrame implements ActionListener
{
	private JPanel panel1;
	private JLabel title;
	private JButton submit,billing,viewHistory,back; 
	public Customer()
	{
		super("Dimoke Restaurant - Customer Section");
		this.setSize(1000,300);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		panel1 = new JPanel();
		panel1.setLayout(null);
		
		title = new JLabel("Welcome To Our Restaurant Billng System");
		title.setFont(new Font("Serif", Font.BOLD, 22)); 
		title.setBounds(400,50,700,30);
		panel1.add(title);
		
		billing= new JButton("BILLING");
		billing.setBounds(390,130,100,30);
		panel1.add(billing);
		
		viewHistory= new JButton("VIEW PRODUCTS");
		viewHistory.setBounds(540,130,150,30);
		panel1.add(viewHistory);
		
		submit = new JButton("SUBMIT");
		submit.setBounds(450, 200, 100,30);
		panel1.add(submit);
		
		back = new JButton("BACK");
		back.setBounds(570, 200, 100,30);
		panel1.add(back);
		
		this.add(panel1);
		
		billing.addActionListener(this);
		viewHistory.addActionListener(this);
		submit.addActionListener(this);
		back.addActionListener(this);
		  
		 
		
	}
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==back)
		{
			
			LoginSystem1 ls1=new LoginSystem1();
		    ls1.setVisible(true);
			setVisible(false);
		}
		if(ae.getSource()==billing)
		{
			Billing b=new Billing();
		    b.setVisible(true);
			setVisible(false);
		}
		if(ae.getSource()==viewHistory)
		{
			
			CustomerBillHistory bh1=new CustomerBillHistory();
		    bh1.setVisible(true);
			setVisible(false);		
		}
	}
	
	public static void main(String args[])
	{
		Customer c=new Customer();
		c.setVisible(true);
	}

	

}