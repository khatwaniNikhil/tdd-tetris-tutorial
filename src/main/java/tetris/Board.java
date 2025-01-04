// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class Board {

    private final char[][] layout;
    private boolean hasFallingBlock;
    private Block currentFallingBlock;

    public Board(int rows, int columns) {
        layout = new char[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                layout[row][col] = '.';
            }
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int row = 0; row < layout.length; row++) {
            for (int col = 0; col < layout[0].length; col++) {
                s += layout[row][col];
            }
            s += "\n";
        }
        return s;
    }

    public boolean hasFalling() {
        return hasFallingBlock;
    }

    public void drop(Block fallingBlock) {
        if(hasFallingBlock)
            throw new IllegalStateException("already falling");
        else {
            hasFallingBlock = true;
            currentFallingBlock = fallingBlock;
            layout[fallingBlock.getFallingOnRow()][fallingBlock.getFallingOnCol()] = currentFallingBlock.getShape();
        }
    }

    private void handleBlockMovement(int currRow, int currCol, int newRow, int newCol) {
        layout[currRow][currCol] = '.';
        layout[newRow][newCol] = currentFallingBlock.getShape();
    }


    public void tick() {
        if(currentFallingBlock.getFallingOnRow() == layout.length-1) {
            hasFallingBlock = false;
        } else if(layout[currentFallingBlock.getFallingOnRow()+1][currentFallingBlock.getFallingOnCol()]!='.'){
            hasFallingBlock = false;
        }
        else {
            int currRow = currentFallingBlock.getFallingOnRow();
            int currCol = currentFallingBlock.getFallingOnCol();
            currentFallingBlock.move();
            int newRow = currentFallingBlock.getFallingOnRow();
            int newCol = currentFallingBlock.getFallingOnCol();
            handleBlockMovement(currRow, currCol, newRow, newCol);
        }
    }
}
