package Services;

import Models.DTO.CreatePlayerDTO;
import Models.DTO.CreateUserDTO;
import Models.Player;
import Models.User;
import Repository.PlayerRepository;
import Repository.UserRepository;

import java.sql.SQLException;

public class PlayerService {

    public static Player register(
            String Emri,String Mbiemri,int mosha,String Pozita,String Nacionaliteti
    ) throws SQLException {

        Player player = PlayerRepository.getByPlayerName(Emri);
        if (player != null) {

            return null;
        }


        CreatePlayerDTO playerDto = new CreatePlayerDTO(Emri,Mbiemri,mosha,Pozita,Nacionaliteti);
        PlayerRepository playerRepository = new PlayerRepository();
        return playerRepository.insert(playerDto);
    }

}
