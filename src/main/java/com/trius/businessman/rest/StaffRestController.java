package com.trius.businessman.rest;

import com.trius.businessman.dao.dto.StaffContractDTO;
import com.trius.businessman.dao.dto.StaffDTO;
import com.trius.businessman.dao.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/staff")
public class  StaffRestController {
    @Autowired
    StaffService staffService;


    @RequestMapping(path= "/getOne/{staff_id}", method = RequestMethod.GET)
    public ResponseEntity<StaffDTO> getOneStaff(@PathVariable("staff_id") Integer id){
        return new ResponseEntity<StaffDTO>  (staffService.convertToStaffDTO(staffService.getStaff(id)), HttpStatus.CREATED);

    }
    @RequestMapping(path= "/create", method = RequestMethod.POST)
    public ResponseEntity<StaffDTO> createStaff(@RequestBody StaffDTO staffDTO){
        return new ResponseEntity<StaffDTO>  (staffService.convertToStaffDTO(staffService.saveAndRetrunObject(staffService.convertToStaffEntity(staffDTO))), HttpStatus.CREATED);
    }
    @RequestMapping(path= "/delete", method = RequestMethod.POST)
    public String deleteDepartment(@RequestBody StaffDTO staffDTO){
        return staffService.deleteAndReturnObject(staffService.convertToStaffEntity(staffDTO));
    }

    @RequestMapping(path= "/addContract", method = RequestMethod.POST)
    public ResponseEntity<StaffContractDTO> addStaffContract(@RequestBody StaffContractDTO staffContractDTO){
        return new ResponseEntity<StaffContractDTO> (staffService.addStaffContract(staffContractDTO),HttpStatus.CREATED);
    }

    @RequestMapping(path= "/deleteContract", method = RequestMethod.POST)
    public StaffContractDTO deleteContract(@RequestBody StaffContractDTO staffContractDTO){
        return staffService.deleteStaffContract(staffContractDTO);
    }

}
