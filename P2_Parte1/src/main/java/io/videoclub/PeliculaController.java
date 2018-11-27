package io.videoclub;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PeliculaController {
	@Autowired
	DataBaseLoader db;
	
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("home");
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping("/home")
	public ModelAndView home() {
		return new ModelAndView("home");
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping("/buscar")
	public ModelAndView buscar() {
		return new ModelAndView("buscar");
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping("/watch")
	public ModelAndView wacth(@RequestParam Long id) {
		ModelAndView model = new ModelAndView("watch");
		Optional<Pelicula> movie = db.getElementById(id);
		
		Pelicula pelicula = movie.get();
		
		model.addObject("name", pelicula.getName());
		model.addObject("id", pelicula.getId());
		model.addObject("url_youtube", pelicula.getURLY());
		
		return model;
	}
	
	@Secured({"ROLE_ADMIN"})
	@RequestMapping("/options")
    public ModelAndView options() {
		return new ModelAndView("options");
    }
	
	@Secured({"ROLE_ADMIN"})
	@RequestMapping("/new")
    public ModelAndView new_movie() {
		return new ModelAndView("new");
    }
	
	@Secured({"ROLE_ADMIN"})
	@RequestMapping("/delete")
    public ModelAndView delete_movie() {
		ModelAndView model = new ModelAndView("delete");
		List<Pelicula> movies = db.getAll();
		
		model.addObject("movies", movies);
		return model;
    }
	
	@Secured({"ROLE_ADMIN"})
	@RequestMapping("/modify")
    public ModelAndView modify_movie() {
		ModelAndView model = new ModelAndView("modify");
		List<Pelicula> movies = db.getAll();
		
		model.addObject("movies", movies);
		return model;
    }
	
	@Secured({"ROLE_ADMIN"})
	@RequestMapping("/insert")
	public ModelAndView insert(@RequestParam String name, @RequestParam int year, @RequestParam String director, @RequestParam String actors, @RequestParam String url_Youtube, @RequestParam String url_cover){
		db.insertar(name, year, director, actors, url_Youtube, url_cover);
        return new ModelAndView("insert");
	}
	
	@Secured({"ROLE_ADMIN"})
	@RequestMapping("/result_modify")
	public ModelAndView modify_result(@RequestParam String name, @RequestParam int year, @RequestParam String director, @RequestParam String actors, @RequestParam String url_Youtube, @RequestParam String url_cover, @RequestParam Long id){
		ModelAndView model = new ModelAndView("result_modify");
		Optional<Pelicula> movie = db.getElementById(id);
		
		Pelicula pelicula = movie.get();
		
		pelicula.setName(name);
		pelicula.setYear(year);
		pelicula.setDirector(director);
		pelicula.setActors(actors);
		pelicula.setURLY(url_Youtube);
		pelicula.setURLC(url_cover);
		
		db.modificar(pelicula);
		
        return model;
	}
	
	@Secured({"ROLE_ADMIN"})
	@RequestMapping("/delete_movie")
	public ModelAndView delete_movie(@RequestParam Long id){
		db.delete(id);
        return new ModelAndView("delete_movie");
	}
	
	@Secured({"ROLE_ADMIN"})
	@RequestMapping("/modify_movie")
	public ModelAndView modify_movie(@RequestParam Long id){
		ModelAndView model = new ModelAndView("modify_movie");
		Optional<Pelicula> movie = db.getElementById(id);
	
		Pelicula pelicula = movie.get();
		
		model.addObject("name", pelicula.getName());
		model.addObject("year", pelicula.getYear());
		model.addObject("director", pelicula.getDirector());
		model.addObject("actors", pelicula.getActors());
		model.addObject("url_YT", pelicula.getURLY());
		model.addObject("url_cover", pelicula.getURLC());
		model.addObject("id", pelicula.getId());
		return model;
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping("/show")
	public ModelAndView show(@RequestParam Long id) {
		ModelAndView model = new ModelAndView("show");
		Optional<Pelicula> movie = db.getElementById(id);
	
		Pelicula pelicula = movie.get();
		
		model.addObject("name", pelicula.getName());
		model.addObject("year", pelicula.getYear());
		model.addObject("director", pelicula.getDirector());
		model.addObject("actors", pelicula.getActors());
		model.addObject("url_cover", pelicula.getURLC());
		model.addObject("id", pelicula.getId());
		return model;
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping("/search_results")
	public ModelAndView results(@RequestParam String name) {
		ModelAndView model = new ModelAndView("results");
		List<Pelicula> movies = db.getAll();
	    List<Pelicula> resultados = new ArrayList<>();
	    	
	    for(int i = 0; i < movies.size(); i++) {
	    	if(movies.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
	    		resultados.add(movies.get(i));
	    	}
	    }
		
		model.addObject("movies", resultados);
		return model;
	}
}
