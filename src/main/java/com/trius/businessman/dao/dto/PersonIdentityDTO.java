package com.trius.businessman.dao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonIdentityDTO {

    @JsonProperty("person_identity_id")
    private Integer personIdentityId;

    @JsonProperty("blood_group")
    private BloodGroupDTO bloodGroupDTO;

    @JsonProperty("gender")
    private GenderDTO genderDTO;

    @JsonProperty("marital_status")
    private MaritalStatusDTO maritalStatusDTO;

    @JsonProperty("birth_place")
    private String birthPlace;

    @JsonProperty("birth_year")
    private LocalDateTime birthYear;
    @JsonProperty("id_number")
    private String idNumber;

    @JsonProperty("mother_name")
    private String motherName;

    @JsonProperty("father_name")
    private String fatherName;

    @JsonProperty("before_surname")
    private String beforeSurname;

    @JsonProperty("delivery_place")
    private String deliveryPlace;

    @JsonProperty("delivery_reason")
    private String deliveryReason;

    @JsonProperty("delivery_date")
    private LocalDateTime deliveryDate;

    @JsonProperty("register_number")
    private String registerNumber;

    @JsonProperty("serial_number")
    private String serialNumber;

    @JsonProperty("bind_number")
    private String bindNumber;

    @JsonProperty("family_row_number")
    private String familyRowNumber;

    @JsonProperty("row_number")
    private String rowNumber;


}
