javac src/*.java -d bin
cd bin
jar -cvfm ../Registration.jar META-INF/MANIFEST.MF *.class
cd ..

sudo chmod +x Registration.jar

java -jar Registration.jar