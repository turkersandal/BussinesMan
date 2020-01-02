package com.trius.businessman.dao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import sun.util.resources.LocaleData;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContractDTO {

    @JsonProperty("contract_id")
    private Integer contractId;

    @JsonProperty("contract_state")
    private ContractStateDTO contractStateDTO;

    @JsonProperty("contract_type")
    private ContractTypeDTO contractTypeDTO;

    @JsonProperty("contract_duration")
    private String contractDuration;

    @JsonProperty("contract_date")
    private LocalDateTime contractDate;

}
