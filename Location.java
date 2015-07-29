//
// Location.java
//
// Created by Greg Burlet.
// Copyright (c) 2015 Greg Burlet. All rights reserved.
//

public class Location {
    
    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    // getters
    public int x() { return this.x; }
    public int y() { return this.y; }

    // compare two locations
    public boolean equals(Location otherLoc) {
        return this.x == otherLoc.x() && this.y == otherLoc.y();
    }
}
