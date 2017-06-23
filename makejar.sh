javac src/*.java -d bin
cd bin
jar -cvfm ../Registration.jar META-INF/MANIFEST.MF *.class
cd ..

java -jar Registration.jar