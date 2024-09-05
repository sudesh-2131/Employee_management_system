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

@WebServlet(urlPatterns = "/show")
public class Home_Servlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		String email=(String) session.getAttribute("email");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?user=root&&password=Somu@7879");
			PreparedStatement ps=con.prepareStatement("select * from employee where email=?");
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) { 
				
				PrintWriter pw= resp.getWriter();
				
				pw.println("<html>");
				pw.println("<head>");
				pw.println("<style> div{height:500px;width:400px; border:2px solid white;margin:auto; background-color:white; margin-top:20px; border-radius:10px;}");
				pw.println("h1{color:purple; text-align:center}");
				pw.println("table{heigth:500px; width:300px; margin:auto;margin-top:10px }");
				pw.println("td{color:blue;}");
				pw.println("button{width:200px; heigth:50px;color: white;font-size: 30px;border-radius: 5px; margin-left:100px;}");
				pw.println("#btn1{background-color:green; border:green;}");
				pw.println("#btn2{background-color:red; border:red;}");
				pw.println("#btn3{background-color:blue; border:blue;}");
				pw.println("</style>");
				pw.println("</head>");
				pw.println("<body bgcolor='aqua'>");
				pw.println("<h1>EMPLOYEE DETAILS</h1>");
				pw.println("<div>");
				pw.println("<table border='5'>");
				pw.println("<tr>");
				pw.println("<th>Employee Id:</th>");
				pw.println("<td>"+rs.getInt(1)+"</td>");
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<th>Name:</th>");
				pw.println("<td>"+rs.getString(2)+"</td>");
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<th>Email:</th>");
				pw.println("<td>"+rs.getString(3)+"</td>");
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<th>Contact No.:</th>");
				pw.println("<td>"+rs.getLong(4)+"</td>");
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<th>Date Of Birth:</th>");
				pw.println("<td>"+rs.getString(5)+"</td>");
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<th>Gender:</th>");
				pw.println("<td>"+rs.getString(6)+"</td>");
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<th>Designation:</th>");
				pw.println("<td>"+rs.getString(7)+"</td>");
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<th>Department:</th>");
				pw.println("<td>"+rs.getString(8)+"</td>");
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<th>Date Of Joining:</th>");
				pw.println("<td>"+rs.getString(9)+"</td>");
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<th>Address:</th>");
				pw.println("<td>"+rs.getString(10)+"</td>");
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<th>Password:</th>");
				pw.println("<td>"+rs.getString(11)+"</td>");
				pw.println("</tr>");
				pw.println("</table>");
				pw.println("<br><br>");
				pw.println("<form action='update' method='post'>");
				pw.println("<button id='btn1'>Update</button>");
				pw.println("</form>");
				pw.println("<br>");
				pw.println("<form action='logout'>");
				pw.println("<button id='btn3'>Logout</button>");
				pw.println("</form>");
				pw.println("<br>");
				pw.println("<form action='delete'>");
				pw.println("<button id='btn2'>Delete</button>");
				pw.println("</form>");
				pw.println("</div>");
				pw.println("</body></html>");
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
