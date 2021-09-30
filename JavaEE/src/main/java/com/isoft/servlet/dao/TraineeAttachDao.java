package com.isoft.servlet.dao;

import com.isoft.servlet.entity.EmpAttach;
import com.isoft.servlet.entity.TraineeAttach;

public interface TraineeAttachDao {
    int addTrainee(TraineeAttach tac);
    int updateTrainee(TraineeAttach tac);
    TraineeAttach selectById(String eid);
    TraineeAttach selectState(String eid);
}
