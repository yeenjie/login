package servlet;

import service.UserService;
import util.DaoUtil;
import bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet(name = "RegisterServlet",urlPatterns = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    private UserService userService =new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if(userService.exist(name))
        {
            response.sendRedirect("fail.jsp");
        }
        else {
            try {
                userService.add(name,password);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                response.sendRedirect("fail.jsp");
            }
            response.sendRedirect("succeed.jsp");
        }
    }
}
