package br.com.tspetshop.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tspetshop.controller.request.AnimalRequest;
import br.com.tspetshop.controller.response.AnimalResponse;
import br.com.tspetshop.entity.Animal;
import br.com.tspetshop.mapper.AnimalMapper;
import br.com.tspetshop.service.AnimalService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/animal")
@RequiredArgsConstructor
public class AnimalController implements AnimalDoc {
	
	private final AnimalService animalService;
	
	@GetMapping
	public ResponseEntity<Page<AnimalResponse>> findAll(@PageableDefault(page = 0, size = 10,sort = "name",direction = Direction.ASC ) Pageable pageable) {
		Page<Animal> animal = animalService.listarTodos(pageable);
		return ResponseEntity.ok(animal.map(AnimalMapper::toAnimalResponse));
	}

	@GetMapping("/{id}")
	public ResponseEntity<AnimalResponse> findById(@PathVariable Long id) {
		return animalService.exibirPorId(id)
				.map(animalResponse -> ResponseEntity.ok(AnimalMapper.toAnimalResponse(animalResponse)))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<AnimalResponse> save(@RequestBody AnimalRequest request) {
		Animal animal = animalService.cadastrar(AnimalMapper.toAnimal(request));
		return ResponseEntity.ok(AnimalMapper.toAnimalResponse(animal));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		try {
			animalService.deletar(id);
		}catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.noContent().build();
	}
	
	
	

}

	
