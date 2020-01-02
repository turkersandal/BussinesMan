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
public class MilitaryStateDTO {

    @JsonProperty("military_state_id")
    private Integer militaryStateId;

    @JsonProperty("military_state_name")
    private String militaryStateName;

}
