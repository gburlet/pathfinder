//
// Map.java
//
// Created by Greg Burlet.
// Copyright (c) 2015 Greg Burlet. All rights reserved.
//

public class Map {
    enum Terrain { GROUND, ROCK, WATER }

    class Cell {
        Terrain type;

        public Cell() {
            this.type = Terrain.GROUND;
        }

        public Cell(Terrain type) {
            this.type = type;
        }
    }

    // state
    private int width;
    private int height;
    private Cell[][] grid;

    // Constructor
    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        
        this.grid = new Cell[this.width][this.height];
        
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                grid[i][j] = new Cell();
            }
        }
    }

    // getters and setters
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
