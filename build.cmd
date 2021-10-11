start /d
javac -cp src src\*.java -d bin
jar cvfm Slate.jar resources\manifest.txt -C bin . src