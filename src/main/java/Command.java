import java.sql.SQLException;

public interface Command {

    void process() throws SQLException, ClassNotFoundException;
}
