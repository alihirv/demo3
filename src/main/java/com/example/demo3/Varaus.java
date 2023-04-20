package com.example.demo3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
public class Varaus extends Application {
//

    public class FontManager {
        public static void setDefaultFont(TextField textField) {
            Font font = Font.font("Arial", 14);
            textField.setFont(font);
        }
        public static void setDefaultFont(Label label) {
            Font font = Font.font("Arial",FontWeight.BOLD, 14);
            label.setTextFill(Color.WHITE);
            label.setFont(font);
        }
        public static void setDefaultFont(Button button){
            Font font = Font.font("Arial", 14);
            button.setFont(font);
        }
        public static void setDefaultFont(TextArea textArea){
            Font font = Font.font("Arial", 14);
            textArea.setFont(font);
        }

    }
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 50));
        grid.setVgap(10);
        grid.setHgap(10);

        Label cabinLabel = new Label("Mökki:");
        FontManager.setDefaultFont(cabinLabel);
        grid.add(cabinLabel, 0, 1);

        TextField cabinTextField = new TextField();
        cabinTextField.setPromptText("Mökki, id, sijainti");
        FontManager.setDefaultFont(cabinTextField);
        grid.add(cabinTextField, 1, 1);

        Label arrivalDateLabel = new Label("Tulopäivämäärä:");
        FontManager.setDefaultFont(arrivalDateLabel);
        grid.add(arrivalDateLabel, 0, 2);

        DatePicker arrivalDatePicker = new DatePicker();
        arrivalDatePicker.setValue(LocalDate.now());
        grid.add(arrivalDatePicker, 1, 2);

        Label departureDateLabel = new Label("Lähtöpäivämäärä:");
        FontManager.setDefaultFont(departureDateLabel);
        grid.add(departureDateLabel, 2, 2);

        DatePicker departureDatePicker = new DatePicker();
        departureDatePicker.setValue(LocalDate.now().plusDays(1));
        grid.add(departureDatePicker, 3, 2);

        Label arrivalTimeLabel = new Label("Saapumisaika:");
        FontManager.setDefaultFont(arrivalTimeLabel);
        grid.add(arrivalTimeLabel, 0, 4);

        TextField arrivalTimeTextField = new TextField();
        arrivalTimeTextField.setPromptText("Anna saapumisaika");
        FontManager.setDefaultFont(arrivalTimeTextField);
        grid.add(arrivalTimeTextField, 1, 4);

        Label durationLabel = new Label("Varauksen kesto:");
        FontManager.setDefaultFont(durationLabel);
        grid.add(durationLabel, 0, 3);

        TextField durationTextField = new TextField();
        durationTextField.setPromptText("Varautut päivät:");
        FontManager.setDefaultFont(durationTextField);
        durationTextField.setEditable(false);
        durationTextField.setPrefWidth(40);
        grid.add(durationTextField, 1, 3);

        Label firstNameLabel = new Label("Etunimi:");
        FontManager.setDefaultFont(firstNameLabel);
        grid.add(firstNameLabel, 0, 5);

        TextField firstNameTextField = new TextField();
        firstNameTextField.setPromptText("Asiakkaan etunimi");
        FontManager.setDefaultFont(firstNameTextField);
        grid.add(firstNameTextField, 1, 5);

        Label lastNameLabel = new Label("Sukunimi:");
        FontManager.setDefaultFont(lastNameLabel);
        grid.add(lastNameLabel, 0, 6);

        TextField lastNameTextField = new TextField();
        lastNameTextField.setPromptText("Asiakkaan sukunimi");
        FontManager.setDefaultFont(lastNameTextField);
        grid.add(lastNameTextField, 1, 6);

        Label phoneNumberLabel= new Label("Puhelin");
        FontManager.setDefaultFont(phoneNumberLabel);
        grid.add(phoneNumberLabel,0,7);

        TextField phoneNumberTextField = new TextField();
        phoneNumberTextField.setPromptText("Asiakkaan puh.num.");
        FontManager.setDefaultFont(phoneNumberTextField);
        grid.add(phoneNumberTextField,1,7);

        Label emailLabel = new Label("Sähköposti:");
        FontManager.setDefaultFont(emailLabel);
        grid.add(emailLabel, 0, 8);

        TextField emailTextField = new TextField();
        emailTextField.setPromptText("Asiakkaan sähköposti");
        FontManager.setDefaultFont(emailTextField);
        grid.add(emailTextField, 1, 8);

        Label messageLabel = new Label("Viesti:");
        FontManager.setDefaultFont(messageLabel);
        grid.add(messageLabel, 0, 10);

        TextArea messageTextArea = new TextArea();
        messageTextArea.setPromptText("Lisätietoja varauksesta");
        FontManager.setDefaultFont(messageTextArea);
        messageTextArea.setPrefRowCount(5);
        messageTextArea.setPrefColumnCount(20);
        messageTextArea.setWrapText(true);
        grid.add(messageTextArea, 1, 10, 3, 1);

        Button submitButton = new Button("Tee varaus");
        FontManager.setDefaultFont(submitButton);
        grid.add(submitButton, 1, 12);

        Button lisapalvelutButton = new Button("Lisäpalvelut");
        FontManager.setDefaultFont(lisapalvelutButton);
        grid.add(lisapalvelutButton, 3, 12);
        lisapalvelutButton.setOnAction(e -> {
            // Luodaan uusi Lisapalvelut-olio ja kutsutaan sen naytaPopup-metodia
            Lisapalvelut lisapalvelut = new Lisapalvelut();
            lisapalvelut.naytaPopup(primaryStage);
        });
        arrivalDatePicker.setOnAction(e -> {
            LocalDate arrivalDate = arrivalDatePicker.getValue();
            LocalDate departureDate = departureDatePicker.getValue();
            long duration = ChronoUnit.DAYS.between(arrivalDate, departureDate);
            durationTextField.setText(Long.toString(duration));
        });
        departureDatePicker.setOnAction(e -> {
            LocalDate arrivalDate = arrivalDatePicker.getValue();
            LocalDate departureDate = departureDatePicker.getValue();
            long duration = ChronoUnit.DAYS.between(arrivalDate, departureDate);
            durationTextField.setText(Long.toString(duration));
        });
        submitButton.setOnAction(e -> {
            String cabin = cabinTextField.getText();
            LocalDate arrivalDate = arrivalDatePicker.getValue();
            LocalDate departureDate = departureDatePicker.getValue();
            String arrivalTime = arrivalTimeTextField.getText();
            String firstName = firstNameTextField.getText();
            String lastName = lastNameTextField.getText();
            String phoneNumber = phoneNumberTextField.getText();
            String email = emailTextField.getText();
            String message = messageTextArea.getText();

            // tallenna varaus tietokantaan
            saveReservation(cabin, arrivalDate, departureDate, arrivalTime, firstName, lastName, email,phoneNumber, message);
            long duration = ChronoUnit.DAYS.between(arrivalDate, departureDate);

            durationTextField.setText(Long.toString(duration));
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime arrivalDateTime = LocalDateTime.parse(arrivalDate.toString() + " " + arrivalTime, inputFormatter);
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("HH:mm dd.MM.yyyy");
            arrivalTimeTextField.setText(arrivalDateTime.format(outputFormatter));

            // tyhjennä lomake
            cabinTextField.clear();
            arrivalTimeTextField.clear();
            firstNameTextField.clear();
            lastNameTextField.clear();
            phoneNumberTextField.clear();
            emailTextField.clear();
            messageTextArea.clear();
        });
        Image backgroundImage = new Image("file:src/main/resources/cabin.jpg");
        ImageView backgroundView = new ImageView(backgroundImage);

        Pane root = new Pane();
        root.getChildren().add(backgroundView);
        root.getChildren().add(grid);

        Label titleLabel = new Label("Village Newbies Oy -mökkivarausjärjestelmä");
        Font titleFont = Font.font("Arial", FontWeight.BOLD, 22);
        titleLabel.setTextFill(Color.GREEN);
        titleLabel.setFont(titleFont);
        titleLabel.setAlignment(Pos.CENTER);
        grid.add(titleLabel, 1, 0, 4, 1);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        backgroundView.fitWidthProperty().bind(scene.widthProperty());
        backgroundView.fitHeightProperty().bind(scene.heightProperty());
        primaryStage.show();
    }
    private void saveReservation(String cabin, LocalDate arrivalDate, LocalDate departureDate, String arrivalTime,
                                 String firstName, String lastName,String phoneNumber, String email, String message) {
        // tallenna varaus tietokantaan SQL-koodilla
        // ...
    }
    public static void main(String[] args) {
        launch(args);
    }
}
