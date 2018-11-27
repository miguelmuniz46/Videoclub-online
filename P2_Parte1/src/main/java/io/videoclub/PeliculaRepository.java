package io.videoclub;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface PeliculaRepository extends CrudRepository<Pelicula, Long>{
	List<Pelicula> findAll();
	
	List<Pelicula> findByFirstName(String firstName);
	
	Optional<Pelicula> findById(Long id);
}
