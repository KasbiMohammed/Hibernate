
package tar;
 import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ExoJDBC {
  

    public static void main(String[] args) {
        String user = "root";
        String password = "";
        String url = "jdbc:mysql://localhost/db2";
        Connection cn = null;
        Statement st = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url, user, password);
            st = cn.createStatement();
             String createTabSQL = "CREATE TABLE DevData ("
                    + "Developpeurs VARCHAR(32),"
                    + "Jour CHAR(11),"
                    + "NbScripts INTEGER)";
            st.executeUpdate(createTabSQL);

            String insertDataSQL1 = "INSERT INTO DevData VALUES ('ALAMI', 'Lundi', 1)";
            String insertDataSQL2 = "INSERT INTO DevData VALUES ('WAFI', 'Lundi', 2)";
            String insertDataSQL3 = "INSERT INTO DevData VALUES ('SLAMI', 'Mardi', 9)";
            st.executeUpdate(insertDataSQL1);
            st.executeUpdate(insertDataSQL2);
            st.executeUpdate(insertDataSQL3);

            System.out.println("Table créée et données insérées avec succès.");

            
            ResultSet resultSet1 = st.executeQuery("SELECT Developpeurs, Jour, MAX(NbScripts) FROM DevData GROUP BY Jour");
            while (resultSet1.next()) {
                System.out.println("Jour : " + resultSet1.getString("Jour") + ", Développeur : " + resultSet1.getString("Developpeurs") + ", Max scripts : " + resultSet1.getInt(3));
            }

            // (b) La liste des personnes triée dans l'ordre décroissant selon leur nombre de scripts
            ResultSet resultSet2 = st.executeQuery("SELECT Developpeurs, SUM(NbScripts) AS TotalScripts FROM DevData GROUP BY Developpeurs ORDER BY TotalScripts DESC");
            while (resultSet2.next()) {
                System.out.println("Développeur : " + resultSet2.getString("Developpeurs") + ", Total scripts : " + resultSet2.getInt("TotalScripts"));
            }

            // Exercice 3 : Exécuter une requête libre
            // Vous devez saisir votre propre requête SQL à exécuter ici
            String requete = "SELECT * FROM DevData";
            ResultSet resultSet3 = st.executeQuery(requete);

            ResultSetMetaData metaData = resultSet3.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Afficher le nombre de colonnes
            System.out.println("Nombre de colonnes : " + columnCount);

            // Afficher les noms et types des colonnes
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Nom de colonne : " + metaData.getColumnName(i) + ", Type : " + metaData.getColumnTypeName(i));
            }

            // Afficher le contenu de la table
            while (resultSet3.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet3.getString(i) + "\t");
                }
                System.out.println();
            }

            System.out.println("Requête exécutée avec succès.");

        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Impossible de charger le driver : " + ex.getMessage());
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Impossible de libérer les ressources : " + ex.getMessage());
            }
    }
}

}