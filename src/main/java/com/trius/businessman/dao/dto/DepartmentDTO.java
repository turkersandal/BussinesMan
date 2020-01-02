package com.trius.businessman.dao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {

    @JsonProperty("department_id")
    private Integer departmentId;

    @JsonProperty("department_name")
    private String departmentName;
}
