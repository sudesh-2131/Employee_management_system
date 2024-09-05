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


@WebServlet(urlPatterns = "/update")
public class Update_Servlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		String email=(String) session.getAttribute("email");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?user=root&&password=Somu@7879");
			PreparedStatement ps=con.prepareStatement("select * from employee where email=?");
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				session.setAttribute("eid", rs.getInt(1));
				PrintWriter pw= resp.getWriter();
				
				pw.println("<html>");
				pw.println("<head>");
				pw.println("<style> button{height: 50px; width: 200px; background-color: blue; color: white; font-size: 30px; border: blue; border-radius: 5px; margin-left: 90px;}");
				pw.println("div{height:750px; width: 400px; margin:auto; border:2px solid; background-color:white;  }");
				pw.println("input{height:30px; width: 300px; background-color:rgb(224, 216, 216); margin-left:50px;}");
				pw.println("label{margin-left:50px;}");
				pw.println("h1{color:red; text-align:center;}");
				
				
				pw.println("</style>");
				pw.println("</head>");
				
				pw.println("<body bgcolor='aqua'>");
				pw.println("<h1>EMPLOYEE ID-"+rs.getInt(1)+"</h1>");
				pw.println("<div>");
				pw.println("<form action='updation' method='post'>");
//				pw.println("<label>EMPLOYEE ID:</label><input type='text' name='eid' disabled='disabled' value='"+rs.getInt(1)+"'><br><br>");
				pw.println("<label>NAME:</label><br><input type='text' name='en' value='"+rs.getString(2)+"'><br><br>");
				pw.println("<label>Email:</label><br><input type='email' name='em'  value='"+rs.getString(3)+"'><br><br>");
				pw.println("<label>CONTACT NO.:</label><br><input type='text' name='cn'  value='"+rs.getLong(4)+"'><br><br>");
				pw.println("<label>DATE OF BIRTH:</label><br><input type='text' name='dob'  value='"+rs.getString(5)+"'><br><br>");
				pw.println("<label>GENDER:</label><br><input type='text' name='gen'  value='"+rs.getString(6)+"'><br><br>");
				pw.println("<label>DESIGNATION:</label><br><input type='text' name='des'  value='"+rs.getString(7)+"'><br><br>");
				pw.println("<label>DEPARTMENT:</label><br><input type='text' name='dep'  value='"+rs.getString(8)+"'><br><br>");
				pw.println("<label>DATE OF JOINING:</label><br><input type='text' name='doj'  value='"+rs.getString(9)+"'><br><br>");
				pw.println("<label>ADDRESS:</label><br><input type='text' name='add'  value='"+rs.getString(10)+"'><br><br>");
				pw.println("<label>PASSWORD:</label><br><input type='text' name='pwd'  value='"+rs.getString(11)+"'><br><br>");
				pw.println("<button>Update</button>");
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
