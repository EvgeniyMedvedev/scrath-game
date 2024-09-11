package org.scrathgame;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import org.scrathgame.components.GameBoard;
import org.scrathgame.components.Scratch;
import org.scrathgame.models.Config;
import org.scrathgame.utils.Params;

import java.io.File;
import java.io.IOException;

public class HelloController {

    @FXML
    private GridPane parent;
    @FXML
    private Button start;

    GameBoard output;

    public void setArgs(String []args) throws IOException {
        Params params = new Params();
        if (params.init(args)) {
            ObjectMapper objectMapper = JsonMapper.builder()
                    .enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS)
                    .build();
            Config config = objectMapper.readValue(new File(params.getConfigPath()), Config.class);

            output = new Scratch(config).scratch(params.getBettingAmount());
        }
    }

    @FXML
    protected void onHelloButtonClick() {
        for (int i = 0; i < output.matrix().length; i++) {
            for (int j = 0; j < output.matrix()[i].length; j++) {
                Label newLabel = new Label(output.matrix()[i][j]);
                newLabel.setId(i + "" + j);
                newLabel.setContentDisplay(ContentDisplay.CENTER);
                newLabel.setAlignment(Pos.CENTER);
                newLabel.setTextAlignment(TextAlignment.CENTER);
                newLabel.applyCss();
                parent.add(newLabel, i, j);
            }
        }
    }

    @FXML
    void initialize() {
    }
}