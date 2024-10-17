package org.example.bmicalculator;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label label1; // label1 shows me BMI calculation, in digits
    @FXML
    private Label Result; // results shows me BMI, like obesity or normal


    @FXML
    private TextField text1; // text1 i need to use for calculation in BMI
    @FXML
    private TextField text2; // same like text1
    // clearFields functions delete all information in fields, and give them value " ", for me it is empty
    @FXML
    private void clearFields() {
        text1.clear();
        text2.clear();
        label1.setText("");
        Result.setText("");
    }
    // closeItem func just close the window, and stopped code
    @FXML
    private void closeItem() {
        Platform.exit();
    }
    // show alert window, to show guide, like how to input height
    @FXML
    private void showHelp() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("How to use?");
        alert.setContentText("Input weight (kg).\n \n"
                + "Input height (meters).\n \n");
        alert.showAndWait();
    }
    // onClickButton this part request weight and height, gives weight and height type DOUBLE, then calculate using mathematics functions bmi
    @FXML
    private void onClickButton() {
        try {
            String val1 = text1.getText();
            String val2 = text2.getText();

            double weight = Double.parseDouble(val1);
            double height = Double.parseDouble(val2);

            double bmi = weight / Math.pow(height, 2);
// as you can see then in label1 code shows the bmi using digits
            label1.setText(String.format("BMI: %.2f", bmi));
            // here some operators, and conclusion
            if (bmi < 18.5) {
                Result.setText("Underweight");
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                Result.setText("Normal");
            } else if (bmi >= 25 && bmi <= 29.9) {
                Result.setText("Overweight");
            } else if (bmi >= 30) {
                Result.setText("Obesity");
            }

        } catch (NumberFormatException e) {
            label1.setText("Input your data:");
            Result.setText("");
        }
    }

}


