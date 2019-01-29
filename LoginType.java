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

class LoginType extends JFrame implements ActionListener
{
	private JPanel panel1;
	private JLabel title;
	private JButton admin, customer,back;
	public LoginType()
	{
		super("Dimoke Restaurant - Login Type");
		this.setSize(1000,300);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		panel1 = new JPanel();
		panel1.setLayout(null);
		
		title = new JLabel("Welcome To Our Restaurant Billng System");
		title.setFont(new Font("Serif", Font.BOLD, 22)); 
		title.setBounds(400,50,700,30);
		panel1.add(title);
		
		admin = new JButton("ADMIN");
		admin.setBounds(390,130,100,30);
		panel1.add(admin);
		
		customer = new JButton("CUSTOMER");
		customer.setBounds(540,130,100,30);
		panel1.add(customer);
		
		back = new JButton("BACK");
		back.setBounds(460, 180, 100,30);
		panel1.add(back);
		
		admin.addActionListener(this);
		customer.addActionListener(this);
		back.addActionListener(this);
		
		this.add(panel1);	
	}



     public void actionPerformed(ActionEvent ae){
		
		if(ae.getSource()==admin){
			
			LoginSystem ls=new LoginSystem();
		    ls.setVisible(true);
			setVisible(false);
		}	
		if(ae.getSource()==customer){
			
			LoginSystem1 ls1=new LoginSystem1();
		    ls1.setVisible(true);
			setVisible(false);
		}
			if(ae.getSource()==back){
			
			Login l=new Login();
		    l.setVisible(true);
			setVisible(false);	
		}
}
	
	

}	


	

