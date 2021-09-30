package com.isoft.servlet.dao;

import com.isoft.servlet.entity.FiveIns;

public interface FiveInsurancesDao {

    int addFiveIns(FiveIns f);
    int updateFiveIns(FiveIns f);
    FiveIns selectByFive(String name);

}
