package com.example.sudoku.buildlogic;

import com.example.sudoku.computationlogic.GameLogic;
import com.example.sudoku.persistance.LocalStorageImpl;
import com.example.sudoku.problemdomain.IStorage;
import com.example.sudoku.problemdomain.SudokuGame;
import com.example.sudoku.usernterface.IUserInterfaceContract;
import com.example.sudoku.usernterface.logic.ControlLogic;

import java.io.IOException;

public class SudokuBuildLogic {
    public static void build(IUserInterfaceContract.View userInterface) throws IOException{
        SudokuGame initialState;
        IStorage storage = new LocalStorageImpl();
        try{
            initialState = storage.getGameData();
        }
        catch (IOException e){
            initialState= GameLogic.getNewGame();
            storage.updateGameData(initialState);
        }
        IUserInterfaceContract.EventListener uiLogic = new ControlLogic(storage,userInterface);

        userInterface.setListener(uiLogic);
        userInterface.updateBoard(initialState);

    }
}
