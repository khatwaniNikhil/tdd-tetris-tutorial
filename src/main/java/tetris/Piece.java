// Copyright (c) 2008-2025  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class Piece {
    private String layout;

    public Piece(String layout) {
        this.layout = layout;
    }

    @Override
    public String toString() {
        return layout;
    }

    public Piece rotateRight() {
        // iterate row by row existing
        for(String row: layout.split("\n")) {

        }
        // fill col by col new
    }
}
