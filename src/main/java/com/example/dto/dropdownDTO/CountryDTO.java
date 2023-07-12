package com.example.dto.dropdownDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDTO {
    @JsonProperty("country_id")
    private Integer countryId;
    @JsonProperty("country_name")
    private String countryName;
}
