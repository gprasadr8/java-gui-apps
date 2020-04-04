package com.pw.jnotepad.app;

import com.pw.jnotepad.app.providers.*;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class NotepadController {

    private TextArea textArea;

    private FileMenuProvider fileMenuProvider;

    private EditMenuProvider editMenuProvider;

    private SearchMenuProvider searchMenuProvider;

    private JNotepadDestroyProvider destroyProvider;


    public NotepadController(Stage window){
        this.destroyProvider = new JNotepadDestroyProvider(window);
        this.textArea = new TextArea("Welcome to j-notepad");
        this.fileMenuProvider = new FileMenuProvider(window,destroyProvider,textArea);
        this.editMenuProvider = new EditMenuProvider(window);
        this.searchMenuProvider = new SearchMenuProvider(window);
        initJNotepad(window);

    }

    private void initJNotepad(Stage window) {
        window.setTitle("j-notepad");
        window.setOnCloseRequest(event ->{
            event.consume();
            this.destroyProvider.destroy();
        });
        javafx.scene.control.MenuBar menuBar = createMenuBar();
        BorderPane rootLayout = new BorderPane();
        rootLayout.setTop(menuBar);

        rootLayout.setCenter(textArea);
        Scene scene = new Scene(rootLayout,600,400);
        window.setScene(scene);
        window.show();

    }
    private MenuBar createMenuBar() {
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = this.fileMenuProvider.createFileMenu();
        Menu editMenu = this.editMenuProvider.createEditMenu();
        Menu searchMenu = this.searchMenuProvider.createSearchMenu();
        menuBar.getMenus().addAll(fileMenu,editMenu,searchMenu);
        return menuBar;
    }




}
