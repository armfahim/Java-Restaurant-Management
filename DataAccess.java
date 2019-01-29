import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DataAccess
{
    Connection conn;
    String JDBC_DRIVER;  
    String DB_URL;
    Statement stmt;
    String USER;
    String PASS;
    ResultSet rs;
    public DataAccess()
	{
        JDBC_DRIVER = "com.mysql.jdbc.Driver";
        DB_URL = "jdbc:mysql://localhost:3306/restaurant";
        USER = "root";
        PASS = "";
	    /*
	    JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
        DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
        USER = "scott";
        PASS = "tiger";*/
        try
		{
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        }
        catch(Exception ex)
		{
            ex.printStackTrace();
        }
    }
    public void close()throws SQLException
	{
        if(rs!=null)rs.close();
        if(rs!=null)stmt.close();
    }
	
	public boolean checkProduct(int user)
	{ 
        try
		{
            int ab = user;
  
            String query = "Select * from  product where code ='"+ab+"'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            if(rs.next())
			{
            return true;
            }
            else
			{
                return false;
            }
        }
        
        catch(Exception ex)
		{
            ex.printStackTrace();
            return false;
        }
        
    }
	
	public int loadDB(String sql)
	{
        int numOfRowsUpdated=0;
        try
		{
            stmt = conn.createStatement();
            numOfRowsUpdated=stmt.executeUpdate(sql);
            System.out.println(numOfRowsUpdated+" row(s) inserted");
            //stmt.close();
            //conn.close();
        }
        catch(Exception ex)
		{
            ex.printStackTrace();
        }
        return numOfRowsUpdated;
    }
	
	/*public boolean removeProduct(int user)
	{
		int numOfRowsDeleted=0;
		try
		{
			
		    int ab = user;
  
            String query = "Delete * FROM product WHERE code ='"+ab+"'";
            stmt = conn.createStatement();
			System.out.println("statement created");
            rs=stmt.executeUpdate(query);
			//System.out.println(numOfRowsDeleted+" row(s) deleted");
			System.out.println("results received");
			if(rs.next())
			{
                return true;
            }
            else
			{
                return false;
            }
		}
		catch(Exception ex)
		{
            ex.printStackTrace();
        }
		//return numOfRowsDeleted;
		
	}*/
}
    