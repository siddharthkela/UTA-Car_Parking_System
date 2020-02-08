package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import data.UserDaoImple;
import model.AdminErrorMSGS;
import model.Parking;
import model.Revoke;
import model.USER;
 

@WebServlet("/SearchUser")
public class SearchUser extends HttpServlet {
	private static final long serialVersionUID = 1L;    
	private void getUserParam (HttpServletRequest request, USER user) {
	user.setUSER(request.getParameter("username"),request.getParameter("password"),request.getParameter("firstname"),request.getParameter("lastname"),request.getParameter("role"),request.getParameter("phone"),request.getParameter("email"),request.getParameter("address"),request.getParameter("parkingpermittype"),request.getParameter("vehiclenumber"),request.getParameter("licensenumber"),request.getParameter("DateofBirth"));  
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		ArrayList<USER> UserInDB = new ArrayList<USER>();
        UserInDB=UserDaoImple.getUserByuserName1(); 
        session.setAttribute("COMPANIES", UserInDB);		
       getServletContext().getRequestDispatcher("/ViewUser.jsp").forward(request, response);
	}
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String action = request.getParameter("action"), url="";
		System.out.println("Hello  I reached here"+action);
		AdminErrorMSGS adminerrormsges=new AdminErrorMSGS();
		USER user=new USER();
		if(action.equalsIgnoreCase("unrevoke")){
			
			String username=request.getParameter("username");	
			System.out.println(username);
			UserDaoImple.UnrevokeUser(username);
			url="/AdminHomePage.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);	

		}
		if(action.equalsIgnoreCase("UpdateUser"))			
		{			
			user.setFirstname(request.getParameter("firstname"));
			user.setLastname(request.getParameter("lastname"));
			user.setUsername(request.getParameter("username"));
			user.setAddress(request.getParameter("address"));
			user.setPassword(request.getParameter("password"));	
            user.setRole(request.getParameter("userrole"));			
			
            UserDaoImple.UpdateUser(user);
			getServletContext().getRequestDispatcher("/ViewUser.jsp").forward(request, response);
			
			
		}
		if (action.equalsIgnoreCase("saveUser") ) {  
			
			
			user.setFirstname(request.getParameter("firstname"));
			user.setLastname(request.getParameter("lastname"));
			user.setUsername(request.getParameter("username"));
			user.setAddress(request.getParameter("address"));
			user.setPassword(request.getParameter("password"));	
            user.setRole(request.getParameter("userrole"));
            user.setUtaid(request.getParameter("utaid"));
            user.setEmail(request.getParameter("email"));
            user.setPhone(request.getParameter("phone"));
            user.setLicensenumber(request.getParameter("dlnumber"));
            user.setParkingpermittype(request.getParameter("permit"));
            
			
				UserDaoImple.insertuser(user);
				getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			
		}
		
		else
		{
		
		String username = request.getParameter("user_name");
		
		session.removeAttribute("errorMsgs");
		user.setUSER(username,"","","","","","","","","","","");
		user.validateUSER(action,user, adminerrormsges);
		
		ArrayList<USER> UserInDB = new ArrayList<USER>();
		if (!adminerrormsges.getErrorMsg().equals("")) {// if error messages
			getUserParam(request,user);
			session.setAttribute("errorMsgs", adminerrormsges);
			url="/SearchUser.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}
		else {
			session.setAttribute("USER", user);
			UserInDB=UserDaoImple.getUserByuserName(username);
			if(UserInDB.isEmpty())
			{ 
				url="/SearchUser.jsp";
				session.setAttribute("bigerror", "User Not Found!! Please try again.");
				getServletContext().getRequestDispatcher(url).forward(request, response);
			}
			else{

			session.setAttribute("user", UserInDB);
			session.setAttribute("errorMsgs", adminerrormsges);
			url="/UpdateUser.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
			}
		}
	
		
		
		   	
		}

		}

}
