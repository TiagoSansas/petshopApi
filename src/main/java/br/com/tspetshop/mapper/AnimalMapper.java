package br.com.tspetshop.mapper;

import br.com.tspetshop.controller.request.AnimalRequest;
import br.com.tspetshop.controller.response.AnimalResponse;
import br.com.tspetshop.entity.Animal;

public class AnimalMapper {
	
	
	public static Animal toAnimal(AnimalRequest request) {
		
		return Animal
				.builder()
				.name(request.nome())
				.idade(request.idade())
				.raca(request.raca())
				.build();
	}
	
	public static AnimalResponse toAnimalResponse(Animal animal) {
		
		return AnimalResponse
				.builder()
				.id(animal.getId())
				.name(animal.getName())
				.idade(animal.getIdade())
				.raca(animal.getRaca())
				.build();
		
	}

}
