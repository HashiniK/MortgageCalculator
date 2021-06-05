package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


import java.io.FileNotFoundException;
import java.io.IOException;

public class Compound extends Application {
    public void start(Stage primaryStage) throws IOException {
        //creating the primary stage
        primaryStage.setTitle("Compound Savings");

        //creating the grid pane
        GridPane keyPane = new GridPane();

        //Textfield console
        TextField console = new TextField();

        //creating the labels
        Label lblFutureValue = new Label ("Future Value (£)");
        lblFutureValue.setLayoutX(37.0);
        lblFutureValue.setLayoutY(60.0);
        lblFutureValue.setFont(Font.font(17.0));

        TextField txtFutureValue = new TextField();
        txtFutureValue.setLayoutX(320.0);
        txtFutureValue.setLayoutY(60.0);
        txtFutureValue.setFont(Font.font(15.0));

        Label lblPrinciple = new Label("Principle Amount (£)");
        lblPrinciple.setLayoutX(37.0);
        lblPrinciple.setLayoutY(110.0);
        lblPrinciple.setFont(Font.font(17.0));

        TextField txtPrinciple = new TextField();
        txtPrinciple.setLayoutX(320.0);
        txtPrinciple.setLayoutY(110.0);
        txtPrinciple.setFont(Font.font(15.0));

        Label lblTime = new Label("Time Period in Months");
        lblTime.setLayoutX(37.0);
        lblTime.setLayoutY(160.0);
        lblTime.setFont(Font.font(17.0));

        TextField txtTime = new TextField();
        txtTime.setLayoutX(320.0);
        txtTime.setLayoutY(160.0);
        txtTime.setFont(Font.font(15.0));

        Label lblInterest = new Label("Interest Rate (%)");
        lblInterest.setLayoutX(37.0);
        lblInterest.setLayoutY(210.0);
        lblInterest.setFont(Font.font(17.0));

        TextField txtInterest = new TextField();
        txtInterest.setLayoutX(320.0);
        txtInterest.setLayoutY(210.0);
        txtInterest.setFont(Font.font(15.0));

        TextField txtMonthlyPay = new TextField();
        txtMonthlyPay.setLayoutX(320.0);
        txtMonthlyPay.setLayoutY(260.0);
        txtMonthlyPay.setFont(Font.font(15.0));

        Label lblMonthlyPay = new Label("Monthly Payment (£)");
        lblMonthlyPay.setLayoutX(37);
        lblMonthlyPay.setLayoutY(260.0);
        lblMonthlyPay.setFont(Font.font(17.0));

        //creating Buttons to calculate, clear and home
        Button btnCalculate = new Button("Calculate");
        btnCalculate.setLayoutX(115.0);
        btnCalculate.setLayoutY(310.0);
        btnCalculate.setText("Calculate");
        btnCalculate.setFont(Font.font(16.0));

        Button btnHome = new Button("Home");
        btnHome.setLayoutX(220.0);
        btnHome.setLayoutY(310.0);
        btnHome.setFont(Font.font(16.0));

        Button btnClear = new Button("Clear");
        btnClear.setLayoutX(310.0);
        btnClear.setLayoutY(310.0);
        btnClear.setFont(Font.font(16.0));

        Button btnHelp = new Button("Help");
        btnHelp.setLayoutX(390.0);
        btnHelp.setLayoutY(310.0);
        btnHelp.setFont(Font.font(16.0));

        Pane root = new Pane();
        root.getStylesheets().add("sample/Compound_Styles.css");

        //adding the labels,buttons and textfields to the root pane
        root.getChildren().add(lblPrinciple);
        root.getChildren().add(lblTime);
        root.getChildren().add(lblFutureValue);
        root.getChildren().add(lblMonthlyPay);
        root.getChildren().add(lblInterest);
        root.getChildren().add(txtPrinciple);
        root.getChildren().add(txtTime);
        root.getChildren().add(txtMonthlyPay);
        root.getChildren().add(txtFutureValue);
        root.getChildren().add(txtInterest);
        root.getChildren().add(btnClear);
        root.getChildren().add(btnCalculate);
        root.getChildren().add(btnHome);
        root.getChildren().add(btnHelp);
        primaryStage.setScene(new Scene(root, 600, 445));
        primaryStage.show();

        //setting on actions to buttons
        btnHome.setOnAction(event -> {
            OpenMenu openMenu = new OpenMenu();
            try {
                openMenu.start(primaryStage);
            } catch(IOException exception){
                exception.printStackTrace();
            }
        });

        btnClear.setOnAction(event -> {
            txtFutureValue.setText("");
            txtInterest.setText("");
            txtMonthlyPay.setText("");
            txtPrinciple.setText("");
            txtTime.setText("");
        });

        btnCalculate.setOnAction(event -> {
            Formulas.compound(txtFutureValue,txtInterest,txtPrinciple,txtMonthlyPay,txtTime);
            try {
                filewriting.Compound_Interest("compound", txtFutureValue.getText(), txtInterest.getText(), txtPrinciple.getText(), txtMonthlyPay.getText(),txtTime.getText());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        //help view
        btnHelp.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("* Future Value - The final sum value the user expects to have earned after investing a present value for a specified amount of time.This will be calculated in pounds (£).\n \n * Interest Rate - The annual nominal rate or the agreed rate in percent.\n \n * Principle Value -  The start value of the investment. This will be taken in pounds (£).\n \n * Monthly Payment - The nominal or the agreed value to be paid periodically. This will be taken in pounds (£). \n \n * Time in Months -  The time period in months the user wishes to invest. \n \n ** Please leave the field that needs to be calculated empty!. ");
            alert.setTitle("Help");
            alert.show();
        });

        //creating the connection between the keyboard and the text fields
        txtFutureValue.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Keyboard.keyboard(txtFutureValue, root);
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        });
        txtInterest.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Keyboard.keyboard(txtInterest, root);
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        });
        txtMonthlyPay.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Keyboard.keyboard(txtMonthlyPay, root);
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        });
        txtPrinciple.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Keyboard.keyboard(txtPrinciple, root);
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        });
        txtTime.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Keyboard.keyboard(txtTime, root);
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        });

    }
}
