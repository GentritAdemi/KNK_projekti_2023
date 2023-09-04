package Services;

import Models.DTO.CreateUserDTO;
import Models.User;
import Repository.UserRepository;

import java.sql.SQLException;

public class UserAuthService {
    public static User login(String username, String password) throws SQLException {
        User user = UserRepository.getByUsername(username);
        if (user == null) {
            return null;
        }
        if (PasswordHasher.compareSaltedHash(password, user.getSalted_password(), user.getHash_password())) {
            return user;
        }
        return null;
    }

    public static User register(
             String  username, String password
    ) throws SQLException {

        User user = UserRepository.getByUsername(username);
        if (user != null) {

            return null;
        }
        String salt = PasswordHasher.generateSalt();
        String saltedPasswordHash = PasswordHasher.generateSaltedHash(password, salt);

        CreateUserDTO userDto = new CreateUserDTO(username,saltedPasswordHash,salt);
        UserRepository userRepository = new UserRepository();
        return userRepository.insert(userDto);
    }



}
