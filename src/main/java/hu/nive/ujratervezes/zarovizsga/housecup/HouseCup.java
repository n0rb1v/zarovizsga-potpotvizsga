package hu.nive.ujratervezes.zarovizsga.housecup;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HouseCup {
    private DataSource ds;

    public HouseCup(DataSource ds) {
        this.ds = ds;
    }

    public int getPointsOfHouse(String s) {
        try (Connection conn = ds.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement(
                             "SELECT points_earned FROM house_points WHERE house_name = ?")) {
            stmt.setString(1, s);
            List<String> res = getStatement(stmt);
            int sum = 0;
            for (String item : res)
                sum += Integer.parseInt(item);
            return sum;
        } catch (SQLException e) {
            throw new IllegalStateException("select error");
        }
    }

    private List<String> getStatement(PreparedStatement stmt) throws SQLException {
        List<String> result = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                result.add(rs.getString(1).toLowerCase());
            }
        }
        return result;
    }
}
