package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorSql {

    public Connection bdd;

    public Connection getBdd() {
        String bddNom = "agence_photo";
        String user ="root";
        String usermdp ="";
        String url ="jdbc:mysql://localhost:3306/" + bddNom;

        try {
            bdd = DriverManager.getConnection(url,user,usermdp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return bdd;
    }
}
