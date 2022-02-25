package ConexionBD;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionBD {

    Connection cn;

    public Connection conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/base_biblioteca", "root", "root");
//            JOptionPane.showMessageDialog(null, "Coneccion Exitosa");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la coneccion");
//            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cn;
    }
}
