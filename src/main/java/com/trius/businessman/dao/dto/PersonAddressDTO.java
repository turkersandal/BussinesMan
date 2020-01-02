package com.trius.businessman.dao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.trius.businessman.dao.dto.AddressDTO;
import com.trius.businessman.dao.dto.PersonDetailDTO;
import com.trius.businessman.dao.dto.PersonIdentityDTO;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonAddressDTO {

    @JsonProperty("person_id")
    private Integer personId;

    @JsonProperty("address")
    private AddressDTO addressDTO;

    @JsonProperty("person_detail")
    private PersonDetailDTO personDetailDTO;

    @JsonProperty("person_identity")
    private PersonIdentityDTO personIdentityDTO;

    @JsonProperty("person_name")
    private String personName;

    @JsonProperty("person_surname")
    private String personSurname;


}
