package controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;
import util.MyConnectionProvider;
import model.*;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	PreparedStatement ps;
	private static final long serialVersionUID = 1L; 
	
	public void getLoginParam (HttpServletRequest request, Login login) {
		login.setLogin(request.getParameter("username"), request.getParameter("password"));
	} 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action"), url="";
		HttpSession session = request.getSession();
		
		Login login = new Login();
		LoginErrorMsgs LerrorMsgs = new LoginErrorMsgs();
		
		if(action.equalsIgnoreCase("loginUser")) {
			/*String user = request.getParameter("username");
			String pass = request.getParameter("password");
			session.removeAttribute("errorMsgs");
			login.setLogin(user, pass);
			login.validateLogin(action,login,LerrorMsgs);
			System.out.println("Helll Nooooooooooooooo111111"); 
			if(!LerrorMsgs.getErrorMsg().equals("")) {
				System.out.println("Helll Nooooooooooooooo222222222");
				getLoginParam(request,login);
				session.setAttribute("errorMsgs", LerrorMsgs);
				url="/login.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);*/
			
			getLoginParam(request,login);
			login.validateLogin(action,login,LerrorMsgs);
			session.setAttribute("login", login);
			if (!LerrorMsgs.getErrorMsg().equals("")) {// if error messages
				getLoginParam(request,login);
				session.setAttribute("lerrorMsgs", LerrorMsgs);
				
				url="/login.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
				
			}
			
			
			else{
				try {
					String username = request.getParameter("username");
					String password = request.getParameter("password");
					System.out.println(username);
					System.out.println(password);
					Connection conn = MyConnectionProvider.getDBConnection();
					PreparedStatement ps = conn.prepareStatement("Select user_name,password,role,firstname,noshow,parkingpermittype from user where user_name=? and password=?");
					ps.setString(1, username);
					ps.setString(2, password);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						
						 
						session.setAttribute("firstname", rs.getString(4));
						session.setAttribute("username", rs.getString(1));
						session.setAttribute("noshow", rs.getString(5));
						session.setAttribute("permittype", rs.getString(6));
						Cookie loginCookie = new Cookie("user",rs.getString(1));
						loginCookie.setMaxAge(30*60);
						response.addCookie(loginCookie);
						System.out.println(rs.getString(1)+"yo"+rs.getString(2)+"yo"+rs.getString(3));
						String ur = rs.getString(3);
						if(ur.equalsIgnoreCase("User")) {
							
							response.sendRedirect("userhome.jsp");
							}
						
						else if(ur.equalsIgnoreCase("Manager")) {
							response.sendRedirect("ManagerHome.jsp");
						}
						else{
							response.sendRedirect("AdminHomePage.jsp");
							
						}
						return;
					}
				//response.sendRedirect("loginerror.jsp");
				return;
				} catch (  SQLException e) {
					e.printStackTrace();
				}
				
			}
		
		
	}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	
}
}
