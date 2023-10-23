package com.example.sudoku.usernterface;

import com.example.sudoku.problemdomain.SudokuGame;

public interface IUserInterfaceContract {
    interface EventListener{
        void onSudokuInput(int x, int y, int input);
        void onDialogueClick();
    }

    interface View{
        void setListener(IUserInterfaceContract.EventListener listener);
        void updateSquare(int x, int y, int input);
        void updateBoard(SudokuGame game);
        void showDialog(String message);
        void showError(String message);
    }
}
