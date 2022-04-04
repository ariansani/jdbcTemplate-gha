package vtttp2022.paf.april4.april4paf.models;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Comment {
    private String c_id;
    private String user;
    private Integer rating;
    private String c_text;
    private Integer gid;

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getC_text() {
        return c_text;
    }

    public void setC_text(String c_text) {
        this.c_text = c_text;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public static Comment create(SqlRowSet rs) {
        Comment comment = new Comment();

        comment.c_id = rs.getString("c_id");
        comment.user = rs.getString("user");
        comment.rating = rs.getInt("rating");
        comment.c_text = rs.getString("c_text");
        comment.gid = rs.getInt("gid");

        return comment;
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("c_id", getC_id())
                .add("user", getUser())
                .add("rating", getRating())
                .add("c_text", getC_text())
                .add("gid", getGid())
                .build();
    }

}
