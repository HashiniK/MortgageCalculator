package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class OpenMenu extends Application {

    @Override
    public void start (Stage primaryStage) throws IOException {
        primaryStage.setTitle("Finance Calculator");

        Label lblHeading = new Label("Finance Calculator");
        lblHeading.setLayoutX(37.0);
        lblHeading.setLayoutY(145.0);
        lblHeading.prefHeight(48.0);
        lblHeading.prefWidth(269.0);
        lblHeading.setFont(Font.font(36.0));

        Button btnCompoundIS = new Button("Compound Interest Savings");
        btnCompoundIS.setLayoutX(352.0);
        btnCompoundIS.setLayoutY(59.0);
        btnCompoundIS.setFont(Font.font(18.0));

        Button btnSavings = new Button("Savings");
        btnSavings.setLayoutX(352.0);
        btnSavings.setLayoutY(119.0);
        btnSavings.setFont(Font.font(18.0));

        Button btnLoans = new Button("Loans");
        btnLoans.setLayoutX(352.0);
        btnLoans.setLayoutY(179.0);
        btnLoans.setFont(Font.font(18.0));

        Button btnMortgage = new Button ("Mortgage");
        btnMortgage.setLayoutX(352.0);
        btnMortgage.setLayoutY(239.0);
        btnMortgage.setFont(Font.font(18.0));

        Button btnHistory = new Button("History");
        btnHistory.setLayoutX(352.0);
        btnHistory.setLayoutY(299.0);
        btnHistory.setFont(Font.font(18.0));

        Button btnQuit = new Button("Quit");
        btnQuit.setLayoutX(352.0);
        btnQuit.setLayoutY(359.0);
        btnQuit.setFont(Font.font(18.0));

        Pane root = new Pane();
        root.getStylesheets().add("sample/Home_Styles.css");

        root.getChildren().add(btnMortgage);
        root.getChildren().add(btnCompoundIS);
        root.getChildren().add(btnLoans);
        root.getChildren().add(btnSavings);
        root.getChildren().add(btnHistory);
        root.getChildren().add(lblHeading);
        root.getChildren().add(btnQuit);

        primaryStage.setScene(new Scene(root, 620, 430));
        primaryStage.show();

        btnSavings.setOnAction(event -> {
            Savings Savings = new Savings();
            try {
                Savings.start(primaryStage);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });

        btnMortgage.setOnAction(event -> {
            Mortgage mortgage = new Mortgage();
            try {
                mortgage.start(primaryStage);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });
        btnHistory.setOnAction(e->{
            History history = new History();
            try {
                history.start(primaryStage);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

        btnCompoundIS.setOnAction(event -> {
            Compound compound = new Compound();
            try {
                compound.start(primaryStage);
            }catch (IOException exception){
                exception.printStackTrace();
            }
                });

        btnLoans.setOnAction(event -> {
            Loan loan = new Loan();
            try
            {
                loan.start(primaryStage);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });

        btnQuit.setOnAction(event -> {
            primaryStage.close();
        });
    }
}
