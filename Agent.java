//
// Agent.java
//
// Created by Greg Burlet.
// Copyright (c) 2015 Greg Burlet. All rights reserved.
//

public class Agent {

    // state
    private String name;
    private Location currentLocation;

    public Agent(String name, Location currentLocation) {
        this.name = name;
        this.currentLocation = currentLocation;
    }

    public String toString() {
        return this.name + " @ " + this.currentLocation;
    }

    public String getName() {
        return this.name;
    }

    public Location getCurrentLocation() {
        return this.currentLocation;
    }

    public void teleport(Location targetLocation) {
        this.currentLocation = targetLocation;
    }
}
