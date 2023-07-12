package com.example.runner;

import com.example.model.dropdown.City;
import com.example.model.dropdown.State;
import com.example.repository.dropdownRepository.CityRepository;
import com.example.repository.dropdownRepository.CountryRepository;
import com.example.repository.dropdownRepository.StateRepository;
import com.example.model.dropdown.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Set;

@Component
public class SetupDataRunner implements CommandLineRunner {
	@Autowired
	private CityRepository cityRepo;
	@Autowired
	private StateRepository stateRepo;
	@Autowired
	private CountryRepository countryRepo;
	
	@Override
	public void run(String... args) throws Exception {
		City c1 = new City(101, "Aligarh");
		City c2 = new City(102, "Agra");
		
		City c3 = new City(103, "Patna");
		City c4 = new City(104, "Gaya");
		
		City c5 = new City(105, "Los Angeles");
		City c6 = new City(106, "San Francisco");
		
		City c7 = new City(107, "Orlando");
		City c8 = new City(108, "Miami");
		
		cityRepo.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8));
		
		State state = new State(201, "U.P", Set.of(c1,c2));
		State st = new State(202, "Bihar", Set.of(c3,c4));
		
		State s3 = new State(203, "California", Set.of(c5,c6));
		State s4 = new State(204, "Florida", Set.of(c7,c8));

		stateRepo.saveAll(Arrays.asList(state,st,s3,s4));
		
		Country country1 = new Country(301, "India", Set.of(state,st));
		Country country2 = new Country(302, "USA", Set.of(s3,s4));
		
		countryRepo.saveAll(Arrays.asList(country1,country2));
		
	}

}
