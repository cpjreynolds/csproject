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

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("CS Project");

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25, 25, 25));

        Label userName = new Label("Entry:");
        root.add(userName, 0, 1);

        TextField textfield = new TextField();
        root.add(textfield, 1, 1);

        // Submit button.
        Button submit_btn = new Button("Submit");
        HBox submit_bound = new HBox(10);
        submit_bound.setAlignment(Pos.BOTTOM_RIGHT);
        submit_bound.getChildren().add(submit_btn);
        root.add(submit_bound, 1, 4);

        final Text actiontarget = new Text();
        root.add(actiontarget, 1, 6);

        submit_btn.setOnAction((ActionEvent e) -> {
            actiontarget.setFill(Color.FIREBRICK);
            actiontarget.setText("Submit button pressed");
        });

        // Grid lines toggle.
        Button gline_btn = new Button("Grid Lines");
        HBox gline_bound = new HBox(10);
        gline_bound.setAlignment(Pos.BOTTOM_LEFT);
        gline_bound.getChildren().add(gline_btn);
        root.add(gline_bound, 0, 8);

        gline_btn.setOnAction((ActionEvent e) -> {
            root.setGridLinesVisible(!root.isGridLinesVisible());
        });


        Scene scene = new Scene(root, 300, 250);
        stage.setScene(scene);
        stage.show();
    }
}
