package by.teachmeskills.lesson35.dao;

import by.teachmeskills.lesson33.Runner;
import by.teachmeskills.lesson35.dto.Client;
import org.apache.log4j.Logger;

import java.sql.*;

public class PostgreSQLJDBC {

    private static final Logger LOGGER = Logger.getLogger(Runner.class);

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public void createTable() {
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            String sql = "CREATE TABLE TMS.CLIENT " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " AGE            INT     NOT NULL, " +
                    " ADDRESS        CHAR(50));";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.commit();
            conn.close();
            LOGGER.info("Successfully created table.");
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }

    public void insertData() {
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            String sql = "INSERT INTO TMS.CLIENT (ID,NAME,AGE,ADDRESS) "
                    + "VALUES (1, 'Paul', 32, 'California');"
                    + "INSERT INTO TMS.CLIENT (ID,NAME,AGE,ADDRESS) "
                    + "VALUES (2, 'Allen', 25, 'Texas');"
                    + "INSERT INTO TMS.CLIENT (ID,NAME,AGE,ADDRESS) "
                    + "VALUES (3, 'Teddy', 23, 'Norway');"
                    + "INSERT INTO TMS.CLIENT (ID,NAME,AGE,ADDRESS) "
                    + "VALUES (4, 'Mark', 25, 'Rich-Mond ');";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.commit();
            conn.close();
            LOGGER.info("Successfully inserted data into table.");
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }

    public void getData() {
        try {
            conn = getConnection();
            conn.setAutoCommit(false);

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM TMS.CLIENT;");
            while (rs.next()) {
                Client client = Client.builder()
                        .id(rs.getLong("id"))
                        .fullName(rs.getString("name"))
                        .age(rs.getInt("age"))
                        .address(rs.getString("address"))
                        .build();
                System.out.println(client.toString());
            }
            rs.close();
            stmt.close();
            conn.close();
            LOGGER.info("Successfully selected data from table.");
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        return DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/tms_database",
                        "kripanda", "12345");
    }

}
