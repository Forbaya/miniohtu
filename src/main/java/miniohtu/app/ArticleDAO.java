
package miniohtu.app;

import java.sql.SQLException;
import java.util.List;

public class ArticleDAO implements EntryDAO<Article> {

    private Database db;
    
    public ArticleDAO(Database db) {
        this.db = db;
    }
    
    @Override
    public void add(Article entry) throws SQLException {
        String sql = "INSERT INTO ARTICLE"
                + "(ID, AUTHOR, TITLE, JOURNAL, YEAR, VOLUME) VALUES ("
                + s(entry.getId()) + ", "
                + s(entry.getAuthor()) + ", "
                + s(entry.getTitle()) + ", "
                + s(entry.getJournal()) + ", "
                + entry.getYear() + ", "
                + entry.getVolume() + " );";
        
        db.update(sql);
    }
    
    private String s(String s) {
        return "'" + s + "'";
    }

    @Override
    public List<Article> findAll() throws SQLException {
        return db.queryAndCollect("SELECT * FROM ARTICLE", rs -> {
           return new Article(
               rs.getString("id"),
               rs.getString("author"),
               rs.getString("title"),
               rs.getString("journal"),
               rs.getInt("volume"),
               rs.getInt("number"),
               rs.getInt("year"),
               rs.getString("pages"),
               rs.getString("month"),
               rs.getString("note"),
               rs.getString("key")); 
        });
    }

    @Override
    public Article find(String id) throws SQLException {
        List<Article> matches = db.queryAndCollect("SELECT * FROM ARTICLE WHERE ID=" + id, rs -> {
            return new Article(
                rs.getString("id"),
                rs.getString("author"),
                rs.getString("title"),
                rs.getString("journal"),
                rs.getInt("volume"),
                rs.getInt("number"),
                rs.getInt("year"),
                rs.getString("pages"),
                rs.getString("month"),
                rs.getString("note"),
                rs.getString("key"));
        });
        
        return matches.isEmpty() ? null : matches.get(0);
    }
}
