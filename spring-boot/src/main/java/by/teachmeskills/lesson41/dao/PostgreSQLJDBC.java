package by.teachmeskills.lesson41.dao;

import by.teachmeskills.lesson41.model.Car;
import by.teachmeskills.lesson41.properties.DBProperties;
import lombok.RequiredArgsConstructor;
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

@Log4j
@Repository
@RequiredArgsConstructor
public class PostgreSQLJDBC {

    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement prstmt = null;
    private ResultSet rs = null;
    private final DBProperties dbProperties;

    public List<Car> getCars() {
        List<Car> result = new ArrayList<>();
        try {
            conn = getConnection();
            conn.setAutoCommit(false);

            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM TMS.CAR ORDER BY ID ASC;");
            while (rs.next()) {
                result.add(Car.builder().id(rs.getLong("id")).name(rs.getString("name")).price(rs.getInt("price")).build());

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

    public Car getCarById(Long id) {
        Car car = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);

            String sql = "SELECT * FROM TMS.CAR WHERE ID = ?;";
            prstmt = conn.prepareStatement(sql);
            prstmt.setLong(1, id);
            rs = prstmt.executeQuery();
            while (rs.next()) {
                car = Car.builder().id(rs.getLong("id")).name(rs.getString("name")).price(rs.getInt("price")).build();

            }
            rs.close();
            stmt.close();
            conn.close();
            log.info("Successfully selected data from table.");

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return car;
    }

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
        return DriverManager.getConnection(dbProperties.getUrl(), dbProperties.getUser(), dbProperties.getPassword());
    }
}
