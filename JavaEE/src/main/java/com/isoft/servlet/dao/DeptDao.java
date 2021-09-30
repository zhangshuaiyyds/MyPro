package com.isoft.servlet.dao;

import com.isoft.servlet.entity.Dept;

import java.util.List;

public interface DeptDao {
    int addDept(Dept dept);
    int deleteDept(int id);
    int updateDept(Dept dept);
    Dept selectById(String dno);
    Dept selectByName(String name);
    List<Dept> selectAll();
}
