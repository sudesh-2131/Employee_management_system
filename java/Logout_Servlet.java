package employee_management_system;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(urlPatterns = "/logout")
public class Logout_Servlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();  
        session.invalidate();
        
        PrintWriter pw=resp.getWriter();
        
        pw.println("<html><body>");
		pw.println("<h1>Logout Successfully.</h1>");
		pw.println("<h3>Click below for Login Or Signup.</h3>");
		pw.println("<form action='index.html'>");
		pw.println("<button>Click</button>");
		pw.println("</form>");
		pw.println("</body></html>");
	}

}
