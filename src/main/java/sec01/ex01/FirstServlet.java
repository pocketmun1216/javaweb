package sec01.ex01;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FirstServlet() {
    }


	public void init(ServletConfig config) throws ServletException {
		System.out.println("first init 호출");
	}


	public void destroy() {
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//response.sendRedirect("second");
		//response.addHeader("Refresh", "1;url=second");
		
//		out.println("<html><head>");
//		out.println("<script type='text/javascript'>location.href='second';</script>");
//		out.println("</head><body></body></html>");
		
		request.setAttribute("name", "mun");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("second");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
