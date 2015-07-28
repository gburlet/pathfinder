CC=javac

pathfinder: *.java
	javac PathFinder.java

run: PathFinder.class
	java PathFinder

clean:
	rm *.class
