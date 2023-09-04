package Services;

import Interface.UserRepositoryInterface;
import Interface.UserServiceInterface;
import Models.DTO.CreateUserDTO;
import Models.User;
import Repository.UserRepository;

import java.sql.SQLException;

public class UserService implements UserServiceInterface {

private UserRepositoryInterface userRepositoryInterface;

public UserService() {
    this.userRepositoryInterface = new UserRepository();
}
    @Override
    public User login(String username, String Password) throws SQLException {
        User loginUser = UserRepository.getByUsername(username);
        if(loginUser == null){
            return null;
        }
        boolean isPasswordCorrect = PasswordHasher.compareSaltedHash(
                Password, loginUser.getSalted_password(), loginUser.getHash_password()
        );
        if(isPasswordCorrect){
            return loginUser;
        }

        return null;
    }

    public User signUp(String username, String password) throws SQLException{
        String salt = PasswordHasher.generateSalt();
        String saltedHash = PasswordHasher.generateSaltedHash(password, salt);
        CreateUserDTO user = new CreateUserDTO(username, saltedHash, salt);
        this.userRepositoryInterface.insert(user);
        return UserRepository.getByUsername(username);
    }
    }

