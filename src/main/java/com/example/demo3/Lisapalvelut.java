package com.example.demo3;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class Lisapalvelut {
    public void naytaPopup(Stage primaryStage) {
        // Luo uusi ikkuna
        Stage popupStage = new Stage();
        // Aseta ikkunan otsikko
        popupStage.setTitle("Lisäpalvelut");
        // Luo raksi ruudut lisäpalveluille
        CheckBox checkbox1 = new CheckBox("Porosafari");
        CheckBox checkbox2 = new CheckBox("Koiravaljakkoajelu");
        CheckBox checkbox3 = new CheckBox("Airsoft");
        CheckBox checkbox4 = new CheckBox("Hevosjelu");
        CheckBox checkbox5 = new CheckBox("Vesiskootteri");
        CheckBox checkbox6 = new CheckBox("Moottorikelkka");
        // Luo tallenna-nappi
        Button tallennaButton = new Button("Tallenna");
        // Lisää tallenna-napin toiminnallisuus
        tallennaButton.setOnAction(e -> {
            // Tallenna valitut lisäpalvelut tietokantaan tai muulla tavalla
            popupStage.close(); // Sulje ikkuna tallennuksen jälkeen
        });
        // Luo GridPane ja lisää siihen checkboxit ja tallenna-napin
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.add(checkbox1, 0, 0);
        grid.add(checkbox2, 0, 1);
        grid.add(checkbox3, 0, 2);
        grid.add(checkbox4,0,3);
        grid.add(checkbox5,1,0);
        grid.add(checkbox6,1,1);
        grid.add(tallennaButton, 1, 8);

        popupStage.setX(primaryStage.getX() + (primaryStage.getWidth() - 100) / 2);
        popupStage.setY(primaryStage.getY() + (primaryStage.getHeight() - 350) / 2);

        Scene popupScene = new Scene(grid, 300, 200);
        popupStage.setScene(popupScene);
        popupStage.show();
    }
}
