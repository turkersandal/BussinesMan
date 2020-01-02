package com.trius.businessman.dao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.trius.businessman.dao.entity.Company;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StaffDTO {

    @JsonProperty("staff_id")
    private Integer staffId;

    @JsonProperty("person")
    private PersonDTO personDTO;

    @JsonProperty("company")
    private CompanyDTO companyDTO;

    @JsonProperty("department")
    private DepartmentDTO departmentDTO;

    @JsonProperty("assurance_type")
    private AssuranceTypeDTO assuranceTypeDTO;

    @JsonProperty("staff_salary")
    private String staffSalary;

    @JsonProperty("staff_date_start_work")
    private LocalDateTime staffDateStartWork;


}
