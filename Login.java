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

public class Login extends JFrame implements ActionListener
{
	private JPanel panel1;
	private JLabel title;
	private JButton login, signup;
	public Login()
	{
		super("Dimoke Restaurant");
		//setContentPane(new JLabel(new ImageIcon("front-side-of-the-restaurant.jpg")));
		//setSize(1000,300);
		//setVisible(true);
		this.setSize(1000,300);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		panel1 = new JPanel();
		panel1.setLayout(null);
		
		title = new JLabel("Welcome To Our Restaurant Billng System");
		title.setFont(new Font("Serif", Font.BOLD, 22)); 
		title.setBounds(360,50,700,30);
		panel1.add(title);
		
		login = new JButton("Log In");
		//login.setFont(new Font("Serif", Font.BOLD, 22)); 
		login.setBounds(390,130,100,30);
		panel1.add(login);
		
		signup = new JButton("SIGNUP");
		//signup.setFont(new Font("Serif", Font.BOLD, 22)); 
		signup.setBounds(540,130,100,30);
		panel1.add(signup);
		
		this.add(panel1);
		
		login.addActionListener(this);
		signup.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==login){
			
			LoginType lt=new LoginType();
		    lt.setVisible(true);
			setVisible(false);
			
		}
		
	    if(ae.getSource()==signup){
			
			SigninForm sf=new SigninForm();
		    sf.setVisible(true);
			setVisible(false);
			
		}
		
		
	}
	
	public static void main(String args[])
	{
		Login l=new Login();
		l.setVisible(true);
		
	}

	

}