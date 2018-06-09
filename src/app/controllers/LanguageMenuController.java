package app.controllers;

import app.Main;
import app.datatype.Language;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageMenuController {
    public AnchorPane getLanguagePane() {
        return languagePane;
    }

    public Scene getScene() {
        if (scene == null) {
            scene = new Scene(this.languagePane);
        }
        return scene;
    }

    private Scene scene;
    @FXML private AnchorPane languagePane;

    public void changeLanguage(Event e) {
        if (e.getEventType().getName().equals("KEY_PRESSED")) {
            KeyEvent key_event = (KeyEvent) e;
            if (!key_event.getCode().isWhitespaceKey()) {
                return;
            }
        }
        ListView<Language> lan_lst_view = (ListView) languagePane.getChildren().get(0);
        Language lan = lan_lst_view.getSelectionModel().getSelectedItem();
        setLanguage(lan);
        Main.getPrimaryStage().setScene(Main.getsStartMenuController().getScene());
    }

    public void setLanguage(Language lan) {
        Main.cur_language = lan.toString().split("_")[1];
        try {
            Main.getPrimaryStage().close();
            new Main().start(Main.getPrimaryStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("set language " + lan);
    }
}
