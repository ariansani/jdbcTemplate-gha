package vtttp2022.paf.april4.april4paf.repositories;

import vtttp2022.paf.april4.april4paf.models.Comment;
import vtttp2022.paf.april4.april4paf.models.Game;
import vtttp2022.paf.april4.april4paf.repositories.Queries.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class GameRepository {

    @Autowired
    private JdbcTemplate template;

    public List<Comment> getCommentsByGid(Integer gid, Integer limit, Integer offset){
       
        final List<Comment> commentList = new LinkedList<>();
        
        final SqlRowSet rs = template.queryForRowSet(Queries.SQL_SELECT_COMMENTS_BY_GID, gid,limit,offset);

        while(rs.next()){
            commentList.add(Comment.create(rs));
        }

        return Collections.unmodifiableList(commentList);

    }

    public Optional<Game> getGameByGid(Integer queryGid) {

        final SqlRowSet rs = template.queryForRowSet(
                // select * from game where gid = <gid>
                Queries.SQL_SELECT_GAME_BY_GID, queryGid);

        

        if(!rs.next()){
            return Optional.empty();
        }

        return Optional.of(Game.create(rs));

    }

}
