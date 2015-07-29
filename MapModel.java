//
// MapModel.java
//
// Created by Greg Burlet.
// Copyright (c) 2015 Greg Burlet. All rights reserved.
//

import java.util.*;

public class MapModel {
    // state
    private int width;
    private int height;
    private double rockDensity;
    private MapCell[][] grid;

    // Constructor
    public MapModel(int width, int height, double rockDensity) {
        this.width = width;
        this.height = height;
        this.rockDensity = rockDensity;
        
        this.grid = new MapCell[this.width][this.height];
        
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                grid[i][j] = new MapCell();
            }
        }
    }

    public void randomizeTerrain() {
        Random rnd = new Random();
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                if (rnd.nextDouble() <= this.rockDensity) {
                    MapCell.Terrain type = MapCell.Terrain.ROCK;
                    this.grid[i][j].setTerrain(type);
                }
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
