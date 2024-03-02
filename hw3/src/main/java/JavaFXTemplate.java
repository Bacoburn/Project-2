// Homework 3 CS 342
// Author: Duc Tran, UIN: 679876782
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFXTemplate extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Duc Tran Homework 3 CS 342");

		Button button1 = new Button();
		Button button2 = new Button();
		Button button3 = new Button();


		Image imagePlay = new Image("E:/HW 3 CS 342/hw3/pic/Large Buttons/Large Buttons/Start Button.jpg");
		Image imageSettings = new Image("E:/HW 3 CS 342/hw3/pic/Large Buttons/Large Buttons/Settings Button.jpg");
		Image imageQuit= new Image("E:/HW 3 CS 342/hw3/pic/Large Buttons/Large Buttons/Quit Button.jpg");



		// Create an ImageView with the image
		ImageView imagePlayView = new ImageView(imagePlay);
		ImageView imageSettingsView = new ImageView(imageSettings);
		ImageView imageQuitView = new ImageView(imageQuit);
		// Set the graphic (image) on the button
		button1.setGraphic(imagePlayView);
		button2.setGraphic(imageSettingsView);
		button3.setGraphic(imageQuitView);



		VBox vbox = new VBox();
		vbox.getChildren().addAll(button1, button2, button3);
		vbox.setSpacing(75);
		vbox.setPadding(new Insets(150, 500, 250, 500));





		TextField centerTextField = new TextField();
		centerTextField.setPromptText("Enter text here then press button 1");
		centerTextField.setPrefWidth(700);

		TextField rightTextField = new TextField("final string goes here");
		rightTextField.setEditable(false);
		rightTextField.setPrefWidth(500);

		BorderPane borderPane = new BorderPane();
		Image backgroundImage = new Image("file:E:/HW 3 CS 342/hw3/pic/blackjack.jpg");
		ImageView backgroundImageView = new ImageView(backgroundImage);
		borderPane.setCenter(backgroundImageView);
		borderPane.setTop(vbox);


		button1.setOnAction(event -> {
			String textFromCenter = centerTextField.getText();
			String newText = textFromCenter + " : from the center text field!";
			rightTextField.setText(newText);
			button1.setDisable(true);
			button1.setText("Pressed");
		});

		button2.setOnAction(event -> {
			centerTextField.clear();
			rightTextField.setText("final string goes here");
			button1.setDisable(false);
			button1.setText("Button 1");
		});

		Scene scene = new Scene(borderPane, 1500, 1000);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
