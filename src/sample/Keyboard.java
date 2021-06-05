package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;


import java.io.FileNotFoundException;


public class Keyboard {
    public static void keyboard(TextField console, Pane keyPane) throws FileNotFoundException {

        Button btn1 = new Button("1");
        btn1.setFont(Font.font(18.0));
        btn1.setLayoutX(550.0);
        btn1.setLayoutY(70.0);

        Button btn2=new Button("2");
        btn2.setFont(Font.font(18.0));
        btn2.setLayoutX(630.0);
        btn2.setLayoutY(70.0);

        Button btn3=new Button("3");
        btn3.setFont(Font.font(18.0));
        btn3.setLayoutX(710.0);
        btn3.setLayoutY(70.0);

        Button btn4=new Button("4");
        btn4.setFont(Font.font(18.0));
        btn4.setLayoutX(550.0);
        btn4.setLayoutY(112.0);

        Button btn5=new Button("5");
        btn5.setFont(Font.font(18.0));
        btn5.setLayoutX(630.0);
        btn5.setLayoutY(112.0);

        Button btn6=new Button("6");
        btn6.setFont(Font.font(18.0));
        btn6.setLayoutX(710.0);
        btn6.setLayoutY(112.0);

        Button btn7=new Button("7");
        btn7.setFont(Font.font(18.0));
        btn7.setLayoutX(550.0);
        btn7.setLayoutY(154.0);

        Button btn8=new Button("8");
        btn8.setFont(Font.font(18.0));
        btn8.setLayoutX(630.0);
        btn8.setLayoutY(154.0);

        Button btn9=new Button("9");
        btn9.setFont(Font.font(18.0));
        btn9.setLayoutX(710.0);
        btn9.setLayoutY(154.0);

        Button btn0=new Button("0");
        btn0.setFont(Font.font(18.0));
        btn0.setLayoutX(550.0);
        btn0.setLayoutY(196.0);

        Button btnDot=new Button(".");
        btnDot.setFont(Font.font(18.0));
        btnDot.setLayoutX(630.0);
        btnDot.setLayoutY(196.0);

        Button btnClear=new Button("-");
        btnClear.setFont(Font.font(18.0));
        btnClear.setLayoutX(710.0);
        btnClear.setLayoutY(196.0);


        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {console.appendText("1");
            }
        });

        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {console.appendText("2");
            }
        });

        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {console.appendText("3");
            }
        });

        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {console.appendText("4");
            }
        });

        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {console.appendText("5");
            }
        });

        btn6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {console.appendText("6");
            }
        });

        btn7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {console.appendText("7");
            }
        });

        btn8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {console.appendText("8");
            }
        });

        btn9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {console.appendText("9");
            }
        });

        btn0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {console.appendText("0");
            }
        });

        btnDot.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {console.appendText(".");
            }
        });

        btnClear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {console.setText(console.getText().substring(0,console.getText().length()-1));
            }
        });

        keyPane.getStylesheets().add("sample/Keyboard_Styles.css");
        keyPane.getChildren().add(btn1);
        keyPane.getChildren().add(btn2);
        keyPane.getChildren().add(btn3);
        keyPane.getChildren().add(btn4);
        keyPane.getChildren().add(btn5);
        keyPane.getChildren().add(btn6);
        keyPane.getChildren().add(btn7);
        keyPane.getChildren().add(btn8);
        keyPane.getChildren().add(btn9);
        keyPane.getChildren().add(btn0);
        keyPane.getChildren().add(btnDot);
        keyPane.getChildren().add(btnClear);
    }
}
