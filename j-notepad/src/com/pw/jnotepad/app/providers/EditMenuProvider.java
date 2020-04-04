package com.pw.jnotepad.app.providers;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class EditMenuProvider {

    private Stage window;

    public EditMenuProvider(Stage window) {
        this.window = window;
    }

    public Menu createEditMenu() {
        Menu editMenu = new Menu("Edit");
        MenuItem undo = new MenuItem("Undo");
        MenuItem redo = new MenuItem("Redo");
        MenuItem cut = new MenuItem("Cut");
        MenuItem copy = new MenuItem("Copy");
        MenuItem paste = new MenuItem("Paste");
        MenuItem delete = new MenuItem("Delete");
        MenuItem selectAll = new MenuItem("SelectAll");
        editMenu.getItems().addAll(undo,redo,cut,copy,paste,delete,selectAll);
        return editMenu;
    }

}
