# Init

rm -rf bin classes myjre
rm -f myapp.jar *.dmg
mkdir bin classes

# Classpath full JRE

javac -d classes src/app/MyApp.java
java -cp classes app.MyApp
jar cvf bin/myapp.jar -C classes .
java -cp bin/myapp.jar app.MyApp
jpackage --name myapp-full --input bin --main-jar myapp.jar --main-class app.MyApp

# Classpath with custom JRE

jdeps bin/myapp.jar
jlink --add-modules java.base,java.desktop --output myjre --no-header-files --no-man-pages --strip-java-debug-attributes --strip-debug --compress=2
myjre/bin/java -cp bin/myapp.jar app.MyApp
jpackage --name myapp-custom --input bin --main-jar myapp.jar --main-class app.MyApp --runtime-image myjre

# Module

javac -d classes src/app/MyApp.java src/module-info.java
java --module-path classes -m app/app.MyApp
jar cvf bin/myapp.jar -C classes .
java --module-path bin -m app/app.MyApp
jpackage --name myapp-module --module-path bin --module app/app.MyApp
