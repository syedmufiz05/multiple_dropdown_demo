package com.example.repository.dropdownRepository;

import com.example.dto.dropdownDTO.CityDTO;
import com.example.model.dropdown.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StateRepository extends JpaRepository<State, Integer> {

    @Query("SELECT new com.example.dto.dropdownDTO.CityDTO(c.id,c.name) FROM State s JOIN s.cities AS c WHERE s.id=:id")
    List<CityDTO> getCitiesByState(Integer id);

    @Query("SELECT new com.example.dto.dropdownDTO.CityDTO(c.id,c.name) FROM State s JOIN s.cities AS c WHERE s.name=:name")
    List<CityDTO> getCities(String name);
}
