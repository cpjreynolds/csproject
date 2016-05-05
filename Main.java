import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        Button btn = new Button();
        btn.setText("Hello!");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren();

        Scene scene = new Scene(root, 300, 250);

        stage.setTitle("Hello");
        stage.setScene(scene);
        stage.show();
    }
}
