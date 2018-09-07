import DBUtils.DaoUtil;
import bean.User;
import dao.UserDao;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

public class Test {

    public static void main(String[] args) {
        UserDao userDao = new DaoUtil().getUserDao();

    }
}
