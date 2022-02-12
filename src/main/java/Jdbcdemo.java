import java.sql.*;

public class Jdbcdemo {

    public static void main(String[] args) {
        System.out.println("JDBC Demo!");
        //INSERT INTO `student` (`id`, `name`, `email`) VALUES (NULL, 'Claudio Landerer', 'claudio.landerer@myimst.at'), (NULL, 'Maria Könne', 'maria.koenne@myimst.at');

        selectAllDemo();
        insertStudentDemo("Name des Studenten", "Email@prov.at");
        selectAllDemo();
        updateStudentDemo(4, "Neuer Name", "neueemail@provider.at");
        selectAllDemo();
        deleteStudentDemo(9);
        selectAllDemo();
        findAllByNameLike("zeck");
    }

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
}
