package controller;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.ReservationDAO;
import data.UserDaoImple;
import model.Reservation;
import model.ReservationErrorMsgs;

/**
 * Servlet implementation class ReservationController
 */
@WebServlet("/ReservationController")
public class ReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */ 
	private void getReservationParam (HttpServletRequest request, Reservation reservation) {
		reservation.setReservation(request.getParameter("reservationid"),request.getParameter("username"),request.getParameter("parking_Area"),request.getParameter("parking_Number"),request.getParameter("starttime_hour"),request.getParameter("starttime_minutes"),request.getParameter("endtime_hour"),request.getParameter("endtime_minutes"),request.getParameter("cost"));  
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
		Reservation reservation = new Reservation();
		ReservationErrorMsgs RerrorMsgs = new ReservationErrorMsgs();
	
		if (action.equalsIgnoreCase("searchReservation") ) {
	  
			String reservationID = request.getParameter("reservationid");
			session.removeAttribute("RerrorMsgs");
			reservation.setReservation(reservationID,"","","","","","","","");
			reservation.validateReservation(action,reservation, RerrorMsgs);
			
			
			getReservationParam(request,reservation);
			reservation.validateReservation(action,reservation,RerrorMsgs);
			session.setAttribute("reservation", reservation);
			if (!RerrorMsgs.getErrorMsg().equals("")) {// if error messages
				getReservationParam(request,reservation);
				session.setAttribute("RerrorMsgs", RerrorMsgs);
				
				url="/searchReservation.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
				
			}
			else{
			ArrayList<Reservation> reservationInDB = new ArrayList<Reservation>();
			reservationInDB=ReservationDAO.listReservation(reservationID);
         	session.setAttribute("RESERVATION", reservationInDB);
         	session.removeAttribute("reservation");
         	url="/ViewReservation.jsp";
         	getServletContext().getRequestDispatcher(url).forward(request, response);
         	
		}
		}
		else{
			if(action.equalsIgnoreCase("delete")){			
				String reservationid=request.getParameter("reservationid");	
				System.out.println(reservationid);
				ReservationDAO.DeleteReservation(reservationid);
				url="/ViewReservations.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
			}
		}
		//getServletContext().getRequestDispatcher(url).forward(request, response);	
	}

}
