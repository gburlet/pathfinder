//
// MapModel.java
//
// Created by Greg Burlet.
// Copyright (c) 2015 Greg Burlet. All rights reserved.
//

public class MapModel {
    // state
    private int width;
    private int height;
    private MapCell[][] grid;

    // Constructor
    public MapModel(int width, int height) {
        this.width = width;
        this.height = height;
        
        this.grid = new MapCell[this.width][this.height];
        
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                grid[i][j] = new MapCell();
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

    public MapCell[][] getCells() {
        return this.grid;
    }
}
