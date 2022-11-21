package com.example.hhhui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class CheckPane {

    @FXML
    private Pane checkYourBmi;

    @FXML
    private Label bmiLabel;



    @FXML
    private void backToMenu() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("MenuPane.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        checkYourBmi.getChildren().clear();
        checkYourBmi.getChildren().add(pane);
    }

    @FXML
    private void end() {
        Platform.exit();
    }

    public void setCalculatedBMI(double yourBmi) {
        String yBMI = String.valueOf((double) yourBmi);
        bmiLabel.setText(String.valueOf(yourBmi));
        if (yourBmi<16.0){
            bmiLabel.setText("Your BMI: " + yBMI.substring(0, 3) + " \nUnderweight (Severe thinness)");
        }else
        if (yourBmi<16.9){
            bmiLabel.setText("Your BMI: " + yBMI.substring(0, 3) + " \nUnderweight (Moderate thinness)");
        } else
        if (yourBmi<18.4){
            bmiLabel.setText("Your BMI: " + yBMI.substring(0, 3) + " \nUnderweight (Mild thinness)");
        } else
        if (yourBmi<24.9){
            bmiLabel.setText("Your BMI: " + yBMI.substring(0, 3) + " \nNormal range ");
        } else
        if (yourBmi<29.9){
           bmiLabel.setText("Your BMI: " + yBMI.substring(0, 3) + " \nOverweight (Pre-obese) ");
        } else
        if (yourBmi<34.9){
            bmiLabel.setText("Your BMI: " + yBMI.substring(0, 3) + " \nObese (Class I) ");
        } else
        if (yourBmi<39.9){
            bmiLabel.setText("Your BMI: " + yBMI.substring(0, 3) + " \nObese (Class II)");
        } else{
            bmiLabel.setText("Your BMI: " + yBMI.substring(0, 3) + " \nObese (Class III) ");
        }
        }
    }

