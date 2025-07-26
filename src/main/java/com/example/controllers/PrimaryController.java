package com.example.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

// com.example.controllers.PrimaryController

public class PrimaryController {

    @FXML private Label label;
    @FXML private Label operationLabel;
    @FXML private Button btnZero;
    @FXML private Button btnOne;
    @FXML private Button btnTwo;
    @FXML private Button btnThree;
    @FXML private Button btnFour;
    @FXML private Button btnFive;
    @FXML private Button btnSix;
    @FXML private Button btnSeven;
    @FXML private Button btnEight;
    @FXML private Button btnNine;
    @FXML private Button btnDivide;
    @FXML private Button btnMulitply;
    @FXML private Button btnAdd;
    @FXML private Button btnMinus;
    @FXML private Button btnComma;
    @FXML private Button btnEquals;

    private double firstNumber = 0;
    private double secondNumber = 0;
    private boolean isResult = false;

    private void setLabelText() {
        label.setText(String.valueOf(firstNumber));
    }

    @FXML
    private void zero() {
        if (label.getText().equals("0")) {
            return;
        }
        if (isResult) {
            firstNumber = 0; // Reset firstNumber to 0 if result is displayed
            isResult = false;
        } else {
            firstNumber = firstNumber * 10;
        }
        setLabelText();
    }

    @FXML
    private void one() {
        if (isResult) {
            firstNumber = 1;    
            isResult = false;
        } else {
            firstNumber = firstNumber * 10 + 1;
        }
        setLabelText();
    }

    @FXML
    private void two() {
        if (isResult) {
            firstNumber = 2;    
            isResult = false;
        } else {
            firstNumber = firstNumber * 10 + 2;
        }
        setLabelText();
    }

    @FXML
    private void three() {  
        if (isResult) {
            firstNumber = 3;
            isResult = false;
        } else {
            firstNumber = firstNumber * 10 + 3;
            
        }
        setLabelText();
    }

    @FXML
    private void four() {   
        if (isResult) {
            firstNumber = 4;
            isResult = false;
        } else {
            firstNumber = firstNumber * 10 + 4;
        }
        setLabelText();
    }

    @FXML
    private void five() {   
        if (isResult) {
            firstNumber = 5;
            isResult = false;
        } else {
            firstNumber = firstNumber * 10 + 5;
        }
        setLabelText();
    }

    @FXML
    private void six() {    
        if (isResult) {
            firstNumber = 6;
            isResult = false;
        } else {
            firstNumber = firstNumber * 10 + 6;
        }
        setLabelText();
    }

    @FXML
    private void seven() {          
        if (isResult) {
            firstNumber = 7;
            isResult = false;
        } else {
            firstNumber = firstNumber * 10 + 7;
        }
        setLabelText();
    }

    @FXML
    private void eight() {
        if (isResult) {
            firstNumber = 8; // Reset firstNumber to 8 if result is displayed
            isResult = false;
        } else {
            firstNumber = firstNumber * 10 + 8;
        }
        setLabelText();
    }

    @FXML
    private void nine() {
        if (isResult) {
            firstNumber = 9; // Reset firstNumber to 9 if result is displayed
            isResult = false;
        } else {
            firstNumber = firstNumber * 10 + 9;
        }
        setLabelText();
    }

    @FXML
    private void divide() {
        if (operationLabel.getText().isEmpty()) {
            secondNumber = firstNumber;
            firstNumber = 0;
            setLabelText();
            isResult = false;
        }
        operationLabel.setText("/");
    }

    @FXML
    private void multiply() {
        if (operationLabel.getText().isEmpty()) {
            secondNumber = firstNumber;
            firstNumber = 0;
            setLabelText();
            isResult = false;
        }
        operationLabel.setText("*");
    }

    @FXML
    private void add() {
        if (operationLabel.getText().isEmpty()) {
            secondNumber = firstNumber;
            firstNumber = 0;
            setLabelText();
            isResult = false;
        }
        operationLabel.setText("+");    
    }

    @FXML
    private void minus() {
        if (operationLabel.getText().isEmpty()) {
            secondNumber = firstNumber;
            firstNumber = 0;
            setLabelText();
            isResult = false;
        }
        operationLabel.setText("-");
    }

    @FXML
    private void comma() {
        if (label.getText().contains(".")) {
            return;
        }
        label.setText(label.getText() + ".");
    }
    @FXML
    private void equals() {
        if (operationLabel.getText().isEmpty()) {
            return;
        }
        switch (operationLabel.getText()) {
            case "+":
                firstNumber = secondNumber + firstNumber;
                break;
            case "-":
                firstNumber = secondNumber - firstNumber;
                break;
            case "*":
                firstNumber = secondNumber * firstNumber;
                break;
            case "/":
                if (firstNumber == 0) {
                    label.setText("Error");
                    return;
                }
                firstNumber = secondNumber / firstNumber;
                break;
        }
        setLabelText();
        operationLabel.setText("");
        isResult = true; // Indicate that the result is displayed
    }
}
