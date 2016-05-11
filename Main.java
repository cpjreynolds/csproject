import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.FileChooser;

import java.io.*;

public class Main extends Application {
    private File target;
    private TextArea text_area;

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
        root.add(choose_bound, 0, 1);

        choose_btn.setOnAction((ActionEvent e) -> {
            FileChooser f_chooser = new FileChooser();
            f_chooser.setTitle("Choose File");
            this.target = f_chooser.showOpenDialog(stage);

            try {
                this.display_text();
            } catch (Exception err){
                // uh oh.
            }
        });

        // Text display.
        this.text_area = new TextArea();
        root.add(this.text_area, 0, 0);

        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    public void display_text() throws IOException {
        if (this.target == null) { return; }

        BufferedReader br = new BufferedReader(new FileReader(this.target));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            sb.append(line + "\n");
            line = br.readLine();
        }
        br.close();

        String text = sb.toString();

        this.text_area.setText(text);
    }
}
