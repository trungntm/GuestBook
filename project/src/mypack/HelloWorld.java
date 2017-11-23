package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/HelloWorld", "/a", "/b","/member/*"}) // request được gửi tới URL được trình bày ở annotation, nếu đổi URL thì servlet chỉ thực hiện request được gửi tới URL được đổi mới
// URL patterns này là mảng kiểu chuỗi có nhiều phần tử nên cần đặt các giá trị trong cặp dấu {}, khi đó các URL này đều được servlet xử lý như nhau
// "/member/*" dùng ký tự thay thế, khi nhập URL thì chỗ dấu * bất kỳ cái gì thì servlet cũng thực thi
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public HelloWorld() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter(); // khai báo đối tượng PrintWriter để lấy nội dung trang HTML bên dưới cho đối tượng response để đưa lên Browser xử lý,
		//và cũng để gọn code hơn khi viết response.getWriter().println()
		response.setContentType("text/html"); // setContentType để định dạng in ra là kiểu text hay một trang html, giúp Browser hiển thị đúng và dễ dàng vì đã chỉ định cụ thể
		//response.getWriter().println("Hello World"); // lệnh để viết ra dòng "Hello World", được gửi về cho browser và browser sẽ in lên trình duyệt web
		out.println("<html><head><title>Hello</title></head><body>"); // in ra các thẻ trong HTML với các thẻ mở và thẻ đóng
		out.println("<h2>Hello World<h2>"); // in ra dòng "Hello World" trong cặp thẻ <h2>
		out.println("</body></html>"); // đóng các thẻ body và html
	}
}
