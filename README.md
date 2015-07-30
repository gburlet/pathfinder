# pathfinder
Pathfinding application to practice Java

## Features

* Random map generation with different terrain for each cell: regular ground, rocks, and water.
* Air drop multiple agents on the map
* Shortest-path graph search to reunite agents using Dijkstra's Algorithm

## Dependencies

* [jgrapht](https://github.com/jgrapht/jgrapht) library

## Usage

Compilation:

```sh
$ make
```

Run:

```sh
$ java -classpath lib/jgrapht-core-0.9.1.jar:. Pathfinder [mapWidth] [mapHeight] [rockDensity] [waterDensity]
```

where rockDensity and waterDensity are in the range [0,1] representing probability that any given cell in the map is rock or water, respectively.
