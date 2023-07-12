package com.example.repository.dropdownRepository;

import com.example.dto.dropdownDTO.CountryDTO;
import com.example.dto.dropdownDTO.StateDTO;
import com.example.model.dropdown.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    @Query("SELECT new com.example.dto.dropdownDTO.CountryDTO(c.id,c.name) FROM Country c")
    List<CountryDTO> getAllCountries();

    @Query("SELECT new com.example.dto.dropdownDTO.StateDTO(s.id,s.name) FROM Country c JOIN c.states AS s WHERE c.id=:id")
    List<StateDTO> getStatesByCountry(Integer id);

    @Query("SELECT new com.example.dto.dropdownDTO.StateDTO(s.id,s.name) FROM Country c JOIN c.states AS s WHERE c.name=:name")
    List<StateDTO> getStatesByCountryName(String name);


}
