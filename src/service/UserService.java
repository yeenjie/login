package service;

import bean.User;
import dao.UserDao;
import util.DaoUtil;
import util.DateUtil;
import util.PasswordUtil;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class UserService {
    private UserDao userDao= DaoUtil.getUserDao();
    public void add(String name,String password) throws NoSuchAlgorithmException {
        //加密处理
        String md5Password = PasswordUtil.md5(password);
        User user = new User();
        user.setPassword(md5Password);
        user.setName(name);
        user.setLogintimes(0);
        user.setDatetime(new Date());
        user.setAuthority(0);
        userDao.add(user);

    }
    public boolean query(String name,String password) throws NoSuchAlgorithmException {
        String md5Password = PasswordUtil.md5(password);
        if(userDao.query(name,md5Password)!=null){
            return true;
        }
        return false;
    }

    public int getAuthority(String name){
         return userDao.queryByName(name).getAuthority();
    }

    public boolean exist(String name){
        if(userDao.queryByName(name)==null) return false;
        return true;
    }
    public void wrong(String name){
        User user = userDao.queryByName(name);
        int loginTime = user.getLogintimes();
        Date date = new Date();
        user.setDatetime(date);
        user.setLogintimes(loginTime+1);
        userDao.update(user);
    }

    public int getLoginTime(String name){
        return userDao.queryByName(name).getLogintimes();
    }

    public Date getDateTime(String name){
        return userDao.queryByName(name).getDatetime();
    }

    public void resetLoginTime(String name){
        User user = userDao.queryByName(name);
        user.setLogintimes(0);
        userDao.update(user);
    }

    public boolean checkLoginTime(String name){
        User user = userDao.queryByName(name);
        if(user!=null){
            int dayDiff = DateUtil.getDayDiff(new Date(),user.getDatetime());
            if(dayDiff>=1){
                resetLoginTime(name);
                return true;
            }
            if(user.getLogintimes()>3){
                return false;
            }
        }
        return true;
    }


}
