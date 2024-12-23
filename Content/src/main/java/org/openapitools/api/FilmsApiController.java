package org.openapitools.api;

import org.openapitools.dao.FilmDAO;
import org.openapitools.model.Film;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@CrossOrigin(origins = "*")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-06T18:04:35.581569900+01:00[Europe/Madrid]", comments = "Generator version: 7.9.0")
@Controller
@RequestMapping("${openapi.aPIDeContenido.base-path:/v1/content}")
public class FilmsApiController implements FilmsApi {

    private final NativeWebRequest request;
    private final FilmDAO filmDAO;

    @Autowired
    public FilmsApiController(NativeWebRequest request, FilmDAO filmDAO) {
        this.request = request;
        this.filmDAO = filmDAO;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }
    
    @Override
    public ResponseEntity<List<Film>> filmsGet () {
    	List<Film> films = filmDAO.getFilms();
    	
    	if (!films.isEmpty()) {
    		return ResponseEntity.ok(films);
    	}
    	else {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	}
    }

    @Override
    public ResponseEntity<Film> filmsPost(@RequestBody Film film) {
        Film newFilm = filmDAO.postFilm(film);

        if (newFilm != null) {
            return ResponseEntity.ok(newFilm);  // Devuelve la película si existe
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // 404 si no existe
        }
    
    }

    @Override
    public ResponseEntity<Film> filmsFilmIDGet(@PathVariable("filmID") Integer filmID) {
        Film film = filmDAO.getFilmById(filmID);

        if (film != null) {
            return ResponseEntity.ok(film);  // Devuelve la película si existe
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // 404 si no existe
        }
    
    }
    
    @Override
    public ResponseEntity<Film> filmsFilmIDPut(@PathVariable("filmID") Integer filmID, @RequestBody Film film) {
        Film newFilm = filmDAO.putFilmById(filmID,film);

        if (newFilm != null) {
            return ResponseEntity.ok(newFilm);  // Devuelve la película si existe
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // 404 si no existe
        }
    
    }
    
    @Override
    public ResponseEntity<Void> filmsFilmIDDelete(@PathVariable("filmID") Integer filmID) {
        boolean resultado = filmDAO.deleteFilmById(filmID);

        if (resultado) {
        	return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // 404 si no existe
        }
    
    }

    @Override
    public ResponseEntity<List<Film>> filmsGenreGenreIDGet(@PathVariable("genreID") Integer genreID) {
        List<Film> films = filmDAO.getFilmsByGenreID(genreID);

        if (!films.isEmpty()) {
            return ResponseEntity.ok(films);  // Devuelve la película si existe
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // 404 si no existe
        }
    
    }

    @Override
    public ResponseEntity<List<Film>> filmsActorActorIDGet(@PathVariable("actorID") Integer actorID) {
        List<Film> films = filmDAO.getFilmsByActorID(actorID);

        if (!films.isEmpty()) {
            return ResponseEntity.ok(films);  // Devuelve la película si existe
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // 404 si no existe
        }
    
    }

    @Override
    public ResponseEntity<Film> filmsTitleTitleGet(@PathVariable String title) {
        Film film = filmDAO.getFilmByTitle(title);

        if (film != null) {
            return ResponseEntity.ok(film);  // Devuelve la película si existe
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // 404 si no existe
        }
    
    }
    

}