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
public class CityDTO {

    @JsonProperty("city_id")
    private Integer cityId;

    @JsonProperty("city_name")
    private String cityName;

    @JsonProperty("city_code")
    private String cityCode;

    @JsonProperty("city_plate_code")
    private String cityPlateCode;

}
