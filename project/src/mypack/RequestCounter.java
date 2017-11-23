package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/RequestCounter",loadOnStartup=1) // khi dùng annotiton có nhiều thành phần thì phải có tên của các thành phần
// url
public class RequestCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RequestCounter() {
        super();
    }
    
	public void init(ServletConfig config) throws ServletException {
		super.init(config); // ghi đè phương thức init trong lớp cha, nên phải gọi lại phương thức init trong lớp cha,
		//nếu không sẽ không được khởi tạo đúng
		int counter=0; // khởi tạo counter = 0
		getServletContext().setAttribute("counter", counter); // truy xuất vào application scope và lưu biết counter vào
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext=getServletContext(); // khởi tạo đói tượng servletContext = getServletContext
		// get counter
		int counter =(int)servletContext.getAttribute("counter"); // Khởi tạo biến counter để truy xuất tới application scope thông qua đối tượng servletContext và ép về kiểu int
		// và dùng getAttribute để lấy đối tượng counter qua tên của nó
		// increment counter

		counter++;	// Mỗi khi request thì hàm doGet sẽ được gọi và tăng biến counter

		// set counter to application scoppe	
		servletContext.setAttribute("counter", counter);// lưu giá trị counter sau khi tăng về lại application scope
		PrintWriter out=response.getWriter(); // khai báo đối tượng PrintWriter để lấy nội dung trang HTML bên dưới cho đối tượng response để đưa lên Browser xử lý,
		//và cũng để gọn code hơn khi viết response.getWriter().println()
		response.setContentType("text/html"); // setContentType để định dạng in ra là kiểu text hay một trang html, giúp Browser hiển thị đúng và dễ dàng vì đã chỉ định cụ thể
		out.println("<html><head><title>Request Counter</title></head><body>"); // in ra các thẻ trong HTML với các thẻ mở và thẻ đóng
		out.println("<h2>The counter is increment"); // in ra dòng "You are visitor" kèm theo số counter trong cặp thẻ <h2>
		out.println("</body></html>"); // đóng các thẻ body và html
	}

}
