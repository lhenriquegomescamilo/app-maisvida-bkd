package movies.spring.data.neo4j.controller;

import java.util.Map;
import java.util.Optional;

import movies.spring.data.neo4j.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mark Angrish
 */
@RestController("/")
public class MovieController {

    final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping("/graph")
    public Map<String, Object> graph(@RequestParam(value = "limit", required = false) Integer limit) {
        limit = Optional.ofNullable(limit).orElse(100);
        return movieService.graph(limit);
    }


}
