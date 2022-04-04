package vtttp2022.paf.april4.april4paf.repositories;

public interface Queries {

    public static final String SQL_SELECT_GAME_BY_GID = "SELECT * FROM game WHERE gid = ?";

    public static final String SQL_SELECT_COMMENTS_BY_GID = "SELECT * FROM comment WHERE gid = ? LIMIT ? OFFSET ?";

    public static final String SQL_SELECT_COUNT_COMMENTS_BY_GID = "SELECT COUNT(*) as total FROM comment WHERE gid = ?";
}
