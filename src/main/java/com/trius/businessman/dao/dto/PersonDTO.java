package com.trius.businessman.dao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonDTO {

    @JsonProperty("person_id")
    private Integer personId;

    @JsonProperty("person_detail")
    private PersonDetailDTO personDetailDTO;

    @JsonProperty("person_identity")
    private PersonIdentityDTO personIdentityDTO;

    @JsonProperty("address")
    private AddressDTO addressDTO;

    @JsonProperty("contact")
    private ContactDTO contactDTO;

    @JsonProperty("person_name")
    private String personName;

    @JsonProperty("person_surname")
    private String personSurname;


}
