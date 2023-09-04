package Interface;

import Models.User;

import java.sql.SQLException;

public interface UserServiceInterface {
    User login(String username,String Password) throws SQLException;

}

