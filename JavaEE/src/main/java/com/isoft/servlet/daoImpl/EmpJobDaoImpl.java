package com.isoft.servlet.daoImpl;

import com.isoft.servlet.dao.EmpJobDao;
import com.isoft.servlet.entity.EmpJob;
import com.isoft.servlet.utils.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmpJobDaoImpl implements EmpJobDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public int addJob(EmpJob job) {
        int flag = 0;
        try {
            conn = DB.getConnection();
            String sql = "insert into emp_job(e_id,d_no,job) (?,?,?)";
            ps=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, job.getEid());
            ps.setString(2, job.getDno());
            ps.setString(3, job.getJob());

            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                flag = rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB.close(conn,ps,rs);
        }
        return flag;
    }

    @Override
    public int updateJob(EmpJob job) {
        int flag = 0;
        try {
            conn = DB.getConnection();
            String sql = "update emp_job set job = ? where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,job.getJob());
            ps.setInt(2,job.getId());

            flag = ps.executeUpdate();


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB.close(conn,ps,rs);
        }
        return flag;
    }
}
