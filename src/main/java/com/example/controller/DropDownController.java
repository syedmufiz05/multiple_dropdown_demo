package com.example.controller;

import com.example.dto.dropdownDTO.CityDTO;
import com.example.dto.dropdownDTO.StateDTO;
import com.example.service.dropDownService.CountryService;
import com.example.service.dropDownService.StateService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DropDownController {
    @Autowired
    private CountryService countryService;
    @Autowired
    private StateService stateService;

    @RequestMapping(value = "/getStates/{country_name}", method = RequestMethod.GET)
    @ResponseBody
    public String getStates(@PathVariable("country_name") String countryName) {
        List<StateDTO> stateList = countryService.getStates(countryName);
        String json = null;
        try {
            json = new ObjectMapper().writeValueAsString(stateList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    @RequestMapping(value = "/getCities/{state_name}", method = RequestMethod.GET)
    @ResponseBody
    public String getCities(@PathVariable("state_name") String stateName) {
        List<CityDTO> cityList = stateService.getCities(stateName);
        String json = null;
        try {
            json = new ObjectMapper().writeValueAsString(cityList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
