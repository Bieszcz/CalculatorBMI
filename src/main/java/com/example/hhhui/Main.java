package com.example.hhhui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    @FXML
    private Pane mainStackPane;
    @FXML
    private TextField inHeight;
    @FXML
    private TextField inWeight;

    public static void main(String[] args) {
        launch(args);
    }
    @FXML
    private void clickExit() {
        Platform.exit();
    }

    @FXML
    private void clickCheck() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("checkPane.fxml"));
        Pane pane;
        try {
            pane = loader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String wzrost = String.valueOf(inHeight.getText());
        double value = Double.parseDouble(wzrost);
        String waga = String.valueOf(inWeight.getText());
        double value2 = Double.parseDouble(waga);
        double checkBMIDouble = Math.round(value2 / Math.pow(value, 2) * 10000);
        CheckPane checkPane = loader.getController();
        checkPane.setCalculatedBMI(checkBMIDouble);
        mainStackPane.getChildren().clear();
        mainStackPane.getChildren().add(pane);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("MenuPane.fxml"));
        Pane pane = loader.load();
        Scene scene = new Scene(pane, 400, 400);

        stage.setScene(scene);
        stage.setTitle("Check your BMI");
        stage.show();

        EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FXMLLoader loader = new FXMLLoader(this.getClass().getResource("checkPane.fxml"));
                Pane pane;
                try {
                    pane = loader.load();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                Scene scene = new Scene(pane);
                stage.setScene(scene);
                stage.setTitle("Your BMI");
                String wzrost = "12.34";
                double value = Double.parseDouble(wzrost);
                String waga = "12.34";
                double value2 = Double.parseDouble(waga);
                double checkBMI = value2 * Math.pow(value, 2);
                Label label4 = new Label("Your BMI: " + checkBMI);
                label4.setLayoutX(150);
                label4.setLayoutY(100);
                label4.setFont(new Font(16));
            }
        };

    }
}
