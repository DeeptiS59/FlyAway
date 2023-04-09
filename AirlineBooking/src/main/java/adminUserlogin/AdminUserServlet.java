package adminUserlogin;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import airline.Airline;
import airport.Airport;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminUserServlet
 */
@WebServlet("/AdminUser")
public class AdminUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AdminUserServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		 Session session = sessionFactory.openSession();
	        Transaction tx=session.beginTransaction();
	       String opassword=request.getParameter("opassword");
	        AdminUser auser=(AdminUser) session.get(AdminUser.class,"admin");
	        String npassword=request.getParameter("npassword");
	        String actualpassword = "123";
			if(auser!= null) {
				actualpassword = auser.getPwd();
			}
	        if(actualpassword.equals(opassword))	
	        {
	        	if(auser!= null) {
	        		auser.setPwd(actualpassword);
	        		session.save(auser);
	        	}
	        	else {
	        		AdminUser a = new AdminUser("admin",npassword);	
		        	session.save(a);
	        	}
	        	response.getWriter().append(" Password Reset Successful ");
	        }
	      
	        else {
	        	response.getWriter().append(" The old password entered is incorrect ");
	        }
	        
	       
	        tx.commit();
	        session.close();
		doGet(request, response);
	}

}
