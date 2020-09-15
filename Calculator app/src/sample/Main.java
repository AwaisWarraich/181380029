package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {


        private Label viewLabel;

        private Button cButton, powerButton, squareButton, plusButton,
                divideButton, dotButton, zeroButton, oneButton,
                miniButton, twoButton, threeButton, fourButton, fiveButton,
                sixButton, sevenButton, eightButton, nineButton,
                multiplyButton, combineButton, equalButton;
        private HBox root1, root2, root3, root4, root5, root6;
        private VBox mainRoot;
        @Override
        public void start (Stage primaryStage) throws Exception {

            //setLabel
            viewLabel = new Label("0");

            root1 = new HBox(20, viewLabel);
            viewLabel.setFont(new Font(36));
            root1.setAlignment(Pos.CENTER_RIGHT);

            //setButton for root1


            cButton = new Button("C");
            cButton.setPrefWidth(120);
            cButton.setPrefHeight(60);

            powerButton = new Button("x^2");
            powerButton.setPrefHeight(60);
            powerButton.setPrefWidth(120);

            squareButton = new Button("Sqrt");
            squareButton.setPrefWidth(120);
            squareButton.setPrefHeight(60);

            divideButton = new Button("/");
            divideButton.setPrefWidth(120);
            divideButton.setPrefHeight(60);

            root2 = new HBox(cButton, powerButton, squareButton, divideButton);
            root2.setAlignment(Pos.BOTTOM_CENTER);

            sevenButton = new Button("7");
            sevenButton.setPrefHeight(60);
            sevenButton.setPrefWidth(120);

            eightButton = new Button("8");
            eightButton.setPrefWidth(120);
            eightButton.setPrefHeight(60);

            nineButton = new Button("9");
            nineButton.setPrefHeight(60);
            nineButton.setPrefWidth(120);

            multiplyButton = new Button("x");
            multiplyButton.setPrefWidth(120);
            multiplyButton.setPrefHeight(60);

            root3 = new HBox(sevenButton, eightButton, nineButton, multiplyButton);
            root3.setAlignment(Pos.BOTTOM_CENTER);

            fourButton = new Button("4");
            fourButton.setPrefHeight(60);
            fourButton.setPrefWidth(120);

            fiveButton = new Button("5");
            fiveButton.setPrefHeight(60);
            fiveButton.setPrefWidth(120);

            sixButton = new Button("6");
            sixButton.setPrefHeight(60);
            sixButton.setPrefWidth(120);

            miniButton = new Button("-");
            miniButton.setPrefHeight(60);
            miniButton.setPrefWidth(120);


            root4 = new HBox(fourButton, fiveButton, sixButton, miniButton);
            root4.setAlignment(Pos.BOTTOM_CENTER);

            oneButton = new Button("1");
            oneButton.setPrefHeight(60);
            oneButton.setPrefWidth(120);

            twoButton = new Button("2");
            twoButton.setPrefHeight(60);
            twoButton.setPrefWidth(120);


            threeButton = new Button("3");
            threeButton.setPrefHeight(60);
            threeButton.setPrefWidth(120);

            plusButton = new Button("+");
            plusButton.setPrefHeight(60);
            plusButton.setPrefWidth(120);

            root5 = new HBox(oneButton, twoButton, threeButton, plusButton);
            root5.setAlignment(Pos.BOTTOM_CENTER);

            combineButton = new Button("+/-");
            combineButton.setPrefHeight(60);
            combineButton.setPrefWidth(120);

            zeroButton = new Button("0");
            zeroButton.setPrefHeight(60);
            zeroButton.setPrefWidth(120);

            dotButton = new Button(".");
            dotButton.setPrefHeight(60);
            dotButton.setPrefWidth(120);

            equalButton = new Button("=");
            equalButton.setPrefHeight(60);
            equalButton.setPrefWidth(120);

            root6 = new HBox(combineButton, zeroButton, dotButton, equalButton);
            root6.setAlignment(Pos.BOTTOM_CENTER);

            //set click listner on button
            getAllValue setLabelValue = new getAllValue();
            oneButton.setOnAction(setLabelValue);
            twoButton.setOnAction(setLabelValue);
            threeButton.setOnAction(setLabelValue);
            fourButton.setOnAction(setLabelValue);
            fiveButton.setOnAction(setLabelValue);
            sixButton.setOnAction(setLabelValue);
            sevenButton.setOnAction(setLabelValue);
            eightButton.setOnAction(setLabelValue);
            nineButton.setOnAction(setLabelValue);
            zeroButton.setOnAction(setLabelValue);

            //button operation
            action action = new action();
            divideButton.setOnAction(action);
            cButton.setOnAction(action);
            squareButton.setOnAction(action);
            powerButton.setOnAction(action);
            equalButton.setOnAction(action);
            multiplyButton.setOnAction(action);
            miniButton.setOnAction(action);
            plusButton.setOnAction(action);

            //mainRoot
            mainRoot = new VBox(root1, root2, root3, root4, root5, root6);
            Scene scene = new Scene(mainRoot, 400, 350);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Calculator-181380017");
            primaryStage.show();


        }


        private class getAllValue implements EventHandler<ActionEvent> {

            @Override
            public void handle(ActionEvent event) {
                if (event.getSource() == sevenButton) {
                    viewLabel.setText("7");
                } else if (event.getSource() == eightButton) {
                    viewLabel.setText("8");
                }
                if (event.getSource() == nineButton) {
                    viewLabel.setText("9");
                } else if (event.getSource() == fourButton) {
                    viewLabel.setText("4");
                }
                if (event.getSource() == fiveButton) {
                    viewLabel.setText("5");
                } else if (event.getSource() == sixButton) {
                    viewLabel.setText("6");
                }
                if (event.getSource() == oneButton) {
                    viewLabel.setText("1");
                } else if (event.getSource() == twoButton) {
                    viewLabel.setText("2");
                }
                if (event.getSource() == threeButton) {
                    viewLabel.setText("3");
                } else if (event.getSource() == zeroButton) {
                    viewLabel.setText("0");
                }
            }
        }


        //perform action
        public class action implements EventHandler<ActionEvent> {
            double v, number;
            String str;

            @Override
            public void handle(ActionEvent event) {
                if (event.getSource() == cButton) {
                    viewLabel.setText("0");
                } else if (event.getSource() == powerButton) {
                    v = getDouble(viewLabel);
                    v = Math.pow(v, 2);
                    viewLabel.setText(v + "");
                } else if (event.getSource() == squareButton) {
                    v = getDouble(viewLabel);
                    System.out.println(v);
                    v = Math.sqrt(v);
                    viewLabel.setText(v + "");
                } else if (event.getSource() == divideButton) {
                    v = getDouble(viewLabel);
                   viewLabel.setText(null);
                    str = "divide";

                } else if (event.getSource() == multiplyButton) {
                    v = getDouble(viewLabel);
                    viewLabel.setText(null);
                    str = "multiply";
                } else if (event.getSource() == miniButton) {
                    v = getDouble(viewLabel);
                    viewLabel.setText(null);
                    str = "minus";
                } else if (event.getSource() == plusButton) {
                    v = getDouble(viewLabel);
                    viewLabel.setText(null);
                    str = "plus";
                } else if (event.getSource() == equalButton) {
                    if (str.equals("divide")) {
                        number = getDouble(viewLabel);
                        String n = v / number + "";
                        if (n.equalsIgnoreCase("Infinity")) {
                            viewLabel.setText("Error");
                        } else
                            viewLabel.setText(setResltOfLabel(v / number));

                    } else if (str.equals("multiply")) {
                        number = getDouble(viewLabel);
                        viewLabel.setText(setResltOfLabel(v * number));

                    } else if (str.equals("minus")) {
                        number = getDouble(viewLabel);
                        viewLabel.setText(setResltOfLabel(v - number));
                    } else if (str.equals("plus")) {
                        number = getDouble(viewLabel);
                        viewLabel.setText(setResltOfLabel(v + number));
                    }
                }

            }
        }




    public double getDouble(Label label) {
        return Double.parseDouble(viewLabel.getText().toString());
    }

    public String setResltOfLabel(double v) {
        return v + "";
    }


    public static void main(String[] args) {
        launch(args);
    }
}


