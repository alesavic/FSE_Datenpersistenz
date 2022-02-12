# FSE_Datenpersistenz Datenbankzugriff mit Java, JDBC und DAO; für FSE (HTL Imst)

# Aufgabe 1 JDBC Intro
Die Aufgabe 1 war es grundsätzlich den ersten Teil des JDBC Intros bestehend aus 8 Videos anzuschauen und zu bearbeiten, um sich darauf sein eigenes Verständnis in puncto JDBC zu verbessern bzw. auszubauen. In folgendem Abschnitt werden dementsprechend entsprechende und wichtige Schritte / Konzepte festgehalten.

## Einrichtung der Entwicklungsumgebung
Folgende 4 Schritte sind bei der Einrichtung der Entwicklungsumgebung von essenzieller Bedeutung:
- Webserver 
- Datenbankserver 
- IDE 
- Maven-Projektsetup

Als erstes sollte das Programm Xampp heruntergeladen und installiert werden sofern nicht vorhanden da es uns als Webserver-/Datenbanklösung dient. Die Installationsschritte werden hier nicht beschrieben da diese selbsterklärend sind und weitere Informationen bezüglich der Installation, Konfiguration finden sich auf der Website www.apachefriends.org.

Nach fertiger Installation sollte man nach Ausführung des Programms folgendes Menü erhalten:

<p align = "center">
  <img src="https://user-images.githubusercontent.com/91562113/153724137-5fbab0fc-d67d-49b6-9004-6a70b1e955ab.png"/>
</p>

Weiters kann der Apache Webserver & MySQL Dienst gestartet werden. Im nächsten Schritt kann die Administrationskonsole mit folgender URL Eingabe geöffnet werden: „localhost/phpmyadmin“. In dieser Übersicht können eigene Datenbanken gemanagt werden. So sieht die Übersicht von „phpmyadmin“ aus:

<p align = "center">
  <img src="https://user-images.githubusercontent.com/91562113/153724268-0035c792-3fe2-46e8-97b4-a5ec06a41764.png"/>
</p>

Als nächstes benötigen wir eine IDE in meinem Fall „IntelliJ“, um die Einrichtung abzuschließen. Die Einrichtung eines „IntelliJ“-Projekts erfolgt mit folgenden Schritten:

1. Als erstes in IntelliJ unter File -> New -> Project

<p align = "center">
  <img src="https://user-images.githubusercontent.com/91562113/153724296-c8bdea14-f15c-43b5-b318-3ba0a84e8249.png"/>
</p>

2. Im Fenster New Project wählt auf der linken Seite das es sich hierbei um ein Maven Projekt handelt, weiters wählt man die Projekt SDK 17er Version aus. -> Auf Next

<p align = "center">
  <img src="https://user-images.githubusercontent.com/91562113/153724404-a793d6d6-413e-4cdd-9f18-16f5f480a547.png"/>
</p>

3. Im nächsten Fenster gibt man den Namen, den Speicherort, evt. Artifact Coordinates an. -> Auf Finish

<p align = "center">
  <img src="https://user-images.githubusercontent.com/91562113/153724435-dcb1e6c3-118c-4867-b89a-64f9189f5d4a.png"/>
</p>

4. Anschließend wurde das Projekt erstellt und Maven wird im Hintergrund geladen.

<p align = "center">
  <img src="https://user-images.githubusercontent.com/91562113/153724468-3b59c692-51a9-4b06-aae1-4f560f01854f.png"/>
</p>

Im weiteren Verlaufe geht man auf die Website mvnrepository.com um sich Informationen über die „MySQL Connector /J“ zu beschaffen bzw. um den richtigen Code der Dependency zu kopieren & zu implementieren.

Die Übersicht nach der gesuchten Abhängigkeit (Dependency) schaut wie folgt aus:

<p align = "center">
  <img src="https://user-images.githubusercontent.com/91562113/153724517-a0a76f52-2268-490f-a24c-4e6bb6961d9e.png"/>
</p>

Hierbei geht es hauptsächlich, um sich die Dependency zu beschaffen und in der pom.xml unseres Projektes zu implementieren.

Als letztes wurde eine Beispielklasse namens „Jdbcdemo“ erstellt, main Methode implementiert. In der main Methode wurde mit sout eine Konsolenausgabe definiert, die im Anschluss auch auf Ausgabe getestet wurde.

<p align = "center">
  <img src="https://user-images.githubusercontent.com/91562113/153724541-d702af3e-b934-416d-9e44-9f6815c530b8.png"/>
</p>

## Aufbau der Datenbankverbindung
Als erstes richten wir uns in der phpmyadmin Konsole eine neue Datenbank ein durch einen Klick auf den Punkt „Neu“ -> unter dem Reiter Datenbanken -> Namen eintragen z.B.: jdbcdemo -> Auf Anlegen klicken

