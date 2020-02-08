package controller;

import model.*;
import data.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.ParkingDAO;

/**
 * Servlet implementation class RevokeController
 */
@WebServlet("/RevokeController")
public class RevokeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    /**
     * @see HttpServlet#HttpServlet()
     */
	private void getRevokeParam (HttpServletRequest request, Revoke revoke) {
		revoke.setRevoke(request.getParameter("username"),request.getParameter("reason"));  
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action"), url="";
		HttpSession session = request.getSession();
		Revoke revoke = new Revoke();
		RevokeErrorMsgs RverrorMsgs = new RevokeErrorMsgs();
	
		if (action.equalsIgnoreCase("revoke") ) {  
			getRevokeParam(request,revoke);
			revoke.validateRevoke(action,revoke,RverrorMsgs);
			session.setAttribute("revoke", revoke);
			if (!RverrorMsgs.getErrorMsg().equals("")) {// if error messages
				getRevokeParam(request,revoke);
				session.setAttribute("RverrorMsgs", RverrorMsgs);
				
				url="/Revoke.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
				
			}
			else {// if no error messages
				UserDaoImple.StoreListinDB(revoke);
				url="/AdminHomePage.jsp";
				//url="AdminHomePage.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
			}
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
