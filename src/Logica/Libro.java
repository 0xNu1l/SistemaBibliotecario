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
public class Libro {
    private String tituloLibro;
    private String genero;
    private int NLibro;
    private long codigoLibro;
    ConexionBD conexion = new ConexionBD();
    Connection cn = conexion.conexion();
    public Libro() {
    }
    public Libro(String tituloLibro, String genero, int nLibro) {
        this.tituloLibro = tituloLibro;
        this.genero = genero;
        this.NLibro = nLibro;
    }
        public String getTituloLibro() {
        return tituloLibro;
    }
    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getNLibro() {
        return NLibro;
    }
    public void setNLibro(int NLibro) {
        this.NLibro = NLibro;
    }
    public long getCodigoLibro() {
        return codigoLibro;
    }
    public void setCodigoLibro(long codigoLibro) {
        this.codigoLibro = codigoLibro;
    }
    public boolean añadirLibro(){
        boolean flag = false;
        try {
            PreparedStatement pps = cn.prepareStatement("INSERT INTO Libro(cantidad,nombre,genero) VALUES (?,?,?)"); 
//            pps.setLong(1, this.codigoLibro);
            pps.setInt(1, this.NLibro);
            pps.setString (2, this.tituloLibro);
            pps.setString(3, this.genero);
            pps.executeUpdate ();
            flag = true;
        } catch(SQLException ex) {
            Logger.getLogger(Libro.class.getName()).log(Level. SEVERE, null, ex);     
        }
        return flag;
    }
    public boolean actualizarLibro(String sql){
        boolean flag = false;
        try {
            PreparedStatement pps = cn.prepareStatement(sql);
            pps.executeUpdate();
            flag = true;
        } catch(SQLException ex) {
            Logger.getLogger(Libro.class.getName()).log(Level. SEVERE, null, ex);    
        }
        return flag;
    }
    public boolean eliminarLibro(){
        boolean flag = false;
        try {
            PreparedStatement pps = cn.prepareStatement("DELETE FROM Libro WHERE codigo_l="+this.codigoLibro); 
            pps.executeUpdate ();
            flag = true;
        } catch(SQLException ex) {
            Logger.getLogger(Libro.class.getName()).log(Level. SEVERE, null, ex);
        }
        return flag;
    }
    
    
    public boolean LibroestaDisponible(){
    int cantidad = 0;
    boolean resultado=false;
    Statement st;
    ResultSet rs=null;    
    try {   
        st = cn.createStatement();
        rs = st.executeQuery("SELECT cantidad FROM Libro WHERE codigo_l = "+ this.codigoLibro); 
        while(rs.next()){
            cantidad = rs.getInt("cantidad");
        }
        if(cantidad > 0){
            resultado = true;
        }
        
    }catch(SQLException ex) {
        Logger.getLogger(Libro.class.getName()).log(Level. SEVERE, null, ex); 
        JOptionPane.showMessageDialog (null, "No se sabe si esta disponible el libro ");     
    }
    return resultado;
    }
    
    
    public int obtenerCantidadLibro(long codigo){
    int cantidad = 0;
    Statement st;
    ResultSet rs = null;
    try{
        st = cn.createStatement();
        rs = st.executeQuery("SELECT cantidad FROM Libro WHERE codigo_l = "+codigo);
        while(rs.next()){
            cantidad = rs.getInt("cantidad");
        }
    }catch(SQLException ex) {
        Logger.getLogger(Libro.class.getName()).log(Level. SEVERE, null, ex); 
        JOptionPane.showMessageDialog (null, "Error al obtener la cantidad de libros");     
    }
    return cantidad;
}
    public void LibroDisponible(){
    int cantidad = obtenerCantidadLibro(this.codigoLibro);
    cantidad++;
    String c = String.valueOf(cantidad);
    System.out.println(c);
    try {   
        PreparedStatement pps = cn.prepareStatement("UPDATE Libro SET cantidad="+ c +" WHERE codigo_l = " +this.codigoLibro); 
        pps.executeUpdate();
            
    } catch(SQLException ex) {
        Logger.getLogger(Libro.class.getName()).log(Level. SEVERE, null, ex); 
        JOptionPane.showMessageDialog (null, "Ocurrio un error al ingresar los datos ");     
    }
}
    public JTable actualizarTabla(JTable tabla1){
        Statement st;
        ResultSet rs=null;
        JTable tabla = tabla1;
        try {   
        st = cn.createStatement();
        rs = st.executeQuery("SELECT * FROM Libro"); 
        DefaultTableModel dfm = new DefaultTableModel();
        tabla.setModel(dfm);
        dfm.setColumnIdentifiers(new Object[]{"Código","Cantidad","Nombre","Género"});
        while(rs.next()){
            dfm.addRow(new Object[]{rs.getInt("codigo_l"), rs.getInt("cantidad"), rs.getString("nombre"), rs.getString("genero")});
        }
    }catch(SQLException ex) {
        Logger.getLogger(JFBiblioteca.class.getName()).log(Level. SEVERE, null, ex); 
        JOptionPane.showMessageDialog (null, "Ocurrio un error al ingresar los datos ");     
    }
        return tabla;
    } 
    public void ActualizarTablaLibrosBusqueda(JTable tabla, String consulta){
    Statement st;
    ResultSet rs=null;    
    try {   
        st = cn.createStatement();      
        rs = st.executeQuery("SELECT * FROM Libro WHERE "+consulta); 
        DefaultTableModel dfm = new DefaultTableModel();
        tabla.setModel(dfm);
        dfm.setColumnIdentifiers(new Object[]{"Código","Cantidad","Nombre","Género"});
        while(rs.next()){
            dfm.addRow(new Object[]{rs.getInt("codigo_l"), rs.getInt("cantidad"), rs.getString("nombre"), rs.getString("genero")});
        }
        
        }catch(SQLException ex) {
        //Logger.getLogger(JFBibliotecaDB.class.getName()).log(Level. SEVERE, null, ex); 
        //JOptionPane.showMessageDialog (null, "Ocurrio un error al ingresar los datos ");     
    }
}
    public void LibroOcupado(){
    int cantidad = obtenerCantidadLibro(this.codigoLibro);
    cantidad--;
    String c = String.valueOf(cantidad);
    System.out.println(c);
    try {
        PreparedStatement pps = cn.prepareStatement("UPDATE Libro SET cantidad="+c+" WHERE codigo_l="+this.codigoLibro); 
        pps.executeUpdate();
            
    } catch(SQLException ex) {
        Logger.getLogger(JFBiblioteca.class.getName()).log(Level. SEVERE, null, ex); 
        JOptionPane.showMessageDialog (null, "Ocurrio un error al ingresar los datos ");     
    }
}

}
