# Copyright (c) 2010 Martin Ueding <dev@martin-ueding.de>

ampel.jar: Ampel.class
	jar -cfm $@ manifest.txt *.class

Ampel.class: *.java
	javac Ampel.java

clean:
	rm -rf *.class *.jar
