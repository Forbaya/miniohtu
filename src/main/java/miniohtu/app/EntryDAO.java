
package miniohtu.app;

import java.sql.SQLException;
import java.util.List;

public interface EntryDAO<Entry> {
    void add(Entry entry) throws SQLException;
    List<Entry> findAll() throws SQLException;
    Entry find(String id) throws SQLException;
}
