package airline;

import java.io.IOException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import flightTravel.FlightTravel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AirlineServlet
 */
@WebServlet("/Airline")
public class AirlineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AirlineServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		 Session session = sessionFactory.openSession();
		 Criteria cr = session.createCriteria(Airline.class);
		 List<Airline>results = cr.list();
		 String outputHtml= "";
		 for(Airline c:results ) {
			 outputHtml+="<option value=\"" +c.getId()+"\">"+c.getName()+"</option>";
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
	        String aname=request.getParameter("name");
	        Airline a = new Airline(aname);
	        session.save(a);
	        tx.commit();
	        session.close();
	        response.getWriter().append("Airline added");
	}

}
