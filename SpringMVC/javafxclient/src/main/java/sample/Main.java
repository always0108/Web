package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.HashMap;
import java.util.Map;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox pane = new VBox();
        pane.setAlignment(Pos.CENTER);
        pane.setSpacing(20);
        pane.setPadding(new Insets(20,20,20,20));
        primaryStage.setTitle("HttpClient");
        Button but = new Button("connect");
        TextArea textArea = new TextArea();
        pane.getChildren().addAll(but,textArea);

        but.setOnAction(e->{
            /*String url = "http://localhost:8080/getcookie";
            //textArea.setText(Httpclient.get(url));
            Httpclient.get(url);
            url = "http://localhost:8080/getcookie1";
            Httpclient.get(url);*/
            String url = "http://localhost:8080/login";
            Map<String,Object> form = new HashMap<>();
            form.put("username","always0108");
            form.put("password","123456");
            Httpclient.post(url,form);
        });
        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();
    }
}

