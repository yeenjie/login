package servlet.yanzhengma;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class checkUtil {
    public static boolean check(HttpServletRequest request){
        //验证码校验
        boolean checked =false;
        String info=null;
        /*获取输入的值*/
        String value1=request.getParameter("logcheck");
        /*获取图片的值*/
        HttpSession session=request.getSession();
        String value2=(String)session.getAttribute("checkcode");
        if(value2.equalsIgnoreCase(value1)){
            checked = true;
        }else{
            checked = false;
        }
        return checked;
    }
}
