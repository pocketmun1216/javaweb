package sec02.ex01;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/initMenu")
public class ContextParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContextParamServlet() {
    }


	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}


	public void destroy() {
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletContext context = getServletContext();
		context.setAttribute("나이 : ", 34);
		
		String name = context.getInitParameter("name");
		String address = context.getInitParameter("address");
		
		
		System.out.println("이름 : " + name);
		System.out.println("주소 : " + address);
		
		StringBuilder data = new StringBuilder("<html><body>");
		data.append("이름 : " + name + "<br>");
		data.append("주소 : " + address + "<br>");
		
		data.append("</body></html>");
		out.print(data);
	}

}
