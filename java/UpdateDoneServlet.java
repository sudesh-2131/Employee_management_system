package employee_management_system;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/updation")
public class UpdateDoneServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		int eid=Integer.parseInt(req.getParameter("eid"));
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
		
		HttpSession session=req.getSession();
		int eid=(int) session.getAttribute("eid");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?user=root&&password=Somu@7879");
			PreparedStatement ps=con.prepareStatement("update employee set ename=?, email=?,contact=?, dob=?, gender=?, designation=?, dept=?,doj=?, address=?, password=? where eid=?");
			
			ps.setString(1, en);
			ps.setString(2, em);
			ps.setLong(3, cn);
			ps.setString(4, dob);
			ps.setString(5, gen);
			ps.setString(6, des);
			ps.setString(7, dep);
			ps.setString(8, doj);
			ps.setString(9, add);
			ps.setString(10, pwd);
			ps.setInt(11, eid);
			ps.executeUpdate();
			
			PrintWriter pw = resp.getWriter();
			
			pw.println("<html>");
			pw.println("<head>");
			pw.println("<style> button{height: 50px; width: 200px; background-color: green; color: white; font-size: 30px; border: green; border-radius: 5px; margin-left: 650px;}");
			pw.println("marquee{background-color:black;  }");
			pw.println("label{margin-left:50px;}");
			pw.println("h1{color:red; text-align:center;}");
			pw.println("h3{color:blue; text-align:center;}");
			pw.println("</style>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("<marquee><h1>ACCOUNT UPDATION SUCCESSFULLY</h1></marquee>");
			pw.println("<h3>CLICK BELOW TO GO HOME</H3>");
			pw.println("<form action='home.html'>");
			pw.println("<button>Home</button>");
			pw.println("</form>");
			pw.println("</body></html>");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