<p align = "center">
  <img src="https://user-images.githubusercontent.com/91562113/153724590-812d63d2-0321-4e95-bcf2-3788b1083636.png"/>
</p>

Als nächstes unter dem Reiter Struktur soll ein Name für die Tabelle angegeben werden z.B.: student und beider Spaltenanzahl zunächst 3 Spalten.

<p align = "center">
  <img src="https://user-images.githubusercontent.com/91562113/153724613-499e010e-bef2-474f-b641-fe5476aca4eb.png"/>
</p>

Anschließend auf Ok klicken.

Weiters muss die Tabelle bezüglich der Spalten konfiguriert werden. Hierbei wurden die Attribute id, name, email mit gewissen Charakteristiken versehen. Anschließend kann man sich unter SQL-Vorschau das SQL Statement zur Erstellung dieser Tabelle anschauen. Zu guter Letzt geht man auf Speichern, um die Tabelle abzuspeichern bzw. dann wird das SQL Statement ausgeführt und somit wird unsere Tabelle erstellt.

<p align = "center">
  <img src="https://user-images.githubusercontent.com/91562113/153724645-12733861-0f48-4138-a47b-653ceb3d568c.png"/>
</p>

SQL Statement Vorschau:

<p align = "center">
  <img src="https://user-images.githubusercontent.com/91562113/153724665-57c19c70-ae71-4476-8c26-27c3938d6baa.png"/>
</p>

Zu Testzwecken wird als nächstes ein Datensatz hinzugefügt. Hierbei klickt man auf den Reiter Einfügen -> Befüllen der Datenfelder -> Mit Ok bestätigen -> somit wird im Hintergrund ein Insert-Statement ausgeführt. Beispiel Datensätze.:

<p align = "center">
  <img src="https://user-images.githubusercontent.com/91562113/153724690-3484a232-e48f-413e-9ba1-86b645a2b3a1.png"/>
  <img src="https://user-images.githubusercontent.com/91562113/153724695-67872736-305d-498e-aca0-ebf738abb1fe.png"/>
</p>

Anschließend mit OK bestätigen.

## Aufbau der Datenbankverbindung Teil 2
Hierbei geht es darum aus Java heraus eine Datenbankverbindung zu erstellen, um feststellen zu können, ob man mit diesen Daten auch interagieren kann bzw. diese abrufen kann.

### Datenabfrage
Als nächstes wird in der JdbcDemo Klasse eine neue Methode namens selectAllDemo() implementiert. Die Methode soll dazu dienen sich alle Datensätze aus der Datenbank jdbcdemo zu holen und in erster Linie diese auch auf die Kommandozeile ausgeben lassen. 
Hier ist folgender Code eingebettet:

```
public static void selectAllDemo()
    {
    System.out.println("Select DEMO mit JDBC");
    String connectionUrl = "jdbc:mysql://localhost:3307/jdbcdemo";
    String user = "root";
    String pwd = "";

    try (Connection conn = DriverManager.getConnection(connectionUrl, user, pwd))
    {
        System.out.println("Verbindung zur DB hergestellt!");
        
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM `student`");
        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next())
        {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            System.out.println("Student aus der DB: [ID] " + id + " [NAME] " + name + " [EMAIL] " + email);
        }
    }catch (SQLException e) {
        System.out.println("Fehler beim Aufbau der Verbindung zur DB: " + e.getMessage());
    }
    }

```

Natürlich muss man bevor man die Daten holen will, zuerst die Parameter wie Verbindungs-URL (URL, über die der Datenbankserver erreichbar ist.), Benutzername, Password deklarieren und die entsprechenden Werte zuweisen. 
Danach kommt ein try-catch Block in dem versucht wird eine Verbindung mit der Datenbank aufzubauen. Falls dies nicht möglich ist aufgrund fehlerhafter Verbindungsparameter bekommt man eine Fehlermeldung. 
Im inneren des try-Blocks wird vom Verbindungsobjekt conn aus die Methode prepareStatement aufgerufen. Dieser Methode wird als Parameter ein Select-Statement übergeben. Dieses SQL-Statement ist ein sogenanntes „prepared Statement“ das in ein preparedStatement Objekt hineingespeichert bzw. zugewiesen wird. 
Hiermit bereitet man ein SQL-Statement vor mit dem in weiterer Folge die Abfrage gestartet wird und die daraus resultierenden Datensätze in ein ResultSet gespeichert werden. 
Als nächstes wurde vom preparedStatement Objekt aus die Methode executeQuery() aufgerufen. Hierbei wurde das SQL-Statement ausgeführt und die daraus resultierenden Datensätze wurden in ein ResultSet Objekt hineingespeichert.
Des Weiteren wurde eine while loop verwendet, die so lange das ResultSet durchgeht, bis der Methodenaufruf next() ein false zurückgibt, dann befindet sich der Cursor genau nach der letzten Reihe. Defacto, bis kein Datensatz mehr vorhanden ist.     
In der while loop holt man sich über das ResultSet Objekt aus die benötigten Daten des jeweils vorhandenen Datensatzes. Anschließend werden die Datensätze mittels Custom Konsolenausgabe ausgegeben. Im Hintergrund funktioniert der Methoden Aufruf next() so dass einerseits die Frage „Gibt es noch einen Datensatz?“ und andererseits die Frage „Wird noch auf einen Datensatz gezeigt?“ mittels true oder false beantwortet wird. 

