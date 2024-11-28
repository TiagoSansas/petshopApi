package br.com.tspetshop.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.tspetshop.entity.Animal;
import br.com.tspetshop.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnimalService {

	private final AnimalRepository animalRepository;

	public Page<Animal> listarTodos(Pageable pageable) {
		return animalRepository.findAll(pageable);
	}

	public Optional<Animal> exibirPorId(Long id) {
		return animalRepository.findById(id);
	}

	public Animal cadastrar(Animal animal) {
		return animalRepository.save(animal);
	}

	public void deletar(Long id) {

		animalRepository.deleteById(id);

	}
}
