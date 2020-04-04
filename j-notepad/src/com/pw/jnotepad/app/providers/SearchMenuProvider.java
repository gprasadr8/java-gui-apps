package com.pw.jnotepad.app.providers;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class SearchMenuProvider {

    private Stage window;

    public SearchMenuProvider(Stage window) {
        this.window = window;
    }

    public Menu createSearchMenu() {
        Menu searchMenu = new Menu("Search");
        MenuItem find = new MenuItem("Find");
        MenuItem replace = new MenuItem("Replace");
        MenuItem gotoLine = new MenuItem("Goto");
        searchMenu.getItems().addAll(find,replace,gotoLine);
        return searchMenu;
    }
}
