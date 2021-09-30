package com.isoft.servlet.dao;

import com.isoft.servlet.entity.Salary;

public interface SalaryDao {
    int addSal(Salary s);
    int updateSal(Salary s);
    Salary selectById(String eid);
}
