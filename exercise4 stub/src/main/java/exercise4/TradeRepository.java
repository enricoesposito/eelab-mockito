package exercise4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TradeRepository {

    private Connection connection;

    public Double read(String isin) {

        try {
            Statement st = connection.createStatement();
            ResultSet rs = null;
            rs = st.executeQuery("select * from trades");
            rs.next();
            return rs.getDouble(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
