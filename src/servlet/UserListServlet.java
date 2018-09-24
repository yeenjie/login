package servlet;

import util.DaoUtil;
import bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "userListServlet",urlPatterns = "/listUsers")
public class UserListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users =new DaoUtil().getUserDao().list();
        req.setAttribute("users",users);
        req.getRequestDispatcher("listUsersAdmin.jsp").forward(req,resp);
    }
}
