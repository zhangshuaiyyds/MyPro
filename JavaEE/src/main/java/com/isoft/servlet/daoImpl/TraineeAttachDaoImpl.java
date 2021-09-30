package com.isoft.servlet.daoImpl;

import com.isoft.servlet.dao.TraineeAttachDao;
import com.isoft.servlet.entity.TraineeAttach;
import com.isoft.servlet.utils.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TraineeAttachDaoImpl implements TraineeAttachDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public int addTrainee(TraineeAttach tac) {
        int flag = 0;
        try {
            conn = DB.getConnection();
            String sql = "insert into t_trainee_attach(e_id,school,class,p_inter,standard,sal_standard,state) values(?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,tac.getEid());
            ps.setString(2,tac.getSchool());
            ps.setString(3,tac.getClasses());
            ps.setString(4,tac.getpInter());
            ps.setInt(5,tac.getStandard());
            ps.setDouble(6,tac.getSalStandard());
            ps.setInt(7,tac.getState());


            flag = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB.close(conn,ps,rs);
        }
        return flag;
    }

    @Override
    public int updateTrainee(TraineeAttach tac) {
        int flag = 0;
        try {
            conn = DB.getConnection();
            String sql = "update t_trainee_attach set school = ?,class = ?,p_inter = ?,standard = ?,sal_standard = ?,state =? where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,tac.getSchool());
            ps.setString(2,tac.getClasses());
            ps.setString(3,tac.getpInter());
            ps.setInt(4,tac.getStandard());
            ps.setDouble(5,tac.getSalStandard());
            ps.setInt(6,tac.getState());
            ps.setInt(7,tac.getId());

            flag = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB.close(conn,ps,rs);
        }
        return flag;
    }

    @Override
    public TraineeAttach selectById(String eid) {
        try {
            conn = DB.getConnection();
            String sql = "select * from t_trainee_attach where e_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,eid);
            if (rs.next()){
                TraineeAttach ta = new TraineeAttach();
                ta.setEid(rs.getString("eid"));
                ta.setSchool(rs.getString("school"));
                ta.setClasses(rs.getString("class"));
                ta.setpInter(rs.getString("p_inter"));
                ta.setStandard(rs.getInt("standard"));
                ta.setSalStandard(rs.getDouble("sal_standard"));
                ta.setState(rs.getInt("state"));
                return ta;
            }
            rs = ps.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB.close(conn,ps,rs);
        }
        return null;
    }

    @Override
    public TraineeAttach selectState(String eid) {
        try {
            conn = DB.getConnection();
            String sql = "select e_id,state from t_trainee_attach where e_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,eid);
            if (rs.next()){
                TraineeAttach ta = new TraineeAttach();
                ta.setEid(rs.getString("eid"));
                ta.setSchool(rs.getString("school"));
                ta.setClasses(rs.getString("class"));
                ta.setpInter(rs.getString("p_inter"));
                ta.setStandard(rs.getInt("standard"));
                ta.setSalStandard(rs.getDouble("sal_standard"));
                ta.setState(rs.getInt("state"));

                return ta;
            }

            rs = ps.executeQuery();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB.close(conn,ps,rs);
        }
        return null;
    }
}
