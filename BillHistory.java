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

public class BillHistory extends JFrame implements ActionListener
{
	
    
    
    private JFrame jframe;
    JLabel label1,label2;
    JButton back2,print;
    JPanel panel;  
	private JTable table;
	private JScrollPane scrollpane;
	private DefaultTableModel tableModel;
	JTable tshowProduct=new JTable();

    public  BillHistory(){
	super("Dimoke Restaurant - Avalaible Products(Admin) ");
	this.setSize(800, 700);
    this. setLayout(null);
	
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
    label1.setBounds(200, 30, 700, 30);
    this.add(label1);
        
    label2 = new JLabel("Here is all Availabe Products");
	label2.setFont(new Font("Serif", Font.BOLD, 20)); 
    label2.setBounds(280,60,700,30);
    this.add(label2);
		
	                                   
    back2 = new JButton("Back");
	back2.setBounds(220,580,120,30);
	this.add(back2);
		
	print = new JButton("View Products");
	print.setBounds(420,580,120,30);
	this.add(print);
	back2.addActionListener(this);
	print.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		DefaultTableModel model = (DefaultTableModel)tshowProduct.getModel();
	    model.setRowCount(0);
		if(ae.getSource()==back2)
		{
			
			Admin a=new Admin();
		    a.setVisible(true);
			setVisible(false);
		}
		
		 if(ae.getSource()==print)
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
	public static void main (String args [])
	{
		BillHistory bh = new BillHistory();
		bh.setVisible(true);
               
	}
}