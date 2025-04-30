java -XX:AOTMode=record -XX:AOTConfiguration=app.aotconf Java11.java
java -XX:AOTMode=create -XX:AOTConfiguration=app.aotconf -XX:AOTCache=app.aot Java11.java
time java -XX:AOTCache=app.aot Java11.java
time java Java11.java
