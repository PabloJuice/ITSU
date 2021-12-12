package Main;

import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;

public class Dispatcher extends Application implements EventHandler<ActionEvent>{
    TextArea plainTextArea = new TextArea();
    TextArea cipherTextArea = new TextArea();
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Code Mahina");
        FlowPane root = new FlowPane(10, 10);
        root.setPadding(new Insets(10)); // ???
        plainTextArea.setPrefHeight(5);
        plainTextArea.setPrefWidth(400);
        HBox boxHigh = new HBox(10, new Label("Plain Text:"), plainTextArea);
        boxHigh.setAlignment(Pos.CENTER);
        cipherTextArea.setPrefHeight(5);
        cipherTextArea.setPrefWidth(390);
        HBox boxMiddle=new HBox(10, new Label("Cipher Text:"), cipherTextArea);
        boxMiddle.setAlignment(Pos.CENTER);
        Button encode = new Button("Encode");
        Button decode = new Button("Decode");
        Button reset = new Button("Reset");

        encode.setOnAction(this);
        decode.setOnAction(this);
        reset.setOnAction(this);

        HBox boxLow = new HBox(10, encode, decode, reset);
        boxLow.setAlignment(Pos.CENTER);
        VBox box = new VBox(10, boxHigh, boxMiddle, boxLow);
        box.setAlignment(Pos.CENTER);

        root.getChildren().add(box);

        Scene scene = new Scene(root, 500, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void handle(ActionEvent ае){
        switch(((Button)(ае.getSource())).getText()){
            case "Encode":
                StringBuilder plainText = new StringBuilder(plainTextArea.getText());
                for(int i = 0; i < plainText.length(); i++) {
                    plainText.setCharAt(i, (char)(plainText.charAt(i)+1));
                }
                cipherTextArea.setText(plainText.toString());
                break;
            case "Decode":
                StringBuilder cipherText = new StringBuilder(cipherTextArea.getText());
                for(int i = 0; i < cipherText.length(); i++) {
                    cipherText.setCharAt(i, (char)(cipherText.charAt(i)-1));
                }
                plainTextArea.setText(cipherText.toString());
                break;
            case "Reset":
                plainTextArea.setText("");
                cipherTextArea.setText("");
        }
    }
}
