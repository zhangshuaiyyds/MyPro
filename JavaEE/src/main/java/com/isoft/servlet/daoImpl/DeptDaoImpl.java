package com.isoft.servlet.daoImpl;

import com.isoft.servlet.dao.DeptDao;
import com.isoft.servlet.entity.Dept;
import com.isoft.servlet.utils.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeptDaoImpl implements DeptDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;



    @Override
    public int addDept(Dept dept) {
        int flag = 0;
        try {
            conn = DB.getConnection();
            String sql = "insert into dept(d_no,d_name,d_mg) values(?,?,?)";
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, dept.getDno());
            ps.setString(2, dept.getDname());
            ps.setString(3, dept.getDmg());
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                flag = rs.getInt(1);
            }
        }catch (SQLIntegrityConstraintViolationException s){
            System.out.println("数值重复，请重新输入！");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB.close(conn,ps,rs);
        }

        return flag;
    }

    @Override
    public int deleteDept(int id) {
        int flag = 0;

        try {
            conn = DB.getConnection();
            String sql = "delete from dept where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            flag = ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB.close(conn,ps,rs);
        }
        return flag;
    }

    @Override
    public int updateDept(Dept dept) {
        int flag = 0;

        try {
           conn =  DB.getConnection();
           String sql = "update dept set d_no = ? where id = ?";
           ps = conn.prepareStatement(sql);
           ps.setString(1,dept.getDno());
           ps.setInt(2,dept.getId());
           flag = ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB.close(conn,ps,rs);
        }

        return flag;
    }

    @Override
    public Dept selectById(String dno) {

        try {
            conn = DB.getConnection();
            String sql = "select * from dept where d_no = ?";

            ps = conn.prepareStatement(sql);

            ps.setString(1,dno);
            rs = ps.executeQuery();

            if (rs.next()){
                Dept dept = new Dept();
                dept.setDno(rs.getString("d_no"));
                dept.setDname(rs.getString("d_name"));
                dept.setDmg(rs.getString("d_mg"));
                return dept;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB.close(conn,ps,rs);
        }
        return null;
    }

    @Override
    public Dept selectByName(String name) {
        try {
            conn = DB.getConnection();
            String sql = "select d_mg from dept where d_name = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            rs = ps.executeQuery();

            if (rs.next()){
                Dept dept = new Dept();
                dept.setDno(rs.getString("d_no"));
                dept.setDname(rs.getString("d_name"));
                dept.setDmg(rs.getString("d_mg"));
                return dept;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB.close(conn,ps,rs);
        }
        return null;

    }

    @Override
    public List<Dept> selectAll() {

        try {
            conn = DB.getConnection();
            String sql = "select * from dept";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            List<Dept> a = new ArrayList<>();

            if (rs.next()){
                Dept dept = new Dept();
                dept.setDno(rs.getString("d_no"));
                dept.setDname(rs.getString("d_name"));
                dept.setDmg(rs.getString("d_mg"));
                a.add(dept);
            }
            return a;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB.close(conn,ps,rs);
        }
        return null;

    }
}
