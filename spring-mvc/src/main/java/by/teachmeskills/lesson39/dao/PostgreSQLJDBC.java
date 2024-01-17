package by.teachmeskills.lesson39.dao;

import by.teachmeskills.lesson39.entity.Car;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j
@Repository
public class PostgreSQLJDBC implements CarDao {

    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement prstmt = null;
    private ResultSet rs = null;

    @Override
    public List<Car> getCars() {
        List<Car> result = new ArrayList<>();
        try {
            conn = getConnection();
            conn.setAutoCommit(false);

            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM TMS.CAR ORDER BY ID ASC;");
            while (rs.next()) {
                result.add(new Car(rs.getLong("id"), rs.getString("name"), rs.getInt("price"), rs.getBoolean("deleted")));
            }
            rs.close();
            stmt.close();
            conn.close();
            log.info("Successfully selected data from table.");

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return result;
    }

    @Override
    public Optional<Car> getCarById(Long id) {
        Car car = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);

            String sql = "SELECT * FROM TMS.CAR WHERE ID = ?;";
            prstmt = conn.prepareStatement(sql);
            prstmt.setLong(1, id);
            rs = prstmt.executeQuery();
            while (rs.next()) {
                car = new Car(rs.getLong("id"), rs.getString("name"), rs.getInt("price"), rs.getBoolean("deleted"));
            }
            rs.close();
            stmt.close();
            conn.close();
            log.info("Successfully selected data from table.");

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Optional.of(car);
    }

    @Override
    public void saveCar(Car car) {
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            String sql = "INSERT INTO TMS.CAR (name,price) " + "VALUES (?, ?);";
            prstmt = conn.prepareStatement(sql);
            prstmt.setString(1, car.getName());
            prstmt.setInt(2, car.getPrice());
            prstmt.executeUpdate();
            prstmt.close();
            conn.commit();
            conn.close();
            log.info("Successfully inserted data into table.");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void updateCar(Car car) {
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            String sql = "UPDATE TMS.CAR SET name = ?, price = ? WHERE ID = ?;";
            prstmt = conn.prepareStatement(sql);
            prstmt.setString(1, car.getName());
            prstmt.setInt(2, car.getPrice());
            prstmt.setLong(3, car.getId());
            prstmt.executeUpdate();
            prstmt.close();
            conn.commit();
            conn.close();
            log.info("Successfully inserted data into table.");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void deleteCar(Long id) {
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            String sql = "DELETE FROM TMS.CAR WHERE ID = ?;";
            prstmt = conn.prepareStatement(sql);
            prstmt.setLong(1, id);
            prstmt.executeUpdate();
            prstmt.close();
            conn.commit();
            conn.close();
            log.info("Successfully inserted data into table.");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/tms_database", "kripanda", "12345");
    }
}
