package Logica;
import ConexionBD.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Login {
       //instanciamos globalmente la clase conexionDB para que podamos hacer uso del metodo conexion();
    public static ConexionBD cnBD = new ConexionBD();
    public static Connection cn = cnBD.conexion();
    private static String user;
    //GETTERS AND SETTERS para saber que usuario esta logeado
    public static String getUser() {
        return user;
    }
    public static void setUser(String user) {
        Login.user = user;
    }
    //METODO PARA EL LOGIN
    public boolean loginUsers(String usuario, String password) {
        //buscamos si los datos ingresados estan en la tabla
        String SQL = "SELECT *FROM base_biblioteca.usuarios WHERE nombre_u='" + usuario + "' and contraseña_u='" + password + "'";
        this.user = usuario;
        try {
            Statement ps = cn.createStatement();
            ResultSet rs = ps.executeQuery(SQL);

            if (rs.next()) {
                System.out.println("Usuario encontrado");
                System.out.println("Contraseña Correcta");
                return true;

            } else {
                System.out.println(rs.next());
                System.out.println("Usuario NO registrado");
                System.out.println(SQL + "->" + " La instruccion es incorrecta en SQL");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return false;
    }
}
