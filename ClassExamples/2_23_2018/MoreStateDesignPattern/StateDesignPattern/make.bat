@echo off
del *.class
javac -cp .;matrix.jar *.java
java -cp .;matrix.jar ForestClick