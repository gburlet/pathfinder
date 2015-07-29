//
// MapCell.java
//
// Created by Greg Burlet.
// Copyright (c) 2015 Greg Burlet. All rights reserved.
//

class MapCell {
    public enum Terrain { GROUND, ROCK, WATER }

    private Terrain type;

    public MapCell() {
        this.type = Terrain.GROUND;
    }

    public MapCell(Terrain type) {
        this.type = type;
    }

    // getters and setters
    public Terrain getTerrain() {
        return this.type;
    }

    public void setTerrain(Terrain type) {
        this.type = type;
    }
}
