package employee_management_system;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/log")
public class Login_Servlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String em=req.getParameter("em");
		String pwd=req.getParameter("pwd");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?user=root&&password=Somu@7879");
			PreparedStatement ps=con.prepareStatement("select * from employee where email=? and password=?");
			ps.setString(1, em);
			ps.setString(2, pwd);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				HttpSession session=req.getSession();
				session.setAttribute("email", em);
				RequestDispatcher rd=req.getRequestDispatcher("home.html");
				rd.forward(req, resp);
			}
			else {
				PrintWriter pw = resp.getWriter();
				pw.println("<html><body>");
				pw.println("<h3>invalid email or password</h3>");
				pw.println("</body></html>");
				RequestDispatcher rd= req.getRequestDispatcher("login.html");
				rd.include(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
