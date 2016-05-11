import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.FileChooser;

import java.io.File;

public class Main extends Application {
    private File target;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Text Editor");
        stage.setMinHeight(300);
        stage.setMinWidth(300);

        // GridPane setup.
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25, 25, 25));

        // Choose file button.
        Button choose_btn = new Button("Choose File");
        HBox choose_bound = new HBox(10);
        choose_bound.setAlignment(Pos.BOTTOM_RIGHT);
        choose_bound.getChildren().add(choose_btn);
        root.add(choose_bound, 0, 0);

        choose_btn.setOnAction((ActionEvent e) -> {
            FileChooser fchooser = new FileChooser();
            fchooser.setTitle("Choose File");
            target = fchooser.showOpenDialog(stage);
        });

        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
}
