package dao;

import bean.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository("userDao")
public class UserDao {
    @Resource(name="jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    public  User add(User user){
        String sql ="insert into user values(null,?,?,?,?,?)";
        Object args[]={user.getName(),user.getPassword(),user.getDatetime(),user.getLogintimes(),user.getAuthority()};
        int id = jdbcTemplate.update(sql,args);
        user.setId(id);
        return user;
    }

    public void delete(int id){
        String sql="delete from user where id = ?";
        Object args[]={id};
        jdbcTemplate.update(sql,args);
        return;
    }

    public User query(String name,String password){
        String sql="select * from user where name=? AND password =?";
        User user = null;
        try{
            user = (User) jdbcTemplate.queryForObject(sql,new Object[]{name,password},new BeanPropertyRowMapper(User.class));
        }catch (EmptyResultDataAccessException e){
            return null;
        }

        return user;
    }

    public User queryByName(String name){
        String sql="select * from user where name =?";
        User user = null;
        try{
            user = (User) jdbcTemplate.queryForObject(sql,new Object[]{name},new BeanPropertyRowMapper(User.class));
        }catch (EmptyResultDataAccessException e){
            return null;
        }
        return user;
    }
    public void update(User user){
        String sql="update user set name= ?,password=?,datetime=?,logintimes=?,authority=? where id=?";
        jdbcTemplate.update(sql,new Object[]{user.getName(),user.getPassword(),user.getDatetime(),user.getLogintimes(),user.getAuthority(),user.getId()});
        return;
    }

    public List<User> list(int start,int count){
        String sql ="select * from user limit ?,?";
        List<User> users = jdbcTemplate.query(sql,new Object[]{start,count},new BeanPropertyRowMapper(User.class));
        return  users;
    }

    public Long getAuthority(String name){
        String sql = "select authority from user where name= ?";
        Long authority = jdbcTemplate.queryForObject(sql,new Object[]{name},Long.class);
        return authority;
    }

    public int getLoginTimes(String name){
        String sql = "select authority from user where name= ?";
        int loginTimes = jdbcTemplate.queryForObject(sql,new Object[]{name},Integer.class);
        return loginTimes;
    }

    public List<User> list(){
        return list(0,Short.MAX_VALUE);
    }
}

