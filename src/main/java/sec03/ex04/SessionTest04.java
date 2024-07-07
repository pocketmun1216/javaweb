package sec03.ex04;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
		urlPatterns = {
				"/login"
		}
		)
public class SessionTest04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SessionTest04() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public void destroy() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession sess = request.getSession();
		
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		if (sess.isNew()) {
			if (id != null) {
				sess.setAttribute("user_id", id);
				out.println("<a href='login.html'>로그인 상태 확인</a>");
			} else {
				out.println("<a href='login.html'>다시 로그인 하세요</a>");
				sess.invalidate();
			}
		} else {
			id = (String) sess.getAttribute("user_id");
			
			if (id != null && id.length() != 0) {
				out.print("안녕하세요 " + id + "님!!!");
			} else {
				out.print("<a href='login.html'>다시 로그인 하세요!!</a>");
				sess.invalidate();
			}
		}
	}

}
