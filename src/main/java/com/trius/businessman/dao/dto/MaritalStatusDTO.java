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
public class MaritalStatusDTO {

    @JsonProperty("marital_status_id")
    private Integer maritalStatusId;

    @JsonProperty("marital_status_name")
    private String maritalStatusName;
}
