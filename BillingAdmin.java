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
public class BillingAdmin extends JFrame implements ActionListener
{
    private JFrame f1;
    private JPanel panel1,northPanel1;
    JLabel label1,label2, label3, label4, label5,lblField1,lblField2;
    private JTextField text1,text2;
    JButton back,add,process1,load;
	private double a,b,c,d,e,f,g,h,i,j,r1,textCode;
	private JTable table;
	private JScrollPane scrollpane;
	//DefaultTableModel model = new DefaultTableModel
	private DefaultTableModel tableModel;
	
	JTable tshowProduct=new JTable();
	
	//private JFrame f;

    public  BillingAdmin()
	{
	    super("Dimoke Restaurant - Admin Billing");
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
        label1.setBounds(200, 30, 700, 30);
        this.add(label1);
        
        label2 = new JLabel("Please Chose The Item You Want to Order");
		label2.setFont(new Font("Serif", Font.BOLD, 20)); 
        label2.setBounds(200,90,700,30);
        this.add(label2);
        
      
		
	    label3 = new JLabel("Enter Product code And Click Add Button To add the Order");
		label3.setFont(new Font("Serif", Font.BOLD, 18)); 
        label3.setBounds(180,500,700,30);
        this.add(label3);
        
        label4 = new JLabel("Product Code:");
		label4.setFont(new Font("Serif", Font.BOLD, 10)); 
        label4.setBounds(125,535,200,30);
        this.add(label4);
        
        text1 = new JTextField();
        text1.setBounds(235,535,70,26);
        this.add(text1);
        
        
        label5 = new JLabel("Product Quantity:");
		label5.setFont(new Font("Serif", Font.BOLD, 10)); 
        label5.setBounds(370,535,200,30);
        this.add(label5);
        
        text2= new JTextField();
        text2.setBounds(500,535,70,26);
        this.add(text2);
		
	    back= new JButton("Back");
        back.setBounds(100,580,120,30);
	    this.add(back);
		
	    add = new JButton("Add To Order");
	    add.setBounds(250,580,120,30);
	    this.add(add);
		
	    process1 = new JButton("Process");
	    process1.setBounds(400,580,120,30);
	    this.add(process1);
		
	    load = new JButton("Load Products");
	    load.setBounds(550,580,120,30);
	    this.add(load);
		
		back.addActionListener(this);
		add.addActionListener(this);
		process1.addActionListener(this);
		load.addActionListener(this);
		
		
		        
    }
	
	public void actionPerformed(ActionEvent ae){
		DefaultTableModel model = (DefaultTableModel)tshowProduct.getModel();
	    model.setRowCount(0);
		if(ae.getSource()==back)
		{
			Admin a=new Admin();
		    a.setVisible(true);
			setVisible(false);
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

	   textCode=Double.parseDouble(text1.getText());
		if(ae.getSource()==add)
		{
		    if(textCode==1)
			{
			System.out.println("Okay add");
			a=Double.parseDouble(text2.getText());
			}
			
			if(textCode==2)
			{
			b=Double.parseDouble(text2.getText());
		    }
			if(textCode==3)
			{
			c=Double.parseDouble(text2.getText());
		    }
			if(textCode==4)
			{
			d=Double.parseDouble(text2.getText());
		    }
			if(textCode==5)
			{
			e=Double.parseDouble(text2.getText());
		    }
			if(textCode==6)
			{
			f=Double.parseDouble(text2.getText());
		    }
			if(textCode==7)
			{
			g=Double.parseDouble(text2.getText());
		    }
			if(textCode==8)
			{
			h=Double.parseDouble(text2.getText());
		    }
			if(textCode==9)
			{
			i=Double.parseDouble(text2.getText());
		    }
			if(textCode==10)
			{
			j=Double.parseDouble(text2.getText());
		    }
			   
		}
		
		if(ae.getSource()==process1)
		{	
			System.out.println("okay");
			
			if(textCode==1)
			{
			r1=a*160;
			System.out.println("okay");
			TotalBillAdmin tba=new TotalBillAdmin();
			tba.setVisible(true);
			tba.setBill(r1);
			setVisible(false);
			}
			if(textCode==2)
			{
			r1=b*170;
			TotalBillAdmin tba=new TotalBillAdmin();
			tba.setVisible(true);
			tba.setBill(r1);
			setVisible(false);
			}
			if(textCode==3)
			{
			r1=c*170;
			TotalBillCustomer tbc=new TotalBillCustomer();
			tbc.setVisible(true);
			tbc.setBill(r1);
			setVisible(false);
			}
			if(textCode==4)
			{
			r1=d*180;
			TotalBillCustomer tbc=new TotalBillCustomer();
			tbc.setVisible(true);
			tbc.setBill(r1);
			setVisible(false);
			}
			if(textCode==5)
			{
			r1=e*90;
			TotalBillCustomer tbc=new TotalBillCustomer();
			tbc.setVisible(true);
			tbc.setBill(r1);
			setVisible(false);
			}
			if(textCode==6)
			{
			r1=f*60;
			TotalBillCustomer tbc=new TotalBillCustomer();
			tbc.setVisible(true);
			tbc.setBill(r1);
			setVisible(false);
			}
			if(textCode==7)
			{
			r1=g*200;
			TotalBillCustomer tbc=new TotalBillCustomer();
			tbc.setVisible(true);
			tbc.setBill(r1);
			setVisible(false);
			}
			if(textCode==8)
			{
			r1=h*80;
			TotalBillCustomer tbc=new TotalBillCustomer();
			tbc.setVisible(true);
			tbc.setBill(r1);
			setVisible(false);
			}
			if(textCode==9)
			{
			r1=i*100;
			TotalBillCustomer tbc=new TotalBillCustomer();
			tbc.setVisible(true);
			tbc.setBill(r1);
			setVisible(false);
			}
			if(textCode==10)
			{
			r1=j*200;
			TotalBillCustomer tbc=new TotalBillCustomer();
			tbc.setVisible(true);
			tbc.setBill(r1);
			setVisible(false);
			}
		}
	}

     /*public static void main (String args [])
	 {
		Billing rs1 = new Billing();
		//rs1.setLocationRelativeTo(null);
		rs1.setVisible(true);
        
	 }*/
		
}