package com.isoft.servlet.dao;

import com.isoft.servlet.entity.EmpJob;

public interface EmpJobDao {
    int addJob(EmpJob job);
    int updateJob(EmpJob job);
}
