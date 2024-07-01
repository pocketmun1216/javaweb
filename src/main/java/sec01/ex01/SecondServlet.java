package sec01.ex01;

import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet 메서드 호출");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출");
	}

	@Override
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}
	
}
