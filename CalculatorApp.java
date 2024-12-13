import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CalculatorApp extends Application {

    private TextField firstNumberField;
    private TextField secondNumberField;
    private TextField resultField;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple Calculator");

        // Create UI elements
        Label firstNumberLabel = new Label("First Number:");
        firstNumberField = new TextField();
        Label secondNumberLabel = new Label("Second Number:");
        secondNumberField = new TextField();
        Label resultLabel = new Label("Result:");
        resultField = new TextField();
        resultField.setEditable(false); // Make result field non-editable

        //Buttons
        Button addButton = new Button("+");
        Button subtractButton = new Button("-");
        Button multiplyButton = new Button("*");
        Button divideButton = new Button("/");

        // Set font size for better readability
        firstNumberLabel.setFont(new Font(14));
        secondNumberLabel.setFont(new Font(14));
        resultLabel.setFont(new Font(14));
        addButton.setFont(new Font(16));
        subtractButton.setFont(new Font(16));
        multiplyButton.setFont(new Font(16));
        divideButton.setFont(new Font(16));

        //Layout using GridPane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        grid.add(firstNumberLabel, 0, 0);
        grid.add(firstNumberField, 1, 0);
        grid.add(secondNumberLabel, 0, 1);
        grid.add(secondNumberField, 1, 1);
        grid.add(resultLabel, 0, 2);
        grid.add(resultField, 1, 2);


        // Arrange buttons in an HBox
        HBox buttonBox = new HBox(10); // Spacing of 10 between buttons
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(addButton, subtractButton, multiplyButton, divideButton);
        grid.add(buttonBox, 1,3);


        // Add event handlers for buttons

        addButton.setOnAction(e -> calculate('+'));
        subtractButton.setOnAction(e -> calculate('-'));
        multiplyButton.setOnAction(e -> calculate('*'));
        divideButton.setOnAction(e -> calculate('/'));


        //Create Scene
        Scene scene = new Scene(grid, 350, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private void calculate(char operator) {
        try {
            double num1 = Double.parseDouble(firstNumberField.getText());
            double num2 = Double.parseDouble(secondNumberField.getText());
            double result = 0;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        resultField.setText("Division by zero!");
                        return;
                    }
                    result = num1 / num2;
                    break;
            }
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}