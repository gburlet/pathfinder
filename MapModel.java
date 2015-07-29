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
    private double waterDensity;
    private MapCell[][] grid;
    private List<Agent> agents;

    // Constructor
    public MapModel(int width, int height, double rockDensity, double waterDensity) {
        this.width = width;
        this.height = height;
        this.setRockDensity(rockDensity);
        this.setWaterDensity(waterDensity);
        
        this.grid = new MapCell[this.width][this.height];
        
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                grid[i][j] = new MapCell(new Location(i,j));
            }
        }

        // populate map with zero agents to start
        this.agents = new ArrayList<Agent>();
    }

    public void randomizeTerrain() {
        Random rnd = new Random();
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                double rand = rnd.nextDouble();
                if (rand <= this.rockDensity) {
                    MapCell.Terrain type = MapCell.Terrain.ROCK;
                    this.grid[i][j].setTerrain(type);
                }
                else if (rand > this.rockDensity && rand <= this.rockDensity+this.waterDensity) {
                    MapCell.Terrain type = MapCell.Terrain.WATER;
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

    public void setRockDensity(double rd) {
        this.rockDensity = rd;
    }

    public double getRockDensity() {
        return this.rockDensity;
    }

    public void setWaterDensity(double wd) {
        this.waterDensity = wd;
    }

    public double getWaterDensity() {
        return this.waterDensity;
    }

    public MapCell[][] getCells() {
        return this.grid;
    }

    public List<Agent> getAgents() {
        return this.agents;
    }

    // member functions
    public void addAgent(Agent a) {
        this.agents.add(a);
    }

    // get random location on the map
    public Location getRandomLocation() {
        Random rand = new Random();
        int x = rand.nextInt((this.width-1) + 1);
        int y = rand.nextInt((this.height-1) + 1);
        
        return new Location(x,y);
    }
}
