package com.pw.jnotepad.app;

import com.pw.jnotepad.app.providers.*;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


public class NotepadController {

    private TextArea textArea;

    private CommonUtilProvider commonUtilProvider;

    private MenuBarProvider menuBarProvider;


    public NotepadController(Stage window){

        this.textArea = new TextArea("Welcome to j-notepad");
        this.menuBarProvider = new MenuBarProvider(window,textArea);
        this.commonUtilProvider = new CommonUtilProvider(window);
        initJNotepad(window);

    }

    private void initJNotepad(Stage window) {
        window.setTitle("j-notepad");
        window.setOnCloseRequest(event ->{
            event.consume();
            this.commonUtilProvider.destroy();
        });

        Scene scene = this.commonUtilProvider.createBorderPaneScene(menuBarProvider.createMenuBar(),textArea);
        window.setScene(scene);
        window.show();

    }






}
