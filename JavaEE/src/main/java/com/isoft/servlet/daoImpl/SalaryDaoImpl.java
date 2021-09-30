package com.isoft.servlet.daoImpl;

import com.isoft.servlet.dao.SalaryDao;
import com.isoft.servlet.entity.Salary;
import com.isoft.servlet.utils.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SalaryDaoImpl implements SalaryDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    @Override
    public int addSal(Salary s) {
        int flag = 0;
        try{
            conn = DB.getConnection();
            String sql = "insert into salary(e_id,p_sal,b_sal,t_sub,c_sub,t_allo) values (?,?,?,?,?,?);";
            ps = conn.prepareStatement(sql);
            ps.setString(1,s.getEid());
            ps.setDouble(2,s.getpSal());
            ps.setDouble(3,s.getbSal());
            ps.setDouble(4,s.gettSub());
            ps.setDouble(5,s.getcSub());
            ps.setDouble(6,s.gettAllo());
            flag = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB.close(conn,ps,rs);
        }
        return flag;
    }

    @Override
    public int updateSal(Salary s) {
        int flag = 0;
        try{
            conn = DB.getConnection();
            String sql = "update salary set p_sal = ?,b_sal = ?,t_sub = ?,c_sub = ?,t_allo = ? where id = ?";
            ps = conn.prepareStatement(sql);

            ps.setDouble(1,s.getpSal());
            ps.setDouble(2,s.getbSal());
            ps.setDouble(3,s.gettSub());
            ps.setDouble(4,s.getcSub());
            ps.setDouble(5,s.gettAllo());
            ps.setInt(6,s.getId());
            flag = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB.close(conn,ps,rs);
        }
        return flag;
    }

    @Override
    public Salary selectById(String eid) {
        try {
            conn = DB.getConnection();
            String sql = "select * from t_emp e join salary s on e.e_id = s.e_id where e.e_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,eid);
            rs = ps.executeQuery();
            if (rs.next()){

                Salary s = new Salary();
                s.setEid(rs.getString("e_id"));
                s.setpSal(rs.getDouble("p_sal"));
                s.setbSal(rs.getDouble("b_sal"));
                s.settSub(rs.getDouble("t_sub"));
                s.setcSub(rs.getDouble("c_sub"));
                s.settAllo(rs.getDouble("t_allo"));

                return s;
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB.close(conn,ps,rs);
        }
        return null;
    }
}
