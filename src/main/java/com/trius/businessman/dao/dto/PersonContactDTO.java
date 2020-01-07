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
public class PersonContactDTO {

    @JsonProperty("person_id")
    private Integer personId;

    @JsonProperty("contact")
    private ContactDTO contactDTO;

    @JsonProperty("person_detail")
    private PersonDetailDTO personDetailDTO;

    @JsonProperty("person_identity")
    private PersonIdentityDTO personIdentityDTO;

    @JsonProperty("person_name")
    private String personName;

    @JsonProperty("person_surname")
    private String personSurname;
}
