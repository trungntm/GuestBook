package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Member")
public class Member extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Member() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=(String)request.getSession().getAttribute("user");
		// check neu nhu co session atribute "user", thi hien thi trang Member
		if(user!=null){
		PrintWriter out=response.getWriter(); 
		response.setContentType("text/html"); 
		out.println("<html><head><title>Member</title></head><body>"); 
		out.println("<h2>This is members-only area!<h2>"); 
		out.println("<p>Welcome, "+user+"</p>"); 
		out.println("<p><a href='Logout'>Logout</a></p>");
		out.println("</body></html>");
		
		}
		// neu khong thi chuyen den trang Login
		else{
			response.sendRedirect("Login");
		}
	}

}
