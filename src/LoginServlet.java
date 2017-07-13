

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String realEmail= "allysa@gmail.com";
		String realPassword= "P@$$word";
		String email = request.getParameter("email");
		String password = request.getParameter("password");	

		String message = "";
		String nextPage = "/output.jsp";

		User u = new User();
		u.setUsername("Allysa5");
		u.setPassword("P@$$word");
		u.setEmail("allysa@gmail.com");
		
		HttpSession session = request.getSession();

		if(u.isValidUser()){
			message = "valid";
			session.setAttribute("user",u);
			
		}else{
			message = "invalid user";
			nextPage = "/index.jsp";

		}


		/*if((email.equals(realEmail)) && (password.equals(realPassword))){
			message = "correct";
		}else {
			message = email + " is incorrect";
		}*/

		request.setAttribute("message", message);
		request.getServletContext().getRequestDispatcher(nextPage).forward(request,response);	




		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
