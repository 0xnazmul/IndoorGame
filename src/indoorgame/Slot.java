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
// Slot.java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Slot {
    private int slotId;
    private int gameId;
    private int studentId;
    private LocalDateTime dateTime;

    public Slot(int slotId, int gameId, int studentId, LocalDateTime dateTime) {
        this.slotId = slotId;
        this.gameId = gameId;
        this.studentId = studentId;
        this.dateTime = dateTime;
    }

    public Slot(int gameId, int studentId, String dateTime) {
        this.gameId = gameId;
        this.studentId = studentId;
        this.dateTime = parseDateTime(dateTime);
    }

    // Getter methods
    public int getSlotId() {
        return slotId;
    }

    public int getGameId() {
        return gameId;
    }

    public int getStudentId() {
        return studentId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    // Method to parse string and convert to LocalDateTime
    private LocalDateTime parseDateTime(String dateTimeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(dateTimeString, formatter);
    }
}
