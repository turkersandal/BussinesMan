package com.trius.businessman.dao.service;

import com.trius.businessman.dao.dto.StaffContractDTO;
import com.trius.businessman.dao.dto.StaffDTO;
import com.trius.businessman.dao.entity.Contract;
import com.trius.businessman.dao.entity.Staff;


public interface StaffService {
    void save(Staff staff);

    Staff getStaff(Integer id);
    StaffDTO convertToStaffDTO(Staff staff);
    Staff convertToStaffEntity(StaffDTO staffDTO);
    Staff saveAndRetrunObject(Staff staff);
    String deleteAndReturnObject(Staff staff);
    StaffContractDTO addStaffContract(StaffContractDTO staffContractDTO);
    String deleteContract(Contract contract);
    StaffContractDTO deleteStaffContract(StaffContractDTO staffContractDTO);
}
