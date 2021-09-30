package com.isoft.servlet.daoImpl;

import com.isoft.servlet.dao.UserDao;
import com.isoft.servlet.entity.Emp;
import com.isoft.servlet.entity.User;
import com.isoft.servlet.utils.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    @Override
    public User login(String username,String password) {

            try {
                conn = DB.getConnection();
                String sql = "select * from user where username = ? and password = ?";

                ps = conn.prepareStatement(sql);

                ps.setString(1, username);
                ps.setString(2, password);

                rs = ps.executeQuery();
                if (rs.next()){
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setEid(rs.getString("e_id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    return user;
                }

            } catch (Exception e) {
                System.out.println("账号或者密码不正确！请重新输入");
            } finally {
                DB.close(conn, ps, rs);
            }

            return null;
    }
}
