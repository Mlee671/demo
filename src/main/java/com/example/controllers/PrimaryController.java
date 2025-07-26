package com.example.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

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
    @FXML private Pane rootPane;

    private double firstNumber = 0;
    private double secondNumber = 0;
    private int decimalPlaces = 0;
    private int decimalPlacesResult = 0;
    private boolean isResult = false;

    @FXML
    public void initialize() {
         // Ensure the root pane is focused to capture key events
    }

    private void setLabelText() {
        if (decimalPlaces > 5) {
            label.setText(String.format("%.5f", firstNumber));
        } else if (decimalPlaces > 0) {
            label.setText(String.format("%." + (decimalPlaces-1) + "f", firstNumber));
        } else {
            label.setText(String.valueOf((int) firstNumber));
        }
    }

    private void addToFirstNumber(double value) {
        if (isResult) {
            firstNumber = value; // Reset firstNumber to value if result is displayed
            isResult = false;
            decimalPlaces = 0;
        } else if (decimalPlaces > 0) {
            firstNumber += value / Math.pow(10, decimalPlaces);
            decimalPlaces++;
        } else {
            firstNumber = firstNumber * 10 + value;
        }
        setLabelText();
    }

    private void setOperationLabel(String operation) {
        if (operationLabel.getText().isEmpty()) {
            decimalPlacesResult = decimalPlaces; // Store decimal places for result
            decimalPlaces = 0; // Reset decimal places for next input
            secondNumber = firstNumber;
            firstNumber = 0;
            setLabelText();
            isResult = false;
        }
        operationLabel.setText(operation);
    }

    
    @FXML
    private void onKeyPressed(KeyEvent event) {
        btnEquals.requestFocus();
        if (event.isShiftDown()){
            switch (event.getCode()) {
                case DIGIT8: multiply(); return;
                case EQUALS: add(); return;
                case MINUS: minus(); return;
                default:
                    // Handle other shift key combinations if necessary
                    return; // Exit if no valid key combination is pressed
            }
        }
        switch (event.getCode()) {
            case DIGIT0: zero(); break;
            case NUMPAD0: zero(); break;
            case DIGIT1: one(); break;
            case NUMPAD1: one(); break;
            case DIGIT2: two(); break;
            case NUMPAD2: two(); break;
            case DIGIT3: three(); break;
            case NUMPAD3: three(); break;
            case DIGIT4: four(); break;
            case NUMPAD4: four(); break;
            case DIGIT5: five(); break;
            case NUMPAD5: five(); break;
            case DIGIT6: six(); break;
            case NUMPAD6: six(); break;
            case DIGIT7: seven(); break;
            case NUMPAD7: seven(); break;
            case DIGIT8: eight(); break;
            case NUMPAD8: eight(); break;
            case DIGIT9: nine(); break;
            case NUMPAD9: nine(); break;
            case SLASH: divide(); break;
            case DIVIDE: divide(); break;
            case MULTIPLY: multiply(); break;
            case MINUS: minus(); break;
            case ADD: add(); break;
            case PLUS: add(); break;
            case SUBTRACT: minus(); break;
            case PERIOD: comma(); break;
            case EQUALS: equals(); break;
            default:
                // Handle other keys if necessary
                break;
        }
    }

    @FXML
    private void zero() {
        if (label.getText().equals("0")) {
            return;
        }
        addToFirstNumber(0);
    }

    @FXML
    private void one() {
        addToFirstNumber(1);
    }

    @FXML
    private void two() {
        addToFirstNumber(2);
    }

    @FXML
    private void three() {  
        addToFirstNumber(3);
    }

    @FXML
    private void four() {   
       addToFirstNumber(4);
    }

    @FXML
    private void five() {   
        addToFirstNumber(5);
    }

    @FXML
    private void six() {    
        addToFirstNumber(6);
    }

    @FXML
    private void seven() {          
        addToFirstNumber(7);
    }

    @FXML
    private void eight() {
        addToFirstNumber(8);
    }

    @FXML
    private void nine() {
        addToFirstNumber(9);
    }

    @FXML
    private void divide() {
        setOperationLabel("/");
    }

    @FXML
    private void multiply() {
        setOperationLabel("*");
    }

    @FXML
    private void add() {
        setOperationLabel("+");    
    }

    @FXML
    private void minus() {
       setOperationLabel("-");
    }

    @FXML
    private void comma() {
        if (decimalPlaces > 0) {
            return;
        }
        decimalPlaces = 1;
        setLabelText();
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
        decimalPlaces = decimalPlacesResult; // Restore decimal places for result
        setLabelText();
        operationLabel.setText("");
        isResult = true; // Indicate that the result is displayed
    }
}
