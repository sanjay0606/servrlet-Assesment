package com.org;





import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;





import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;





/**
* Servlet implementation class Login
*/
@WebServlet("/Login")
public class Login extends HttpServlet {
private static final long serialVersionUID = 1L;



/**
* @see HttpServlet#HttpServlet()
*/
public Login() {
super();
// TODO Auto-generated constructor stub
}





/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
//response.getWriter().append("Served at: ").append(request.getContextPath());



response.setContentType("text/html");
PrintWriter out = response.getWriter();
String username = request.getParameter("username");
String password = request.getParameter("password");
try {
Class.forName("com.mysql.cj.jdbc.Driver");
System.out.println("connection ready");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/register","######","*********");
System.out.println(con);



PreparedStatement ps = con.prepareStatement("select * from registeruser where name=? and pass=?");
ps.setString(1, username);
ps.setString(2, password);



System.out.println(ps.execute());
ResultSet rs=ps.executeQuery();
while(rs.next()) {
System.out.println(rs.getString(2));



}
//System.out.println("login "+ rs);
out.print("Login success");
}catch(Exception e){
System.out.println(e);
}
out.close();




}





}
