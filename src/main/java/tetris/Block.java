// Copyright (c) 2008-2025  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

import java.util.*;

public class Block {
    private char shape;
    private int fallingOnRow;
    private int fallingOnCol;

    public Block(char shape) {
        this.shape = shape;
        fallingOnRow = 0;
        fallingOnCol = 1;
    }

    public void move() {
        fallingOnRow = fallingOnRow + 1;
    }

    public char getShape() {
        return shape;
    }

    public int getFallingOnRow() {
        return fallingOnRow;
    }

    public int getFallingOnCol() {
        return fallingOnCol;
    }
}
