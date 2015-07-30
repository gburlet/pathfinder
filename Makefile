CC=javac
CP=lib/jgrapht-core-0.9.1.jar:.

pathfinder: *.java
	$(CC) -classpath $(CP) PathFinder.java

run: PathFinder.class
	java -classpath $(CP) PathFinder 10 15 0.2 0.15

clean:
	rm *.class
