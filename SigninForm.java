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

public class SigninForm extends JFrame implements ActionListener
{
	private JPanel panel1;
	private JLabel title,name,mail,password,contact;
	private JTextField t1,t2,t3,t4;
	private JPasswordField passField;
	private JButton submit,back;
	
	Statement st=null;
	ResultSet rs=null;
	public SigninForm()
	{
		super("Dimoke Restaurant - Sign UP ");
		this.setSize(1000,600);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		panel1 = new JPanel();
		panel1.setLayout(null);
		
		title = new JLabel("Welcome To Our Restaurant Billng System");
		title.setFont(new Font("Serif", Font.BOLD, 22)); 
		title.setBounds(400,50,700,30);
		panel1.add(title);
		
		name = new JLabel("Name : ");
		name.setBounds(400,100,90,60);
		panel1.add(name);
		
		mail = new JLabel("E-Mail : ");
		mail.setBounds(400,170,90,60);
		panel1.add(mail);
		
		contact = new JLabel("Contact Number: ");
		contact.setBounds(400,240,100,60);
		panel1.add(contact);
		
		password= new JLabel("Password : ");
		password.setBounds(400,310,90,60);
		panel1.add(password);
		
		t1= new JTextField();
		t1.setBounds(500,110,100,30);
		panel1.add(t1);
		
		t2= new JTextField();
		t2.setBounds(500,180,100,30);
		panel1.add(t2);
		
		t3= new JTextField();
		t3.setBounds(500,255,100,30);
		panel1.add(t3);
		
		
		passField = new JPasswordField();
		passField.setBounds(500,320,100,30);
		panel1.add(passField);
		
		submit = new JButton("SUBMIT");
		submit.setBounds(450, 390, 100,30);
		panel1.add(submit);
		
		back = new JButton("BACK");
		back.setBounds(450, 430, 100,30);
		panel1.add(back);
		
		this.add(panel1);
		
		submit.addActionListener(this);
		back.addActionListener(this);
		
		
	}
	
	public void actionPerformed(ActionEvent ae){
		
		if(ae.getSource()==back){
			
			Login l=new Login();
		    l.setVisible(true);
			setVisible(false);
	     }
		 if(ae.getSource()==submit){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				st = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","").createStatement();
				
				
				String name = t1.getText();
				String email = t2.getText();
				String contact = t3.getText();
				//String email=t4.getText();
				String password=passField.getText();
				
				String query="INSERT INTO `userinfo`(`Name`, `Email`, `Contact`,`Password`) VALUES ('"+name+"','"+email+"','"+contact+"','"+password+"')";
				
				if(st.executeUpdate(query)==1){
					JOptionPane.showMessageDialog(this, "Successfully Registered ");

				}
				
				else{
					JOptionPane.showMessageDialog(this, "Failed To Insert");
				}
				//ProductCat p = new ProductCat();
				Login l=new Login ();
				setVisible(true);
				//setVisible(false);
				}catch (Exception ex){
					
					JOptionPane.showMessageDialog(this, "Error");
					  
				}
	     }
	}
	
	/*public static void main(String args[])
	{
		SigninForm sf=new SigninForm();
		sf.setVisible(true);
	}*/

	

}