package vtttp2022.paf.april4.april4paf.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vtttp2022.paf.april4.april4paf.models.Comment;
import vtttp2022.paf.april4.april4paf.models.Game;
import vtttp2022.paf.april4.april4paf.repositories.GameRepository;

@Controller
@RequestMapping
public class GameController {

    @Autowired
    GameRepository gameRepo;

    @GetMapping(path = "games/")
    public String getGames(Model model,
            @RequestParam Integer gid) {
        Optional<Game> opt = gameRepo.getGameByGid(gid);

        if (opt.isEmpty()) {
            System.out.println(">>>>>>>>>>>> THIS SHIT EMPTY");
            return "error";
        }

        Game g = opt.get();
        System.out.println(">>>>>>>>>>>>" +g.getImage());
        model.addAttribute("game", g);
        
        List<Comment> commentList = gameRepo.getCommentsByGid(gid);
        model.addAttribute("commentsList", commentList);
        return "games";
    }

}
