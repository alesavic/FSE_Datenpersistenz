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


# Aufgabe 2 & 3 JDBC Intro Teil 2

Die Aufgabe 2 widmet sich dem 2ten Teil des JDBC Intros bestehend aus 13 Videos die anzuschauen und zu bearbeiten sind, um sich in weiterer Folge mit dem DAO Pattern auseinanderzusetzen und einen Überblick über die Funktionsweise / Zusammensetzung zu bekommen. In folgendem Abschnitt werden dementsprechend entsprechende und wichtige Schritte / Konzepte festgehalten.

## Projektsetup

Folgende 4 Schritte sind beim Projektsetup von essenzieller Bedeutung:
- Webserver (XAMPP)
- Datenbankserver (XAMPP)
- IDE
- Maven-Projektsetup 

Als erstes startet wir beim XAMPP Control Panel den Webserver als auch den Datenbankserver. Im weiteren Verlauf wird zur Datenbankadministration phpmyadmin angewendet.

Als nächstes wird eine neue Datenbank namens „kurssystem“ angelegt.

<p align = "center">
  <img src="https://user-images.githubusercontent.com/91562113/158076410-840dcc7c-e01a-49e4-adac-da214938dbd8.png"/>
</p>

Hinzu kommt auch die Erstellung einer Tabelle namens „courses“.

