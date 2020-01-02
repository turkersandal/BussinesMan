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
public class GenderDTO {

    @JsonProperty("gender_id")
    private Integer genderId;

    @JsonProperty("gender_name")
    private String genderName;
}
