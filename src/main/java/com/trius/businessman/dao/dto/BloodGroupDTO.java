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
public class BloodGroupDTO {

    @JsonProperty("blood_group_id")
    private    Integer bloodGroupId;

    @JsonProperty("blood_group_name")
    private  String bloodGroupName;
}