![image](https://user-images.githubusercontent.com/91562113/158076479-ed552367-2361-4138-a67f-8d067acc1108.png)

Nach Eingabe des gewünschten Namens der Tabelle und Angabe der benötigten Spalten kann mit OK die Erstellung bestätigt werden.

Als nächstes müssen die Spalten mit gewünschten Eigenschaften befüllt werden. In folgender Abbildung sind die Eigenschaften der Tabelle zu sehen:

![image](https://user-images.githubusercontent.com/91562113/158076493-fbe107c8-148d-45ee-a959-3e363e9748a1.png)
 
Hier ist auch noch eine SQL-Vorschau zu sehen:

 ![image](https://user-images.githubusercontent.com/91562113/158076497-ff9794d8-e51e-4f75-b0e8-309b4c9eeaa1.png)

Jetzt kann man sich über den Reiter Einfügen ein oder mehrere Datensätze einfügen. Hierbei wurde ein Datensatz mit folgenden Daten erstellt:

![image](https://user-images.githubusercontent.com/91562113/158076508-21594eff-8788-4915-9619-ef9a5063f1d8.png)

Nach dem Bestätigen mit OK wurde der Datensatz eingefügt und es war folgende Meldung zu sehen:

 ![image](https://user-images.githubusercontent.com/91562113/158076514-7a05398f-8982-41e5-818b-bef30b736765.png)

Im 2ten Teil des Projektsetups wird in IntelliJ ein neues Maven-Projekt angelegt. Folgendes Schritte sind zu erledigen:
1)	Unter dem Reiter File -> New -> Project kommt man zum Konfigurationsfenster hin.

 ![image](https://user-images.githubusercontent.com/91562113/158076521-2a390f90-4644-41a6-a796-4c4a499b269e.png)

2)	Als nächstes die Option Maven wählen, die ausgewählte SDK ist die Version 17.0.1 -> Weiter mit Next

 ![image](https://user-images.githubusercontent.com/91562113/158076523-accb6ddb-7ec4-4c4e-b0ae-f763ff3ecdb9.png)

3)	Beim nächstes Fenster ->Projektname eintragen, evtl. Pfad anpassen, bei den Artifact Coordinates die GroupId anpassen -> Auf Finish klicken
 
![image](https://user-images.githubusercontent.com/91562113/158076530-a0667f90-434b-4cb4-a52b-68442ece067b.png)

Hiermit wurde das Maven-Projekt erstellt. Im weiteren Verlaufe geht man auf die Website mvnrepository.com um sich die benötigten Dependencies herauszusuchen um die Syntax der Dependencies in die pom.xml hineinzukopieren. In weiterer Abfolge werden die Dependencies beim Laden von Maven heruntergeladen.
 
![image](https://user-images.githubusercontent.com/91562113/158076539-aa3d3671-cde6-4dff-b3d3-94573cea031a.png)

![image](https://user-images.githubusercontent.com/91562113/158076545-25743722-b267-497b-87eb-e52eb5b3dc93.png)
 
Als nächstes wurde eine Main Klasse, eine dazugehörige main Methode und einer Konsolenausgabe zum Testen der Main Klasse angelegt.

 ![image](https://user-images.githubusercontent.com/91562113/158076551-6838c058-f0e1-4b5a-90c6-b9c390debc9a.png)

Anschließend wurde noch die main Methode ausgeführt, um diese auch auf Funktion zu prüfen.

![image](https://user-images.githubusercontent.com/91562113/158076559-f8eac2f7-3ed4-4f03-a822-ff82690a78ad.png)
 
Wie in obiger Abbildung zu sehen ist war der Test natürlich erfolgreich.

## Aufbau der Datenbankverbindung Teil 1

Hierbei kommt das Singleton Pattern zum Einsatz. Es bietet sich bei der Datenbankverbindung sehr gut an da diese nur einmal aufgebaut werden muss sofern eine vorhanden.

Als nächstes wird ein neues Package namens „dataaccess“ erstellt.

![image](https://user-images.githubusercontent.com/91562113/158076585-6a4590b5-001e-4010-884f-5486cc6db77c.png)

Weiters wurde in diesem Package eine neue Klasse namens „MysqlDatabaseConnection“ erstellt.

![image](https://user-images.githubusercontent.com/91562113/158076589-23348c4a-156e-44f0-86df-5fa4598e41d2.png)

Diese Klasse wurde im weiteren Verlauf implementiert. Als erstes wurde eine private statische variable namens con vom Typ Connection deklariert und dieser wurde null zugewiesen. Des Weiteren wurde ein privater Konstruktor angelegt und es wurde auch die hauptsächliche Methode zum Verbindungsaufbau implementiert. Hierbei handelt es sich um eine öffentliche statische Methode namens getConnection vom Typ Connection. Diese Methode benötigt folgende Parameter: url, user, pwd. Die Methode gibt uns ein Connection Objekt zurück. 

In folgender Abbildung ist der Quellcodeabschnitt zu sehen:

'''
public class MysqlDatabaseConnection {
    //Statisches Feld vom Typ Connection
    private static Connection con = null;

    private MysqlDatabaseConnection()
    {

    }

    public static Connection getConnection(String url, String user, String pwd) throws ClassNotFoundException, SQLException {
        if(con != null) {
            return con;
        } else {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pwd);
            return con;
        }
    }
}
'''

In der main Methode der Main-Klasse wurde ein try-catch Konstrukt aufgezogen, um das Singleton-Pattern zu testen. Anbei ist der folgende Quellcode zu sehen:

'''
public class Main {

    public static void main(String[] args) {

        try {
            Connection myConnection =
                    MysqlDatabaseConnection.getConnection("jdbc:mysql://localhost:3307/kurssystem","root","");
            System.out.println("Verbindung erfolgreich aufgebaut!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Verbindung fehlgeschlagen!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Verbindung fehlgeschlagen!");
        }
    }
}
'''

## Erstellung Kommandozeilenmenü

Dazu legt man sich ein neues Package namens „ui“ an. Des Weiteren legt man eine neue Klasse namens „Cli“ an.

In der Cli Klasse wurde als erstes eine Variable namens scan vom Typ Scanner definiert. Weiters wurde im Konstruktor ein neues Scanner Objekt erstellt und der scan Variable zugewiesen. Des Weiteren wurde ein Switch Case angewendet mit dem wird durch verschiedene Auswahlmöglichkeiten iterieren.

'''
public class Cli {

    Scanner scan;
    
    public Cli() {
        this.scan = new Scanner(System.in);
    }

    public void start() {
        String input = "-";
        while (!input.equals("x")) {
            showMenue();
            input = scan.nextLine();
            switch (input) {
                case "1":
                    addCourse();
                    break;
                case "2":
                    showAllCourses();
                    break;

                case "x":
                    System.out.println("Auf Wiedersehen!");
                    break;
                default:
                    inputError();
                    break;
            }
        }
        scan.close();
    }

private void showMenue() {
        System.out.println("-------------KURSMANAGEMENT-------------");
        System.out.println("(1) Kurs eingeben \t (2) Alle Kurse anzeigen \t (x) ENDE");
    }

    private void inputError() {
        System.out.println("Bitte nur die Zahlen der Menüauswahl eingeben!");
    }
}
'''

## Domain Package

Als nächstes erstellen wir uns ein „domain“ Verzeichnis und die darin benötigten Entitäten als Klassen. Es wurden eine Course Klasse und eine Course Type Klasse angelegt. Die Course Type Klasse ist ein Enum das die verschiedenen Kurstypen enthält. Des Weiteren wurde die  abstrakte BaseEntity Klasse erstellt. Diese ist für die automatische Eintragung der ID zuständig -> Sie kümmert sich um die Logik der IDs. In der Course Klasse müssen Konstruktoren, div. Getter & Setter implementiert werden. Einer davon mit ID & der andere ohne ID bzw. die ID wird auf Null gesetzt.

![image](https://user-images.githubusercontent.com/91562113/158078297-e3f9e31f-b10a-46bb-815e-df8ced92f019.png)

## DAO GetAll Implementierung Teil 2 


Als erstes fügen wir über die Datenbankadministrationskonsole einen weiteren Datensatz ein. In folgender Abbildung sind die Eigenschaften des Datensatzes zu sehen:

![image](https://user-images.githubusercontent.com/91562113/158078326-be55031e-89cd-499f-930d-37fb60f9b8b5.png)

Wie in der Tabelle courses zu sehen ist sind jetzt 2 Datensätze vorhanden:

![image](https://user-images.githubusercontent.com/91562113/158078335-be6a72b1-6d27-42f5-8fc2-8ca63835b1de.png)

Im Anschluss wurde das Programm ausgeführt und die Implementierung des Cases 2 namens showAllCourses() getestet:

![image](https://user-images.githubusercontent.com/91562113/158078343-1a342f17-e993-443d-9c15-824d87a2ec3a.png)

## GetById Implementierung

Hierbei geht es um die Implementierung der getById Methode der Klasse MySqlCourseRepository. Diese dient uns, um nach bestimmten Kursen suchen zu können.


Als erstes wird ein neues Package namens „util“ angelegt und in diesem wird auch eine neue Klasse namens „Assert“ erstellt.

![image](https://user-images.githubusercontent.com/91562113/158078362-c6bad579-3505-4e30-b7df-d378b9334551.png)

Diese Klasse hat nur die Aufgabe uns die Nullchecks (Nullabfragen) zu übernehmen.
Hier ist folgender Quellcode der Assert Klasse einsehbar:

'''
public class Assert {
    public static void notNull(Object o)
    {
        if(o == null) throw new IllegalArgumentException("Reference must not be null");
    }
}
'''

Der Vorteil ist, dass die statische Methode überall verwendet kann und es viel schneller ist als überall den Nullcheck händisch übernehmen muss.

Des Weiteren wurde in der MySqlCourseRepository eine Hilfsmethode namens „countCoursesInDbWithId“ vom Typ int. Hierzu ist folgender Quellcode ersichtlich:

'''
private int countCoursesInDbWithId(Long id)
{
    try {
        String countSql = "SELECT COUNT(*) FROM `courses` WHERE `id`=?";
        PreparedStatement preparedStatementCount = con.prepareStatement(countSql);
        preparedStatementCount.setLong(1, id);
        ResultSet resultSetCount = preparedStatementCount.executeQuery();
        resultSetCount.next();
        int courseCount = resultSetCount.getInt(1);
        return courseCount;
    } catch (SQLException sqlException)
    {
        throw new DatabaseException(sqlException.getMessage());
    }
}
'''

Weiters wurde auch die Methode getById vollständig ausimplementiert, wo die Hilfsmethode zur Anwendung bei beim Nullcheck kam. In folgender Abbildung ist der Quellcode ersichtlich:

'''
@Override
public Optional<Course> getById(Long id) {
    Assert.notNull(id);
    if(countCoursesInDbWithId(id) == 0)
    {
        return Optional.empty();
    } else {
        try {
            String sql = "SELECT * FROM `courses` WHERE `id` = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            Course course = new Course(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getString("description"),
                    resultSet.getInt("hours"),
                    resultSet.getDate("beginDate"),
                    resultSet.getDate("endDate"),
                    CourseType.valueOf(resultSet.getString("coursetype"))
            );
            return Optional.of(course);

        } catch (SQLException sqlException)
        {
            throw new DatabaseException(sqlException.getMessage());
        }
    }
}
'''

Weiters wurde in der Cli Klasse im Cli-Menü ein weiterer Case hinzugefügt der bei Auswahl per Konsoleneingabe der Zahl 3 durch den jew. Anwender die Methode namens „showCourseDetails“ aufruft. Folgende Implementierung ist zu sehen:

![image](https://user-images.githubusercontent.com/91562113/158078544-2a05d9e8-9fd3-4420-8fac-ba34e93a8c1f.png)

Als nächstes wurde in der Cli Klasse eine interne private Methode namens „showCourseDetails“ implementiert die beim Case „3“ hinterlegt wurde. Am Anfang wird der Anwender nach der Eingabe der zu suchenden Kursid gefragt. Im try-catch Konstrukt wird von repo Objekt aus die getById aufgerufen und dieser wird der eingelese Parameter namens courseId mitübergeben und das Ergebnis wird in ein Optional vom Typ Course namens courseOptional gespeichert. Weiters wird mit einem If-else Konstrukt geprüft, ob ein courseOptional bzw. ein Kurs vorliegt wenn ja dann wird dieser auf der Konsole ausgegeben ansonsten wird eine custom Konsolenausgabe ausgegeben.
Im catch Block werden die Exceptions bzw. Fehler abgefangen und ein wenig abgeändert durch eigens angepasste Fehlermeldungen mit Verkettung der Standardnachricht. Die Ausgabe im Fehlerfall erfolgt per Konsolenausgabe.

Anbei der Quellcode der showCourseDetails() Methode:

'''
private void showCourseDetails() {
    System.out.println("Für welchen Kurs möchten Sie die Kursdetails anzeigen?");
    Long courseId = Long.parseLong(scan.nextLine());
    try
    {
        Optional<Course> courseOptional = repo.getById(courseId);
        if(courseOptional.isPresent())
        {
            System.out.println(courseOptional.get());
        } else
        {
            System.out.println("Kurs mit der ID " + courseId + " nicht gefunden!");
        }
    } catch(DatabaseException databaseException)
    {
        System.out.println("Datenbankfehler bei Kurs-Detailanzeige: " + databaseException.getMessage());
    } catch (Exception exception)
    {
        System.out.println("Unbekannter Fehler bei Kurs-Detailanzeige: " + exception.getMessage());
    }
}
'''
  
Weiters wurde auch ein kleine Anpassung der showMenue() Methode vorgenommen wo lediglich die Konsolenausgabe angepasst werden musste. Hierzu ist folgende Abbildung ersichtlich:

![image](https://user-images.githubusercontent.com/91562113/158078621-76f03214-99ef-4fee-a2f1-8bbe99206423.png)

## CRUD Implementierung

Hierbei geht es um die Bereitstellung der Funktionalität zur Erstellung eines Kurses durch unser Cli-Menü. Die grundlegende Vorgangsweise ist folgende das zuerst die Daten vom Anwender abgefragt werden, der entsprechende Kurs erzeugt wird und der jeweilige Datensatz in die Datenbank geschrieben wird.

### Insert()

Erweiterung in der Cli-Klasse durch weitere Methode namens „addCourse“. Hierzu ist folgender Quellcode zu sehen:

'''
private void addCourse() {
    String name, description;
    int hours;
    Date dateFrom, dateTo;
    CourseType courseType;

    try
    {
        System.out.println("Bitte alle Kursdaten angeben: ");
        System.out.println("Name: ");
        name = scan.nextLine();
        if(name.equals("")) throw new IllegalArgumentException("Eingabe darf nicht leer sein!");
        System.out.println("Beschreibung: ");
        description = scan.nextLine();
        if(description.equals("")) throw new IllegalArgumentException("Eingabe darf nicht leer sein!");
        System.out.println("Stundenanzahl: ");
        hours = Integer.parseInt(scan.nextLine());
        System.out.println("Startdatum (YYYY-MM-DD): ");
        dateFrom = Date.valueOf(scan.nextLine());
        System.out.println("Enddatum (YYYY-MM-DD): ");
        dateTo = Date.valueOf(scan.nextLine());
        System.out.println("Kurstyp (ZA/BF/FF/OE): ");
        courseType = CourseType.valueOf(scan.nextLine());

        Optional<Course> optionalCourse = repo.insert(
                new Course(name,description,hours,dateFrom,dateTo,courseType)
        );

        if(optionalCourse.isPresent())
        {
            System.out.println("Kurs angelegt: " + optionalCourse.get());
        } else
        {
            System.out.println("Kurs konnte nicht angelegt werden!");
        }

    } catch(IllegalArgumentException illegalArgumentException)
    {
        System.out.println("Eingabefehler: " + illegalArgumentException.getMessage());
    } catch (InvalidValueException invalidValueException)
    {
        System.out.println("Kursdaten nicht korrekt angegeben: " + invalidValueException.getMessage());
    } catch (DatabaseException databaseException)
    {
        System.out.println("Datenbankfehler beim Einfügen: " + databaseException.getMessage());
    } catch (Exception exception)
    {
        System.out.println("Unbekannter Fehler beim Einfügen: " + exception.getMessage());
    }
}
'''

Als erstes wurden lokale Variablen mit den jeweiligen Typen deklariert. Im try-Block wurde der Anwender durch Meldungen auf der Konsole nach den benötigten Daten abgefragt. Diese wurde mittels Scanner der jeweiligen Variablen zugewiesen. An manchen Stellen wurde intern validiert mittels if (jew. Variable.equals(““)) … und dann Auswurf der jew. Exception mit einer eigenen Meldung. Bei den letzteren Abfragen hat man sich auf die Validierung innerhalb der Domäne verlassen. Nach Einlesen der Daten wurde ein Optional vom Typ Course definiert. Von der repo Variable wurde die Methode insert aufgerufen in der ein neuer Kurs erstellt wurde mit Übergabe der jew. lokalen Variablen. Das Ergebnis des insert Aufrufs wurde dem Optional Objekt zugewiesen. 

Des Weiteren wurde mittels if-Abfrage geprüft, ob im Optional überhaupt etwas verfügbar ist. Anhand dessen wurde bei Verfügbarkeit die Meldung ausgegeben das der Kurs angelegt wurde und ansonsten eine eigene Fehlermeldung, dass der Kurs nicht angelegt werden konnte.
Es wurden hierbei auch alle möglichen Exceptions mittels jew. catch Blöcke abgefangen.

## CRUD - Update Implementierung

Hierbei geht es um die Bereitstellung von der Funktionalität der Aktualisierung von jew. Entitäten.
Es wurde hierbei die update Methode mit dem Rückgabetyp Optional<Course> implementiert. Darunter ist folgender Quellcodeabschnitt ersichtlich:

'''
private void updateCourseDetails() {
    System.out.println("Für welche Kurs-ID möchten Sie die Kursdetails ändern?");
    Long courseId = Long.parseLong(scan.nextLine());

    try
    {
        Optional<Course> courseOptional = repo.getById(courseId);
        if(courseOptional.isEmpty())
        {
            System.out.println("Kurs mit der gegebenen ID nicht in der Datenbank!");
        } else
        {
            Course course = courseOptional.get();

            System.out.println("Änderungen für folgenden Kurs: ");
            System.out.println(course);

            String name, description, hours, dateFrom, dateTo, courseType;

            System.out.println("Bitte neue Kursdaten angeben (Enter, falls keine Änderung gewünscht ist):");
            System.out.println("Name: ");
            name = scan.nextLine();
            System.out.println("Beschreibung: ");
            description = scan.nextLine();
            System.out.println("Stundenanzahl: ");
            hours = scan.nextLine();
            System.out.println("Startdatum (YYYY-MM-DD): ");
            dateFrom = scan.nextLine();
            System.out.println("Enddatum (YYYY-MM-DD): ");
            dateTo = scan.nextLine();
            System.out.println("Kurstyp (ZA/BF/FF/OE): ");
            courseType = scan.nextLine();

            Optional<Course> optionalCourseUpdated = repo.update(
                    new Course(course.getId(),
                                name.equals("") ? course.getName() : name,
                                description.equals("") ? course.getDescription() : description,
                                hours.equals("") ? course.getHours() : Integer.parseInt(hours),
                                dateFrom.equals("") ? course.getBeginDate() : Date.valueOf(dateFrom),
                                dateTo.equals("") ? course.getEndDate() : Date.valueOf(dateTo),
                                courseType.equals("") ? course.getCourseType() : CourseType.valueOf(courseType)
                    )
            );

            //Funktionale Programmierung
            optionalCourseUpdated.ifPresentOrElse(
                    (c)-> System.out.println("Kurs aktualisiert: " + c),
                    ()-> System.out.println("Kurs konnte nicht aktualisiert werden!")
            );
        }
    } catch (Exception exception)
    {
        System.out.println("Unbekannter Fehler bei Kursupdate: " + exception.getMessage());
    }
}
'''

Hierbei wurde die update Methode ausimplementiert. Hier übergeben wir einen Kurs und aktualisieren die gewünschten Felder basierend auf der ID des übermittelten Kurses.
  
## CRUD – Delete Implementierung

Hierbei geht es um die Bereitstellung von der Funktionalität des Löschens von jew. Entitäten.
Es wurde hierbei die deleteCourse Methode mit dem Rückgabetyp void implementiert. Darunter ist folgender Quellcodeabschnitt ersichtlich:

'''
private void deleteCourse() {
    System.out.println("Welchen Kurs möchten Sie löschen? Bitte ID eingeben: ");
    Long courseIdToDelete = Long.parseLong(scan.nextLine());

    try
    {
        repo.deleteById(courseIdToDelete);
    }
    catch (DatabaseException databaseException)
    {
        System.out.println("Datenbankfehler beim Löschen: " + databaseException.getMessage());
    }
    catch (Exception e)
    {
        System.out.println("Unbekannter Fehler beim Löschen: " + e.getMessage());
    }
}
'''

Hier wird einfach der Benutzer nach der ID des zu löschenden Datensatzes abgefragt. Eingabe wurde per scanner eingelesen und wurde einer entsprechenden Variable zugewiesen. Im Try Block wird vom Repository Objekt aus die deleteById Methode aufgerufen. Dieser wurde natürlich die ID mittels Parameterübergabe der courseToDelete Variable übergeben. In den jeweiligen 2 catch Blöcken werden spezifische Fehlermeldungen mittels SysOut realisiert.
  
## DAO Implementierung Kurssuche

Hierbei ist es darum gegangen die Methoden zur Suche nach bestimmten Kursen mittels Name oder Beschreibung. Dazu wurde im SQL Statement die LOWER Anweisung angewendet und diese setzt die Werte lediglich auf Kleinschreibung um. Die Werte werden dann in Fragezeichen sog. Platzhalter hinzugefügt. Die Prozentzeichen dienen uns als Wildcards, um nach den benutzerdefinierten String zu suchen. Im Anschluss werden alle zutreffenden Zeilen in eine ArrayList hinzugefügt. Diese Ergebnisse werden einfach zurückgegeben.

![image](https://user-images.githubusercontent.com/91562113/158079002-1e9f43ab-46f2-4bfa-82a4-974b554a4dbe.png)

## DAO Implementierung Running Courses

![image](https://user-images.githubusercontent.com/91562113/158079024-d96417df-b193-4d9f-ad4e-9e31cd1910f5.png)

Als nächstes wurde die oben zu sehende Methode implementiert. Diese ähnelt sich mit vorgehender Methode stark. Das wichtigste was sich meistens ändert ist das SQL Statement.
  
# Aufgabe 4 JDBC und DAO - Studenten
Erweitere die fertig nachprogrammierte Applikation mit einem DAO für CRUD für eine neue Domänenklasse „Student“:
- Studenten haben einen eine Student-ID, einen VN, einen NN, ein Geburtsdatum
- Domänenklasse implementieren (Setter absichern, neue Exceptions definieren, Business-Regeln selbst wählen - z.B. dass Name nicht leer sein darf)
- Eigenes Interface MyStudentRepository von BaseRepository ableiten. MyStudentRepository muss mindestens 3 studentenspezifische Methoden enthalten (z.B. Studentensuche nach Namen, Suche nach ID, Suche nach bestimmtem Geburtsjahr, Suche mit Geburtsdatum zwischen x und y etc.).
- Implementierung von MyStudentRepository durch eine neue Klasse MySqlStudentRepository analog zum MySqlCourseRepository.
- Erweiterung des CLI für die Verarbeitung von Studenten und für spezifische Studenten-Funktionen (z.B. Student nach dem Namen suchen)

Der Quell Code zur Aufgabe ist im Stammverzeichnis enthalten.

# Aufgabe 5 JDBC und DAO - Buchungen
Gib einen textuellen Vorschlag hab, wie man die bisher programmierte Applikation für die Buchung von Kursen
durch Studenten erweitern könnte.
Beschreibe, wie eine neue Buchungs-Domänenklasse ausschauen sollte, wie man ein DAO für Buchungen dazu
entwickeln sollte, wie man die CLI anpassen müsste und welche Anwendungsfälle der Benutzer brauchen
könnte (wie etwa „Buchung erstellen“).
Verwende zur Illustration insb. auch UML-Diagramme.

Man könnte eine n zu m Verbindung zwischen der Student Entität und der Kurs Entität erstellen. Die daraus etablierte Zwischentabelle wird derzeit Buchung genannt. So kann ein Student über etliche Buchungen verfügen und ein Kurs kann zu vielerlei Buchungen gehören. In der Buchung könnte daraufhin z.B.: das Buchungsdatum und der Buchungszeitraum stehen, uvm.

Im „dataaccess“ Verzeichnis würde man jetzt eine MySqlBookingRepository Klasse & ein MyBookingRepository Interface erstellen und fertig implementieren. Im „domain“ Verzeichnis würde man eine Accounting Entität benötigen. In der Cli könnte man mühelos die Szenarien hinzufügen wie z.B.:

Basis Repository
- Alle Buchungen ausgeben
- Einzelne Buchungen auffinden und herausgeben
- Buchung aktualisieren
- Buchung löschen
- Buchung erstellen

MyBookingRepository
- Buchungen im Datum-Intervall von x bis y finden
- Abgelaufene Buchungen finden
- Laufende Buchungen finden  	

<p align = "center">
  <img src="https://user-images.githubusercontent.com/91562113/158075819-4524326e-c915-418f-80e0-be22537a416e.png"/>
</p>

In nachfolgender Abbildung wäre eine mögliche Version der Implementierung als ER-Modell zu sehen:
Ein dazugehöriges UML Diagramm könnte wie folgt aussehen:

<p align = "center">
  <img src="https://user-images.githubusercontent.com/91562113/158075866-2873717d-fb2c-4712-b2c9-f3fad8bb50b1.png"/>
</p>
