package com.example.dto.dropdownDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityDTO {
    @JsonProperty("city_id")
    private Integer cityId;
    @JsonProperty("city_name")
    private String cityName;
}
