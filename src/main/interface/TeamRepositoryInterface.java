package Interface;

import Models.DTO.CreateTeamDto;
import Models.Team;

import java.sql.SQLException;

public interface TeamRepositoryInterface {
    public Team insert(CreateTeamDto teamDto) throws SQLException;
}
