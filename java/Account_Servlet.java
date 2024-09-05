package employee_management_system;

import java.io.IOException;
import java.io.PipedWriter;
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

@WebServlet(urlPatterns="/created")
public class Account_Servlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int eid=Integer.parseInt(req.getParameter("eid"));
		String en=req.getParameter("en");
		String em=req.getParameter("em");
		long cn=Long.parseLong(req.getParameter("cn"));
		String dob=req.getParameter("dob");
		String gen=req.getParameter("gen");
		String des=req.getParameter("des");
		String dep=req.getParameter("dep");
		String doj=req.getParameter("doj");
		String add=req.getParameter("add");
		String pwd=req.getParameter("pwd");
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?user=root&&password=Somu@7879");
			PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, eid);
			ps.setString(2, en);
			ps.setString(3, em);
			ps.setLong(4, cn);
			ps.setString(5, dob);
			ps.setString(6, gen);
			ps.setString(7, des);
			ps.setString(8, dep);
			ps.setString(9, doj);
			ps.setString(10, add);
			ps.setString(11, pwd);
			ps.executeUpdate();
			
			PrintWriter pw = resp.getWriter();
			
			pw.println("<html>");
			pw.println("<head>");
			pw.println("<style> button{height: 50px; width: 200px; background-color: blue; color: white; font-size: 30px; border: blue; border-radius: 5px; margin-left: 660px;}</style>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("<marquee style='background-color:black;'><h1 style='color:red;'>ACCOUNT CREATED SUCCESSFULLY</H1></marquee>");
			pw.println("<h3 style='text-align:centre; color:purple;'>CLICK FOR LOGIN</h3>");
			pw.println("<form action='login.html'>");
			pw.println("<button>Login</button>");
			pw.println("</form>");
			pw.println("</body></html>");
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}

}
