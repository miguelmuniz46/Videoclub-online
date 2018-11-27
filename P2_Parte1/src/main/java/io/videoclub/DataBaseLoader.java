package io.videoclub;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;


@Component
public class DataBaseLoader {
	private UserRepository userrepository;
   
    private PeliculaRepository repository;

    public DataBaseLoader(PeliculaRepository repository, UserRepository userrepository) {
        this.repository = repository;
        this.userrepository = userrepository;
    }
    
   @PostConstruct
   private void initDatabase() {
	   userrepository.deleteAll();

       List<GrantedAuthority> userRoles = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
       userrepository.save(new User("user", "user", userRoles));

       List<GrantedAuthority> adminRoles = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"), new SimpleGrantedAuthority("ROLE_ADMIN"));
       userrepository.save(new User("admin", "admin", adminRoles));

       repository.deleteAll();
	   repository.save(new Pelicula("Interstellar", 2014, "Christopher Nolan", "Matthew McConaughey, Anne Hathaway, Jessica Chastain, Michael Caine and Matt Damon", "https://www.youtube-nocookie.com/embed/UoSSbmD9vqc?rel=0", "https://ia.media-imdb.com/images/M/MV5BZjdkOTU3MDktN2IxOS00OGEyLWFmMjktY2FiMmZkNWIyODZiXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SY1000_SX675_AL_.jpg"));
	   repository.save(new Pelicula("Avengers: Infinity War", 2018, "Brothers Russo", "Robert Downey Jr., Chris Hemsworth, Mark Ruffalo, Chris Evans, Scarlett Johansson and Benedict Cumberbatch", "https://www.youtube-nocookie.com/embed/6ZfuNTqbHE8?rel=0", "https://ia.media-imdb.com/images/M/MV5BMjMxNjY2MDU1OV5BMl5BanBnXkFtZTgwNzY1MTUwNTM@._V1_SY1000_CR0,0,674,1000_AL_.jpg"));
	   repository.save(new Pelicula("Wonder Woman", 2017, "Patty Jenkins", "Gal Gadot, Chris Pine, Robin Wrigth", "https://www.youtube-nocookie.com/embed/gOfmwQijKFg?rel=0", "https://ia.media-imdb.com/images/M/MV5BNDFmZjgyMTEtYTk5MC00NmY0LWJhZjktOWY2MzI5YjkzODNlXkEyXkFqcGdeQXVyMDA4NzMyOA@@._V1_SY1000_SX675_AL_.jpg"));
	   repository.save(new Pelicula("Star Wars: Episodio VIII - Los ultimos Jedi", 2017, "Rian Johnson", "Daisy Ridley, Mark Hamill, Carrie Fisher", "https://www.youtube-nocookie.com/embed/anOJjqQb8x0?rel=0", "https://ia.media-imdb.com/images/M/MV5BMjQ1MzcxNjg4N15BMl5BanBnXkFtZTgwNzgwMjY4MzI@._V1_SY1000_CR0,0,675,1000_AL_.jpg"));
	   repository.save(new Pelicula("IT", 2017, "Andres Muschietti", "Bill Skarsgård, Finn Wolfhard, Sophia Lillis","https://www.youtube-nocookie.com/embed/_oBZ_zTz0Nw?rel=0","https://ia.media-imdb.com/images/M/MV5BZDVkZmI0YzAtNzdjYi00ZjhhLWE1ODEtMWMzMWMzNDA0NmQ4XkEyXkFqcGdeQXVyNzYzODM3Mzg@._V1_SY1000_CR0,0,666,1000_AL_.jpg"));
	   repository.save(new Pelicula("Thor: Ragnarok", 2017, "Taika Waititi", "Cate Blanchett, Tessa Thompson, Chris Hemsworth, Mark Ruffalo, Tom Hiddleston","https://www.youtube-nocookie.com/embed/Cdp7Xo0x0Uw?rel=0","https://ia.media-imdb.com/images/M/MV5BMjMyNDkzMzI1OF5BMl5BanBnXkFtZTgwODcxODg5MjI@._V1_SY1000_CR0,0,674,1000_AL_.jpg"));
	   repository.save(new Pelicula("Liga de la Justicia", 2017, "Zack Snyder", "Ben Affleck, Gal Gadot, Henry Cavill","https://www.youtube-nocookie.com/embed/bv0v2pmLea8?rel=0","https://ia.media-imdb.com/images/M/MV5BYWVhZjZkYTItOGIwYS00NmRkLWJlYjctMWM0ZjFmMDU4ZjEzXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SY1000_SX675_AL_.jpg"));
	   repository.save(new Pelicula("Spider-Man Homecoming", 2017, "Jon Watts", "Tom Holland, Robert Downey Jr.","https://www.youtube-nocookie.com/embed/3fX1O-xKsFg?rel=0","https://ia.media-imdb.com/images/M/MV5BNTk4ODQ1MzgzNl5BMl5BanBnXkFtZTgwMTMyMzM4MTI@._V1_SY1000_CR0,0,658,1000_AL_.jpg"));
	   repository.save(new Pelicula("Guardianes de la Galaxia Vol. 2", 2017, "James Gunn", "Chris Pratt, Zoe Saldana, Dave Bautista","https://www.youtube-nocookie.com/embed/fCPEpGpem3I?rel=0","https://ia.media-imdb.com/images/M/MV5BMTg2MzI1MTg3OF5BMl5BanBnXkFtZTgwNTU3NDA2MTI@._V1_SY1000_CR0,0,674,1000_AL_.jpg"));
	   repository.save(new Pelicula("Venom", 2018, "Ruben Fleischer", "Tom Hardy, Woody Harrelson, Michelle Williams","https://www.youtube-nocookie.com/embed/nZ8FXOpcXSs?rel=0","https://ia.media-imdb.com/images/M/MV5BMTU3MTQyNjQwM15BMl5BanBnXkFtZTgwNDgxNDczNTM@._V1_SY1000_CR0,0,675,1000_AL_.jpg"));
   }
    
    public void insertar(String name, int year, String director , String actors, String url_Youtube, String url_cover) {
    	repository.save(new Pelicula(name, year, director, actors, url_Youtube, url_cover));
    }
    
    public void modificar(Pelicula pelicula_modificada) {
    	repository.save(pelicula_modificada);
    }
    
    public List<Pelicula> getAll(){
    	return repository.findAll();
    }
    
    public void delete(Long id) {
    	repository.deleteById(id);
    }
    
    public List<Pelicula> getElementByName(String name) {
    	return repository.findByFirstName(name);
    }
    
    public Optional<Pelicula> getElementById(Long id) {
    	return repository.findById(id);
    }
    
}
