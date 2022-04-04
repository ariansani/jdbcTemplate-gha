package vtttp2022.paf.april4.april4paf.controllers;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObjectBuilder;
import vtttp2022.paf.april4.april4paf.models.Comment;
import vtttp2022.paf.april4.april4paf.models.Game;
import vtttp2022.paf.april4.april4paf.repositories.GameRepository;
import vtttp2022.paf.april4.april4paf.services.GameService;

@RestController
@RequestMapping(path = "/game")
public class GameRestController {

    @Autowired
    private GameService gameSvc;

    @GetMapping(path = "/{gid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getGameAndCommentsByGid(@PathVariable Integer gid) {

        Optional<Game> opt = gameSvc.getCommentsByGid(gid);
        JsonObjectBuilder builder = Json.createObjectBuilder();

        if (opt.isEmpty())
            return ResponseEntity.status(404).body(
                    builder.add("error", "not found: %s".formatted(gid))
                            .build().toString());

        Game game = opt.get();
        builder.add("gid", game.getGid());
        builder.add("name", game.getName());
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        for (Comment c : game.getComments()) 
            arrBuilder.add("/comment/%s".formatted(c.getC_id()));
        builder.add("Comments",arrBuilder.build());
    
        //CHANGE THIS
        return ResponseEntity.ok().build();
    }

}
