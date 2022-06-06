package Utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class UtilsDB {
	private static final String cadenaConexion=
            "jdbc:mysql://127.0.0.1:3306/bdgestorcasa";

    private static final String usuarioBD="root";
    private static final String contrasenaBD="capi1984";
    private static Connection conexion;
    //final significa que no sep uede modificar una vez arrancadon si se lo quitara se ccambiaria a todos los usuarios en vez de solo a uno
    //static si esta hace q todas tengan o hagan lo mismo mientras sea lo mismo claro....
    //static final cuando queremos q algunas cosas no cambien en nada durante todoo el programa.
    //La ultima sive para asegurarnos que solo vamos a tener una conexion por programa

    public static Statement conectarBD() {//java.sql es el que hay q importar

        try {
            if(conexion==null) {
                conexion=DriverManager.getConnection(
                        cadenaConexion,usuarioBD,contrasenaBD);
            }

            return conexion.createStatement();
            //Esto nos devuelve un objeto tipo String.
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("No se ha podido conectar, inténtalo luego");
            return null;

        }


    }

    public static void desconectarBD() {
        if(conexion!=null) {
            try {
                conexion.close();
                conexion=null;
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("No se pudo desconectar");
            }
        }
    }
}
