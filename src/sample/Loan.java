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


public class Loan extends Application{
        public void start (Stage primaryStage) throws IOException {

                //creating the primary stage
                primaryStage.setTitle("Fixed Periodic Payment");
                Stage loan;
                loan = primaryStage;
                loan.setTitle("Loan Calculator");


                // creating a new anchor pane
                AnchorPane anchorPane = new AnchorPane();
                anchorPane.prefHeight(400.0);
                anchorPane.prefWidth(600.0);


                //creating labels and textfields
                Label lblLoan = new Label ("Loan Amount (£)") ;
                lblLoan.setLayoutX(37.0);
                lblLoan.setLayoutY(60.0);
                lblLoan.setFont(Font.font(17.0));

                TextField txtLoan = new TextField();
                txtLoan.setLayoutX(320.0);
                txtLoan.setLayoutY(60.0);
                txtLoan.setFont(Font.font(15.0));

                Label lblInterest = new Label("Interest Rate (%)");
                lblInterest.setLayoutX(37.0);
                lblInterest.setLayoutY(110.0);
                lblInterest.setFont(Font.font(17.0));

                TextField txtInterest = new TextField();
                txtInterest.setLayoutX(320.0);
                txtInterest.setLayoutY(110.0);
                txtInterest.setFont(Font.font(15.0));

                Label lblLoanTerm= new Label("Loan Term");
                lblLoanTerm.setLayoutX(37.0);
                lblLoanTerm.setLayoutY(160.0);
                lblLoanTerm.setFont(Font.font(17.0));

                TextField txtLoanTerm = new TextField();
                txtLoanTerm.setLayoutX(320.0);
                txtLoanTerm.setLayoutY(160.0);
                txtLoanTerm.setFont(Font.font(15.0));

                Label lblMonthlyPay= new Label("Monthly Payment");
                lblMonthlyPay.setLayoutX(37.0);
                lblMonthlyPay.setLayoutY(210.0);
                lblMonthlyPay.setFont(Font.font(17.0));

                TextField txtMonthlyPay = new TextField();
                txtMonthlyPay.setLayoutX(320.0);
                txtMonthlyPay.setLayoutY(210.0);
                txtMonthlyPay.setFont(Font.font(15.0));

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
                root.getStylesheets().add("sample/Loan_Styles.css");

                //adding the labels,buttons and textfields to the root pane
                root.getChildren().add(btnCalculate);
                root.getChildren().add(btnHome);
                root.getChildren().add(btnClear);
                root.getChildren().add(btnHelp);
                root.getChildren().add(txtLoan);
                root.getChildren().add(lblLoan);
                root.getChildren().add(txtInterest);
                root.getChildren().add(lblLoanTerm);
                root.getChildren().add(lblInterest);
                root.getChildren().add(txtLoanTerm);
                root.getChildren().add(txtMonthlyPay);
                root.getChildren().add(lblMonthlyPay);

                primaryStage.setScene(new Scene(root, 800, 440));
                primaryStage.show();


                //setting on actions for buttons
                btnHome.setOnAction(e ->
                {
                        OpenMenu openMenu = new OpenMenu();
                        try {
                                openMenu.start(primaryStage);
                        } catch (IOException exception) {
                                exception.printStackTrace();
                        }
                });
                btnCalculate.setOnAction(event ->
                {
                        Formulas.loan(txtLoan,txtInterest, txtLoanTerm, txtMonthlyPay);
                        try {
                                filewriting.Loan("loan", txtLoan.getText(), txtInterest.getText(), txtLoanTerm.getText(), txtMonthlyPay.getText());
                        } catch (IOException ioException) {
                                ioException.printStackTrace();
                        }
                });
                btnClear.setOnAction(event ->

                {
                        txtInterest.setText("");
                        txtInterest.setText("");
                        txtLoan.setText("");
                        txtMonthlyPay.setText("");
                });

                btnHelp.setOnAction(event -> {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("* Loan Amount - The sum value of the loan.This will be calculated in pounds (£).\n \n * Interest Rate - The annual nominal rate or the agreed rate in percent.\n \n * Monthly Payment -  The nominal or the agreed value to be paid periodically. This will be taken in pounds (£).\n \n * Loan Term -  The time period in months the user has to pay off the loan. \n \n ** Please leave the field that needs to be calculated empty!.");
                        alert.setTitle("Help");
                        alert.show();

                });

                //creating the connection between the keyboard and the text fields
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
                txtLoanTerm.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                                try {
                                        Keyboard.keyboard(txtLoanTerm, root);
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




        }
}