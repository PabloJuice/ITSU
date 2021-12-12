package Main;

import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
public class Timer extends Application{
    Label response;
    long startTime, currentTime;
    boolean isStarted = false;
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage myStage) {
        myStage.setTitle("Timer");
        FlowPane root = new FlowPane(10, 10);
        root.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(root, 400, 150);
        myStage.setScene(myScene);

        Button start = new Button("START");
        Button stop = new Button("STOP");
        response = new Label("Timer does not running");
        start.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent ае) {
                startTime = System.currentTimeMillis();
                isStarted = true;
                response.setText("Timer is running..");
            }
        });
        stop.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent ае){
                currentTime = System.currentTimeMillis();
                if(isStarted){
                    response.setText("Elapsed time is " +
                            (currentTime - startTime) / 1000.0);
                    isStarted = false; // !!!!!!!!
                }
            }
        });
        root.getChildren().addAll(start, stop, response);
        myStage.show();
    }
}
