package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import serve.DB;

public class Signin extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try{
			Connection conn=DB.getCon();
			
			String sql="select * from cinemauser where UNAME=? AND PASS=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			String name=request.getParameter("uname");
			String pass=request.getParameter("pass");
			
			HttpSession session=request.getSession();
			session.setAttribute("key", name);
			
			pst.setString(1, name);
			pst.setString(2, pass);
			
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				RequestDispatcher rd=request.getRequestDispatcher("afterlog.jsp");
				rd.forward(request, response);
			}else{
				RequestDispatcher rd=request.getRequestDispatcher("errorlog.jsp");
				rd.forward(request, response);
			}
		}catch(Exception e){
			System.out.println(e);
			RequestDispatcher rd=request.getRequestDispatcher("errorlog.jsp");
			rd.forward(request, response);
		}
	}

}

