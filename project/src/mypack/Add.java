package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.InterningXmlVisitor;


@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Add() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int a = Integer.parseInt(request.getParameter("a"));
//		int b = Integer.parseInt(request.getParameter("b"));
//		int a=0,b=0;
//		if(request.getParameter("a")!=null){
//			a = Integer.parseInt(request.getParameter("a"));
//		}
//		if(request.getParameter("b")!=null){
//			b = Integer.parseInt(request.getParameter("b"));
//		}
		
		String a=request.getParameter("a");
		String b=request.getParameter("b");
		if(a==null || b==null|| a.trim().length()==0 || b.trim().length()==0){
			response.sendRedirect("AddForm.html");
			return;
		}
		
		PrintWriter out=response.getWriter(); // khai báo đối tượng PrintWriter để lấy nội dung trang HTML bên dưới cho đối tượng response để đưa lên Browser xử lý,
		//và cũng để gọn code hơn khi viết response.getWriter().println()
		response.setContentType("text/html"); // setContentType để định dạng in ra là kiểu text hay một trang html, giúp Browser hiển thị đúng và dễ dàng vì đã chỉ định cụ thể
		int sum=Integer.parseInt("a")+Integer.parseInt("b");
		out.println("<html><head><title>Add</title></head><body>"); 
		out.println("<p>"+a+"+"+b+"="+sum+"</p>"); 
		out.println("</body></html>"); // đóng các thẻ body và html
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
