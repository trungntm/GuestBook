package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Countdown")
public class Countdown extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	int counter=10;
	
    public Countdown() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter(); 
		response.setContentType("text/html"); 
		out.println("<html><head><title>Countdown</title></head><body>"); 
		
		if(counter==0){
			out.println("<p>Rocket launched!</p>");
		}
		else{
			out.println("<h3>"+counter+"</h3>");
			response.setHeader("Refresh", "1");
			--counter; 
		}
		
		out.println("</body></html>"); 
	}

}
