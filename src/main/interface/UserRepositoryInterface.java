package Interface;
import Models.User;
import Models.DTO.CreateUserDTO;

import java.sql.SQLException;

public interface UserRepositoryInterface {
     User insert(CreateUserDTO user) throws SQLException;

}

