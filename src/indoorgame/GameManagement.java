/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indoorgame;

/**
 *
 * @author nazmul
 */
// GameManagement.java
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameManagement {
    private DatabaseIntegration databaseIntegration;

    public GameManagement(DatabaseIntegration databaseIntegration) {
        this.databaseIntegration = databaseIntegration;
    }

    public void registerGame(Game game) {
        databaseIntegration.executeUpdate("INSERT INTO games (gameName, gameType, boardNumber, maxPlayers) VALUES ('"
                + game.getGameName() + "', '" + game.getGameType() + "', " + game.getBoardNumber() + ", " + game.getMaxPlayers() + ")");
    }

    public void modifyGame(Game game) {
        databaseIntegration.executeUpdate("UPDATE games SET gameName = '" + game.getGameName() + "', gameType = '"
                + game.getGameType() + "', boardNumber = " + game.getBoardNumber() + ", maxPlayers = " + game.getMaxPlayers()
                + " WHERE gameId = " + game.getGameId());
    }

    public List<Game> getAllGames() {
        List<Game> games = new ArrayList<>();
        String selectQuery = "SELECT * FROM games";
        try (ResultSet resultSet = databaseIntegration.executeQuery(selectQuery)) {
            while (resultSet.next()) {
                int gameId = resultSet.getInt("gameId");
                String gameName = resultSet.getString("gameName");
                String gameType = resultSet.getString("gameType");
                int boardNumber = resultSet.getInt("boardNumber");
                int maxPlayers = resultSet.getInt("maxPlayers");
                games.add(new Game(gameId, gameName, gameType, boardNumber, maxPlayers));
            }
        } catch (SQLException e) {
    System.err.println("Error executing update query: " + e.getMessage());
    e.printStackTrace();
}

        return games;
    }
}
