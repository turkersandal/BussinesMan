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
public class AddressDTO {

    @JsonProperty("address_id")
    private Integer addressId;

    @JsonProperty("district")
    private DistrictDTO districtDTO;

    @JsonProperty("city")
    private CityDTO cityDTO;

    @JsonProperty("country")
    private CountryDTO countryDTO;

    @JsonProperty("address_type")
    private AddressTypeDTO addressTypeDTO;

    @JsonProperty("address_detail")
    private String addressDetail;

}
