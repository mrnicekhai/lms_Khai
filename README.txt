Vorausetzung:
* JAVA 8
* Eclipse / Intellij Idea IDE

* Projekt in Eclipse/IntelliJ als Gradle Projekt importieren
* Starten der LmsApplication über Run
* http://localhost:8080/api/v1/tasks sollte dann eine leere Liste zurückliefern
* POST auf http://localhost:8080/rest/tasks sollte ein Task erstellen, welcher dann auch geliefert wird
* Die Persistierung erfolgt in einer H2-Datenbank, ist nach Neustart jungfräulich
