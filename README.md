java comp <optional path to file>
    -or-
java -jar fileAob.jar <optional path to file>

## About
    Really simple program to generate aobs that can be used
    in any program where you are trying to identify a static
    array of bytes in memory.

## Usage
        java -jar fileAob.jar <optional path to file>
    if you don't provide a path to a file the program will ask
    you to give a path. If you just press enter here it will 
    default to the "strings" file in the same directory as the jar

## Changing the program
    after modifying the source
        javac comp.java
            -then if you want a jar-
        jar cmvf META-INF/MANIFEST.MF aob.jar comp.class
    
    to run the created jar
        java comp
            -or-
        java -jar aob.jar

## Requirements
    java JDK
