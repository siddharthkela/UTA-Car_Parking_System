 package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.ParkingSpotsDAO;
import model.ParkingSpots;
import model.ParkingSpotsErrorMsgs;


@WebServlet("/ParkingspotsController")
public class ParkingspotsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    /**
     * @see HttpServlet#HttpServlet() 
     */
	public void getParkingSpotsParam (HttpServletRequest request, ParkingSpots parkingspots) {
		parkingspots.setParkingSpots(request.getParameter("parking_Area"),request.getParameter("parking_Number"),request.getParameter("membership_type"));  
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
		ParkingSpots parkingspots = new ParkingSpots();
		ParkingSpotsErrorMsgs pserrorMsgs = new ParkingSpotsErrorMsgs();
		
		if (action.equalsIgnoreCase("setStatus") ) {  
			getParkingSpotsParam(request,parkingspots); 
			System.out.println(parkingspots.toString());
			parkingspots.validateParkingSpots(action,parkingspots,pserrorMsgs);
			session.setAttribute("parkingspots", parkingspots); 
			
				if (!pserrorMsgs.getErrorMsg().equals("")) {// if error messages
					
					getParkingSpotsParam(request, parkingspots);
					session.setAttribute("pserrorMsgs",pserrorMsgs );
					url="/available.jsp";
					//getServletContext().getRequestDispatcher(url).forward(request, response);
					 
				}
				else{
			
			ParkingSpotsDAO.StoreListinDB(request.getParameter("parking_Area"),request.getParameter("parking_Number"),request.getParameter("membership_type"));
			url="/SpotAvailabilityConfirmation.jsp";
			}
				getServletContext().getRequestDispatcher(url).forward(request, response);
			
	}
		
	}
		
	}
 

 