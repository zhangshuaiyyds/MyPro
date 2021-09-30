package com.isoft.servlet.dao;

import com.isoft.servlet.entity.Emp;

import java.util.List;

public interface EmpDao {
    int addEmp(Emp emp);
    int deleteEmp(int id);
    int updateEmp(Emp emp);
    List<Emp> selectAll();

    Emp selectById(String eid);

    Emp selectByName(String ename);
    Emp selectByIdNum(String num);
    Emp selectPhone(String phone);
    Emp selectSex(String sex);

}
