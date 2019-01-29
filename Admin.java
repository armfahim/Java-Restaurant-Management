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

public class Admin extends JFrame implements ActionListener
{
	private JPanel panel1;
	private JLabel title;
	private JButton billing,viewHistory,manageProduct,back;
	public Admin()
	{
		super("Dimoke Restaurant - Admin Section");
		this.setSize(1000,400);
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
		
		manageProduct= new JButton("MANAGE PRODUCTS");
		manageProduct.setBounds(540,130,150,30);
		panel1.add(manageProduct);
		
		viewHistory= new JButton("VIEW PRODUCTS");
		viewHistory.setBounds(445,180,150,30);
		panel1.add(viewHistory);
		
		back = new JButton("BACK");
		back.setBounds(470, 250, 100,30);
		panel1.add(back);
		
		this.add(panel1);
		
		billing.addActionListener(this);
		viewHistory.addActionListener(this);
		manageProduct.addActionListener(this);
		back.addActionListener(this);
		
	}
	
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==back)
		{
			LoginSystem ls=new LoginSystem();
		    ls.setVisible(true);
			setVisible(false);
		}
        else if(ae.getSource()==manageProduct)
        {
			ManageProduct mp =new ManageProduct();
		    mp.setVisible(true);
			setVisible(false);
		}
        else if(ae.getSource()==billing)
        {
			BillingAdmin b = new BillingAdmin();
		    b.setVisible(true);
			setVisible(false);
		}
        else if(ae.getSource()==viewHistory)
        {
			
		     BillHistory bh = new BillHistory();
		     bh.setVisible(true);
			 setVisible(false);
		}			
		
		
	}
	public static void main(String args[])
	{
		Admin a=new Admin();
		a.setVisible(true);
		
	}

	

}