### Daten einfügen
Hierbei geht es darum eine Methode zu implementieren die zum Einfügen von Datensätzen dient.
Die zu implementierende Methode heißt „insertStudentDemo()“. Sehr viele Codeelemnte können von vorheriger Methode übernommen werden. Es sind lediglich kleinere Änderungen zu implementieren.
Als erstes kopiert man sich den inneren Quelltext der vorhergehenden Methode. Des Weiteren wird die Abfrage nichtmehr benötigt. Das äußere try-catch-Konstrukt bleibt erhalten weiters wird das vorhergehende SELECT-Statement nicht mehr benötigt.
Als nächstes wird das INSERT-Statement als String dem prepareStatement Methodenaufruf übergeben. Hierbei ist zu beachten das hierbei sogenannte Platzhalter (?) im Spiel sind. Dies hat den Vorteil das bezüglich der SQL Injection keine Parameter mehr für potenzielle Angreifer abgreifbar sind. Des Weiteren sorgen prepared Statements auch für schnellere Ausführung, da das SQL Statement schon vorliegt und im try-catch Konstrukt lediglich noch die Parameter an gegebener Stelle eingesetzt werden und das vom preparedStatement Objekt aus die Methode executeUpdate() ausgeführt wird.
Anbei ist folgender Quellcode zu sehen:

```
public static void insertStudentDemo(String name, String email)
{
    //Zugriffswerte für die Datenbankverbindung
    System.out.println("Insert DEMO mit JDBC");
    String connectionUrl = "jdbc:mysql://localhost:3307/jdbcdemo";
    String user = "root";
    String pwd = "";


    try(Connection conn = DriverManager.getConnection(connectionUrl, user, pwd))
    {
        System.out.println("Verbindung zur DB hergestellt!");
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO `student` (`id`, `name`, `email`) VALUES (NULL, ?, ?)");
        try
        {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            //liefert Anzahl der betroffenen Datensätze zurück.
            int rowAffected = preparedStatement.executeUpdate();
            System.out.println(rowAffected + " Datensätze eingefügt.");
        }catch (SQLException e)
        {
            System.out.println("Fehler im SQL-INSERT Statement: " + e.getMessage());
        }

    }catch (SQLException e) {
        System.out.println("Fehler beim Aufbau der Verbindung zur DB: " + e.getMessage());
    }
}
```

### Daten ändern
Hierbei geht es darum eine Methode zu implementieren die zum Ändern von Datensätzen dient.
Die zu implementierende Methode heißt „updateStudentDemo()“. Sehr viele Codeelemente können von vorheriger Methode übernommen werden. Es sind lediglich kleinere Änderungen zu implementieren.

Anbei ist folgender Quellcodeabschnitt zu sehen:

```
public static void updateStudentDemo(int id, String neuerName, String neueEmail)
{
    //Zugriffswerte für die Datenbankverbindung
    System.out.println("Update DEMO mit JDBC");
    String connectionUrl = "jdbc:mysql://localhost:3307/jdbcdemo";
    String user = "root";
    String pwd = "";


    try(Connection conn = DriverManager.getConnection(connectionUrl, user, pwd))
    {
        System.out.println("Verbindung zur DB hergestellt!");
        PreparedStatement preparedStatement = conn.prepareStatement("UPDATE `student` SET `name` = ?, `email` = ? WHERE `student`.`id` = ?");
        try
        {
            preparedStatement.setString(1,neuerName);
            preparedStatement.setString(2, neueEmail);
            preparedStatement.setInt(3, id);
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println("Anzahl der aktualisierten Datensätze: " + affectedRows);
        }catch (SQLException e)
        {
            System.out.println("Fehler im SQL-UPDATE Statement: " + e.getMessage());
        }

    }catch (SQLException e) {
        System.out.println("Fehler beim Aufbau der Verbindung zur DB: " + e.getMessage());
    }
}

```
Im Prinzip liegt der Unterschied bei obiger Methodenimplementierung nur darin das sich das prepared Statement und die Konsolenausgaben im Vergleich zur insertStudentDemo() Methode unterscheiden. 

