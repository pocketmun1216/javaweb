package sec02.ex01;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

@WebServlet(
		urlPatterns = {
				"/set"
		}
		)
public class SetCookieValue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SetCookieValue() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public void destroy() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Date d = new Date();
		Cookie c = new Cookie("cookieTest", URLEncoder.encode("JSP 프로그래밍입니다.", "UTF-8"));
		c.setMaxAge(-1);
		
		response.addCookie(c);
		
		out.print("현재 시간 : " + d);
		out.print("현재 시간을 Cookie로 저장합니다.");
		
	}

}
