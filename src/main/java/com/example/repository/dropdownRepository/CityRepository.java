package com.example.repository.dropdownRepository;

import com.example.model.dropdown.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}
