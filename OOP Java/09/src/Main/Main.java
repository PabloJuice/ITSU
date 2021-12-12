package Main;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.File;
import java.util.*;

public class Main extends Application {
    ObservableList<Sport> sportsList;
    public static void main(String[] args) {
        Application.launch(args);
//G:\STEP\javv\09\src\Main\Sports.txt

    }
    @Override
    public void start(Stage primaryStage){
        primaryStage.setMaxHeight(400);
        primaryStage.setMinHeight(400);
        primaryStage.setMaxWidth(400);
        primaryStage.setMinWidth(400);

        ObservableList<String> sortMethod = FXCollections.observableArrayList("All", "countries <= 50", "50 < countries < 120", "countries => 120");
        ChoiceBox<String> sortingBox = new ChoiceBox<>(sortMethod);
        sortingBox.setValue("All");
        Label lbl = new Label();


        TextArea pathTextArea = new TextArea();
        pathTextArea.setPrefHeight(5);
        pathTextArea.setPrefWidth(300);


        TableView<Sport> table = new TableView<>(sportsList);
        table.setPrefWidth(380);
        table.setPrefHeight(200);

        Button setPath = new Button("Set path");

        setPath.setOnAction(event -> {
            fileLoad(pathTextArea.getText());
            table.setItems(sportsList);
            sortingBox.setValue("All");
        });
        sortingBox.setOnAction(event -> {
            table.setItems(tableSet(sportsList,sortingBox.getValue()));
        });

        TableColumn<Sport, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nameData"));
        nameColumn.prefWidthProperty().bind(table.widthProperty().multiply(0.5));
        TableColumn<Sport, String> countiesColumn = new TableColumn<>("Countries");
        countiesColumn.setCellValueFactory(new PropertyValueFactory<>("countriesData"));
        countiesColumn.prefWidthProperty().bind(table.widthProperty().multiply(0.25));
        TableColumn<Sport, String> isOlympicColumn = new TableColumn<>("Is Olympic");
        isOlympicColumn.setCellValueFactory(new PropertyValueFactory<>("isOlympicData"));
        table.getColumns().addAll(nameColumn, countiesColumn,isOlympicColumn);
        isOlympicColumn.prefWidthProperty().bind(table.widthProperty().multiply(0.25));

        FlowPane root = new FlowPane(10, 10, lbl, pathTextArea, setPath, sortingBox, table);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));

        primaryStage.setTitle("Sport comparator");
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }
    public void fileLoad(String path){

        if(path.endsWith(".txt")){
            try{
                File sportFile = new File(path);
                Scanner scanner = new Scanner(sportFile);
                ArrayList<Sport> sports = new ArrayList<>();
                while (scanner.hasNextLine()){
                    sports.add(new Sport(scanner.next(),scanner.next(), scanner.next()));
                }
                Collections.sort(sports);
                sportsList = FXCollections.observableArrayList(sports);
            }catch (Exception e){
                errMessage("File reading error!");
            }
        }else {
            if (path.contains(":\\")){
                errMessage("Wrong file extension");
            }else {
                errMessage("It's not a file path!");
            }

        }

    }
    public void errMessage(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error!");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public ObservableList<Sport> tableSet(ObservableList<Sport> list, String type){
        ObservableList<Sport> result = FXCollections.observableArrayList();
        if (type.compareTo("50 < countries < 120") == 0){
            for (Object s:list) {
                if(((Sport)s).countries < 120 && ((Sport)s).countries > 50){
                    result.add((Sport)s);
                }
            }
        }
        else if (type.compareTo("countries <= 50") == 0){
            for (Object s:list) {
                if(((Sport)s).countries <= 50){
                    result.add((Sport)s);
                }
            }
        }else if (type.compareTo("countries => 120") == 0){
            for (Object s:list) {
                if(((Sport)s).countries >= 120){
                    result.add((Sport)s);
                }
            }
        }else{
            result = list;
        }

        return result;
    }
}


