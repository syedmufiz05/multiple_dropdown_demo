package com.example.dto.dropdownDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StateDTO {
    @JsonProperty("state_id")
    private Integer stateId;
    @JsonProperty("state_name")
    private String stateName;
}
