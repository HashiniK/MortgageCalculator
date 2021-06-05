package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Mortgage extends Application{

    public void start (Stage primaryStage) throws IOException{
        //creating the primary stage
        primaryStage.setTitle("Fixed Periodic Payment");

        //creating the labels
        Label lblHomePrice = new Label ("Home Price (£)");
        lblHomePrice.setLayoutX(37.0);
        lblHomePrice.setLayoutY(60.0);
        lblHomePrice.setFont(Font.font(17.0));

        TextField txtHomePrice = new TextField();
        txtHomePrice.setLayoutX(320.0);
        txtHomePrice.setLayoutY(60.0);
        txtHomePrice.setFont(Font.font(15.0));

        Label lblDownPay = new Label("Down Payment (£)");
        lblDownPay.setLayoutX(37.0);
        lblDownPay.setLayoutY(110.0);
        lblDownPay.setFont(Font.font(17.0));

        TextField txtDownPay = new TextField();
        txtDownPay.setLayoutX(320.0);
        txtDownPay.setLayoutY(110.0);
        txtDownPay.setFont(Font.font(15.0));

        Label lblLoan = new Label("Loan Term");
        lblLoan.setLayoutX(37.0);
        lblLoan.setLayoutY(160.0);
        lblLoan.setFont(Font.font(17.0));

        TextField txtLoan = new TextField();
        txtLoan.setLayoutX(320.0);
        txtLoan.setLayoutY(160.0);
        txtLoan.setFont(Font.font(15.0));

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
        root.getStylesheets().add("sample/Mortgage_Styles.css");

        root.getChildren().add(lblLoan);
        root.getChildren().add(lblHomePrice);
        root.getChildren().add(lblDownPay);
        root.getChildren().add(lblMonthlyPay);
        root.getChildren().add(lblInterest);
        root.getChildren().add(txtLoan);
        root.getChildren().add(txtHomePrice);
        root.getChildren().add(txtMonthlyPay);
        root.getChildren().add(txtDownPay);
        root.getChildren().add(txtInterest);
        root.getChildren().add(btnClear);
        root.getChildren().add(btnCalculate);
        root.getChildren().add(btnHome);
        root.getChildren().add(btnHelp);

        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();


        btnCalculate.setOnAction(event -> {
            
            Formulas.mortgage(txtHomePrice, txtDownPay, txtLoan,txtInterest,txtMonthlyPay);
            try {
                filewriting.Mortgage("mortgage", txtHomePrice.getText(), txtDownPay.getText(), txtLoan.getText(), txtInterest.getText(),txtMonthlyPay.getText());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        btnHome.setOnAction(event -> {
            OpenMenu openMenu = new OpenMenu();
            try {
                openMenu.start(primaryStage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnClear.setOnAction(event -> {
            txtDownPay.setText("");
            txtInterest.setText("");
            txtHomePrice.setText("");
            txtLoan.setText("");
            txtMonthlyPay.setText("");
        });

        btnHelp.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("* Home Price - The sum value of the house the mortgage will be taken for.This will be calculated in pounds (£).\n \n * Down Payment - The initial payment made at the beginning of the process. This will be calculated in pounds (£). \n \n * Loan Term - The period of time in months the user has to pay off the mortgage. \n \n * Interest Rate - The annual nominal rate or the agreed rate in percent.\n \n * Monthly Payment -  The nominal or the agreed value to be paid periodically. This will be taken in pounds (£). \n \n ** Please leave the field that needs to be calculated empty!. ");
            alert.setTitle("Help");
            alert.show();
        });

        txtLoan.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Keyboard.keyboard(txtLoan, root);
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        });
        txtDownPay.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Keyboard.keyboard(txtDownPay, root);
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
        txtHomePrice.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try{
                    Keyboard.keyboard(txtHomePrice,root);
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        });
    }
}
