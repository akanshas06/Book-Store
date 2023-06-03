package test;

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

import com.mysql.cj.xdevapi.Statement;
@WebServlet("/Display")
public class Display extends HttpServlet{
		Connection con=null;
		
		public void init() throws ServletException{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/akansha?user=root&password=sql123");
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();}
			}
			 @Override
				protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
				ResultSet rs = null;
				PreparedStatement pstmt=null;
				PrintWriter pw=resp.getWriter();
				String query="select * from book_info1";
					try {
						pstmt=con.prepareStatement(query);
						rs=pstmt.executeQuery(query);
						pw.print("<table border='2'>");
						pw.print("<tr>");
						pw.print("<th>BookId</th>");
						pw.print("<th>BookName</th>");
						pw.print("<th>BookPrice</th>");
						pw.print("<th>BookAuthor</th>");
						pw.print("</tr>");
						while(rs.next()) {
							pw.print("<tr>");
							pw.print("<td>"+rs.getInt(1)+"</td>");
							pw.print("<td>"+rs.getString(2)+"</td>");
							pw.print("<td>"+rs.getDouble(3)+"</td>");
							pw.print("<td>"+rs.getString(4)+"</td>");
							pw.print("</tr>");
						}
						pw.print("Display Book");
						pw.print("/table");
		}catch(SQLException e) {
			e.printStackTrace();
					}}
}
