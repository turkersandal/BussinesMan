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
public class CountryDTO {

    @JsonProperty("country_id")
    private Integer countryId;

    @JsonProperty("country_name")
    private String countryName;

}
