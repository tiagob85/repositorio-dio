package part2;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        String urlConnection = "jdbc:mysql://localhost/digital_innovation_one";
      //  Connection conn = null;

        System.out.println("teste  1");

        try (Connection conn = DriverManager.getConnection(urlConnection, "root", "admin123"))
            {System.out.println("Sucesso !");
        }catch (Exception ex){
            System.out.println("Falha na conexão");
        }

    }
}
