package com.example.model.dropdown;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "country")
public class Country {
	@Id
	private Integer id;
	private String name;
	@OneToMany
	@JoinColumn(name="state_id")
	private Set<State> states;
}
