package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GuestBookEntry;

@WebServlet("/AddCommentWithSession")
public class AddCommentWithSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddCommentWithSession() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter(); 
		response.setContentType("text/html"); 
		out.println("<html><head><title>Add Comment With Session</title></head><body>"); 
		out.println("<form action='AddCommentWithSession' method='Post'>");
		// Neu da co name trong session, chi can hien thi name
		String name=(String) request.getSession().getAttribute("name"); 	
		
		//  co username trong session
		if(name!=null){
			out.println("Name: " + name+"<br/>");
		}
		else{
			// Neu khong thi hien thi feild nhap
			out.println("Name: <input type='text' name='name'></br>");
		}
		out.println("Message: <textarea name='message' rows='5' cols='60'></textarea></br>");
		out.println("<input type='submit' name='add' value='add'>");
		out.println("</form>");
		out.println("</body></html>"); // đóng các thẻ body và html
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=(String) request.getSession().getAttribute("name");
		
		if(name==null){
			name=request.getParameter("name");
			request.getSession().setAttribute("name", name);
		}
		// Lay ra nguoi dung nhap
		
		String message=request.getParameter("message");
		int id=(int)getServletContext().getAttribute("id");
		int curid=id+1;
		GuestBookEntry entry=new GuestBookEntry(name,message,curid);
		getServletContext().setAttribute("id", curid);
		List<GuestBookEntry> entries=(List<GuestBookEntry>) getServletContext().getAttribute("entries");
		// add data da lay vao entries
		entries.add(entry);
		// gui user nay den URl GuestBook
		response.sendRedirect("GuestBook");
	}

}
