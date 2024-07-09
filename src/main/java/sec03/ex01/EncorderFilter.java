package sec03.ex01;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;


@WebFilter(
		urlPatterns = {
				"/*"
		}
	)
public class EncorderFilter extends HttpFilter implements Filter {
       
    public EncorderFilter() {
        super();
        // TODO Auto-generated constructor stub
    }


	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Encorder Filter doFilter");
		
		long begin = System.currentTimeMillis();
		
		request.setCharacterEncoding("utf-8");
		String context = request.getServletContext().getContextPath();
		
		System.out.println(context);
		
		chain.doFilter(request, response);
		
		long end = System.currentTimeMillis();
		System.out.println("작업 시간 : " + (end - begin) + "ms");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Encorder Filter init");
	}

}
