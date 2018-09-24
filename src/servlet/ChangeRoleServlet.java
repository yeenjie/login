package servlet;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ChangeRoleServlet",urlPatterns = "/changeRole")
public class ChangeRoleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String role = request.getParameter("role");
        String userName = request.getParameter("name");
        int auth = 0;
        if("1".equals(role)){
            auth = 1;
        }else if("0".equals(role)){
            auth = 0;
        }
        new UserService().updateRole(userName,auth);
        response.sendRedirect("listUsers");
    }
}
