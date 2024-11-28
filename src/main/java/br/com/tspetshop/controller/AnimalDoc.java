package br.com.tspetshop.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;

import br.com.tspetshop.controller.request.AnimalRequest;
import br.com.tspetshop.controller.response.AnimalResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Animal", description = "Recurso responsavel para gerenciamento o Animail Pet ")
public interface AnimalDoc {

	@Operation(summary="Buscar todos animais", description = "Método responsável por retornar todos os animais cadastrados")
	@ApiResponse(responseCode = "200", description = "Retorna todos os animais cadastrados",content = @Content(array = @ArraySchema(schema=@Schema(implementation = AnimalResponse.class))))
	ResponseEntity<Page<AnimalResponse>> findAll( @PageableDefault(page = 0, size = 10,sort = "name",direction = Direction.ASC ) Pageable pageable);
	
	@Operation(summary = "Buscar animal por id", description = "Método responsável por retonar animal por Id")
	@ApiResponse(responseCode = "200",description = "Retorna o animal requisitado pelo Id")
	@ApiResponse(responseCode = "400", description = "Retorna elemeno nao encontrado")
	ResponseEntity<AnimalResponse> findById ( Long id);
	
	@Operation(summary="Registar um Animal", description = "Método responsavel por registar um animal")
	@ApiResponse(responseCode = "200",description = "Retorna sucesso ao cadastar um animal")
	@ApiResponse(responseCode = "400", description = "Error ao registrar")
	ResponseEntity<AnimalResponse> save(AnimalRequest request);
	
	@Operation(summary="Deletar um animal", description = "Método responsavel por deletar um anima por id")
	@ApiResponse(responseCode = "200", description = "Retorna sucesso ao deletar um animal" )
	@ApiResponse(responseCode = "400", description = "Error ao deletar" )
	ResponseEntity<Void> deletar(Long id);
}
