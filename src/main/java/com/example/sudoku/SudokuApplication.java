package com.example.sudoku;

import com.example.sudoku.buildlogic.SudokuBuildLogic;
import com.example.sudoku.usernterface.IUserInterfaceContract;
import com.example.sudoku.usernterface.UserInterfaceImpl;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class SudokuApplication extends Application {
    private IUserInterfaceContract.View uiImpl;
    @Override
    public void start(Stage stage) throws IOException {
       uiImpl = new UserInterfaceImpl(stage);
       try {
           SudokuBuildLogic.build(uiImpl);
       }catch (IOException e){
           e.printStackTrace();
           throw e;
       }
    }

    public static void main(String[] args) {
        launch(args);
    }
}