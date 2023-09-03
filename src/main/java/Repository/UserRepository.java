package Repository;

import Interface.UserRepositoryInterface;
import Models.DTO.CreateUserDTO;
import Models.User;
import Services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository implements UserRepositoryInterface {

    public  User insert(CreateUserDTO user) throws SQLException {
        String sql = "INSERT INTO Perdoruesi (username, salted_password, hash_password) VALUES (?, ?, ?)";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getSalted_password());
        statement.setString(3, user.getHash_password());
        statement.executeUpdate();

         return UserRepository.getByUsername(user.getUsername());
    }



    public static User getByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM Perdoruesi WHERE username=?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("user_id");
                String saltedHash = resultSet.getString("salted_password");
                String salt = resultSet.getString("hash_password");

                return new User(id, username, saltedHash, salt);
            } else {
                return null;
            }
        }
    }



}
