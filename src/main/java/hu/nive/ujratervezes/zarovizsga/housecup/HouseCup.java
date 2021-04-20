package hu.nive.ujratervezes.zarovizsga.housecup;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HouseCup {
    private JdbcTemplate jdbcTemplate;
    private DataSource ds;

    public HouseCup(DataSource ds) {
        this.ds = ds;
    }

    public int getPointsOfHouse(String name) {
//        try (Connection conn = ds.getConnection();
//             PreparedStatement stmt =
//                     conn.prepareStatement(
//                             "SELECT points_earned FROM house_points WHERE house_name = ?")) {
//            stmt.setString(1, s);
//            List<String> res = getStatement(stmt);
//            int sum = 0;
//            for (String item : res)
//                sum += Integer.parseInt(item);
//            return sum;
//        } catch (SQLException e) {
//            throw new IllegalStateException("select error");
//        }
        jdbcTemplate = new JdbcTemplate(ds);
        List<Integer> res = jdbcTemplate.query("select points_earned from house_points where house_name = ?",
                new Object[]{name}, (rs, i) -> rs.getInt("points_earned"));
        int sum = 0;
        for (Integer item : res) {
            sum += item;
        }
        return sum;
    }

    private List<String> getStatement(PreparedStatement stmt) throws SQLException {
        List<String> result = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                result.add(rs.getString(1));
            }
        }
        return result;
    }

    public void createRow(String hname, String sname, int points) {
        jdbcTemplate = new JdbcTemplate(ds);
        jdbcTemplate.update("insert into house_points(house_name,student_name,points_earned) values(?,?,?)",
                hname, sname, points);
    }

    public List<String> listNames() {
        jdbcTemplate = new JdbcTemplate(ds);
        return jdbcTemplate.query("select student_name from house_points order by student_name",
                (resultSet, i) -> resultSet.getString("student_name"));
    }
}
