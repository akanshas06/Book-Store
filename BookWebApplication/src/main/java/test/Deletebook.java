package test;

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
@WebServlet("/deletebooks")
public class Deletebook extends HttpServlet{
	Connection con=null;
	public void init() throws ServletException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/akansha?user=root&password=sql123");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 PreparedStatement pstmt = null;
			String query="Delete from book_info1 where book_id=?";
		try {
		 pstmt = con.prepareStatement(query);
         pstmt.setInt(1,1);
         int count1=pstmt.executeUpdate();
        

         PrintWriter pw=resp.getWriter();
         pw.print("<h1>"+count1+"DATA DELETED SUCCESSFULLY</h1>");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
