package com.trius.businessman.dao.service.impl;

import com.trius.businessman.dao.dto.*;
import com.trius.businessman.dao.entity.*;
import com.trius.businessman.dao.repository.ContractRepository;
import com.trius.businessman.dao.repository.StaffRepository;
import com.trius.businessman.dao.service.PersonService;
import com.trius.businessman.dao.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class StaffServiceImp implements StaffService {

    @Autowired
    StaffRepository staffRepository;
    @Autowired
    ContractRepository contractRepository;
    @Autowired
    PersonService personService;


    public void save(Staff staff){ staffRepository.save(staff); }

    public String deleteAndReturnObject(Staff staff){
        try {
            staffRepository.delete(staff);
            return "Staff Başarıyla silindi.";
        }catch (Exception e){
            return "Silinemedi.";
        }

    }
    public String deleteContract(Contract contract){
        try {
            contractRepository.delete(contract);
            return "Staff Başarıyla silindi.";
        }catch (Exception e){
            return "Silinemedi.";
        }

    }
    public Staff saveAndRetrunObject(Staff staff){
        return staffRepository.save(staff);
    }
    public Staff getStaff(Integer id){ return staffRepository.findByStaffId(id); }

    public StaffContractDTO addStaffContract(StaffContractDTO staffContractDTO){

        Staff staff=staffRepository.findByStaffId(staffContractDTO.getStaffId());
        Contract contract= Contract.builder()
                .contractId(staffContractDTO.getContractDTO().getContractId())
                .contractDate(staffContractDTO.getContractDTO().getContractDate())
                .contractDuration(staffContractDTO.getContractDTO().getContractDuration())
                .contractState(convertToContractStateEntity(staffContractDTO.getContractDTO().getContractStateDTO()))
                .contractType(convertToContractTypeEntity(staffContractDTO.getContractDTO().getContractTypeDTO()))
                .build();

        Contract newContract=contractRepository.save(contract);
        staff.getContractSet().add(newContract);
        save(staff);


        return convertToStaffContractDTO(staff,newContract);
    }
    public StaffContractDTO deleteStaffContract(StaffContractDTO staffContractDTO){
        Staff staff=staffRepository.findByStaffId(staffContractDTO.getStaffId());
        Contract contract=contractRepository.findByContractId(staffContractDTO.getContractDTO().getContractId());
        deleteContract(contract);


        return null;
    }


    private StaffContractDTO convertToStaffContractDTO(Staff staff, Contract newContract) {
        StaffContractDTO staffContractDTO=StaffContractDTO.builder()
                .staffId(staff.getStaffId())
                .staffDateStartWork(staff.getStaffDateOfStartWork())
                .staffSalary(staff.getStaffSalary())
                .assuranceTypeDTO(convertToAssuranceTypeDTO(staff.getAssuranceType()))
                .departmentDTO(convertToDepartmentDTO(staff.getDepartment()))
                //.personDTO()
                //.companyDTO()
                .contractDTO(convertToContractDTO(newContract))
                .build();
        return staffContractDTO;
    }


    public StaffDTO convertToStaffDTO(Staff staff){
        StaffDTO staffDTO=StaffDTO.builder()
                .staffId(staff.getStaffId())
                .staffSalary(staff.getStaffSalary())
                .staffDateStartWork(staff.getStaffDateOfStartWork())
                .assuranceTypeDTO(AssuranceTypeDTO.builder()
                        .assuranceTypeId(staff.getAssuranceType().getAssuranceTypeId())
                        .assuranceTypeName(staff.getAssuranceType().getAssuranceTypeName())

                        .build())
                .departmentDTO(DepartmentDTO.builder()
                        .departmentId(staff.getDepartment().getDepartmentId())
                        .departmentName(staff.getDepartment().getDepartmentName())
                        .build())
                .personDTO(personService.convertPersonToDTO(personService.findByPersonId(staff.getPerson().getPersonId())))
                .build();

        return staffDTO;

    }
    public Staff convertToStaffEntity(StaffDTO staffDTO) {
        Staff staff= Staff.builder()
                .staffId(staffDTO.getStaffId())
                .staffSalary(staffDTO.getStaffSalary())
                .staffDateOfStartWork(staffDTO.getStaffDateStartWork())
                .assuranceType(AssuranceType.builder()
                        .assuranceTypeId(staffDTO.getAssuranceTypeDTO().getAssuranceTypeId())
                        .assuranceTypeName(staffDTO.getAssuranceTypeDTO().getAssuranceTypeName())
                        .build())
                .department(Department.builder()
                        .departmentId(staffDTO.getDepartmentDTO().getDepartmentId())
                        .departmentName(staffDTO.getDepartmentDTO().getDepartmentName())
                        .build())
                .person(personService.findByPersonId(staffDTO.getPersonDTO().getPersonId()))
                .build();
        return staff;

    }


    public ContractDTO convertToContractDTO(Contract contract){
        ContractDTO contractDTO=ContractDTO.builder()
                .contractId(contract.getContractId())
                .contractDate(contract.getContractDate())
                .contractDuration(contract.getContractDuration())
                .contractTypeDTO(ContractTypeDTO.builder()
                        .contractTypeId(contract.getContractType().getContractTypeId())
                        .contractTypeName(contract.getContractType().getContractTypeName())
                        .build())
                .contractStateDTO(ContractStateDTO.builder()
                        .contractStateId(contract.getContractState().getContractStateId())
                        .contractState(contract.getContractState().getContractState())
                        .build())
                .build();
        return contractDTO;
    }
    public Contract convertToContractEntity(ContractDTO contractDTO){
        Contract contract= Contract.builder()
                .contractId(contractDTO.getContractId())
                .contractDate(contractDTO.getContractDate())
                .contractDuration(contractDTO.getContractDuration())
                .contractType(ContractType.builder()
                        .contractTypeId(contractDTO.getContractTypeDTO().getContractTypeId())
                        .contractTypeName(contractDTO.getContractTypeDTO().getContractTypeName())

                        .build())
                .contractState(ContractState.builder()
                        .contractStateId(contractDTO.getContractStateDTO().getContractStateId())
                        .contractState(contractDTO.getContractStateDTO().getContractState())
                        .build())
                .build();
        return contract;
    }
    /*    public StaffDTO convertToStaffDTO(Staff staff){
            StaffDTO staffDTO=new StaffDTO();
            staffDTO.setStaffId(staff.getStaffId());
            staffDTO.setStaffSalary(staff.getStaffSalary());
            staffDTO.setStaffDateStartWork(staff.getStaffDateOfStartWork());
            staffDTO.setDepartmentDTO(convertToDepartmentDTO(staff.getDepartment()));
            staffDTO.setAssuranceTypeDTO(convertToAssuranceTypeDTO(staff.getAssuranceType()));

            return staffDTO;
        }*/
    /*public Staff convertToStaffEntity(StaffDTO staffDTO){
        Staff staff=new Staff();
        staff.setStaffId(staffDTO.getStaffId());
        staff.setStaffSalary(staffDTO.getStaffSalary());
        staff.setStaffDateOfStartWork(staffDTO.getStaffDateStartWork());
        staff.setAssuranceType(convertToAssuranceTypeEntity(staffDTO.getAssuranceTypeDTO()));
        staff.setDepartment(convertToDepartmentEntity(staffDTO.getDepartmentDTO()));
        return staff;
    }
*/
    public AssuranceTypeDTO convertToAssuranceTypeDTO(AssuranceType assuranceType){
        AssuranceTypeDTO assuranceTypeDTO=new AssuranceTypeDTO();
        assuranceTypeDTO.setAssuranceTypeId(assuranceType.getAssuranceTypeId());
        assuranceTypeDTO.setAssuranceTypeName(assuranceType.getAssuranceTypeName());
        return assuranceTypeDTO;
    }
    public AssuranceType convertToAssuranceTypeEntity(AssuranceTypeDTO assuranceTypeDTO){
        AssuranceType assuranceType=new AssuranceType();
        assuranceType.setAssuranceTypeId(assuranceTypeDTO.getAssuranceTypeId());
        assuranceType.setAssuranceTypeName(assuranceTypeDTO.getAssuranceTypeName());
        return assuranceType;
    }
    public DepartmentDTO convertToDepartmentDTO(Department department){
        DepartmentDTO departmentDTO=new DepartmentDTO();

        departmentDTO.setDepartmentId(department.getDepartmentId());
        departmentDTO.setDepartmentName(department.getDepartmentName());
        return  departmentDTO;
    }
    public Department convertToDepartmentEntity(DepartmentDTO departmentDTO){
        Department department=new Department();
        department.setDepartmentId(departmentDTO.getDepartmentId());
        department.setDepartmentName(departmentDTO.getDepartmentName());
        return department;
    }
    public ContractStateDTO convertToContractStateDTO(ContractState contractState){
        ContractStateDTO contractStateDTO=new ContractStateDTO();
        contractStateDTO.setContractStateId(contractState.getContractStateId());
        contractStateDTO.setContractState(contractState.getContractState());
        return contractStateDTO;
    }
    public ContractState convertToContractStateEntity(ContractStateDTO contractStateDTO){
        ContractState contractState=new ContractState();
        contractState.setContractStateId(contractStateDTO.getContractStateId());
        contractState.setContractState(contractStateDTO.getContractState());
        return contractState;
    }
    public ContractTypeDTO convertToContractTypeDTO(ContractType contractType){
        ContractTypeDTO contractTypeDTO=new ContractTypeDTO();
        contractTypeDTO.setContractTypeId(contractType.getContractTypeId());
        contractTypeDTO.setContractTypeName(contractType.getContractTypeName());
        return contractTypeDTO;
    }
    public ContractType convertToContractTypeEntity(ContractTypeDTO contractTypeDTO){
        ContractType contractType=new ContractType();
        contractType.setContractTypeId(contractTypeDTO.getContractTypeId());
        contractType.setContractTypeName(contractTypeDTO.getContractTypeName());
        return contractType;
    }



}
