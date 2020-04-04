package com.pw.jnotepad.app.providers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class FileMenuProvider {

    private Stage window;

    private  JNotepadDestroyProvider destroyProvider;

    private TextArea textArea;

    public  FileMenuProvider(Stage window, JNotepadDestroyProvider destroyProvider, TextArea textArea){
        this.window = window;
        this.destroyProvider = destroyProvider;
        this.textArea = textArea;
    }

    public Menu createFileMenu() {
        Menu fileMenu = new Menu("File");
        MenuItem newFile = new MenuItem("New");
        MenuItem  openFile = new MenuItem("Open");
        openFile.setOnAction(event -> {
            triggerOpenFile();
        });
        MenuItem  saveFile = new MenuItem("Save");
        saveFile.setOnAction(event -> {
            System.out.println("Save file action triggered");
            triggerSaveOption(event);

        });
        MenuItem  saveAs = new MenuItem("Save As");
        saveAs.setOnAction(event -> {
            System.out.println("Save file action triggered");
            triggerSaveOption(event);
        });
        MenuItem  exitApp = new MenuItem("Exit");
        exitApp.setOnAction(event -> {
            this.destroyProvider.destroy();
        });
        fileMenu.getItems().addAll(newFile,openFile,saveFile,saveAs,exitApp);
        return fileMenu;
    }

    private void triggerOpenFile() {
        FileChooser fileChooser = createFileChooser("Open File");
        File selectedFile = fileChooser.showOpenDialog(this.window);
        if(selectedFile!=null){
            System.out.println(selectedFile.getName()+ " selected to open.");
        }
    }

    private void triggerSaveOption(ActionEvent event) {
        FileChooser fileChooser = createFileChooser("Save File");
        File selectedFile = fileChooser.showSaveDialog(this.window);
        if(selectedFile != null){
            saveTextToFile(selectedFile);
        }
    }

    private FileChooser createFileChooser(String title) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter onlyTextFilesFilter = new FileChooser.ExtensionFilter("Txt files(*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(onlyTextFilesFilter);
        fileChooser.setTitle(title);
        fileChooser.setInitialDirectory(Paths.get("").toAbsolutePath().toFile());
        return fileChooser;
    }

    /**
     * Use BufferedWriter when number of write operations are more
     * It uses internal buffer to reduce real IO operations and saves time
     */
    private void saveTextToFile(File file) {
        try(BufferedWriter buffer = new BufferedWriter(new FileWriter(file));) {
            ObservableList<CharSequence> paragraphs =  this.textArea.getParagraphs();
            paragraphs.forEach(charSequence -> {
                try {
                    buffer.append(charSequence);
                    buffer.newLine();
                } catch (IOException e) {
                    System.out.println("failed to write to text file.");
                    AlertBox.display("File Save Error", "failed to write to text file.");
                    e.printStackTrace();
                }
            });
            buffer.flush();

        } catch (IOException e) {
            System.out.println("failed to write to text file.");
            AlertBox.display("File Save Error", "failed to write to text file.");
            e.printStackTrace();
        }
    }

}
