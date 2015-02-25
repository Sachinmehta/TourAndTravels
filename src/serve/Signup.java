package serve;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Signup extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try{
			
			
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class",
					"javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
	 
			Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("technocall.callyou","technocall1630");
					}
				});
	 
			try {
	 
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("technocall.callyou@gmail.com"));
				message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(request.getParameter("mail")));
				message.setSubject("Welcome to www.gotravel.com");
				message.setText("Dear Customer," +
						"\n\n This is a mail from www.gotravel.com!"+" Your Username is:  "+request.getParameter("uname")+" And Password is:  "+request.getParameter("pass"));
	 
				Transport.send(message);
	 
				System.out.println("Done");
	 
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
			
			
			
			Connection conn=DB.getCon();
			String sql="insert into CINEMAUSER values(?,?,?,?,?,?)";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, request.getParameter("uname"));
			pst.setString(2, request.getParameter("pass"));
			pst.setString(3, request.getParameter("mail"));
			pst.setString(5, request.getParameter("ques"));
			pst.setString(6, request.getParameter("ans"));
			
			SimpleDateFormat sim=new SimpleDateFormat("dd-MMM-yyyy:hh:mm:ss aaa");
			java.util.Date dd=new java.util.Date();
			String dor=sim.format(dd);
			
			pst.setString(4, dor);
			
			int x=pst.executeUpdate();
			if(x>0){
				RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
				rd.forward(request, response);
			}else{
				RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
			}
		}catch(Exception e){
			System.out.println(e);
			RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
	}

	

}

