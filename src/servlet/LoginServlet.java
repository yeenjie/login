package servlet;

import bean.User;
import dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;
import servlet.yanzhengma.checkUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

@WebServlet(name = "LoginServlet",urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //验证码校验
        boolean checked = checkUtil.check(request);
        String name = request.getParameter("name");
        String password= request.getParameter("password");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter printWriter = response.getWriter();
        UserService userService = new UserService();
        if(checked){
            if(!userService.exist(name)){
                printWriter.print("用户不存在！");
            }else{
                try {
                    if(!userService.checkLoginTime(name)){
                        printWriter.print("登陆超过三次");
                    }else {
                        if (!userService.query(name, password)) {
                            userService.wrong(name);
                            printWriter.print("密码错误！");
                        } else {
                            if (userService.getAuthority(name) == 1) {
                                printWriter.print("listUsers");
                            } else {
                                printWriter.print("admin");
                            }

                        }
                    }
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
            }
        }else{
            printWriter.print("验证码错误！");
        }

    }
}
