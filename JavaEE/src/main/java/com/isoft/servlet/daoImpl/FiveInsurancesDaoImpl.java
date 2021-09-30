package com.isoft.servlet.daoImpl;

import com.isoft.servlet.dao.FiveInsurancesDao;
import com.isoft.servlet.entity.Emp;
import com.isoft.servlet.entity.FiveIns;
import com.isoft.servlet.utils.DB;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class FiveInsurancesDaoImpl implements FiveInsurancesDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public int addFiveIns(FiveIns f) {
        int flag = 0;
        try {
            conn = DB.getConnection();
            String sql = "insert into five_insurances(e_id,edt_int,med_int,uet_int,emi_int,mat_int,h_p_f) (?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);

            ps.setString(1,f.getEid());
            ps.setDouble(2,f.getEdtInt());
            ps.setDouble(3,f.getMedInt());
            ps.setDouble(4,f.getUetInt());
            ps.setDouble(5,f.getEmiInt());
            ps.setDouble(6,f.getMatInt());
            ps.setDouble(7,f.getHpf());

            flag = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB.close(conn,ps,rs);
        }
        return flag;
    }

    @Override
    public int updateFiveIns(FiveIns f) {
        int flag = 0;
        try {
            conn = DB.getConnection();
            String sql = "update five_insurances set edt_int = ?,med_int = ?,uet_int = ?,emi_int = ?,mat_int = ?,h_p_f = ? where id = ?";
            ps = conn.prepareStatement(sql);

            ps.setDouble(1,f.getEdtInt());
            ps.setDouble(2,f.getMedInt());
            ps.setDouble(3,f.getUetInt());
            ps.setDouble(4,f.getEmiInt());
            ps.setDouble(5,f.getMatInt());
            ps.setDouble(6,f.getHpf());
            ps.setInt(7,f.getId());

            flag = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB.close(conn,ps,rs);
        }
        return flag;
    }

    @Override
    public FiveIns selectByFive(String name) {
        try {
            conn = DB.getConnection();
            String sql = "select * from t_emp e join five_insurances f on e.e_id = f.e_id where e.e_name = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            rs = ps.executeQuery();
            if (rs.next()){
                FiveIns f = new FiveIns();
                f.setEid(rs.getString("e_id"));
                f.setEdtInt(rs.getDouble("edt_int"));
                f.setMedInt(rs.getDouble("med_int"));
                f.setUetInt(rs.getDouble("uet_int"));
                f.setEmiInt(rs.getDouble("emi_int"));
                f.setMatInt(rs.getDouble("mat_int"));
                f.setHpf(rs.getDouble("h_p_f"));
                return f;
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB.close(conn,ps,rs);
        }
        return null;
    }
}
