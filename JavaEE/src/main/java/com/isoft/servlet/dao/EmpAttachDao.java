package com.isoft.servlet.dao;

import com.isoft.servlet.entity.Dept;
import com.isoft.servlet.entity.Emp;
import com.isoft.servlet.entity.EmpAttach;

import java.util.List;

public interface EmpAttachDao {
    int addEA(EmpAttach empAttach);
    int updateEA(EmpAttach empAttach);
    EmpAttach selectById(String eid);
    EmpAttach selectState(String state);
    List<EmpAttach> selectAll();
}
