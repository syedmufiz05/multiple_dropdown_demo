package com.example.service.dropDownService;

import com.example.dto.dropdownDTO.CountryDTO;
import com.example.dto.dropdownDTO.StateDTO;
import com.example.repository.dropdownRepository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public List<CountryDTO> getAllCountries() {
        return countryRepository.getAllCountries();
    }

    public List<StateDTO> getStatesByCountry(Integer id) {
        return countryRepository.getStatesByCountry(id);
    }

    public List<StateDTO> getStates(String name) {
        return countryRepository.getStatesByCountryName(name);
    }
}
