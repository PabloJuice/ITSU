package Main;

import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;

public class Encoder extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Code Mahina");
        FlowPane root = new FlowPane(10, 10);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        TextArea mainTextArea = new TextArea();
        mainTextArea.setPrefHeight(10);
        mainTextArea.setPrefWidth(400);
        Label resultTextLabel = new Label("");
        resultTextLabel.setPrefHeight(5);
        resultTextLabel.setPrefWidth(400);
        resultTextLabel.setPadding(new Insets(25));
        root.getChildren().addAll(new Label("Plain Text:"), mainTextArea, resultTextLabel);

        Button encode = new Button("Encode");
        Button decode = new Button("Decode");
        Button reset = new Button("Reset");

        encode.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent ае)
            {
                StringBuilder plainText = new StringBuilder(mainTextArea.getText());
                for(int i = 0; i < plainText.length(); i++) {
                    plainText.setCharAt(i, (char)(plainText.charAt(i)+1));
                }
                resultTextLabel.setText(plainText.toString());
            }
        });
        decode.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent ае)
            {
                StringBuilder cipherText = new StringBuilder(mainTextArea.getText());
                for(int i = 0; i < cipherText.length(); i++) {
                    cipherText.setCharAt(i, (char)(cipherText.charAt(i)-1));
                }
                resultTextLabel.setText(cipherText.toString());
            }
        });
        reset.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent ае)
            {
                mainTextArea.setText("");
                resultTextLabel.setText("");
            }
        });
        HBox hbox = new HBox(encode, decode, reset);
        root.getChildren().add(hbox);

        Scene scene = new Scene(root, 500, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
