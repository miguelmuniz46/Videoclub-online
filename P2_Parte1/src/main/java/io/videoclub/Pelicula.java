package io.videoclub;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pelicula {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private int year;
    private String director;
    private String actors;
    private String url_Youtube;
    private String url_cover;

    protected Pelicula() {
    }

    public Pelicula(String name, int year, String director, String actors, String url_Youtube, String url_cover) {
        this.firstName = name;
        this.year = year;
        this.director = director;
        this.actors = actors;
        this.url_Youtube = url_Youtube;
        this.url_cover = url_cover;
    }

    // Getter, Setters and toString

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return firstName;
    }

    public void setName(String name) {
        this.firstName = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public String getDirector() {
    	return director;
    }
    
    public void setDirector(String director) {
        this.director = director;
    }
    
    public String getActors() {
    	return actors;
    }
    
    public void setActors(String actors) {
        this.actors = actors;
    }
    
    public String getURLY() {
    	return url_Youtube;
    }
    
    public void setURLY(String url_Youtube) {
        this.url_Youtube = url_Youtube;
    }
    
    public String getURLC() {
    	return url_cover;
    }
    
    public void setURLC(String url_cover) {
        this.url_cover = url_cover;
    }
    
    public String getDescr() {
    	return (this.firstName +" - "+this.year+" - "+this.director);
    }
    
    @Override
    public String toString() {
        return "Pelicula [id=" + id + ", name=" + firstName + ", year="
                + year + ", director="+ director + ", actors="+ actors + ", url_youtube="+ url_Youtube + ", url_cover="+ url_cover + "]";
    }
}
