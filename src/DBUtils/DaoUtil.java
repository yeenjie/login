package DBUtils;

import dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoUtil {
    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    public static UserDao getUserDao(){
        return (UserDao)applicationContext.getBean("userDao");
    }
}
