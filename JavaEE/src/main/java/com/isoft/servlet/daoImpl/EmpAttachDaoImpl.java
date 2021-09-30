package com.isoft.servlet.daoImpl;

import com.isoft.servlet.dao.EmpAttachDao;
import com.isoft.servlet.entity.Dept;
import com.isoft.servlet.entity.Emp;
import com.isoft.servlet.entity.EmpAttach;
import com.isoft.servlet.utils.DB;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EmpAttachDaoImpl implements EmpAttachDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public int addEA(EmpAttach empAttach) {
        int flag = 0;
        try {
            conn = DB.getConnection();
            String sql = "insert into t_emp_attach(e_id,education,hiredate,bank,card,LCE,state) values(?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, empAttach.getEid());
            ps.setString(2, empAttach.getEducation());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(empAttach.getHiredate());
            java.sql.Date sqldate = new java.sql.Date(date.getTime());
            ps.setDate(3,sqldate);

            ps.setString(4,empAttach.getBank());
            ps.setString(5,empAttach.getCard());
            ps.setString(6,empAttach.getLce());
            ps.setInt(7, empAttach.getState());

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                flag = rs.getInt(1);
            }
        }catch (SQLIntegrityConstraintViolationException s){
            System.out.println("没有此员工编号，请重新输入！");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB.close(conn,ps,rs);
        }
        return flag;
    }


    @Override
    public int updateEA(EmpAttach empAttach) {

        int flag = 0;
        try {
            conn = DB.getConnection();
            String sql = "update t_emp_attach set state = ? where id = ?";
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, empAttach.getState());
            ps.setInt(2,empAttach.getId());

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                flag = rs.getInt(1);
            }
        }catch (SQLIntegrityConstraintViolationException s){
            System.out.println("没有此员工编号，请重新输入！");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB.close(conn,ps,rs);
        }
        return flag;
    }

    @Override
    public EmpAttach selectById(String eid) {
        return null;
    }

    @Override
    public EmpAttach selectState(String state) {
        return null;
    }


    @Override
    public List<EmpAttach> selectAll() {
        return null;
    }
}
