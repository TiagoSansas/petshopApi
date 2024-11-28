package br.com.tspetshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tspetshop.entity.Animal;

@Repository
public interface AnimalRepository  extends JpaRepository<Animal, Long> {

}
