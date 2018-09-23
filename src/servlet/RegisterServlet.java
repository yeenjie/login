package servlet;

import util.DaoUtil;
import bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet",urlPatterns = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if(new DaoUtil().getUserDao().exist(name))
        {
            response.sendRedirect("fail.jsp");
        }
        else {
            User user = new User();
            user.setName(name);
            user.setPassword(password);
            new DaoUtil().getUserDao().add(user);
            response.sendRedirect("succeed.jsp");
        }
    }
}
