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
import javax.swing.table.DefaultTableModel;

public class TotalBillCustomer extends JFrame implements ActionListener
{
	private JPanel panel1;
	private JLabel label1,title,label2,label3,label4;
	private JTextField text1;
	private JButton button1,button2;
	private JRadioButton r1,r2;
	private ButtonGroup bg1,bg2;
	private double r;
	public TotalBillCustomer()
	{
		
		super("Dimoke Restaurant - Show Bill (Customer) ");
		//setContentPane(new JLabel(new ImageIcon("front-side-of-the-restaurant.jpg")));
		//setSize(1000,300);
		//setVisible(true);
		this.setSize(500,500);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		panel1 = new JPanel();
		panel1.setLayout(null);
		
		title = new JLabel("Welcome To Our Restaurant Billng System");
		title.setFont(new Font("Serif", Font.BOLD, 20)); 
		title.setBounds(90,15,700,30);
		panel1.add(title);
		
		//JLabel myText = new JLabel("I'm a label in the window, output : "+total,
        //SwingConstants.CENTER);
		
		
		
		label1=new JLabel("Total Bill: ");
		label1.setFont(new Font("Serif", Font.BOLD, 32)); 
		label1.setBounds(110,100,150,60);
		panel1.add(label1);
		
		label2=new JLabel("Something: ");
		label2.setFont(new Font("Serif", Font.BOLD, 32)); 
		label2.setBounds(270,100,150,60);
		panel1.add(label2);
		
		label3=new JLabel("TK");
		label3.setFont(new Font("Serif", Font.BOLD, 32)); 
		label3.setBounds(350,100,100,60);
		panel1.add(label3);
		
		label4=new JLabel("<>Want To Order More Foods<>");
		label4.setFont(new Font("Serif", Font.BOLD, 20));
		label4.setBounds(125,200,280,40);
		panel1.add(label4);
		
		r1 = new JRadioButton(" Yes ");
		r1.setBounds(170,255,80,30);
		panel1.add(r1);
		
		r2 = new JRadioButton("No");
		r2.setBounds(280,255,80,30);
		panel1.add(r2);
		
		bg1 = new ButtonGroup();
		bg1.add(r1);
		bg1.add(r2);
		
		button1=new JButton("Log Out");
		button1.setFont(new Font("Serif", Font.BOLD, 20));
		button1.setBounds(185,380,120,40);
		panel1.add(button1);
		
		r1.addActionListener(this);
		r2.addActionListener(this);
		button1.addActionListener(this);
		
		
		 
		
		
		this.add(panel1);
	}
	
	public void setBill(double r)
	{   
		this.r=r;
		label2.setText(String.valueOf(r));
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==r1)
		{
			Billing b=new Billing();
			b.setVisible(true);
			setVisible(false);
			
		}
		if(ae.getSource()==r2)
		{
			JOptionPane.showMessageDialog(rootPane,"Thank You For Coming To Our Restaurant");
			
		}
		if(ae.getSource()==button1)
		{
		    LoginSystem1 ls1=new LoginSystem1();
		    ls1.setVisible(true);
			setVisible(false);
			
		}
	}
	
	public static void main(String args[])
	{
		TotalBill l=new TotalBill();
		l.setVisible(true);
		
	}
}