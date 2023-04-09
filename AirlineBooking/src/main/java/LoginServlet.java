

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import adminUserlogin.AdminUser;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
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
		
		PrintWriter p=response.getWriter();
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		 Session session = sessionFactory.openSession();
	        AdminUser auser=(AdminUser) session.get(AdminUser.class,"admin");
		String s1=request.getParameter("uname");
		String s2=request.getParameter("password");
		String actualpassword = "123";
		if(auser!= null) {
			actualpassword = auser.getPwd();
		}
		if(s1.equals("admin") && s2.equals(actualpassword))
		  {
			RequestDispatcher rd=request.getRequestDispatcher("/Admin.html"); 
			rd.include(request, response);
		  }
	
		  else
		  {
			//p.print("Invalid Login Credentials");
			RequestDispatcher rd=request.getRequestDispatcher("/flyAway.html"); 
			rd.include(request, response);
		  }		
		
		session.close();
		p.close();
		
		doGet(request, response);
	}

}
