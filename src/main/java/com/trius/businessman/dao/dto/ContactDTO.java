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
public class ContactDTO {

    @JsonProperty("contact_id")
    private Integer contactId;

    @JsonProperty("contact_type")
    private ContactTypeDTO contactTypeDTO;

    @JsonProperty("contact_info")
    private String contactInfo;

}
