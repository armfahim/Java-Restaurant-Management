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

public class RemoveTBill extends JFrame implements ActionListener
 {
    
    
        
	private JFrame jframe;
    JLabel label1,label2, label3, label4, label5,label6;
    JTextField text1,text2,text3;
    JButton back,remove,process2, exit,load;
    JPanel panel;
	private JTable table;
	private JScrollPane scrollpane;
    private DefaultTableModel tableModel;
	
	JTable tshowProduct=new JTable();
	//Private string m;

    public  RemoveTBill(){
    super("Dimoke Restaurant - Remove/Update (Admin) ");
	this.setSize(800, 700);
    this. setLayout(null);
	this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	
	JPanel contentPane=new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
		
	JScrollPane scrollPane=new JScrollPane();
	scrollPane.setBounds(60,150,650,200);
	contentPane.add(scrollPane);
		
	tshowProduct.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Product Code", "Product Name", "Price","Category"
				}
			));
		
	tshowProduct.getTableHeader().setReorderingAllowed(false);
	scrollPane.setViewportView(tshowProduct);
	tshowProduct.setDefaultEditor(Object.class,null);
		
    label1  = new   JLabel("Welcome To Our Billing Management System"); 
    label1.setFont(new Font("Serif", Font.BOLD, 22)); 	
    label1.setBounds(170, 30, 700, 30);
    this.add(label1);
        
    label2 = new JLabel("-------------Remove Product---------------");
	label2.setFont(new Font("Serif", Font.BOLD, 20)); 
    label2.setBounds(200,60,700,30);
    this.add(label2);
		
	label3 = new JLabel("Enter Product Code And Click Remove Product To Remove It from Order");
	label3.setFont(new Font("Serif", Font.BOLD, 18)); 
    label3.setBounds(180,500,700,30);
    this.add(label3);
        
    label4 = new JLabel("Product Code:");
    label4.setBounds(125,535,200,30);
    this.add(label4);
        
    text1 = new JTextField();
    text1.setBounds(235,535,70,26);
    this.add(text1);
        
    back = new JButton("Back");
    back.setBounds(100,580,120,30);
	this.add(back);
		
	remove = new JButton("Remove Product");
	remove.setBounds(247,580,135,30);
	this.add(remove);
	
	load = new JButton("Load Products");
	load.setBounds(550,580,120,30);
	this.add(load);
	
	back.addActionListener(this);
	remove.addActionListener(this);
	load.addActionListener(this);
    }
	
	public void actionPerformed(ActionEvent ae){
		DefaultTableModel model = (DefaultTableModel)tshowProduct.getModel();
	    model.setRowCount(0);
		if(ae.getSource()==back)
		{
		     ManageProduct mp =new ManageProduct();
		    mp.setVisible(true);
			setVisible(false);
		}
        if(ae.getSource()==remove)
		{
			Connection con=null;//for connection
            Statement st = null;//for query execution
		    ResultSet rs = null;//to get row by row result from DB
		    //System.out.println(query);
			String query = "DELETE from product where code="+text1.getText()+";";
			try
			{
				Class.forName("com.mysql.jdbc.Driver");//load driver
				System.out.println("driver loaded");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");
				System.out.println("connection done");//connection with database established
				st = con.createStatement();//create statement
				System.out.println("statement created");
				st.execute(query);
				
			   System.out.println("okay");
			   
			   
			   JOptionPane.showMessageDialog(rootPane,"Product Removed Successfully");
			   
			   
			  
			   
			   
			}
			catch(Exception ex)
			{
                ex.printStackTrace();
            }
		}	
		
		if(ae.getSource()==load)
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
				String query ="SELECT `Code`,`Name`,`Price`,`Category` FROM `product`;";
				rs = st.executeQuery(query);//getting result
				System.out.println("results received");
		    
             
                while(rs.next())
                {
                String d = rs.getString("Code");
                String ex = rs.getString("Name");
                String f = rs.getString("Category");
                int p = rs.getInt("Price");
                      
                model.addRow(new Object[]{d, ex, p,f});
                    
                }	
                tshowProduct.setModel(model);	
				
		    }
			catch(Exception ex){
		        System.out.println("Exception : " +ex.getMessage());
              }
	    }
	}
	
	
	/*public static void main (String args [])
	{
		RemoveTBill rtb=new RemoveTBill();
		rtb.setVisible(true);
                             
	}*/
}

		