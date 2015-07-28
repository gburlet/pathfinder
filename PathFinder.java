// 
// PathFinder.java
//
// Created by Greg Burlet
// Copyright (c) Greg Burlet. All rights reserved.
//

public class PathFinder {

    public static void main (String args[]) {
        // Get size of map 
        int mapSize = 10;
        if (args.length > 0) {
            try {
                mapSize = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("mapSize argument must be an integer.");
                System.exit(1);
            }
        }
        System.out.println(mapSize);

        // create square map
        Map map = new Map(mapSize, mapSize);
    }
}
