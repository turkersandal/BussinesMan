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
public class ContractTypeDTO {

    @JsonProperty("contract_type_id")
    private Integer contractTypeId;

    @JsonProperty("contract_type_name")
    private String contractTypeName;

}
