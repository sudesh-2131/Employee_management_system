package employee_management_system;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/delete")
public class Delete_Servlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		String email=(String) session.getAttribute("email");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?user=root&&password=Somu@7879");
			PreparedStatement ps=con.prepareStatement("Delete from employee where email=?");
			ps.setString(1, email);
			ps.executeUpdate();
			
			
			PrintWriter pw= resp.getWriter();
			
			pw.println("<html><body>");
			pw.println("<h1>Your Account is deleted.</h1>");
			pw.println("<h3>Click below for Login Or Signup.</h3>");
			pw.println("<form action='index.html'>");
			pw.println("<button>Click</button>");
			pw.println("</form>");
			pw.println("</body></html>");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
