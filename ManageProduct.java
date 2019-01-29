import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
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

public class ManageProduct extends JFrame implements ActionListener
{
	
	private JFrame jframe;
    JLabel label1,label2, label3, label4, label5;
    JTextField text1,text2, text3,text4;
    JButton back,submit,remove,update;
    JPanel panel; 
    JComboBox comboCategory;
	
	Statement st=null;
	ResultSet rs=null;

		
    public  ManageProduct(){ 
    super("Dimoke Restaurant - Manage Product ");	
	this.setSize(750, 600);
    this. setLayout(null);
		
    label1  = new   JLabel("------Here is Managing Product List-------");  
    label1.setFont(new Font("Serif", Font.BOLD, 22)); 	
    label1.setBounds(180, 50, 700, 30);
    this.add(label1);
			    
    label2 = new JLabel("Product Code: ");
    label2.setBounds(100,180,250,30);
    this.add(label2); 
		
	text1 = new JTextField();
    text1.setBounds(250,180,300,30);
    this.add(text1); 
		
	
	label3 = new JLabel("Product Name: ");
    label3.setBounds(100,230,250,30);
    this.add(label3);
		
	text2 = new JTextField();
    text2.setBounds(250,230,300,30);
    this.add(text2);
		
		
	label4 = new JLabel("Product Category: ");
    label4.setBounds(100,280,250,30);
    this.add(label4);
		
	
    String Cate[] = new String[]{"Lunch","Dinner","Breakfast","Drinks","Chinese","Thai","Burger","Soup"};
  
    comboCategory = new JComboBox(Cate);
    comboCategory.setBounds(250, 280, 200, 20);
    this.add(comboCategory);
		
		
	label5 = new JLabel("Product Price: ");
    label5.setBounds(100,330,250,30);
    this.add(label5);
		
	text4 = new JTextField();
    text4.setBounds(250,330,300,30);
    this.add(text4);
        
    back = new JButton("Back"); 
    back.setBounds(190,370,150,40);
    this.add(back);
		
	submit = new JButton("Submit"); 
    submit.setBounds(420,370,150,40);
    this.add(submit);
	
    remove = new JButton("Want To Remove Product???");
    remove.setBounds(285,490,210,40);
    add(remove);
	
	update = new JButton("UPDATE");
    update.setBounds(285,420,210,40);
    add(update);
		
	//submit.addActionListener(new ActionListener();
	submit.addActionListener(this);
	back.addActionListener(this);
	remove.addActionListener(this);
	update.addActionListener(this);
	
	}
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==back)
		{
			
			Admin a=new Admin();
		    a.setVisible(true);
			setVisible(false);
		}	
		
		if(ae.getSource()==submit)
		{
			try 
			{
				//Class.forName("com.mysql.jdbc.Driver");
				//st = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","").createStatement();
				
				String name = text2.getText();
                String category = comboCategory.getSelectedItem().toString(); //get selected item from combobox
                Double price =Double.parseDouble( text4.getText());
                int code = Integer.parseInt(text1.getText());
                    
                DataAccess da = new DataAccess();
                if(da.checkProduct(code)==true)
				{
                   JOptionPane.showMessageDialog(rootPane, "Product code Already used ,enter new Product code");
                }
                else
				{
                    
                    String sql = "INSERT INTO `product`(`Code`, `Name`, `Price`,`Category`) VALUES ('"+code+"','"+name+"','"+price+"','"+category+"')";
                    
                    int c = da.loadDB(sql);
                  
                    
                    if(c==1)
					{
                        JOptionPane.showMessageDialog(rootPane,"Data Inserted Successfully");
                    }
                    
                }
				
            }
			
            catch(Exception ex)
			{
                ex.printStackTrace();
            }
				

		}	
		
		if(ae.getSource()==remove)
		{
			RemoveTBill b=new RemoveTBill();
			b.setVisible(true);
			setVisible(false);
		}	
		
		if(ae.getSource()==update)
		{
			//Class.forName("com.mysql.jdbc.Driver");
			//st = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","").createStatement();
			Connection con=null;//for connection
            Statement st = null;//for query execution
		    ResultSet rs = null;//to get row by row result from DB
		    //System.out.println(query);
			//String query = "DELETE from product where code="+text1.getText()+";";
			try
			{
				Class.forName("com.mysql.jdbc.Driver");//load driver
				System.out.println("driver loaded");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");
				System.out.println("connection done");//connection with database established
				st = con.createStatement();//create statement
				System.out.println("statement created");
				//st.execute(query);
				
				String name = text2.getText();
				String category = comboCategory.getSelectedItem().toString();
				Double price =Double.parseDouble( text4.getText());
				int code = Integer.parseInt(text1.getText());
		
				String query="UPDATE `product` SET `Code`='"+code+"',`Name`='"+name+"',`Price`='"+price+"',`Category`='"+category+"' WHERE Code='"+code+"'";
				System.out.println("okay");
			    if(st.executeUpdate(query)==1){
				JOptionPane.showMessageDialog(this, "Successfully Registered ");
			   }
				
			 else{
				JOptionPane.showMessageDialog(this, "Failed To Insert");
			   }
			}
			catch(Exception ex)
			{
               ex.printStackTrace();
            }
		}	
		
	}
	public static void main (String args [])
	{
		ManageProduct mp =new ManageProduct();
		mp.setVisible(true);
	}
}