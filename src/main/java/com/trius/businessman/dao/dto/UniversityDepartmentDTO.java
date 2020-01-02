package com.trius.businessman.dao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class UniversityDepartmentDTO {

    @JsonProperty("university_department_id")
    private Integer universityDepartmentId;

    @JsonProperty("university_department_name")
    private String universityDepartmentName;

}
