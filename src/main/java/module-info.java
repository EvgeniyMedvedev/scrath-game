module scratchgame {
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens org.scrathgame to javafx.fxml;
    exports org.scrathgame;
    opens org.scrathgame.models to com.fasterxml.jackson.databind;
}