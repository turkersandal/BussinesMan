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
public class DistrictDTO {

    @JsonProperty("district_id")
    private Integer districtId;

    @JsonProperty("district_name")
    private String districtName;

}
