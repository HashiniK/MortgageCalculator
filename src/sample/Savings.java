package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Savings extends Application {


    public void start (Stage primaryStage) throws IOException {
        primaryStage.setTitle("Simple Savings");

        // creating a new anchor pane
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.prefHeight(400.0);
        anchorPane.prefWidth(600.0);

        //creating labels and text fields
        Label lblFutureVal = new Label ("Future Value (£)") ;
        lblFutureVal.setLayoutX(37.0);
        lblFutureVal.setLayoutY(60.0);
        lblFutureVal.setFont(Font.font(17.0));

        TextField txtFutureVal = new TextField();
        txtFutureVal.setLayoutX(320.0);
        txtFutureVal.setLayoutY(60.0);
        txtFutureVal.setFont(Font.font(15.0));

        Label lblInterest = new Label("Interest Rate (%)");
        lblInterest.setLayoutX(37.0);
        lblInterest.setLayoutY(110.0);
        lblInterest.setFont(Font.font(17.0));

        TextField txtInterest = new TextField();
        txtInterest.setLayoutX(320.0);
        txtInterest.setLayoutY(110.0);
        txtInterest.setFont(Font.font(15.0));

        Label lblPrinciple= new Label("Principle Amount (£)");
        lblPrinciple.setLayoutX(37.0);
        lblPrinciple.setLayoutY(160.0);
        lblPrinciple.setFont(Font.font(17.0));

        TextField txtPrinciple = new TextField();
        txtPrinciple.setLayoutX(320.0);
        txtPrinciple.setLayoutY(160.0);
        txtPrinciple.setFont(Font.font(15.0));

        Label lblTime= new Label("Time in Months");
        lblTime.setLayoutX(37.0);
        lblTime.setLayoutY(210.0);
        lblTime.setFont(Font.font(17.0));

        TextField txtTime = new TextField();
        txtTime.setLayoutX(320.0);
        txtTime.setLayoutY(210.0);
        txtTime.setFont(Font.font(15.0));

        //creating the buttons
        Button btnCalculate = new Button("Calculate");
        btnCalculate.setLayoutX(115.0);
        btnCalculate.setLayoutY(260.0);
        btnCalculate.setFont(Font.font(16.0));

        Button btnHome = new Button("Home");
        btnHome.setLayoutX(220.0);
        btnHome.setLayoutY(260.0);
        btnHome.setText("Home");
        btnHome.setFont(Font.font(16.0));

        Button btnClear = new Button("Clear");
        btnClear.setLayoutX(300.0);
        btnClear.setLayoutY(260.0);
        btnClear.setFont(Font.font(16.0));

        Button btnHelp = new Button("Help");
        btnHelp.setLayoutX(380.0);
        btnHelp.setLayoutY(260.0);
        btnHelp.setFont(Font.font(16.0));

        Pane root = new Pane();
        root.getStylesheets().add("sample/Savings.css");

        //adding the text fields, buttons and labels to the root pane
        root.getChildren().add(btnCalculate);
        root.getChildren().add(btnHome);
        root.getChildren().add(btnClear);
        root.getChildren().add(btnHelp);
        root.getChildren().add(txtFutureVal);
        root.getChildren().add(lblFutureVal);
        root.getChildren().add(txtInterest);
        root.getChildren().add(lblPrinciple);
        root.getChildren().add(lblInterest);
        root.getChildren().add(txtPrinciple);
        root.getChildren().add(txtTime);
        root.getChildren().add(lblTime);

        primaryStage.setScene(new Scene(root, 600, 450));
        primaryStage.show();

        btnHome.setOnAction(event -> {
            OpenMenu openMenu = new OpenMenu();
            try {
                openMenu.start(primaryStage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnCalculate.setOnAction(event->
        {
            Formulas.savings(txtPrinciple,txtInterest,txtTime,txtFutureVal);
            try {
                filewriting.Simple_Savings("savings", txtPrinciple.getText(), txtInterest.getText(), txtTime.getText(), txtFutureVal.getText());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        btnClear.setOnAction(event -> {
            txtFutureVal.setText("");
            txtInterest.setText("");
            txtPrinciple.setText("");
            txtTime.setText("");
        });

        btnHelp.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("* Future Value - The final sum value the user expects to have earned after investing a present value for a specified amount of time.This will be calculated in pounds (£).\n \n * Interest Rate - The annual nominal rate or the agreed rate in percent.\n \n * Principle Value -  The start value of the investment. This will be taken in pounds (£).\n \n * Time in Months -  The time period in months the user wishes to invest. \n \n ** Please leave the field that needs to be calculated empty!.");
            alert.show();
        });

        //creating the connection between the keyboard and the text fields
        txtFutureVal.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Keyboard.keyboard(txtFutureVal, root);
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
