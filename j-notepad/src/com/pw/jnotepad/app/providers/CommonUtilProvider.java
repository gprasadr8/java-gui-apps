package com.pw.jnotepad.app.providers;

import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CommonUtilProvider {

    private  Stage window;


    public CommonUtilProvider(Stage window){
        this.window = window;

    }



    public void destroy(){
        boolean response = ConfirmBox.confirmAction("Title", "Are you sure?");
        if(response){
            System.out.println("All unsaved data saved in tmp files.");
            this.window.close();
        }
    }


    public Scene createBorderPaneScene(MenuBar menuBar, TextArea textArea) {
        BorderPane rootLayout = new BorderPane();
        rootLayout.setTop(menuBar);
        rootLayout.setCenter(textArea);
        Scene scene = new Scene(rootLayout,1000,800);
        return scene;
    }
}
