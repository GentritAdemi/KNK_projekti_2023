package Interface;

import Models.DTO.CreatePlayerDTO;
import Models.Player;

import java.sql.SQLException;

public interface PlayerRepositoryInterface {

    public Player insert (CreatePlayerDTO player) throws SQLException;
}
