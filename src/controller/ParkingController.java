package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.ParkingDAO;
import model.Parking;
import model.ParkingErrorMsgs;

/**
 * Servlet implementation class ParkingController
 */
@WebServlet("/ParkingController")
public class ParkingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet() 
     */
	private void getParkingParam (HttpServletRequest request, Parking parking) {
		parking.setParking(request.getParameter("parking_area"),request.getParameter("capacity"),request.getParameter("floor"),request.getParameter("type"),request.getParameter("cart"),request.getParameter("camera"),request.getParameter("history"));  
	}
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action"), url="";
		HttpSession session = request.getSession();
		
		Parking parking = new Parking();
		ParkingErrorMsgs PerrorMsgs = new ParkingErrorMsgs();
	
		if (action.equalsIgnoreCase("saveParking") ) {  
			getParkingParam(request,parking);
			parking.validateParking(action,parking,PerrorMsgs);
			session.setAttribute("parking", parking);
			if (!PerrorMsgs.getErrorMsg().equals("")) {// if error messages
				getParkingParam(request,parking);
				session.setAttribute("errorMsgs", PerrorMsgs);
				url="/formParking.jsp";
			}
			else {// if no error messages
				ParkingDAO.StoreListinDB(parking);
	
				url="/ManagerHome.jsp";
			}
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);		
	}
}
