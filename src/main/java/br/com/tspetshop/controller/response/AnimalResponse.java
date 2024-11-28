package br.com.tspetshop.controller.response;

import lombok.Builder;

@Builder
public record AnimalResponse(Long id, String name,int idade, String raca) {

}
