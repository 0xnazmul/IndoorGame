/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indoorgame;


import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class UserInterfaceController {

    @FXML
    private TextField gameNameField;

    @FXML
    private TextField gameTypeField;

    @FXML
    private TextField boardNumberField;

    @FXML
    private TextField maxPlayersField;

    @FXML
    private TextField studentNameField;

    @FXML
    private TextField studentIdField;

    @FXML
    private TextField gameIdField;

    @FXML
    private TextField studentIdSlotField;

    @FXML
    private TextField dateTimeField;

    private GameManagement gameManagement;
    private StudentManagement studentManagement;
    private SlotBooking slotBooking;

    public UserInterfaceController() {
        this.gameManagement = new GameManagement(new DatabaseIntegration());
        this.studentManagement = new StudentManagement(new DatabaseIntegration());
        this.slotBooking = new SlotBooking(new DatabaseIntegration());
    }

    // Method to handle game registration
    @FXML
    private void handleGameRegistration() {
        // Retrieve data from UI elements
        String gameName = gameNameField.getText();
        String gameType = gameTypeField.getText();
        int boardNumber = Integer.parseInt(boardNumberField.getText());
        int maxPlayers = Integer.parseInt(maxPlayersField.getText());

        // Create a new Game object (assuming gameId is auto-incremented and set to 0)
        Game newGame = new Game(0, gameName, gameType, boardNumber, maxPlayers);

        // Register the new game
        gameManagement.registerGame(newGame);

        // Display a success message
        showAlert("Game Registration", "Game registered successfully!");
    }

    // Method to handle student registration
    @FXML
    private void handleStudentRegistration() {
        // Retrieve data from UI elements
        String studentName = studentNameField.getText();
        String studentID = studentIdField.getText();

        // Create a new Student object
        Student newStudent = new Student(studentName, studentID);

        // Register the new student
        studentManagement.registerStudent(newStudent);

        // Display a success message
        showAlert("Student Registration", "Student registered successfully!");
    }

    // Method to handle slot booking
    @FXML
    private void handleSlotBooking() {
        // Retrieve data from UI elements
        int gameId = Integer.parseInt(gameIdField.getText());
        int studentId = Integer.parseInt(studentIdSlotField.getText());
        String dateTime = dateTimeField.getText();

        // Create a new Slot object
        Slot newSlot = new Slot(gameId, studentId, dateTime);

        // Attempt to book the slot
        boolean success = slotBooking.bookSlot(newSlot);

        // Display a success or error message
        if (success) {
            showAlert("Slot Booking", "Slot booked successfully!");
        } else {
            showAlert("Slot Booking", "Slot booking failed. The slot may not be available.");
        }
    }

    // Helper method to display an alert
    private void showAlert(String title, String content) {
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
          alert.setTitle(title);
          alert.setHeaderText(null);
          alert.setContentText(content);
          alert.showAndWait();
      }
    public void UserInterfaceController() {
        // Replace "your_url", "your_username", and "your_password" with your actual database connection details
        this.gameManagement = new GameManagement(new DatabaseIntegration("your_url", "your_username", "your_password"));
        this.studentManagement = new StudentManagement(new DatabaseIntegration("your_url", "your_username", "your_password"));
        this.slotBooking = new SlotBooking(new DatabaseIntegration("your_url", "your_username", "your_password"));
    }
    
    
    @FXML
    private void openAdditionalWindow() {
        // Create a new stage
        Stage additionalStage = new Stage();

        // Create UI elements for the new window
        VBox vbox = new VBox();
        Label label = new Label("This is an additional window!");

        vbox.getChildren().add(label);

        // Set up the scene and show the stage
        Scene scene = new Scene(vbox, 300, 200);
        additionalStage.setScene(scene);
        additionalStage.setTitle("Additional Window");
        additionalStage.initModality(Modality.APPLICATION_MODAL); // Makes it a modal window

        additionalStage.showAndWait(); // Show the window and wait for it to be closed
    }
}
    

