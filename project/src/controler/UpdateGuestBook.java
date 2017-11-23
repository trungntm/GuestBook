package controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateGuestBook")
public class UpdateGuestBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public UpdateGuestBook() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ID = Integer.parseInt(request.getParameter("id"));
		String Name = request.getParameter("Name");
		String Mess = request.getParameter("Mess");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");   // Set contentype khi xuat ra mot file html.
		
		out.println("<html><head><title>Edit Comment</title><head><body>");
		out.println("<form action='Update' method='Post'>");
		out.println("Key:<input type='text' name='key' readonly value='"+ID +"'/><br/>");
		out.println("Name:<input type='text' name='name' value='"+ Name +"'/><br/>");
		out.println("Message:<textarea name='message' rows='5' cols='60'>"+ Mess +"</textarea>");
		out.println("<input type='hidden' name='index' value='"+ID+"'>");
		out.println("<input type='submit' name='editentry' value='Edit'/>");
		
		out.println("</form>");
		out.println("</body></html>");
	}

}
