import util.DaoUtil;
import dao.UserDao;

public class Test {

    public static void main(String[] args) {
        UserDao userDao = new DaoUtil().getUserDao();

    }
}
