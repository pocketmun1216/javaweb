package sec03.ex01;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
		urlPatterns = {
				"/login"
		}
	)
public class LoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginTest() {
        super();
    }


	public void init(ServletConfig config) throws ServletException {
	}


	public void destroy() {
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginTest Servlet doGet");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		
		out.print("<html><body>");
		out.print("이름 : " + name + "<br>");
		out.print("비밀번호 : " + pw + "<br>");
		out.print("</body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
