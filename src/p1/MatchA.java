package p1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import serve.DB;



public class MatchA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MatchA() {
        super();
        
    }

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
		
		String answer=request.getParameter("ans");
		HttpSession session=request.getSession();
		try{
			Connection conn=DB.getCon();
			String sql="select * from cinemauser where username=? AND SECURITY=? AND ANSWER=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, (String)session.getAttribute("u"));
			pst.setString(2, (String)session.getAttribute("se"));
			pst.setString(3, answer);
			
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				String pass=rs.getString("password");
				System.out.println("Your Password is: "+pass);
			}else{
				System.out.println("try again");
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
	}


}
