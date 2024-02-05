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
// SlotBooking.java
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SlotBooking {
    private final DatabaseIntegration databaseIntegration;

    public SlotBooking(DatabaseIntegration databaseIntegration) {
        this.databaseIntegration = databaseIntegration;
    }

    // Method to book a slot for a game
    public boolean bookSlot(Slot slot) {
        if (isSlotAvailable(slot)) {
            databaseIntegration.executeUpdate("INSERT INTO slots (gameId, studentId, dateTime) VALUES ("
                    + slot.getGameId() + ", " + slot.getStudentId() + ", '" + slot.getDateTime() + "')");
            return true;
        } else {
            return false;
        }
    }

    private boolean isSlotAvailable(Slot slot) {
        String selectQuery = "SELECT * FROM slots WHERE gameId = " + slot.getGameId() + " AND dateTime = '" + slot.getDateTime() + "'";
        try (ResultSet resultSet = databaseIntegration.executeQuery(selectQuery)) {
            return !resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Slot> getAllSlots() {
        List<Slot> slots = new ArrayList<>();
        String selectQuery = "SELECT * FROM slots";
        try (ResultSet resultSet = databaseIntegration.executeQuery(selectQuery)) {
            while (resultSet.next()) {
                int gameId = resultSet.getInt("gameId");
                int studentId = resultSet.getInt("studentId");
                String dateTime = resultSet.getString("dateTime");
                slots.add(new Slot(gameId, studentId, dateTime));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return slots;
    }
}
