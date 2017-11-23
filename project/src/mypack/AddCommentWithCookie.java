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

@WebServlet("/AddCommentWithCookie")
public class AddCommentWithCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddCommentWithCookie() {
        super();
    }

    private String getUsernameFromCookie(HttpServletRequest request){
    	// khoi tao mang cookies lay toan bo cookie
    	Cookie[] cookies=request.getCookies();
    	// neu cookies khac nul
    	if(cookies!=null){
    		// duyet tren tat ca cac phan tu cua cookies
    		for(Cookie cookie: cookies){
    			if(cookie.getName().equals("name")){
    				return cookie.getValue();
    			}
    		}
    	}
    	return null;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter(); // khai báo đối tượng PrintWriter để lấy nội dung trang HTML bên dưới cho đối tượng response để đưa lên Browser xử lý,
		//và cũng để gọn code hơn khi viết response.getWriter().println()
		response.setContentType("text/html"); 
		out.println("<html><head><title>Add Comment With Cookie</title></head><body>"); 
		out.println("<form action='AddCommentWithCookie' method='Post'>");
		// Neu da co name trong cookies, chi can hien thi name
		String name=getUsernameFromCookie(request);
		
		//  co username trong cookie
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
		String name=getUsernameFromCookie(request);
		
		if(name==null){
			name=request.getParameter("name");
			Cookie cookie=new Cookie("name", name);
			response.addCookie(cookie);
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
