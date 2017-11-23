package mypack;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GuestBookEntry;

@WebServlet("/DeleteEntry")
public class DeleteEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteEntry() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// lay danh sach entry tu appScope
		List<GuestBookEntry> entries=(List<GuestBookEntry>) getServletContext().getAttribute("entries");
		int id=Integer.parseInt(request.getParameter("id"));
		for (GuestBookEntry entry : entries) {
			if(entry.getId()==id) {
				entries.remove(entry);
				break;
			}
		}
		response.sendRedirect("GuestBook");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
