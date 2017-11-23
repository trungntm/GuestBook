package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.GuestBookDAO;
import model.GuestBookEntry;


@WebServlet("/DSGuestBook")
public class DSGuestBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DSGuestBook() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
		request.setCharacterEncoding("utf-8"); 
		
		PrintWriter out = response.getWriter();
		
		try {
			List<GuestBookEntry> DsGuestBook = GuestBookDAO.getMessage();
			
			if(DsGuestBook == null)
			{
				System.out.println("Loi");
				return;
			}
					
			for(GuestBookEntry rs: DsGuestBook)
				out.println("<tr><td>"+rs.getId()+"</td><td>"+rs.getName()+"</td><td>"+rs.getMessage()+"</td></tr>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