### Daten löschen
Hierbei geht es darum eine Methode zu implementieren die zum Löschen von Datensätzen dient.
Die zu implementierende Methode heißt „deleteStudentDemo()“. Sehr viele Codeelemente können von vorheriger Methode übernommen werden. Es sind lediglich kleinere Änderungen zu implementieren.

Anbei ist folgender Quellcodeabschnitt zu sehen:

```
public static void deleteStudentDemo(int studentId)
{
    //Zugriffswerte für die Datenbankverbindung
    System.out.println("Delete DEMO mit JDBC");
    String connectionUrl = "jdbc:mysql://localhost:3307/jdbcdemo";
    String user = "root";
    String pwd = "";


    try(Connection conn = DriverManager.getConnection(connectionUrl, user, pwd))
    {
        System.out.println("Verbindung zur DB hergestellt!");
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM `student` WHERE `student`.`id` = ?");
        try
        {
            preparedStatement.setInt(1,studentId);
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println("Anzahl der gelöschten Datensätze: " + affectedRows);
        }catch (SQLException e)
        {
            System.out.println("Fehler im SQL-DELETE Statement: " + e.getMessage());
        }

    }catch (SQLException e) {
        System.out.println("Fehler beim Aufbau der Verbindung zur DB: " + e.getMessage());
    }
}

```
Der Ablauf zur Implementierung innerhalb der Methode ist immer annähernd derselbe -> 
1. Parameter für Datenbankverbindung definieren, 
2. try-catch Konstrukt aufziehen, 
3. beim try zwischen den runden Klammern vom DriverManager aus die getConnection Methode mit Übergabe der Werte für die Datenbankverbindung -> Zuweisung an Connection-Objekt conn,
3. evt. eigene custom Konsolenausgaben wie z.B.: „Verbindung zur DB hergestellt“ uvm.,
4. Im Rumpf des try Blocks: Methodenaufruf prepareStatement() vom Connection-Objekt mit Übergabe von SQL-Statement -> Zuweisung an preparedStatement-Objekt
5. Im nächsten try-Block innerhalb des äußeren try-Block wird der zu löschende Datensatz mittels Übergabe von parameterIndex und der studentid an den Methodenaufruf setInt(), der vom prearedStatement Objekt ausgeht, übergeben. 
6. Weiters wurde mittels Hilfsvariable namens affectedRows die Anzahl der gelöschten Datensätze abgespeichert
7. Im weiteren Verlaufe wurde die Hilfsvaribale in einer Custom Konsolenausgabe verbaut und bei jeweiliger Ausführung ausgegeben.

### Daten abfragen erweitert
Ein letztes Thema ist es wie man etwas speziellere SELECT Statement zusammenbaut. Da diese ab und an gebraucht werden. Hierbei geht es um die Implementierung einer Methode, die eine etwas umfangreichere Abfrage machen soll, bei der man nach bestimmten Datensätzen in Abhängigkeit der gesuchten Eigenschaft sucht.
Hier ist folgender relevanter Quellcodeabschnitt zu sehen: 

```
private static void findAllByNameLike(String pattern) {
    System.out.println("Find all by Name DEMO mit JDBC");
    String connectionUrl = "jdbc:mysql://localhost:3307/jdbcdemo";
    String user = "root";
    String pwd = "";

    try (Connection conn = DriverManager.getConnection(connectionUrl, user, pwd))
    {
        System.out.println("Verbindung zur DB hergestellt!");

        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM `student` WHERE `student`.`name` LIKE ?");
        preparedStatement.setString(1, "%" + pattern + "%");
        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next())
        {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            System.out.println("Student aus der DB: [ID] " + id + " [NAME] " + name + " [EMAIL] " + email);
        }
    }catch (SQLException e) {
        System.out.println("Fehler beim Aufbau der Verbindung zur DB: " + e.getMessage());
    }
}

```

Bei dieser Implementierung der Methode ist wie oben zu sehen das der Parameter für den Methodenaufruf prepareStatement() ein wenig anders ist als beim herkömmlichen Select Statement wo man alle Studenten bekommt. Hierbei will man alle Studenten der student Tabelle, wo der Name gleich dem pattern ist bzw. gleich dem Platzhalter (?). Des Weiteren ist auch zu sehen dass bei der Parameterübergabe des Suchstrings, der übergebene String Parameter namens pattern wird mithilfe des Verkettungsoperator (+) jeweils links und rechts von der Variable „pattern“ mit sogenannten Wildcards dem Prozentzeichen vom Typ String verkettet. Diese Vorgehensweise dient uns, um den Suchstring komplett aufzubauen. 
Im weiteren Verlaufe ist die Vorgehensweise dieselbe wie bei der Suche nach allen Datensätzen. 
Mit der while loop wird solange über das ResultSet iteriert solange rs.next() true ist. Sobald rs.next false ist, ist sozusagen kein Datensatz mehr verfügbar.  


Aufgabe 2 JDBC Intro Teil 2
