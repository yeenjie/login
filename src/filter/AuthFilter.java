package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter",urlPatterns = "/*")
public class AuthFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response =(HttpServletResponse)resp;

        String uri = request.getRequestURI();
        if(uri.endsWith("login.html")||uri.endsWith("register.jsp")||uri.endsWith("logcheck")||uri.endsWith("loginServlet")||uri.endsWith("registerServlet")){
            chain.doFilter(request,response);
            return;
        }
        HttpSession session= request.getSession();
        String userName = (String) session.getAttribute("name");
        int authority =0;
        if(session.getAttribute("authority")!=null){
            authority = (Integer) session.getAttribute("authority");
        }
        if(userName==null){
            response.sendRedirect("login.html");
            return;
        }else{
            int auth = authority;
            switch (auth){
                case 0 : if(uri.endsWith("Admin.jsp")){
                    response.sendRedirect("login.html");
                    return;
                }break;
            }
        }
        chain.doFilter(request,response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
