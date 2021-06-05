package sample;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class History{
    public void start(Stage historyStage) throws FileNotFoundException {

        //creating the history stage
        historyStage.setTitle("History");

        //creating grid pane
        GridPane historyPane = new GridPane();


        Scene sceneHistory = new Scene(historyPane,600,400);

        TabPane tabPane = new TabPane();

        //adding tab to compound savings
        Tab tabCompoundSaving = new Tab("Compound Savings");
        tabPane.getTabs().addAll(tabCompoundSaving);
        ScrollPane scrollCompoundSaving = new ScrollPane();
        tabCompoundSaving.setContent(scrollCompoundSaving);
        Pane paneCompoundSaving = new Pane();
        scrollCompoundSaving.setContent(paneCompoundSaving);
        TextArea lblCompoundSaving = new TextArea();
        paneCompoundSaving.getChildren().add(lblCompoundSaving);

        //adding tab to simple savings
        Tab tabSimpleSaving = new Tab("Simple Savings");
        tabPane.getTabs().addAll(tabSimpleSaving);
        ScrollPane scrollSimpleSaving = new ScrollPane();
        tabSimpleSaving.setContent(scrollSimpleSaving);
        Pane paneSimpleSaving = new Pane();
        scrollSimpleSaving.setContent(paneSimpleSaving);
        TextArea lblSimpleSaving = new TextArea();
        paneSimpleSaving.getChildren().add(lblSimpleSaving);

        //adding tab to mortgage
        Tab tabMortgage = new Tab("Mortgage");
        tabPane.getTabs().addAll(tabMortgage);
        ScrollPane scrollMortgage = new ScrollPane();
        tabMortgage.setContent(scrollMortgage);
        Pane paneMortgage = new Pane();
        scrollMortgage.setContent(paneMortgage);
        TextArea lblMortgage = new TextArea();
        paneMortgage.getChildren().add(lblMortgage);

        //adding tab to loan
        Tab tabLoan = new Tab("Loan Savings");
        tabPane.getTabs().addAll(tabLoan);
        ScrollPane scrollPane = new ScrollPane();
        tabLoan.setContent(scrollPane);
        Pane paneLoan= new Pane();
        scrollPane.setContent(paneLoan);
        TextArea lblLoan = new TextArea("");
        paneLoan.getChildren().add(lblLoan);

        Button btnHome = new Button("Home");
        btnHome.setText("Home");
        btnHome.setFont(Font.font(12.0));

        //reading the files from each file and label
        fileRead.readfile("savings",lblSimpleSaving);
        fileRead.readfile("compound",lblCompoundSaving);
        fileRead.readfile("loan",lblLoan);
        fileRead.readfile("mortgage",lblMortgage);

        //creating scroll pane to add the labels
        scrollPane.setContent(lblLoan);
        scrollCompoundSaving.setContent(lblCompoundSaving);
        scrollMortgage.setContent(lblMortgage);
        scrollSimpleSaving.setContent(lblSimpleSaving);

        //adding tab pane to historyPane
        historyPane.getChildren().add(tabPane);
        historyPane.addColumn(8,btnHome);
        historyStage.setScene(sceneHistory);
        historyStage.show();

        btnHome.setOnAction(e ->
        {
            OpenMenu openMenu = new OpenMenu();
            try {
                openMenu.start(historyStage);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });

    }

}

