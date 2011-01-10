ampel.jar: Ampel.class
	jar -cfm ampel.jar manifest.txt *.class

Ampel.class: *.java
	javac Ampel.java
