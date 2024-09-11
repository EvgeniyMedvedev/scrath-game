package org.scrathgame;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.scrathgame.components.Scratch;
import org.scrathgame.models.Config;
import org.scrathgame.utils.Params;

import java.io.File;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        String[] appArgs = getParameters().getRaw().toArray(new String[0]);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent load = fxmlLoader.load();
        HelloController controller = fxmlLoader.getController();
        controller.setArgs(appArgs);
        Scene scene = new Scene(load, 402, 402);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        System.out.println("test");
        launch(args);
    }
}