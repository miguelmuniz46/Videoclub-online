package io.videoclub;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class PeliculaRestController {
	@Autowired
	DataBaseLoader db;
	
	@RequestMapping(value = "/buscarPelicula/{name}", method = RequestMethod.GET)
	public ResponseEntity<List<Pelicula>> getPelicula(@PathVariable("name") String name) {
	    List<Pelicula> peliculas = db.getAll();
	    List<Pelicula> resultados = new ArrayList<>();
	    	
	    for(int i = 0; i < peliculas.size(); i++) {
	    	if(peliculas.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
	    		resultados.add(peliculas.get(i));
	    	}
	    }
	    	
		HttpStatus status = HttpStatus.OK;
        ResponseEntity<List<Pelicula>> response = new ResponseEntity<>(resultados,
                status);
        return response;
	}
	
}
