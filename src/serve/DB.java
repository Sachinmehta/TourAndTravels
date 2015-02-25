package serve;

import java.sql.*;

public class DB {

	public static void main(String[] args) {
		DB.getCon();

	}
	
	public static Connection getCon(){
		Connection con=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","java");
			System.out.println("Connected Successfully with DB Server");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}

}
