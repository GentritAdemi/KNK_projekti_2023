package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
        private static Connection connection;

        public static Connection getConnection() throws SQLException {
            if (connection == null || connection.isClosed()) {
                String url = "jdbc:mysql://localhost:3306/projectKNK1";
                String user = "root";
                String password = "210756100127";
                connection = DriverManager.getConnection(url, user, password);

            }
            return connection;
        }
    }

