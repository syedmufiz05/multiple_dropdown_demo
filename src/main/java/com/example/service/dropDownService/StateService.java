package com.example.service.dropDownService;

import com.example.dto.dropdownDTO.CityDTO;
import com.example.repository.dropdownRepository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {
    @Autowired
    private StateRepository repo;

    public List<CityDTO> getCitiesByState(Integer id) {
        return repo.getCitiesByState(id);
    }

    public List<CityDTO> getCities(String name) {
        return repo.getCities(name);
    }
}
