/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.9.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import org.openapitools.model.Film;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-11T16:08:26.906146+01:00[Europe/Madrid]", comments = "Generator version: 7.9.0")
@Validated
@Tag(name = "films", description = "Este endpoint maneja toda la información relacionada con las películas, incluyendo su creación, modificación, eliminación, y consulta de detalles como título, género, duración, y año de lanzamiento.")
public interface FilmsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /films/actor/{actorID} : Lista películas por ID de actor
     * Devuelve una lista de películas filtradas por el id del actor que participa en ellas
     *
     * @param actorID El ID del actor por el cual se filtrarán las películas. (required)
     * @return Lista de películas filtrada por actor obtenida con éxito (status code 200)
     *         or (NotFound) El recurso solicitado no existe en la base de datos. (status code 404)
     *         or (BadRequest) Los datos enviados no son correctos o faltan datos obligatorios en la solicitud. (status code 400)
     */
    @Operation(
        operationId = "filmsActorActorIDGet",
        summary = "Lista películas por ID de actor",
        description = "Devuelve una lista de películas filtradas por el id del actor que participa en ellas",
        tags = { "films" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Lista de películas filtrada por actor obtenida con éxito", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Film.class)))
            }),
            @ApiResponse(responseCode = "404", description = "(NotFound) El recurso solicitado no existe en la base de datos."),
            @ApiResponse(responseCode = "400", description = "(BadRequest) Los datos enviados no son correctos o faltan datos obligatorios en la solicitud.")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/films/actor/{actorID}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<Film>> filmsActorActorIDGet(
        @Parameter(name = "actorID", description = "El ID del actor por el cual se filtrarán las películas.", required = true, in = ParameterIn.PATH) @PathVariable("actorID") Integer actorID
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"genreID\" : 1, \"duration\" : 120, \"photoURL\" : \"photoURL\", \"filmID\" : 1, \"description\" : \"Film Sinopsis\", \"arrayActors\" : [ 101, 102, 103 ], \"title\" : \"Film Title\", \"releaseYear\" : 2023 }, { \"genreID\" : 1, \"duration\" : 120, \"photoURL\" : \"photoURL\", \"filmID\" : 1, \"description\" : \"Film Sinopsis\", \"arrayActors\" : [ 101, 102, 103 ], \"title\" : \"Film Title\", \"releaseYear\" : 2023 } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /films/{filmID} : Elimina una película
     * Este endpoint elimina una película existente de la base de datos. El ID de la película debe ser especificado en la URL.
     *
     * @param filmID El ID de la película a eliminar (required)
     * @return Película eliminada con éxito (status code 204)
     *         or (NotFound) El recurso solicitado no existe en la base de datos. (status code 404)
     *         or (BadRequest) Los datos enviados no son correctos o faltan datos obligatorios en la solicitud. (status code 400)
     */
    @Operation(
        operationId = "filmsFilmIDDelete",
        summary = "Elimina una película",
        description = "Este endpoint elimina una película existente de la base de datos. El ID de la película debe ser especificado en la URL.",
        tags = { "films" },
        responses = {
            @ApiResponse(responseCode = "204", description = "Película eliminada con éxito"),
            @ApiResponse(responseCode = "404", description = "(NotFound) El recurso solicitado no existe en la base de datos."),
            @ApiResponse(responseCode = "400", description = "(BadRequest) Los datos enviados no son correctos o faltan datos obligatorios en la solicitud.")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/films/{filmID}"
    )
    
    default ResponseEntity<Void> filmsFilmIDDelete(
        @Parameter(name = "filmID", description = "El ID de la película a eliminar", required = true, in = ParameterIn.PATH) @PathVariable("filmID") Integer filmID
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /films/{filmID} : Devuelve los detalles de una película específica
     * Obtiene los detalles de una película específica utilizando su ID. Este endpoint permite consultar información detallada sobre una película, como su título, año de lanzamiento, duración, género y sinopsis.
     *
     * @param filmID El ID de la película a obtener (required)
     * @return Película obtenida con éxito (status code 200)
     *         or (NotFound) El recurso solicitado no existe en la base de datos. (status code 404)
     */
    @Operation(
        operationId = "filmsFilmIDGet",
        summary = "Devuelve los detalles de una película específica",
        description = "Obtiene los detalles de una película específica utilizando su ID. Este endpoint permite consultar información detallada sobre una película, como su título, año de lanzamiento, duración, género y sinopsis.",
        tags = { "films" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Película obtenida con éxito", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Film.class))
            }),
            @ApiResponse(responseCode = "404", description = "(NotFound) El recurso solicitado no existe en la base de datos.")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/films/{filmID}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<Film> filmsFilmIDGet(
        @Parameter(name = "filmID", description = "El ID de la película a obtener", required = true, in = ParameterIn.PATH) @PathVariable("filmID") Integer filmID
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"genreID\" : 1, \"duration\" : 120, \"photoURL\" : \"photoURL\", \"filmID\" : 1, \"description\" : \"Film Sinopsis\", \"arrayActors\" : [ 101, 102, 103 ], \"title\" : \"Film Title\", \"releaseYear\" : 2023 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /films/{filmID} : Actualiza una película
     * Actualiza la información de una película existente. Se debe proporcionar el ID de la película en la URL y los nuevos valores en el cuerpo de la solicitud. Permite actualizar detalles como el título, género o sinopsis.
     *
     * @param filmID El ID de la película a actualizar (required)
     * @param film Objeto película con los nuevos valores (required)
     * @return Película actualizada con éxito (status code 200)
     *         or (NotFound) El recurso solicitado no existe en la base de datos. (status code 404)
     *         or (BadRequest) Los datos enviados no son correctos o faltan datos obligatorios en la solicitud. (status code 400)
     */
    @Operation(
        operationId = "filmsFilmIDPut",
        summary = "Actualiza una película",
        description = "Actualiza la información de una película existente. Se debe proporcionar el ID de la película en la URL y los nuevos valores en el cuerpo de la solicitud. Permite actualizar detalles como el título, género o sinopsis.",
        tags = { "films" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Película actualizada con éxito", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Film.class))
            }),
            @ApiResponse(responseCode = "404", description = "(NotFound) El recurso solicitado no existe en la base de datos."),
            @ApiResponse(responseCode = "400", description = "(BadRequest) Los datos enviados no son correctos o faltan datos obligatorios en la solicitud.")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/films/{filmID}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Film> filmsFilmIDPut(
        @Parameter(name = "filmID", description = "El ID de la película a actualizar", required = true, in = ParameterIn.PATH) @PathVariable("filmID") Integer filmID,
        @Parameter(name = "Film", description = "Objeto película con los nuevos valores", required = true) @Valid @RequestBody Film film
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"genreID\" : 1, \"duration\" : 120, \"photoURL\" : \"photoURL\", \"filmID\" : 1, \"description\" : \"Film Sinopsis\", \"arrayActors\" : [ 101, 102, 103 ], \"title\" : \"Film Title\", \"releaseYear\" : 2023 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /films/genre/{genreID} : Lista películas por género
     * Devuelve una lista de películas filtradas por el género especificado en el &#x60;genreID&#x60;.
     *
     * @param genreID El ID del género por el cual se filtrarán las películas. (required)
     * @return Lista de películas filtrada por género obtenida con éxito (status code 200)
     *         or (NotFound) El recurso solicitado no existe en la base de datos. (status code 404)
     *         or (BadRequest) Los datos enviados no son correctos o faltan datos obligatorios en la solicitud. (status code 400)
     */
    @Operation(
        operationId = "filmsGenreGenreIDGet",
        summary = "Lista películas por género",
        description = "Devuelve una lista de películas filtradas por el género especificado en el `genreID`.",
        tags = { "films" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Lista de películas filtrada por género obtenida con éxito", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Film.class)))
            }),
            @ApiResponse(responseCode = "404", description = "(NotFound) El recurso solicitado no existe en la base de datos."),
            @ApiResponse(responseCode = "400", description = "(BadRequest) Los datos enviados no son correctos o faltan datos obligatorios en la solicitud.")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/films/genre/{genreID}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<Film>> filmsGenreGenreIDGet(
        @Parameter(name = "genreID", description = "El ID del género por el cual se filtrarán las películas.", required = true, in = ParameterIn.PATH) @PathVariable("genreID") Integer genreID
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"genreID\" : 1, \"duration\" : 120, \"photoURL\" : \"photoURL\", \"filmID\" : 1, \"description\" : \"Film Sinopsis\", \"arrayActors\" : [ 101, 102, 103 ], \"title\" : \"Film Title\", \"releaseYear\" : 2023 }, { \"genreID\" : 1, \"duration\" : 120, \"photoURL\" : \"photoURL\", \"filmID\" : 1, \"description\" : \"Film Sinopsis\", \"arrayActors\" : [ 101, 102, 103 ], \"title\" : \"Film Title\", \"releaseYear\" : 2023 } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /films : Devuelve una lista de todas las películas
     * Este endpoint permite obtener una lista completa de todas las películas en la base de datos, con su información como título, año de lanzamiento, duración, y más. Se puede usar para mostrar el catálogo en la interfaz de usuario o realizar análisis sobre el contenido.
     *
     * @return Lista de películas obtenida con éxito (status code 200)
     */
    @Operation(
        operationId = "filmsGet",
        summary = "Devuelve una lista de todas las películas",
        description = "Este endpoint permite obtener una lista completa de todas las películas en la base de datos, con su información como título, año de lanzamiento, duración, y más. Se puede usar para mostrar el catálogo en la interfaz de usuario o realizar análisis sobre el contenido.",
        tags = { "films" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Lista de películas obtenida con éxito", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Film.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/films",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<Film>> filmsGet(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"genreID\" : 1, \"duration\" : 120, \"photoURL\" : \"photoURL\", \"filmID\" : 1, \"description\" : \"Film Sinopsis\", \"arrayActors\" : [ 101, 102, 103 ], \"title\" : \"Film Title\", \"releaseYear\" : 2023 }, { \"genreID\" : 1, \"duration\" : 120, \"photoURL\" : \"photoURL\", \"filmID\" : 1, \"description\" : \"Film Sinopsis\", \"arrayActors\" : [ 101, 102, 103 ], \"title\" : \"Film Title\", \"releaseYear\" : 2023 } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /films : Inserta una nueva película
     * Inserta una nueva película en la base de datos. La película debe contener al menos su título, género, año de lanzamiento y duración. Este endpoint es utilizado por administradores para añadir nuevos contenidos al catálogo.
     *
     * @param film Objeto película que será añadido (required)
     * @return Película añadida con éxito (status code 201)
     *         or (BadRequest) Los datos enviados no son correctos o faltan datos obligatorios en la solicitud. (status code 400)
     */
    @Operation(
        operationId = "filmsPost",
        summary = "Inserta una nueva película",
        description = "Inserta una nueva película en la base de datos. La película debe contener al menos su título, género, año de lanzamiento y duración. Este endpoint es utilizado por administradores para añadir nuevos contenidos al catálogo.",
        tags = { "films" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Película añadida con éxito", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Film.class))
            }),
            @ApiResponse(responseCode = "400", description = "(BadRequest) Los datos enviados no son correctos o faltan datos obligatorios en la solicitud.")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/films",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Film> filmsPost(
        @Parameter(name = "Film", description = "Objeto película que será añadido", required = true) @Valid @RequestBody Film film
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"genreID\" : 1, \"duration\" : 120, \"photoURL\" : \"photoURL\", \"filmID\" : 1, \"description\" : \"Film Sinopsis\", \"arrayActors\" : [ 101, 102, 103 ], \"title\" : \"Film Title\", \"releaseYear\" : 2023 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /films/title/{title} : Busca una película por título
     * Devuelve la información de una película basada en el título especificado.
     *
     * @param title El título de la película que se desea buscar. (required)
     * @return Película encontrada con éxito (status code 200)
     *         or (NotFound) El recurso solicitado no existe en la base de datos. (status code 404)
     *         or (BadRequest) Los datos enviados no son correctos o faltan datos obligatorios en la solicitud. (status code 400)
     */
    @Operation(
        operationId = "filmsTitleTitleGet",
        summary = "Busca una película por título",
        description = "Devuelve la información de una película basada en el título especificado.",
        tags = { "films" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Película encontrada con éxito", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Film.class))
            }),
            @ApiResponse(responseCode = "404", description = "(NotFound) El recurso solicitado no existe en la base de datos."),
            @ApiResponse(responseCode = "400", description = "(BadRequest) Los datos enviados no son correctos o faltan datos obligatorios en la solicitud.")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/films/title/{title}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<Film> filmsTitleTitleGet(
        @Parameter(name = "title", description = "El título de la película que se desea buscar.", required = true, in = ParameterIn.PATH) @PathVariable("title") String title
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"genreID\" : 1, \"duration\" : 120, \"photoURL\" : \"photoURL\", \"filmID\" : 1, \"description\" : \"Film Sinopsis\", \"arrayActors\" : [ 101, 102, 103 ], \"title\" : \"Film Title\", \"releaseYear\" : 2023 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
