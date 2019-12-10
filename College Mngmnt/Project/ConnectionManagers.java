package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagers
{
       public Connection getConnection() throws ClassNotFoundException, SQLException
       {
    	Class.forName("com.mysql.jdbc.Driver");
    	Connection con=null;
    	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
    	if(con!=null)
    		return con;
    	else
		    return null;
    	   
       }
}
