package vtttp2022.paf.april4.april4paf.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vtttp2022.paf.april4.april4paf.models.Game;
import vtttp2022.paf.april4.april4paf.repositories.GameRepository;


@Service
public class GameService {
    
    @Autowired
    private GameRepository gameRepo;

    public Optional<Game> getCommentsByGid(Integer gid){

        Optional<Game> opt = gameRepo.getGameByGid(gid);
        if(opt.isEmpty())
            return Optional.empty();
        
        Game game = opt.get();
        game.setComments(gameRepo.getCommentsByGid(gid));

        return Optional.of(game);

    }

}
