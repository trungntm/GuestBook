package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GuestBookEntry;

@WebServlet("/EditEntry")
public class EditEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditEntry() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// lay entry tu appScope
		List<GuestBookEntry> entries=(List<GuestBookEntry>) getServletContext().getAttribute("entries");
		// lay index tu requestParam
		int id=Integer.parseInt(request.getParameter("id"));
		// lay entry tai index da lay

		for (GuestBookEntry entry : entries) {
			if(entry.getId()==id){
				PrintWriter out=response.getWriter(); // khai báo đối tượng PrintWriter để lấy nội dung trang HTML bên dưới cho đối tượng response để đưa lên Browser xử lý,
				//và cũng để gọn code hơn khi viết response.getWriter().println()
				response.setContentType("text/html"); 
				out.println("<html><head><title>Edit Comment</title></head><body>"); 
				out.println("<form action='EditEntry' method='Post'>");
				// Them gia tri value = index vao <input>
				out.println("Name: <input type='text' name='name' value="+entry.getName()+"'></br>");
				out.println("Message: <textarea name='message' rows='5' cols='60'>"+entry.getMessage()+"</textarea></br>");
				out.println("<input type='hidden' name='id' value='"+entry.getId()+"'>");
				out.println("<input type='submit' name='add' value='add'>");
				out.println("</form>");
				out.println("</body></html>"); // đóng các thẻ body và html
			}
			else{
				PrintWriter out=response.getWriter();
				response.setContentType("text/html"); 
				out.println("<html><head><title>Edit Comment</title></head><body>"); 
				out.println("<h3> Phan tu da bi xoa. Vui long quay tro lai trang truoc!</h3>");
				out.println("</body></html>");
			}
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Lay data submit tu form
				List<GuestBookEntry> entries=(List<GuestBookEntry>) getServletContext().getAttribute("entries");
				String name=request.getParameter("name");
				String message=request.getParameter("message");
				// lay index tu request de cap nhat trong doPost
				int id=Integer.parseInt(request.getParameter("id"));
				for (GuestBookEntry entry : entries) {
					if(entry.getId()==id){
						// Lay entry hien tai va cap nhat
						//entries.add(new GuestBookEntry(name,message));
						entry.setName(name);
						entry.setMessage(message);
						// gui user nay den URl GuestBook
						break;
					}
				}

				response.sendRedirect("GuestBook");
	}

}
