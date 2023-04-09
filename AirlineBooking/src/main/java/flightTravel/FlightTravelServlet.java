package flightTravel;

import java.io.IOException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import airline.Airline;
import airport.Airport;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class FlightTravelServlet
 */
@WebServlet("/FlightTravel")
public class FlightTravelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FlightTravelServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long sid= Long.parseLong(request.getParameter("sourceId"));
        long did= Long.parseLong(request.getParameter("destinationId"));
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		 Session session = sessionFactory.openSession();
		 Criteria cr = session.createCriteria(FlightTravel.class);
		 cr.add(Restrictions.eq("sid",sid));
		 cr.add(Restrictions.eq("did",did));
		 List<FlightTravel>results = cr.list();
		 String outputHtml= "";
		 for(FlightTravel c:results ) {
			 outputHtml+="<input type=\"radio\" name=\"flight\" value=\"" +c.getId()+"\">"+c.getSname()+" to "+c.getDname()+" "+c.getAname()+" Rs."+c.getPrice()+"</input><br>";
		 }
		 response.getWriter().append(outputHtml);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		 Session session = sessionFactory.openSession();
	        Transaction tx=session.beginTransaction();
	        long sid= Long.parseLong(request.getParameter("sourceId"));
	        long did= Long.parseLong(request.getParameter("destinationId"));
	        long aid= Long.parseLong(request.getParameter("airlineId"));
	        double price= Double.parseDouble(request.getParameter("price"));
	        Airport s=(Airport) session.get(Airport.class,sid);
	        Airport d=(Airport) session.get(Airport.class,did);
	        Airline a=(Airline) session.get(Airline.class,aid);
	        FlightTravel c1 = new FlightTravel(sid,s.getName(),did,d.getName(),aid,a.getName(),price);
	        session.save(c1);
	        tx.commit();
	        session.close();
	        response.getWriter().append("Created new flight entry");
	        }

}
