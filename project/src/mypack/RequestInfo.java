package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestInfo")
public class RequestInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RequestInfo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter(); // khai báo đối tượng PrintWriter để lấy nội dung trang HTML bên dưới cho đối tượng response để đưa lên Browser xử lý,
		//và cũng để gọn code hơn khi viết response.getWriter().println()
		response.setContentType("text/html"); // setContentType để định dạng in ra là kiểu text hay một trang html, giúp Browser hiển thị đúng và dễ dàng vì đã chỉ định cụ thể
		
		out.println("<html><head><title>RequestInfo</title></head><body>"); 
		out.println("<p>Method : "+request.getMethod()+"</p>"); 
		out.println("<p>ContextPath : "+request.getContextPath()+"</p>");
		out.println("<p>URL : "+request.getRequestURL()+"</p>");	
		out.println("<p>URI : "+request.getRequestURI()+"</p>");
		out.println("<p>RemoteAddr : "+request.getRemoteAddr()+"</p>");
		if(request.getHeader("Accept-Encoding").indexOf("gzip")>=0)
			out.println("<p>Gzip supported</p>");
		else{
			out.println("<p>Gzip not supported</p>");
		}
		out.println("</body></html>"); // đóng các thẻ body và html
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
