package Logica;
import ConexionBD.ConexionBD;
import Vista.JFBiblioteca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Estudiante {
    ConexionBD conexion = new ConexionBD();
    Connection cn = conexion.conexion();
    private String nombre;
    private String apellidos;
    private long codigoEstudiante;
    public Estudiante() {
    }
    public Estudiante(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
        public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public long getCodigoEstudiante() {
        return codigoEstudiante;
    }
    public void setCodigoEstudiante(int codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }
    public boolean añadirEstudiante(){
        boolean flag = false;
        try {
            PreparedStatement pps = cn.prepareStatement("INSERT INTO Estudiante(nombres_e, apellidos_e) VALUES (?,?)"); 
//            pps.setLong(1, this.codigoEstudiante);
            pps.setString(1, this.nombre);
            pps.setString (2, this.apellidos);
            pps.executeUpdate ();
            flag = true;
        } catch(SQLException ex) {
            Logger.getLogger(Estudiante.class.getName()).log(Level. SEVERE, null, ex); 
            flag = false;     
        }
        return flag;
    }
    public boolean ActualizarEstudiante(String sql){
        boolean flag = false;
        try {
        PreparedStatement pps = cn.prepareStatement(sql);
        pps.executeUpdate();
        flag = true;
     } catch(SQLException ex) {
            Logger.getLogger(Estudiante.class.getName()).log(Level. SEVERE, null, ex); 
            JOptionPane.showMessageDialog (null, "Ocurrio un error al Actualizar los datos ");     
        }
        return flag;
    }
    public boolean EliminarEstudiante(){
        boolean flag = false;
        try {
            PreparedStatement pps = cn.prepareStatement("DELETE FROM Estudiante WHERE codigo_e="+this.codigoEstudiante); 
            pps.executeUpdate ();
            flag = true;
        } catch(SQLException ex) {
            Logger.getLogger(Estudiante.class.getName()).log(Level. SEVERE, null, ex); 
            JOptionPane.showMessageDialog (null, "Ocurrio un error al eliminar los datos ");     
        }
        return flag;
        
    }
    public JTable actualizarTabla(JTable tabla1){
    Statement st;
    ResultSet rs=null; 
    JTable tabla = tabla1;
    try {   
        st = cn.createStatement();
        rs = st.executeQuery("SELECT * FROM Estudiante"); 
        DefaultTableModel dfm = new DefaultTableModel();
        tabla.setModel(dfm);
        dfm.setColumnIdentifiers(new Object[]{"Código","Nombres","Apellidos"});
        while(rs.next()){
            dfm.addRow(new Object[]{rs.getInt("codigo_e"), rs.getString("nombres_e"), rs.getString("apellidos_e")});
        }
    }catch(SQLException ex) {
        Logger.getLogger(JFBiblioteca.class.getName()).log(Level. SEVERE, null, ex); 
    }        
        return tabla;
    }
    public void actualizarTablaBusqueda(JTable tabla1, String consulta){
    Statement st;
    ResultSet rs=null;    
    try {   
        st = cn.createStatement();       
        rs = st.executeQuery("SELECT * FROM Estudiante WHERE "+consulta); 
        DefaultTableModel dfm = new DefaultTableModel();
        tabla1.setModel(dfm);
        dfm.setColumnIdentifiers(new Object[]{"Código","Nombre","Apellido"});
        while(rs.next()){
            dfm.addRow(new Object[]{rs.getInt("codigo_e"), rs.getString("nombres_e"), rs.getString("apellidos_e")});
        }
        
        }catch(SQLException ex) {
        //Logger.getLogger(JFBibliotecaDB.class.getName()).log(Level. SEVERE, null, ex); 
        //JOptionPane.showMessageDialog (null, "Ocurrio un error al ingresar los datos ");     
    }
    }
}
