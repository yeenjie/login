package servlet;

import service.UserService;
import servlet.yanzhengma.checkUtil;
import util.DaoUtil;
import bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

@WebServlet(name = "RegisterServlet",urlPatterns = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    private UserService userService =new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean checked = checkUtil.check(request);
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String isCheckName = request.getParameter("checkName");
        PrintWriter out = response.getWriter();
//        System.out.println(isCheckName);
        if("1".equals(isCheckName)&&userService.exist(name))
        {
            out.print("exist");
        }else if("0".equals(isCheckName)){
            if(checked){
                if(userService.exist(name)){
                    out.print("exist");
                }else{
                    try {
                        userService.add(name,password);
                    } catch (Exception e) {
                        e.printStackTrace();
                        out.print("fail");
                    }
                    out.print("succeed");
                }
            }else{
                out.print("checkfail");
            }

        }
    }
}
