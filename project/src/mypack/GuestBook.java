package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.GuestBookEntry;

// thiet lap cho servlet duoc load len sau khi deploy len server
@WebServlet(urlPatterns="/GuestBook",loadOnStartup=1)// luon dam bao du lieu dc khoi tao truoc khi co servlet nao truy xuat den no
public class GuestBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GuestBook() {
        super();
    }

    
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		List<GuestBookEntry> entries=new ArrayList<GuestBookEntry>();
		entries.add(new GuestBookEntry("john","hello",0));
		entries.add(new GuestBookEntry("joe","Nice to meet you!",1));
		// luu entries vao aplycation context
		getServletContext().setAttribute("entries", entries); // luu data vao appScope
		getServletContext().setAttribute("id", 1);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// lay entries trong appScope
		List<GuestBookEntry> entries=(List<GuestBookEntry>) getServletContext().getAttribute("entries");
		PrintWriter out=response.getWriter(); 
		response.setContentType("text/html"); 
		out.println("<html><head><title>GuestBook</title></head><body>"); 
		out.println("<h2>Guest Book<h2>"); 
		out.println("<table border='1'>");
		out.println("<tr><th>Name</th><th>Message</th>");
		//  duyet qua cac danh sach entries nay voi moi entries se tao ra 1 table row
		//for(int i=0;i<entries.size();i++){
		for (GuestBookEntry entry : entries) {
			//GuestBookEntry entry=entries.get(i);
			out.println("<tr><td>"+entry.getName()+" said : </td><td>"+entry.getMessage()+
					"</td><td><a href='EditEntry?id="+entry.getId()+"'>Edit</a>|<a href='DeleteEntry?id="+entry.getId()+"'>Delete</a></td></tr>");
		}
		out.println("</table>");
		out.println("<p><a href='AddComment'>Leave Comment</a></p>");
		out.println("<p><a href='AddCommentWithCookie'>Leave Comment (with cookie)</a></p>");
		out.println("<p><a href='AddCommentWithSession'>Leave Comment (with session)</a></p>");
		out.println("</body></html>"); 	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
