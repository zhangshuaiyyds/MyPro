package com.isoft.servlet.daoImpl;

import com.isoft.servlet.dao.EmpDao;
import com.isoft.servlet.entity.Dept;
import com.isoft.servlet.entity.Emp;
import com.isoft.servlet.utils.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public int addEmp(Emp emp) {
        int flag = 0;
        try {
            conn = DB.getConnection();
            String sql = "insert into t_emp(e_id,e_name,e_sex,e_mail,phone,qq,address,postal,country,rpr,birthday,e_num,nation)" +
                    " values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, emp.getEid());
            ps.setString(2, emp.getName());
            ps.setString(3, emp.getSex());
            ps.setString(4, emp.getMail());
            ps.setString(5, emp.getPhone());
            ps.setString(6, emp.getQq());
            ps.setString(7, emp.getAddress());
            ps.setString(8, emp.getPostal());
            ps.setString(9, emp.getCountry());
            ps.setString(10, emp.getRpr());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(emp.getBirthday());
            java.sql.Date sqldate = new java.sql.Date(date.getTime());
            ps.setDate(11, sqldate);
            ps.setString(12, emp.getNum());
            ps.setString(13, emp.getNational());

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                flag = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(conn, ps, rs);
        }
        return flag;
    }

    @Override
    public int deleteEmp(int id) {
        int flag = 0;

        try {
            conn = DB.getConnection();
            String sql = "delete from t_emp where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            flag = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(conn, ps, rs);
        }
        return flag;
    }

    @Override
    public int updateEmp(Emp emp) {
        int flag = 0;

        try {
            conn = DB.getConnection();
            String sql = "update t_emp set birthday = ?";

            if (emp.getEid() != null) {
                sql=sql+", e_id ='" +emp.getEid()+"'";
            }
            if (emp.getName() != null) {
                sql=sql+", e_name ='" +emp.getName()+"'";
            }
            if (emp.getSex() != null) {
                sql=sql+", e_sex ='" +emp.getSex()+"'";
            }
            if (emp.getMail() != null) {
                sql=sql+", e_name ='" +emp.getEid()+"'";
            }
            if (emp.getPhone() != null) {
                sql=sql+", phone ='" +emp.getPhone()+"'";
            }
            if (emp.getQq() != null) {
                sql=sql+", qq ='" +emp.getQq()+"'";
            }
            if (emp.getAddress() != null) {
                sql=sql+", address ='" +emp.getAddress()+"'";
            }
            if (emp.getPostal() != null) {
                sql=sql+", postal ='" +emp.getPostal()+"'";
            }
            if (emp.getCountry() != null) {
                sql=sql+", country ='" +emp.getCountry()+"'";
            }
            if (emp.getRpr() != null) {
                sql=sql+", rpr ='" +emp.getRpr()+"'";
            }


            if (emp.getNum() != null) {
                ps.setString(12, emp.getNum());
            }
            if (emp.getNational() != null) {
                sql=sql+", nation ='" +emp.getNational()+"'";
            }
            sql=sql+"where id = ?";
            ps = conn.prepareStatement(sql);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(emp.getBirthday());
            java.sql.Date sqldate = new java.sql.Date(date.getTime());
            ps.setDate(1, sqldate);

            ps.setInt(2, emp.getId());

            flag = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(conn, ps, rs);
        }

        return flag;
    }

    @Override
    public List<Emp> selectAll() {
        try {
            conn = DB.getConnection();
            String sql = "select * from t_emp";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            List<Emp> a = new ArrayList<>();

            if (rs.next()){
                Emp emp1 = new Emp();
                emp1.setEid(rs.getString("e_id"));
                emp1.setName(rs.getString("e_name"));
                emp1.setSex(rs.getString("e_sex"));
                emp1.setMail(rs.getString("e_mail"));
                emp1.setPhone(rs.getString("phone"));
                emp1.setQq(rs.getString("qq"));
                emp1.setAddress(rs.getString("address"));
                emp1.setPostal(rs.getString("postal"));
                emp1.setCountry(rs.getString("country"));
                emp1.setRpr(rs.getString("rpr"));
                emp1.setBirthday(rs.getString("birthday"));
                emp1.setNum(rs.getString("e_num"));
                emp1.setNational(rs.getString("nation"));
                a.add(emp1);
            }
            return a;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB.close(conn,ps,rs);
        }
        return null;
    }

    @Override
    public Emp selectById(String eid) {
        try {
            conn = DB.getConnection();
            String sql = "select * from t_emp where e_id = ?";

            ps = conn.prepareStatement(sql);

            ps.setString(1, eid);
            rs = ps.executeQuery();

            if (rs.next()) {
                Emp emp1 = new Emp();
                emp1.setEid(rs.getString("e_id"));
                emp1.setName(rs.getString("e_name"));
                emp1.setSex(rs.getString("e_sex"));
                emp1.setMail(rs.getString("e_mail"));
                emp1.setPhone(rs.getString("phone"));
                emp1.setQq(rs.getString("qq"));
                emp1.setAddress(rs.getString("address"));
                emp1.setPostal(rs.getString("postal"));
                emp1.setCountry(rs.getString("country"));
                emp1.setRpr(rs.getString("rpr"));
                emp1.setBirthday(rs.getString("birthday"));
                emp1.setNum(rs.getString("e_num"));
                emp1.setNational(rs.getString("nation"));

                return emp1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(conn, ps, rs);
        }
        return null;
    }

    @Override
    public Emp selectByName(String ename) {
        try {
            conn = DB.getConnection();
            String sql = "select * from t_emp where e_name = ?";

            ps = conn.prepareStatement(sql);

            ps.setString(1, ename);
            rs = ps.executeQuery();

            if (rs.next()) {
                Emp emp1 = new Emp();
                emp1.setEid(rs.getString("e_id"));
                emp1.setName(rs.getString("e_name"));
                emp1.setSex(rs.getString("e_sex"));
                emp1.setMail(rs.getString("e_mail"));
                emp1.setPhone(rs.getString("phone"));
                emp1.setQq(rs.getString("qq"));
                emp1.setAddress(rs.getString("address"));
                emp1.setPostal(rs.getString("postal"));
                emp1.setCountry(rs.getString("country"));
                emp1.setRpr(rs.getString("rpr"));
                emp1.setBirthday(rs.getString("birthday"));
                emp1.setNum(rs.getString("e_num"));
                emp1.setNational(rs.getString("nation"));

                return emp1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(conn, ps, rs);
        }
        return null;
    }

    @Override
    public Emp selectByIdNum(String num) {
        try {
            conn = DB.getConnection();
            String sql = "select * from t_emp where e_num = ?";

            ps = conn.prepareStatement(sql);

            ps.setString(1, num);
            rs = ps.executeQuery();

            if (rs.next()) {
                Emp emp1 = new Emp();
                emp1.setEid(rs.getString("e_id"));
                emp1.setName(rs.getString("e_name"));
                emp1.setSex(rs.getString("e_sex"));
                emp1.setMail(rs.getString("e_mail"));
                emp1.setPhone(rs.getString("phone"));
                emp1.setQq(rs.getString("qq"));
                emp1.setAddress(rs.getString("address"));
                emp1.setPostal(rs.getString("postal"));
                emp1.setCountry(rs.getString("country"));
                emp1.setRpr(rs.getString("rpr"));
                emp1.setBirthday(rs.getString("birthday"));
                emp1.setNum(rs.getString("e_num"));
                emp1.setNational(rs.getString("nation"));

                return emp1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(conn, ps, rs);
        }
        return null;
    }

    @Override
    public Emp selectPhone(String phone) {
        try {
            conn = DB.getConnection();
            String sql = "select * from t_emp where phone = ?";

            ps = conn.prepareStatement(sql);

            ps.setString(1, phone);

            ps.executeQuery();
            if (rs.next()) {
                Emp emp1 = new Emp();
                emp1.setEid(rs.getString("e_id"));
                emp1.setName(rs.getString("e_name"));
                emp1.setSex(rs.getString("e_sex"));
                emp1.setMail(rs.getString("e_mail"));
                emp1.setPhone(rs.getString("phone"));
                emp1.setQq(rs.getString("qq"));
                emp1.setAddress(rs.getString("address"));
                emp1.setPostal(rs.getString("postal"));
                emp1.setCountry(rs.getString("country"));
                emp1.setRpr(rs.getString("rpr"));
                emp1.setBirthday(rs.getString("birthday"));
                emp1.setNum(rs.getString("e_num"));
                emp1.setNational(rs.getString("nation"));

                return emp1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(conn, ps, rs);
        }
        return null;
    }

    @Override
    public Emp selectSex(String sex) {
        try {
            conn = DB.getConnection();
            String sql = "select * from t_emp where e_sex = ?";

            ps = conn.prepareStatement(sql);

            ps.setString(1, sex);

            ps.executeQuery();
            if (rs.next()) {
                Emp emp1 = new Emp();
                emp1.setEid(rs.getString("e_id"));
                emp1.setName(rs.getString("e_name"));
                emp1.setSex(rs.getString("e_sex"));
                emp1.setMail(rs.getString("e_mail"));
                emp1.setPhone(rs.getString("phone"));
                emp1.setQq(rs.getString("qq"));
                emp1.setAddress(rs.getString("address"));
                emp1.setPostal(rs.getString("postal"));
                emp1.setCountry(rs.getString("country"));
                emp1.setRpr(rs.getString("rpr"));
                emp1.setBirthday(rs.getString("birthday"));
                emp1.setNum(rs.getString("e_num"));
                emp1.setNational(rs.getString("nation"));

                return emp1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(conn, ps, rs);
        }
        return null;
    }

}
