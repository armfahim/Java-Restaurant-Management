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

public class LoginSystem1 extends JFrame implements ActionListener
{
	private JPanel panel1;
	private JLabel title,username,password;
	private JTextField nameField;
	private JPasswordField passField;
	private JButton back,submit;
	private boolean flag;

	public LoginSystem1()
	{
		super("Dimoke Restaurant - Customer Login Window");
		this.setSize(1000,600);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		panel1 = new JPanel();
		panel1.setLayout(null);
		
		title = new JLabel("Welcome To Our Restaurant Billng System");
		title.setFont(new Font("Serif", Font.BOLD, 22)); 
		title.setBounds(400,50,700,30);
		panel1.add(title);
		
		username = new JLabel("USER NAME:");
		username.setBounds(400,100,90,60);
		panel1.add(username);
		
		password = new JLabel("PASSWORD:");
		password.setBounds(400,140,90,60);
		panel1.add(password);
		
		nameField = new JTextField();
		nameField.setBounds(500,110,100,30);
		panel1.add(nameField);
		
		passField = new JPasswordField();
		passField.setBounds(500,150,100,30);
		panel1.add(passField);
		
		submit = new JButton("SUBMIT");
		submit.setBounds(450, 200, 100,30);
		panel1.add(submit);
		
		back = new JButton("BACK");
		back.setBounds(600, 200, 100,30);
		panel1.add(back);
		
		back.addActionListener(this);
		submit.addActionListener(this);
		
		this.add(panel1);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		
		if(ae.getSource()==back)
		{
			
            LoginType lt=new LoginType();
		    lt.setVisible(true);
			setVisible(false);
		}
	    if(ae.getSource()==submit)
	    {
               
          Connection con=null;//for connection
          Statement st = null;//for query execution
		  ResultSet rs = null;//to get row by row result from DB
		  //System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			String query ="SELECT `Name`,`Password` FROM `userinfo`;";
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");
					
			while(rs.next())
			{
                String name = rs.getString("Name");
                String pass = rs.getString("Password");
				//int accountNumber = rs.getInt("AccountNumber");
				//String accountHolderName = rs.getString("AccountHolderName");
				//double balance = rs.getDouble("Balance");
				
				if(name.equals(nameField.getText()))
				{
					flag=false;
					if(pass.equals(passField.getText()))
					{
						Customer c=new Customer();
						c.setVisible(true);
						setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(this,"Invalid pass"); 
					}
				}			
			}
			if(flag){JOptionPane.showMessageDialog(this,"Invalid name"); }
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
	}		
			
  }   
	
	/*public static void main(String args[])
	{
		LoginSystem ls=new LoginSystem();
		ls.setVisible(true);
	}*/


}