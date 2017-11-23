package mypack;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Dowload")
public class Dowload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Dowload() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpg");
		response.setHeader("Content-Disposition", "inline;filename=Bill Gate.jpg");
		FileInputStream in=new FileInputStream("D://LT Web//DOANCUOIKY//Workshop-Website//front-end-web//private//images-user/Bill Gate.jpg");
		OutputStream out=response.getOutputStream();
		byte[] buffer=new byte[2048];
		int byteRead;
		while((byteRead=in.read(buffer))>0){
			out.write(buffer,0,byteRead);
		}
		in.close();
	}

}
