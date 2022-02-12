FSE_Datenpersistenz
Datenbankzugriff mit Java, JDBC und DAO; für FSE (HTL Imst)

Aufgabe 1 JDBC Intro
Die Aufgabe 1 war es grundsätzlich den ersten Teil des JDBC Intros bestehend aus 8 Videos anzuschauen und zu bearbeiten, um sich darauf sein eigenes Verständnis in puncto JDBC zu verbessern bzw. auszubauen. In folgendem Abschnitt werden dementsprechend entsprechende und wichtige Schritte / Konzepte festgehalten.

Einrichtung der Entwicklungsumgebung
Folgende 4 Schritte sind bei der Einrichtung der Entwicklungsumgebung von essenzieller Bedeutung: -Webserver -Datenbankserver -IDE -Maven-Projektsetup

Als erstes sollte das Programm Xampp heruntergeladen und installiert werden sofern nicht vorhanden da es uns als Webserver-/Datenbanklösung dient. Die Installationsschritte werden hier nicht beschrieben da diese selbsterklärend sind und weitere Informationen bezüglich der Installation, Konfiguration finden sich auf der Website www.apachefriends.org.

Nach fertiger Installation sollte man nach Ausführung des Programms folgendes Menü erhlten:



Weiters kann der Apache Webserver & MySQL Dienst gestartet werden. Im nächsten Schritt kann die Administrationskonsole mit folgender URL Eingabe geöffnet werden: „localhost/phpmyadmin“.In dieser Übersicht können eigene Datenbanken gemanagt werden. So sieht die Übersicht von „phpmyadmin“ aus:



Als nächstes benötigen wir eine IDE in meinem Fall „IntelliJ“, um die Einrichtung abzuschließen. Die Einrichtung eines „IntelliJ“-Projekts erfolgt mit folgenden Schritten:

Als erstes in IntelliJ unter File -> New -> Project


Im Fenster New Project wählt auf der linken Seite das es sich hierbei um ein Maven Projekt handelt, weiters wählt man die Projekt SDK 17er Version aus. -> Auf Next


Im nächsten Fenster gibt man den Namen, den Speicherort, evt. Artifact Coordinates an. -> Auf Finish


Anschließend wurde das Projekt erstellt und Maven wird im Hintergrund geladen.


Im weiteren Verlaufe geht man auf die Website mvnrepository.com um sich Informationen über die „MySQL Connector /J“ zu beschaffen bzw. um den richtigen Code der Dependency zu kopieren & zu implementieren.

Die Übersicht nach der gesuchten Abhängigkeit (Dependency) schaut wie folgt aus:



Hierbei geht es hauptsächlich, um sich die Dependency zu beschaffen und in der pom.xml unseres Projektes zu implementieren.

Als letztes wurde eine Beispielklasse namens „Jdbcdemo“ erstellt, main Methode implementiert. In der main Methode wurde mit sout eine Konsolenausgabe definiert, die im Anschluss auch auf Ausgabe getestet wurde.



Aufbau der Datenbankverbindung
Als erstes richten wir uns in der phpmyadmin Konsole eine neue Datenbank ein durch einen Klick auf den Punkt „Neu“ -> unter dem Reiter Datenbanken -> Namen eintragen z.B.: jdbcdemo -> Auf Anlegen klicken



Als nächstes unter dem Reiter Struktur soll ein Name für die Tabelle angegeben werden z.B.: student und beider Spaltenanzahl zunächst 3 Spalten.



Anschließend auf Ok klicken.

Weiters muss die Tabelle bezüglich der Spalten konfiguriert werden. Hierbei wurden die Attribute id, name, email mit gewissen Charakteristiken versehen. Anschließend kann man sich unter SQL-Vorschau das SQL Statement zur Erstellung dieser Tabelle anschauen. Zu guter Letzt geht man auf Speichern, um die Tabelle abzuspeichern bzw. dann wird das SQL Statement ausgeführt und somit wird unsere Tabelle erstellt.



SQL Statement Vorschau:



Zu Testzwecken wird als nächstes ein Datensatz hinzugefügt. Hierbei klickt man auf den Reiter Einfügen -> Befüllen der Datenfelder -> Mit Ok bestätigen -> somit wird im Hintergrund ein Insert-Statement ausgeführt. Beispiel Datensätze.:





Anschließend mit OK bestätigen.

Aufbau der Datenbankverbindung Teil 2
bitte weitermachen!!!

Aufgabe 2 JDBC Intro Teil 2
