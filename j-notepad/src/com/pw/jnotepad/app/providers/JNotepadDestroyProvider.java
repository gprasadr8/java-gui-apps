package com.pw.jnotepad.app.providers;

import javafx.stage.Stage;

public class JNotepadDestroyProvider {

    private  Stage window;

    public JNotepadDestroyProvider(Stage window){
        this.window = window;
    }

    public void destroy(){
        boolean response = ConfirmBox.confirmAction("Title", "Are you sure?");
        if(response){
            System.out.println("All unsaved data saved in tmp files.");
            this.window.close();
        }
    }
}
