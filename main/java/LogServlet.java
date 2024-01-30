

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LogServlet
 */
public class LogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogServlet() {
        super();
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
		// TODO Auto-generated method stub
		String name=request.getParameter("name"); 
		String password=request.getParameter("password");
		Log l=new Log(name,password);
		if(l.check()) {
			RequestDispatcher requ=request.getRequestDispatcher("home.html");
			requ.forward(request, response);
		}
		else {
			String errorMessage = "Invalid username or password";
	        response.getWriter().println("<script type='text/javascript'>");
	        response.getWriter().println("alert('" + errorMessage + "');");
	        response.getWriter().println("window.location='login.html';"); // You can customize the redirect URL
	        response.getWriter().println("</script>");
		}
		doGet(request, response);
	}

}
