package Logica;
import ConexionBD.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Prestamo {
    private long codigoPrestamo;
    private Estudiante estudiante;
    private Libro libro;
    ConexionBD conexion = new ConexionBD();
    Connection cn = conexion.conexion();

    public Prestamo() {
    }
    public Prestamo(Estudiante estudiante, Libro libro) {
        this.estudiante = estudiante;
        this.libro = libro;
    }
        public long getCodigoPrestamo() {
        return codigoPrestamo;
    }

    public void setCodigoPrestamo(long codigoPrestamo) {
        this.codigoPrestamo = codigoPrestamo;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    public boolean añadirPrestamo(String dateDevolucion){
        boolean flag = false;
        try {
            PreparedStatement pps = cn.prepareStatement("INSERT into Prestamo(codigo_l,codigo_e,fecha_desde,fecha_hasta,multas) VALUES (?,?,?,?,?)"); 
//            pps.setLong(1, this.codigoPrestamo);
            pps.setLong(1, this.libro.getCodigoLibro());
            pps.setLong (2, this.estudiante.getCodigoEstudiante());
            pps.setString(3,this.fechaActual());
            pps.setString(4,dateDevolucion);
            pps.setInt(5,0);
            pps.executeUpdate();
            libro.LibroOcupado();
            flag = true;
        } catch(SQLException ex) {
            Logger.getLogger(Prestamo.class.getName()).log(Level. SEVERE, null, ex); 
        }
        return flag;
    }
    public void setMultas(){
        boolean flag = false;
        int x;
        DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal=Calendar.getInstance();
        Date date=cal.getTime();
        String fechaAct=dateFormat.format(date);
        try {
            Statement stat = cn.createStatement();
            ResultSet rs = stat.executeQuery("SELECT codigo_le,fecha_hasta FROM prestamo");
            
            while(rs.next()){  
                Prestamo aux = new Prestamo();
                aux.codigoPrestamo=rs.getInt(1);
                String fechaDevuelta = rs.getString(2);
                Date fechadevuelta = dateFormat.parse(fechaDevuelta);  
                //fechadevuelta.
                long constante= (date.getTime() - (fechadevuelta.getTime()));
                if (constante > 0) {
                    aux.actualizarPrestamo("UPDATE prestamo SET multas ="+ constante/100000000 +" WHERE codigo_le="+aux.codigoPrestamo);
                } 
            }

        } catch (SQLException ex) {
            Logger.getLogger(Prestamo.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminar los datos ");
        } catch (ParseException ex) {
            Logger.getLogger(Prestamo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public boolean actualizarPrestamo(String sql){
        boolean flag = false;
        try {
            PreparedStatement pps = cn.prepareStatement(sql);
            pps.executeUpdate();
            flag = true;
        } catch(SQLException ex) {
            Logger.getLogger(Prestamo.class.getName()).log(Level. SEVERE, null, ex);    
        }
        return flag;
    }
   
    public String fechaActual(){
        SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date dateObj = calendar.getTime();
        String formattedDate = dtf.format(dateObj);
        return formattedDate;
        
        }
    
    public boolean verificarMultas(){
        boolean x=false;
        
        try {
            Statement stat = cn.createStatement();
            ResultSet rs = stat.executeQuery("SELECT multas FROM prestamo WHERE codigo_le=" + this.codigoPrestamo);
            rs.next();
            int multas = rs.getInt(1);


            if (multas > 0) {
                x=true; 
            } 

        } catch (SQLException ex) {
            Logger.getLogger(Prestamo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }
    
    public void eliminarRegistro(){
        this.libro.LibroDisponible();
        
        try {
            PreparedStatement pps;
            pps = cn.prepareStatement("DELETE FROM prestamo WHERE codigo_le=" + this.codigoPrestamo);
            pps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Prestamo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public JTable ActualizarTablaPrestamos(JTable tabla1){
    Statement st;
    ResultSet rs=null; 
    JTable tabla = tabla1;
    try {   
        st = cn.createStatement();
        rs = st.executeQuery("SELECT * FROM Prestamo"); 
        DefaultTableModel dfm = new DefaultTableModel();
        tabla.setModel(dfm);
        dfm.setColumnIdentifiers(new Object[]{"Codigo Prestamo","Codigo Libro","Código Estudiante","Fecha Prestamo","Fecha Devolucion","Multas"});
        while(rs.next()){
            dfm.addRow(new Object[]{rs.getInt("codigo_le"), rs.getInt("codigo_l"), rs.getInt("codigo_e"),rs.getString("fecha_desde"),rs.getString("fecha_hasta"),rs.getInt("multas")});
        }
    }catch(SQLException ex) {
        Logger.getLogger(Prestamo.class.getName()).log(Level. SEVERE, null, ex); 
        JOptionPane.showMessageDialog (null, "Ocurrio un error al mostrar la tabla ");     
    }
    return tabla;
}
    
    public void ActualizarTablaPrestamosBusqueda(JTable tabla1, String consulta){
    Statement st;
    ResultSet rs=null; 
    try {   
        st = cn.createStatement();
        rs = st.executeQuery(consulta); 
        DefaultTableModel dfm = new DefaultTableModel();
        tabla1.setModel(dfm);
        dfm.setColumnIdentifiers(new Object[]{"Codigo Prestamo","Codigo Libro","Código Estudiante","Fecha Prestamo","Fecha Devolucion","Multas"});
        while(rs.next()){
            dfm.addRow(new Object[]{rs.getInt("codigo_le"), rs.getInt("codigo_l"), rs.getInt("codigo_e"),rs.getString("fecha_desde"),rs.getString("fecha_hasta"),rs.getInt("multas")});
        }
    }catch(SQLException ex) {
        Logger.getLogger(Prestamo.class.getName()).log(Level. SEVERE, null, ex); 
        //JOptionPane.showMessageDialog (null, "Ocurrio un error al mostrar la tabla ");     
    }

}
}
