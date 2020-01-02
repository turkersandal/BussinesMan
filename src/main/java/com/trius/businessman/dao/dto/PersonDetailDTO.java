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
public class PersonDetailDTO {

    @JsonProperty("person_detail_id")
    private Integer personDetailId;

    @JsonProperty("military_state")
    private MilitaryStateDTO militaryStateDTO;

    @JsonProperty("university_department")
    private UniversityDepartmentDTO universityDepartmentDTO;

    @JsonProperty("contact_phone")
    private String personDetailContactPhone;

    @JsonProperty("university_name")
    private String personDetailUniversityName;

    @JsonProperty("graduate_year")
    private String personDetailGraduateYear;

    @JsonProperty("chronic_ills")
    private String personDetailChronicIll;

    @JsonProperty("child_count")
    private String personDetailChildCount;


}
