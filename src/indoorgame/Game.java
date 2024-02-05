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
// Game.java
public class Game {
    private int gameId;
    private String gameName;
    private String gameType;
    private int boardNumber;
    private int maxPlayers;

    public Game(int gameId, String gameName, String gameType, int boardNumber, int maxPlayers) {
        this.gameId = gameId;
        this.gameName = gameName;
        this.gameType = gameType;
        this.boardNumber = boardNumber;
        this.maxPlayers = maxPlayers;
    }

    // Getter methods
    public int getGameId() {
        return gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public String getGameType() {
        return gameType;
    }

    public int getBoardNumber() {
        return boardNumber;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    // Setter methods
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public void setBoardNumber(int boardNumber) {
        this.boardNumber = boardNumber;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    // Example: Add logic for playing the game
    public void playGame() {
        System.out.println("Game is being played: " + gameName);
        // Add your specific logic for playing the game
        // For example, start game-related processes or update game status
    }

    // Example: Add logic for pausing the game
    public void pauseGame() {
        System.out.println("Game is paused: " + gameName);
        // Add your specific logic for pausing the game
        // For example, pause game-related processes or update game status
    }

    // Existing methods...

    // Add your existing methods here
    // For example:
    public void displayGameDetails() {
        System.out.println("Game Details - Name: " + gameName + ", Type: " + gameType + ", Board: " + boardNumber +
                ", Max Players: " + maxPlayers);
        // Add your specific logic for displaying game details
    }

    // Add more methods based on your requirements
}
