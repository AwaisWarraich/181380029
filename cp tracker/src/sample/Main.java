package sample;

import java.io.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main extends Application {

    TextField marksBox=new TextField();
    DatePicker datePicker=new DatePicker();


    @Override
    public void start(Stage primaryStage) {

        Label titleLabel=new Label("My CP Tracker");

        titleLabel.setFont(new Font("Arial",22));

        Label dateLabel=new Label("Date:");
        dateLabel.setFont(new Font(16));
        Label marksLabel=new Label("Marks:");
        marksLabel.setFont(new Font(16));


        Button saveBtn = new Button("Save Data");
        saveBtn.setFont(new Font(16));
        saveBtn.setOnAction((ActionEvent event) -> {
            save();
        });

        HBox dBox=new HBox(70);
        dBox.getChildren().add(dateLabel);
        dBox.getChildren().add(datePicker);
        dBox.setAlignment(Pos.CENTER);


        HBox mBox=new HBox(70);
        mBox.getChildren().add(marksLabel);
        mBox.getChildren().add(marksBox);
        mBox.setAlignment(Pos.CENTER);

        HBox bBox=new HBox();
        bBox.getChildren().add(saveBtn);
        bBox.setAlignment(Pos.CENTER_RIGHT);
        bBox.setPadding(new Insets(0,20,0,0));



        VBox vb=new VBox(20);
        vb.getChildren().add(titleLabel);
        vb.getChildren().add(dBox);
        vb.getChildren().add(mBox);
        vb.getChildren().add(bBox);
        vb.setAlignment(Pos.CENTER);

        StackPane root = new StackPane();
        root.getChildren().add(vb);


        Scene scene = new Scene(root, 350, 300);
        primaryStage.setTitle("RollNumber CP Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private void save(){
        try(PrintWriter writer=new PrintWriter(new FileWriter("cp.txt",true))){
            String data="----- CP Marks on "+datePicker.getValue().toString()+" ----------\n";
            data+=" Marks: "+marksBox.getText();
            writer.println(data);
            alert(data);
        }catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }

    private void alert(String data){
        Alert a=new Alert(AlertType.INFORMATION);
        a.setTitle("CP Data Saved");
        a.setHeaderText("Your CP data is saved successfully");
        a.setContentText(data);
        a.showAndWait();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
