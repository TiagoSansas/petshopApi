package br.com.tspetshop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Table(name="tb_animal")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animal  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 255,nullable = false)
	private String name;
	
	@Column(nullable = false)
	private int idade;
	
	@Column(length=100, nullable = false)
	private String raca;
}
