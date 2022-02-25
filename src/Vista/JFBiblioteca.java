package Vista;

import Logica.*;
import java.awt.Color;
import java.awt.Image;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
public class JFBiblioteca extends javax.swing.JFrame implements Runnable {
    String hora, min, seg;
    Thread hilo;
    JFAddLibro jfaddlibro;
    JFAddEstudiante jfaddestudiante;
    JFEditEstudiante jfeditestudiante;
    JFModificarLibro jfmodificarlibro;
    JFAddPrestamo jfaddprestamo;
    JFElimPrestamo jfelimprestamo;
    Login log = new Login();
    public JFBiblioteca() {
        Prestamo prestamo = new Prestamo();
        prestamo.setMultas();
        initComponents();
        this.setLocationRelativeTo(null);
        scaleImage();
        getFechaHora();
        showPanel();
        hilo = new Thread(this);
        hilo.start();
        setVisible(true);
        jfaddlibro = new JFAddLibro(this.jTLibros);
        jfaddestudiante = new JFAddEstudiante(this.jTEstudiantes);
        jfeditestudiante = new JFEditEstudiante(this.jTEstudiantes);
        jfmodificarlibro = new JFModificarLibro(this.jTLibros);
        jfaddprestamo = new JFAddPrestamo(this.jTPrestamos);
        jfelimprestamo = new JFElimPrestamo(this.jTPrestamos);
    }
    public void showPanel() {
        this.PEstudiantes.setVisible(false);
        this.PLibros.setVisible(false);
        this.PPrestamos.setVisible(false);
        this.PAboutUs.setVisible(false);
        lblUsers.setText(log.getUser());
        lblUsers.setForeground(Color.white);
    }
    public void Hora() {
        Calendar calendario = new GregorianCalendar();
        Date horaActual = new Date();
        calendario.setTime(horaActual);
        hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        min = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        seg = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
    }
    public void run() {
        Thread current = Thread.currentThread();
        while (current == hilo) {
            Hora();
            lblHora.setText(hora + ":" + min + ":" + seg);
            Libro libro = new Libro();
            Estudiante estudiante = new Estudiante();
            libro.actualizarTabla(jTLibros);
            estudiante.actualizarTabla(jTEstudiantes);
            contarEstud();
            contarLib();
            contarMult();
        }
    }
    //Obtener Fecha y Hora
    public void getFechaHora() {
        //Hora actual
        LocalTime HoraActual = LocalTime.now();
        //Fecha Actual
        LocalDate FechaActual = LocalDate.now();
        //Hora y fecha Actual
        LocalDateTime fechaHora = LocalDateTime.now();
        this.lblFechaHora.setText("" + FechaActual);
    }
    //Escalar imagenes del inicio
    public void scaleImage() {
        //Bibliotecario
        ImageIcon iconBiblio = new ImageIcon(getClass().getResource("/Imagenes/bibliotecario.png"));
        Image imageBilio = (iconBiblio).getImage().getScaledInstance(this.iconoAdmin0.getWidth(), iconoAdmin0.getHeight(), Image.SCALE_SMOOTH);
        iconBiblio = new ImageIcon(imageBilio);
        iconoAdmin0.setIcon(iconBiblio);
        //EscudoEpn
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/EPN.png"));
        Image image = (icon).getImage().getScaledInstance(this.iconoLogoEpn.getWidth(), iconoLogoEpn.getHeight(), Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        iconoLogoEpn.setIcon(icon);
        //Fecha/Hora
        ImageIcon iconFechaHora = new ImageIcon(getClass().getResource("/Imagenes/FechaHora.png"));
        Image imageFecha = (iconFechaHora).getImage().getScaledInstance(this.iconoCalendarioHora.getWidth(), iconoCalendarioHora.getHeight(), Image.SCALE_SMOOTH);
        iconFechaHora = new ImageIcon(imageFecha);
        iconoCalendarioHora.setIcon(iconFechaHora);
        //Admin
        ImageIcon iconoAdminis = new ImageIcon(getClass().getResource("/Imagenes/admin.png"));
        Image imageAdmin = (iconoAdminis).getImage().getScaledInstance(this.iconoAdmin.getWidth(), iconoAdmin.getHeight(), Image.SCALE_SMOOTH);
        iconoAdminis = new ImageIcon(imageAdmin);
        iconoAdmin.setIcon(iconoAdminis);
        //PoradaLibro
        ImageIcon iconLibro = new ImageIcon(getClass().getResource("/Imagenes/libro.png"));
        Image imageLibro = (iconLibro).getImage().getScaledInstance(this.iconoLibro.getWidth(), iconoLibro.getHeight(), Image.SCALE_SMOOTH);
        iconLibro = new ImageIcon(imageLibro);
        iconoLibro.setIcon(iconLibro);
        //IconoHome
        ImageIcon iconeHome = new ImageIcon(getClass().getResource("/Imagenes/Home.png"));
        Image imageHome = (iconeHome).getImage().getScaledInstance(this.iconHome.getWidth(), this.iconHome.getHeight(), Image.SCALE_SMOOTH);
        iconeHome = new ImageIcon(imageHome);
        iconHome.setIcon(iconeHome);
        //Estudiante
        ImageIcon iconRegis = new ImageIcon(getClass().getResource("/Imagenes/RegistroEstudiante.png"));
        Image imageEstu = (iconRegis).getImage().getScaledInstance(this.iconoEstud.getWidth(), iconoEstud.getHeight(), Image.SCALE_SMOOTH);
        iconRegis = new ImageIcon(imageEstu);
        iconoEstud.setIcon(iconRegis);
        //AñadirLibro
        ImageIcon iconoLibro = new ImageIcon(getClass().getResource("/Imagenes/AñadirLib.png"));
        Image imageLib = (iconoLibro).getImage().getScaledInstance(this.iconLib.getWidth(), iconLib.getHeight(), Image.SCALE_SMOOTH);
        iconoLibro = new ImageIcon(imageLib);
        iconLib.setIcon(iconoLibro);
        //Prestamos y multas
        ImageIcon iconPrestamo = new ImageIcon(getClass().getResource("/Imagenes/prestamo.png"));
        Image imagePrest = (iconPrestamo).getImage().getScaledInstance(this.iconoPrestamo.getWidth(), iconoPrestamo.getHeight(), Image.SCALE_SMOOTH);
        iconPrestamo = new ImageIcon(imagePrest);
        iconoPrestamo.setIcon(iconPrestamo);
        //SobreNosotros
        ImageIcon iconSobre = new ImageIcon(getClass().getResource("/Imagenes/AboutUs.png"));
        Image imageSobre = (iconSobre).getImage().getScaledInstance(this.iconoSobreNosotros.getWidth(), iconoSobreNosotros.getHeight(), Image.SCALE_SMOOTH);
        iconSobre = new ImageIcon(imageSobre);
        iconoSobreNosotros.setIcon(iconSobre);
        //Añadir Estudiante
        ImageIcon iconEstud = new ImageIcon(getClass().getResource("/Imagenes/AñadirEstud.png"));
        Image imageAñadir = (iconEstud).getImage().getScaledInstance(this.EiconoAñadir.getWidth(), EiconoAñadir.getHeight(), Image.SCALE_SMOOTH);
        iconEstud = new ImageIcon(imageAñadir);
        EiconoAñadir.setIcon(iconEstud);
        //Modificar Estudiante
        ImageIcon iconModif = new ImageIcon(getClass().getResource("/Imagenes/ModificarEstud.png"));
        Image imageModif = (iconModif).getImage().getScaledInstance(this.EiconoModificar.getWidth(), EiconoModificar.getHeight(), Image.SCALE_SMOOTH);
        iconModif = new ImageIcon(imageModif);
        EiconoModificar.setIcon(iconModif);

        //Lupa
        ImageIcon iconLupa = new ImageIcon(getClass().getResource("/Imagenes/Lupa.png"));
        Image imageLupa = (iconLupa).getImage().getScaledInstance(this.EiconoLupa.getWidth(), EiconoLupa.getHeight(), Image.SCALE_SMOOTH);
        iconLupa = new ImageIcon(imageLupa);
        EiconoLupa.setIcon(iconLupa);
        //Lupa
        ImageIcon iconLupaPrest = new ImageIcon(getClass().getResource("/Imagenes/Lupa.png"));
        Image imageLupa1 = (iconLupaPrest).getImage().getScaledInstance(this.PMiconoLupa.getWidth(), PMiconoLupa.getHeight(), Image.SCALE_SMOOTH);
        iconLupaPrest = new ImageIcon(imageLupa1);
        PMiconoLupa.setIcon(iconLupaPrest);
        //Añadir Libro
        ImageIcon iconoLib = new ImageIcon(getClass().getResource("/Imagenes/AñadirLib_1.png"));
        Image imageAñadirLib = (iconoLib).getImage().getScaledInstance(this.LiconoAñadir.getWidth(), LiconoAñadir.getHeight(), Image.SCALE_SMOOTH);
        iconoLib = new ImageIcon(imageAñadirLib);
        LiconoAñadir.setIcon(iconoLib);

        //Eliminar Libro
        ImageIcon iconElimiLib = new ImageIcon(getClass().getResource("/Imagenes/EliminarLib.png"));
        Image imageEliminarLib = (iconElimiLib).getImage().getScaledInstance(this.LiconoEliminar.getWidth(), LiconoEliminar.getHeight(), Image.SCALE_SMOOTH);
        iconElimiLib = new ImageIcon(imageEliminarLib);
        LiconoEliminar.setIcon(iconElimiLib);
        //Lupa
        ImageIcon iconLupa1 = new ImageIcon(getClass().getResource("/Imagenes/Lupa.png"));
        Image imageLupa2 = (iconLupa1).getImage().getScaledInstance(this.LiconoLupa.getWidth(), LiconoLupa.getHeight(), Image.SCALE_SMOOTH);
        iconLupa1 = new ImageIcon(imageLupa2);
        LiconoLupa.setIcon(iconLupa1);
        //Prestamos
        ImageIcon iconoPrestm1 = new ImageIcon(getClass().getResource("/Imagenes/Prestamo_1.png"));
        Image imagePrest1 = (iconoPrestm1).getImage().getScaledInstance(this.PiconoPrestamo.getWidth(), PiconoPrestamo.getHeight(), Image.SCALE_SMOOTH);
        iconoPrestm1 = new ImageIcon(imagePrest1);
        PiconoPrestamo.setIcon(iconoPrestm1);
        //EliminarPrestamo
        ImageIcon iconoEliPres = new ImageIcon(getClass().getResource("/Imagenes/EliminarMulta.png"));
        Image imageEliPrest = (iconoEliPres).getImage().getScaledInstance(this.PiconoElimiPrest.getWidth(), PiconoElimiPrest.getHeight(), Image.SCALE_SMOOTH);
        iconoEliPres = new ImageIcon(imageEliPrest);
        PiconoElimiPrest.setIcon(iconoEliPres);

        //CerrarSesion
        ImageIcon iconoCerrar = new ImageIcon(getClass().getResource("/Imagenes/cerrar-sesion.png"));
        Image imageCerrar = (iconoCerrar).getImage().getScaledInstance(this.iconoCerrarSesion.getWidth(), iconoCerrarSesion.getHeight(), Image.SCALE_SMOOTH);
        iconoCerrar = new ImageIcon(imageCerrar);
        iconoCerrarSesion.setIcon(iconoCerrar);

        //BOOKS
        ImageIcon imageBOOK = new ImageIcon(getClass().getResource("/Imagenes/BOOKS.jpg"));
        Image imageBK = (imageBOOK).getImage().getScaledInstance(this.IMAGEBOOK.getWidth(), IMAGEBOOK.getHeight(), Image.SCALE_SMOOTH);
        imageBOOK = new ImageIcon(imageBK);
        IMAGEBOOK.setIcon(imageBOOK);

        //PerfilPaul
        ImageIcon imagePaul = new ImageIcon(getClass().getResource("/Imagenes/PAUL.jpeg"));
        Image imageP = (imagePaul).getImage().getScaledInstance(this.iconoPaul.getWidth(), iconoPaul.getHeight(), Image.SCALE_SMOOTH);
        imagePaul = new ImageIcon(imageP);
        iconoPaul.setIcon(imagePaul);
        //PerfilAngel
        ImageIcon imageAngel = new ImageIcon(getClass().getResource("/Imagenes/ANGEL.jpeg"));
        Image imageA = (imageAngel).getImage().getScaledInstance(this.iconoAngel.getWidth(), iconoAngel.getHeight(), Image.SCALE_SMOOTH);
        imageAngel = new ImageIcon(imageA);
        iconoAngel.setIcon(imageAngel);
        //PerfilWilliam
        ImageIcon imageWilliam = new ImageIcon(getClass().getResource("/Imagenes/WILLIAM.jpg"));
        Image imageW = (imageWilliam).getImage().getScaledInstance(this.iconoWilliam.getWidth(), iconoWilliam.getHeight(), Image.SCALE_SMOOTH);
        imageWilliam = new ImageIcon(imageW);
        iconoWilliam.setIcon(imageWilliam);
        //PerfilJohan
        ImageIcon imageJohan = new ImageIcon(getClass().getResource("/Imagenes/JOHAN.jpeg"));
        Image imageJ = (imageJohan).getImage().getScaledInstance(this.iconoJohan.getWidth(), iconoJohan.getHeight(), Image.SCALE_SMOOTH);
        imageJohan = new ImageIcon(imageJ);
        iconoJohan.setIcon(imageJohan);
        //PerfilGary
        ImageIcon imageGary = new ImageIcon(getClass().getResource("/Imagenes/GARY.jpg"));
        Image imageG = (imageGary).getImage().getScaledInstance(this.iconoGary.getWidth(), iconoGary.getHeight(), Image.SCALE_SMOOTH);
        imageGary = new ImageIcon(imageG);
        iconoGary.setIcon(imageGary);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Container = new javax.swing.JPanel();
        iconoLibro = new javax.swing.JLabel();
        TopBar = new javax.swing.JPanel();
        TolBar = new javax.swing.JPanel();
        lblFechaHora = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        iconoCalendarioHora = new javax.swing.JLabel();
        iconoAdmin = new javax.swing.JLabel();
        lblUsers = new javax.swing.JLabel();
        iconoCerrarSesion = new javax.swing.JLabel();
        EPN = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        iconoLogoEpn = new javax.swing.JLabel();
        Opciones = new javax.swing.JPanel();
        Inicio = new javax.swing.JPanel();
        btnIniciotxt = new javax.swing.JLabel();
        iconHome = new javax.swing.JLabel();
        RegistroEstudiante = new javax.swing.JPanel();
        btnEstudTxt = new javax.swing.JLabel();
        iconoEstud = new javax.swing.JLabel();
        RegistroLibro = new javax.swing.JPanel();
        btnLibTxt = new javax.swing.JLabel();
        iconLib = new javax.swing.JLabel();
        PrestamoMulta = new javax.swing.JPanel();
        btnPrestamoTxt = new javax.swing.JLabel();
        iconoPrestamo = new javax.swing.JLabel();
        SobreNosotros = new javax.swing.JPanel();
        btnSobreUsTxt = new javax.swing.JLabel();
        iconoSobreNosotros = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Contenido = new javax.swing.JLayeredPane();
        PInicio = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        iconoAdmin0 = new javax.swing.JLabel();
        IMAGEBOOK = new javax.swing.JLabel();
        PEstudiantes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTEstudiantes = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        EtxtBusqueda = new javax.swing.JTextField();
        EiconoLupa = new javax.swing.JLabel();
        EPanelAñadir = new javax.swing.JPanel();
        btnAñadirEstuxt = new javax.swing.JLabel();
        EiconoAñadir = new javax.swing.JLabel();
        EPanelModif = new javax.swing.JPanel();
        btnModificarEstuTxt = new javax.swing.JLabel();
        EiconoModificar = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblCountEstud = new javax.swing.JLabel();
        PLibros = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        LtxtBusqueda = new javax.swing.JTextField();
        LiconoLupa = new javax.swing.JLabel();
        LPanelElimiLib = new javax.swing.JPanel();
        LiconoEliminar = new javax.swing.JLabel();
        btnModificarLibrTxt = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTLibros = new javax.swing.JTable();
        LPanelAñadirLib = new javax.swing.JPanel();
        btnAñadirLibTxt = new javax.swing.JLabel();
        LiconoAñadir = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblCountLib = new javax.swing.JLabel();
        PPrestamos = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        PPanelPrestamo = new javax.swing.JPanel();
        btnPrestamoLibTxt = new javax.swing.JLabel();
        PiconoPrestamo = new javax.swing.JLabel();
        PPEliminarPrestamo = new javax.swing.JPanel();
        btnEliminarPrestamoLibTxt = new javax.swing.JLabel();
        PiconoElimiPrest = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTPrestamos = new javax.swing.JTable();
        PMiconoLupa = new javax.swing.JLabel();
        LtxtBusquedaPrestamosMultas = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        lblCountMult = new javax.swing.JLabel();
        PAboutUs = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        iconoPaul = new javax.swing.JLabel();
        iconoWilliam = new javax.swing.JLabel();
        iconoJohan = new javax.swing.JLabel();
        iconoAngel = new javax.swing.JLabel();
        iconoGary = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Bibliotecario");
        setResizable(false);

        TolBar.setBackground(new java.awt.Color(37, 40, 80));
        TolBar.setToolTipText("");

        lblFechaHora.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblFechaHora.setForeground(new java.awt.Color(255, 255, 255));

        lblHora.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblHora.setForeground(new java.awt.Color(255, 255, 255));
        lblHora.setToolTipText("");

        iconoAdmin.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblUsers.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblUsers.setForeground(new java.awt.Color(255, 255, 255));
        lblUsers.setText(": ....");

        iconoCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconoCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconoCerrarSesionMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout TolBarLayout = new javax.swing.GroupLayout(TolBar);
        TolBar.setLayout(TolBarLayout);
        TolBarLayout.setHorizontalGroup(
            TolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TolBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconoAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 468, Short.MAX_VALUE)
                .addComponent(iconoCalendarioHora, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblFechaHora, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(iconoCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        TolBarLayout.setVerticalGroup(
            TolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFechaHora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TolBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(TolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(iconoCalendarioHora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsers, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(iconoAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(TolBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconoCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        EPN.setBackground(new java.awt.Color(255, 0, 0));

        jLabel1.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ESCUELA POLITÉCNICA NACIONAL");

        javax.swing.GroupLayout EPNLayout = new javax.swing.GroupLayout(EPN);
        EPN.setLayout(EPNLayout);
        EPNLayout.setHorizontalGroup(
            EPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
        );
        EPNLayout.setVerticalGroup(
            EPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout TopBarLayout = new javax.swing.GroupLayout(TopBar);
        TopBar.setLayout(TopBarLayout);
        TopBarLayout.setHorizontalGroup(
            TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TopBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iconoLogoEpn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        TopBarLayout.setVerticalGroup(
            TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TopBarLayout.createSequentialGroup()
                .addGroup(TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(iconoLogoEpn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EPN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, TopBarLayout.createSequentialGroup()
                        .addComponent(TolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        Opciones.setBackground(new java.awt.Color(37, 40, 80));
        Opciones.setToolTipText("");

        Inicio.setBackground(new java.awt.Color(37, 40, 80));
        Inicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Inicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                InicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                InicioMouseExited(evt);
            }
        });

        btnIniciotxt.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btnIniciotxt.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciotxt.setText("Inicio");
        btnIniciotxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIniciotxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIniciotxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIniciotxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIniciotxtMouseExited(evt);
            }
        });

        iconHome.setForeground(new java.awt.Color(255, 255, 102));
        iconHome.setAlignmentY(0.0F);
        iconHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                iconHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                iconHomeMouseExited(evt);
            }
        });

        javax.swing.GroupLayout InicioLayout = new javax.swing.GroupLayout(Inicio);
        Inicio.setLayout(InicioLayout);
        InicioLayout.setHorizontalGroup(
            InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InicioLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(iconHome, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnIniciotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        InicioLayout.setVerticalGroup(
            InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnIniciotxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(InicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconHome, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        RegistroEstudiante.setBackground(new java.awt.Color(37, 40, 80));
        RegistroEstudiante.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RegistroEstudiante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RegistroEstudianteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RegistroEstudianteMouseExited(evt);
            }
        });

        btnEstudTxt.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btnEstudTxt.setForeground(new java.awt.Color(255, 255, 255));
        btnEstudTxt.setText("Registro de Estudiantes");
        btnEstudTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEstudTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEstudTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEstudTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEstudTxtMouseExited(evt);
            }
        });

        iconoEstud.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                iconoEstudMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                iconoEstudMouseExited(evt);
            }
        });

        javax.swing.GroupLayout RegistroEstudianteLayout = new javax.swing.GroupLayout(RegistroEstudiante);
        RegistroEstudiante.setLayout(RegistroEstudianteLayout);
        RegistroEstudianteLayout.setHorizontalGroup(
            RegistroEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegistroEstudianteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(iconoEstud, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEstudTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        RegistroEstudianteLayout.setVerticalGroup(
            RegistroEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEstudTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(RegistroEstudianteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconoEstud, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        RegistroLibro.setBackground(new java.awt.Color(37, 40, 80));
        RegistroLibro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RegistroLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RegistroLibroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RegistroLibroMouseExited(evt);
            }
        });

        btnLibTxt.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btnLibTxt.setForeground(new java.awt.Color(255, 255, 255));
        btnLibTxt.setText("Registro Libros y Catalogos");
        btnLibTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLibTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLibTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLibTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLibTxtMouseExited(evt);
            }
        });

        iconLib.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                iconLibMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                iconLibMouseExited(evt);
            }
        });

        javax.swing.GroupLayout RegistroLibroLayout = new javax.swing.GroupLayout(RegistroLibro);
        RegistroLibro.setLayout(RegistroLibroLayout);
        RegistroLibroLayout.setHorizontalGroup(
            RegistroLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegistroLibroLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(iconLib, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLibTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        RegistroLibroLayout.setVerticalGroup(
            RegistroLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnLibTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(RegistroLibroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconLib, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PrestamoMulta.setBackground(new java.awt.Color(37, 40, 80));
        PrestamoMulta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PrestamoMulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PrestamoMultaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PrestamoMultaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PrestamoMultaMouseExited(evt);
            }
        });

        btnPrestamoTxt.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btnPrestamoTxt.setForeground(new java.awt.Color(255, 255, 255));
        btnPrestamoTxt.setText("Prestamos y Multas");
        btnPrestamoTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrestamoTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrestamoTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPrestamoTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPrestamoTxtMouseExited(evt);
            }
        });

        iconoPrestamo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                iconoPrestamoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                iconoPrestamoMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PrestamoMultaLayout = new javax.swing.GroupLayout(PrestamoMulta);
        PrestamoMulta.setLayout(PrestamoMultaLayout);
        PrestamoMultaLayout.setHorizontalGroup(
            PrestamoMultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PrestamoMultaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(iconoPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPrestamoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PrestamoMultaLayout.setVerticalGroup(
            PrestamoMultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPrestamoTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PrestamoMultaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconoPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SobreNosotros.setBackground(new java.awt.Color(37, 40, 80));
        SobreNosotros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SobreNosotros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SobreNosotrosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SobreNosotrosMouseExited(evt);
            }
        });

        btnSobreUsTxt.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btnSobreUsTxt.setForeground(new java.awt.Color(255, 255, 255));
        btnSobreUsTxt.setText("Sobre Nosotros");
        btnSobreUsTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSobreUsTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSobreUsTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSobreUsTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSobreUsTxtMouseExited(evt);
            }
        });

        iconoSobreNosotros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconoSobreNosotrosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                iconoSobreNosotrosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                iconoSobreNosotrosMouseExited(evt);
            }
        });

        javax.swing.GroupLayout SobreNosotrosLayout = new javax.swing.GroupLayout(SobreNosotros);
        SobreNosotros.setLayout(SobreNosotrosLayout);
        SobreNosotrosLayout.setHorizontalGroup(
            SobreNosotrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SobreNosotrosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(iconoSobreNosotros, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSobreUsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        SobreNosotrosLayout.setVerticalGroup(
            SobreNosotrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSobreUsTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(SobreNosotrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconoSobreNosotros, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel13.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Copyright ©2022");

        javax.swing.GroupLayout OpcionesLayout = new javax.swing.GroupLayout(Opciones);
        Opciones.setLayout(OpcionesLayout);
        OpcionesLayout.setHorizontalGroup(
            OpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(RegistroEstudiante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(RegistroLibro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PrestamoMulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(SobreNosotros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(OpcionesLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        OpcionesLayout.setVerticalGroup(
            OpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OpcionesLayout.createSequentialGroup()
                .addComponent(Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RegistroEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RegistroLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PrestamoMulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SobreNosotros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        Contenido.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel3.setFont(new java.awt.Font("Roboto Medium", 0, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("ADMMINISTRACION DE USUARIOS");

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabel2.setText("SISTEMA BIBLIOTECARIO EPN");

        jLabel4.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("BIENVENIDO AL SISTEMA BIBLIOTECARIO DE LA EPN, ESTA SECCION ES PARA");

        jLabel7.setText(" REGISTRAR NUEVOS  BIBLIOTECARIOS LLENANDO EL SIGUIENTE FOMRULARIO");

        iconoAdmin0.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout PInicioLayout = new javax.swing.GroupLayout(PInicio);
        PInicio.setLayout(PInicioLayout);
        PInicioLayout.setHorizontalGroup(
            PInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PInicioLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(PInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PInicioLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(iconoAdmin0, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(PInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PInicioLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PInicioLayout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addComponent(IMAGEBOOK, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
        PInicioLayout.setVerticalGroup(
            PInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PInicioLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(PInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGroup(PInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PInicioLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addGroup(PInicioLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(iconoAdmin0, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(IMAGEBOOK, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        PEstudiantes.setPreferredSize(new java.awt.Dimension(947, 706));

        jTEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código del estudiante", "Nombres", "Apellidos"
            }
        ));
        jTEstudiantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTEstudiantesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTEstudiantes);

        jLabel6.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabel6.setText("REGISTRO Y MODIFICACION DE ESTUDIANTES");

        jLabel9.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel9.setText("Escritorio");

        jLabel10.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("/ Estudiantes");

        EtxtBusqueda.setForeground(new java.awt.Color(204, 204, 204));
        EtxtBusqueda.setText("Busqueda");
        EtxtBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 40, 80)));
        EtxtBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EtxtBusquedaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EtxtBusquedaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EtxtBusquedaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                EtxtBusquedaMousePressed(evt);
            }
        });

        EPanelAñadir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EPanelAñadir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EPanelAñadirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EPanelAñadirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EPanelAñadirMouseExited(evt);
            }
        });

        btnAñadirEstuxt.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btnAñadirEstuxt.setText("Añadir Estudiante");

        javax.swing.GroupLayout EPanelAñadirLayout = new javax.swing.GroupLayout(EPanelAñadir);
        EPanelAñadir.setLayout(EPanelAñadirLayout);
        EPanelAñadirLayout.setHorizontalGroup(
            EPanelAñadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EPanelAñadirLayout.createSequentialGroup()
                .addGroup(EPanelAñadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EPanelAñadirLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnAñadirEstuxt))
                    .addGroup(EPanelAñadirLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(EiconoAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        EPanelAñadirLayout.setVerticalGroup(
            EPanelAñadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EPanelAñadirLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(EiconoAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAñadirEstuxt)
                .addContainerGap())
        );

        EPanelModif.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EPanelModif.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EPanelModifMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EPanelModifMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EPanelModifMouseExited(evt);
            }
        });

        btnModificarEstuTxt.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btnModificarEstuTxt.setText("Modificar/Eliminar Estudiante");

        javax.swing.GroupLayout EPanelModifLayout = new javax.swing.GroupLayout(EPanelModif);
        EPanelModif.setLayout(EPanelModifLayout);
        EPanelModifLayout.setHorizontalGroup(
            EPanelModifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EPanelModifLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificarEstuTxt)
                .addGap(14, 14, 14))
            .addGroup(EPanelModifLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(EiconoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        EPanelModifLayout.setVerticalGroup(
            EPanelModifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EPanelModifLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(EiconoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificarEstuTxt)
                .addContainerGap())
        );

        jLabel8.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel8.setText("Estudiantes Registrados: ");

        lblCountEstud.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblCountEstud.setText("...");

        javax.swing.GroupLayout PEstudiantesLayout = new javax.swing.GroupLayout(PEstudiantes);
        PEstudiantes.setLayout(PEstudiantesLayout);
        PEstudiantesLayout.setHorizontalGroup(
            PEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PEstudiantesLayout.createSequentialGroup()
                .addGroup(PEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PEstudiantesLayout.createSequentialGroup()
                        .addContainerGap(636, Short.MAX_VALUE)
                        .addComponent(EiconoLupa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(EtxtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PEstudiantesLayout.createSequentialGroup()
                            .addGap(111, 111, 111)
                            .addComponent(EPanelAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(168, 168, 168)
                            .addComponent(EPanelModif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PEstudiantesLayout.createSequentialGroup()
                            .addGap(62, 62, 62)
                            .addGroup(PEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(PEstudiantesLayout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lblCountEstud))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(77, Short.MAX_VALUE))
            .addGroup(PEstudiantesLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(PEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PEstudiantesLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addComponent(jLabel6))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PEstudiantesLayout.setVerticalGroup(
            PEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PEstudiantesLayout.createSequentialGroup()
                .addGroup(PEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PEstudiantesLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel6)
                        .addGroup(PEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PEstudiantesLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(PEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PEstudiantesLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                                .addComponent(EPanelModif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PEstudiantesLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EPanelAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(PEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EtxtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EiconoLupa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblCountEstud))
                .addGap(36, 36, 36))
        );

        PLibros.setPreferredSize(new java.awt.Dimension(947, 706));

        jLabel14.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabel14.setText("REGISTRO Y MODIFICACION DE LIBROS");

        jLabel15.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel15.setText("Escritorio");

        jLabel16.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 153, 153));
        jLabel16.setText("/ Libros y Catálogos");

        LtxtBusqueda.setForeground(new java.awt.Color(204, 204, 204));
        LtxtBusqueda.setText("Busqueda");
        LtxtBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 40, 80)));
        LtxtBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LtxtBusquedaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LtxtBusquedaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LtxtBusquedaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LtxtBusquedaMousePressed(evt);
            }
        });

        LPanelElimiLib.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LPanelElimiLib.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LPanelElimiLibMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LPanelElimiLibMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LPanelElimiLibMouseExited(evt);
            }
        });

        btnModificarLibrTxt.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btnModificarLibrTxt.setText("Modificar/Eliminar Libro");
        btnModificarLibrTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarLibrTxtMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout LPanelElimiLibLayout = new javax.swing.GroupLayout(LPanelElimiLib);
        LPanelElimiLib.setLayout(LPanelElimiLibLayout);
        LPanelElimiLibLayout.setHorizontalGroup(
            LPanelElimiLibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LPanelElimiLibLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(LPanelElimiLibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LPanelElimiLibLayout.createSequentialGroup()
                        .addComponent(btnModificarLibrTxt)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LPanelElimiLibLayout.createSequentialGroup()
                        .addComponent(LiconoEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97))))
        );
        LPanelElimiLibLayout.setVerticalGroup(
            LPanelElimiLibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LPanelElimiLibLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(LiconoEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificarLibrTxt)
                .addGap(15, 15, 15))
        );

        jTLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cantidad", "Nombre", "Género"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTLibros);

        jScrollPane4.setViewportView(jScrollPane3);

        LPanelAñadirLib.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LPanelAñadirLib.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LPanelAñadirLibMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LPanelAñadirLibMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LPanelAñadirLibMouseExited(evt);
            }
        });

        btnAñadirLibTxt.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btnAñadirLibTxt.setText("Añadir Libro");

        javax.swing.GroupLayout LPanelAñadirLibLayout = new javax.swing.GroupLayout(LPanelAñadirLib);
        LPanelAñadirLib.setLayout(LPanelAñadirLibLayout);
        LPanelAñadirLibLayout.setHorizontalGroup(
            LPanelAñadirLibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LPanelAñadirLibLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(LPanelAñadirLibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAñadirLibTxt)
                    .addGroup(LPanelAñadirLibLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(LiconoAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        LPanelAñadirLibLayout.setVerticalGroup(
            LPanelAñadirLibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LPanelAñadirLibLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LiconoAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAñadirLibTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel11.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel11.setText("Libros Registrados: ");

        lblCountLib.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblCountLib.setText("...");

        javax.swing.GroupLayout PLibrosLayout = new javax.swing.GroupLayout(PLibros);
        PLibros.setLayout(PLibrosLayout);
        PLibrosLayout.setHorizontalGroup(
            PLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PLibrosLayout.createSequentialGroup()
                .addGroup(PLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PLibrosLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(PLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PLibrosLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel16))
                            .addComponent(jLabel14)
                            .addGroup(PLibrosLayout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(PLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(LiconoLupa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PLibrosLayout.createSequentialGroup()
                                        .addComponent(LPanelAñadirLib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(125, 125, 125)
                                        .addComponent(LPanelElimiLib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LtxtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PLibrosLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(PLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PLibrosLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblCountLib)))))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        PLibrosLayout.setVerticalGroup(
            PLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PLibrosLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(PLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(44, 44, 44)
                .addGroup(PLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LPanelElimiLib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LPanelAñadirLib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(PLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LiconoLupa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LtxtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblCountLib))
                .addContainerGap(126, Short.MAX_VALUE))
        );

        jLabel19.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabel19.setText("PRESTAMOS Y MULTAS");

        jLabel20.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel20.setText("Escritorio");

        jLabel21.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(153, 153, 153));
        jLabel21.setText("/ Prestamos y multas");

        PPanelPrestamo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PPanelPrestamo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PPanelPrestamoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PPanelPrestamoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PPanelPrestamoMouseExited(evt);
            }
        });

        btnPrestamoLibTxt.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btnPrestamoLibTxt.setText("Solicitar Préstamo");

        javax.swing.GroupLayout PPanelPrestamoLayout = new javax.swing.GroupLayout(PPanelPrestamo);
        PPanelPrestamo.setLayout(PPanelPrestamoLayout);
        PPanelPrestamoLayout.setHorizontalGroup(
            PPanelPrestamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PPanelPrestamoLayout.createSequentialGroup()
                .addGroup(PPanelPrestamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PPanelPrestamoLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnPrestamoLibTxt))
                    .addGroup(PPanelPrestamoLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(PiconoPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        PPanelPrestamoLayout.setVerticalGroup(
            PPanelPrestamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PPanelPrestamoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PiconoPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPrestamoLibTxt)
                .addContainerGap())
        );

        PPEliminarPrestamo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PPEliminarPrestamo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PPEliminarPrestamoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PPEliminarPrestamoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PPEliminarPrestamoMouseExited(evt);
            }
        });

        btnEliminarPrestamoLibTxt.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btnEliminarPrestamoLibTxt.setText("Eliminar Préstamo");

        javax.swing.GroupLayout PPEliminarPrestamoLayout = new javax.swing.GroupLayout(PPEliminarPrestamo);
        PPEliminarPrestamo.setLayout(PPEliminarPrestamoLayout);
        PPEliminarPrestamoLayout.setHorizontalGroup(
            PPEliminarPrestamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PPEliminarPrestamoLayout.createSequentialGroup()
                .addGroup(PPEliminarPrestamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PPEliminarPrestamoLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnEliminarPrestamoLibTxt))
                    .addGroup(PPEliminarPrestamoLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(PiconoElimiPrest, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PPEliminarPrestamoLayout.setVerticalGroup(
            PPEliminarPrestamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PPEliminarPrestamoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PiconoElimiPrest, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarPrestamoLibTxt)
                .addContainerGap())
        );

        jTPrestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cantidad", "Nombre", "Género"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTPrestamos);

        jScrollPane5.setViewportView(jScrollPane6);

        LtxtBusquedaPrestamosMultas.setForeground(new java.awt.Color(204, 204, 204));
        LtxtBusquedaPrestamosMultas.setText("Busqueda");
        LtxtBusquedaPrestamosMultas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 40, 80)));
        LtxtBusquedaPrestamosMultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LtxtBusquedaPrestamosMultasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LtxtBusquedaPrestamosMultasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LtxtBusquedaPrestamosMultasMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LtxtBusquedaPrestamosMultasMousePressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel12.setText("Prestamos Registrados:");

        lblCountMult.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblCountMult.setText("...");

        javax.swing.GroupLayout PPrestamosLayout = new javax.swing.GroupLayout(PPrestamos);
        PPrestamos.setLayout(PPrestamosLayout);
        PPrestamosLayout.setHorizontalGroup(
            PPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PPrestamosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PMiconoLupa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LtxtBusquedaPrestamosMultas, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
            .addGroup(PPrestamosLayout.createSequentialGroup()
                .addGroup(PPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PPrestamosLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(PPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PPrestamosLayout.createSequentialGroup()
                                .addGroup(PPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PPrestamosLayout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel21)
                                        .addGap(234, 234, 234))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PPrestamosLayout.createSequentialGroup()
                                        .addComponent(PPanelPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(179, 179, 179)))
                                .addComponent(PPEliminarPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel19)))
                    .addGroup(PPrestamosLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCountMult)))
                .addContainerGap(259, Short.MAX_VALUE))
            .addGroup(PPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PPrestamosLayout.createSequentialGroup()
                    .addContainerGap(84, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(61, Short.MAX_VALUE)))
        );
        PPrestamosLayout.setVerticalGroup(
            PPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PPrestamosLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(PPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PMiconoLupa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PPrestamosLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addGroup(PPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PPrestamosLayout.createSequentialGroup()
                                .addGroup(PPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel21))
                                .addGap(41, 41, 41)
                                .addComponent(PPanelPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(PPEliminarPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(LtxtBusquedaPrestamosMultas, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 291, Short.MAX_VALUE)
                .addGroup(PPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblCountMult))
                .addGap(47, 47, 47))
            .addGroup(PPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PPrestamosLayout.createSequentialGroup()
                    .addContainerGap(266, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(82, Short.MAX_VALUE)))
        );

        jLabel5.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabel5.setText("ESTOS SOMOS NOSOTROS");

        iconoPaul.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        iconoWilliam.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        iconoJohan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        iconoAngel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        iconoGary.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel22.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel22.setText("Somos Estudiantes de la Escuela Politécnica Nacional , creamos el siguiente programa como parte de proyecto final para");

        jLabel23.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel23.setText("la materia de Programación 2.");

        jLabel24.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel24.setText("Paul Román");

        jLabel25.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel25.setText("William Moyano");

        jLabel26.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel26.setText("Johan Illicachi");

        jLabel27.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel27.setText("Ángel Cabezas");

        jLabel28.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel28.setText("Gary Campaña");

        javax.swing.GroupLayout PAboutUsLayout = new javax.swing.GroupLayout(PAboutUs);
        PAboutUs.setLayout(PAboutUsLayout);
        PAboutUsLayout.setHorizontalGroup(
            PAboutUsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PAboutUsLayout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(PAboutUsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PAboutUsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PAboutUsLayout.createSequentialGroup()
                            .addGroup(PAboutUsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel23)
                                .addComponent(jLabel22))
                            .addGap(26, 26, 26))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PAboutUsLayout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(254, 254, 254)))
                    .addGroup(PAboutUsLayout.createSequentialGroup()
                        .addGroup(PAboutUsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PAboutUsLayout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addComponent(iconoAngel, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(140, 140, 140)
                                .addComponent(iconoGary, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PAboutUsLayout.createSequentialGroup()
                                .addGap(181, 181, 181)
                                .addComponent(jLabel27)
                                .addGap(173, 173, 173)
                                .addComponent(jLabel28)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PAboutUsLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(iconoPaul, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142)
                        .addComponent(iconoWilliam, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconoJohan, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102))
                    .addGroup(PAboutUsLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel24)
                        .addGap(175, 175, 175)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel26)
                        .addGap(117, 117, 117))))
        );
        PAboutUsLayout.setVerticalGroup(
            PAboutUsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PAboutUsLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel5)
                .addGap(30, 30, 30)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addGroup(PAboutUsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PAboutUsLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(PAboutUsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(iconoPaul, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iconoWilliam, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iconoJohan, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PAboutUsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PAboutUsLayout.createSequentialGroup()
                        .addGap(154, 259, Short.MAX_VALUE)
                        .addGroup(PAboutUsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(iconoGary, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iconoAngel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PAboutUsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28))
                        .addGap(102, 102, 102))))
        );

        Contenido.setLayer(PInicio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Contenido.setLayer(PEstudiantes, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Contenido.setLayer(PLibros, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Contenido.setLayer(PPrestamos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Contenido.setLayer(PAboutUs, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout ContenidoLayout = new javax.swing.GroupLayout(Contenido);
        Contenido.setLayout(ContenidoLayout);
        ContenidoLayout.setHorizontalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenidoLayout.createSequentialGroup()
                .addComponent(PInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 53, Short.MAX_VALUE))
            .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ContenidoLayout.createSequentialGroup()
                    .addComponent(PEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 895, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 52, Short.MAX_VALUE)))
            .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ContenidoLayout.createSequentialGroup()
                    .addComponent(PLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 897, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 50, Short.MAX_VALUE)))
            .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ContenidoLayout.createSequentialGroup()
                    .addComponent(PAboutUs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 53, Short.MAX_VALUE)))
            .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ContenidoLayout.createSequentialGroup()
                    .addComponent(PPrestamos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 50, Short.MAX_VALUE)))
        );
        ContenidoLayout.setVerticalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ContenidoLayout.createSequentialGroup()
                    .addComponent(PEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ContenidoLayout.createSequentialGroup()
                    .addComponent(PLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 3, Short.MAX_VALUE)))
            .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ContenidoLayout.createSequentialGroup()
                    .addComponent(PAboutUs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ContenidoLayout.createSequentialGroup()
                    .addComponent(PPrestamos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout ContainerLayout = new javax.swing.GroupLayout(Container);
        Container.setLayout(ContainerLayout);
        ContainerLayout.setHorizontalGroup(
            ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContainerLayout.createSequentialGroup()
                .addGroup(ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContainerLayout.createSequentialGroup()
                        .addComponent(iconoLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContainerLayout.createSequentialGroup()
                        .addComponent(Opciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addComponent(Contenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(ContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TopBar, javax.swing.GroupLayout.PREFERRED_SIZE, 1186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ContainerLayout.setVerticalGroup(
            ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContainerLayout.createSequentialGroup()
                .addComponent(TopBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContainerLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(iconoLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Opciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(ContainerLayout.createSequentialGroup()
                        .addComponent(Contenido, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Container, javax.swing.GroupLayout.PREFERRED_SIZE, 1191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Container, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PrestamoMultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrestamoMultaMouseClicked

    }//GEN-LAST:event_PrestamoMultaMouseClicked

    private void btnIniciotxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciotxtMouseEntered
        this.Inicio.setBackground(Color.red);
    }//GEN-LAST:event_btnIniciotxtMouseEntered

    private void btnIniciotxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciotxtMouseExited
        this.Inicio.setBackground(new Color(37, 40, 80));
    }//GEN-LAST:event_btnIniciotxtMouseExited

    private void iconHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconHomeMouseEntered
        this.Inicio.setBackground(Color.red);
    }//GEN-LAST:event_iconHomeMouseEntered

    private void iconHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconHomeMouseExited
        this.Inicio.setBackground(new Color(37, 40, 80));
    }//GEN-LAST:event_iconHomeMouseExited

    private void InicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InicioMouseEntered
        this.Inicio.setBackground(Color.red);
    }//GEN-LAST:event_InicioMouseEntered

    private void InicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InicioMouseExited
        this.Inicio.setBackground(new Color(37, 40, 80));
    }//GEN-LAST:event_InicioMouseExited

    private void RegistroEstudianteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistroEstudianteMouseEntered
        this.RegistroEstudiante.setBackground(Color.red);
    }//GEN-LAST:event_RegistroEstudianteMouseEntered

    private void RegistroEstudianteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistroEstudianteMouseExited
        this.RegistroEstudiante.setBackground(new Color(37, 40, 80));
    }//GEN-LAST:event_RegistroEstudianteMouseExited

    private void btnEstudTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstudTxtMouseEntered
        this.RegistroEstudiante.setBackground(Color.red);
    }//GEN-LAST:event_btnEstudTxtMouseEntered

    private void btnEstudTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstudTxtMouseExited
        this.RegistroEstudiante.setBackground(new Color(37, 40, 80));
    }//GEN-LAST:event_btnEstudTxtMouseExited

    private void iconoEstudMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconoEstudMouseEntered
        this.RegistroEstudiante.setBackground(Color.red);
    }//GEN-LAST:event_iconoEstudMouseEntered

    private void iconoEstudMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconoEstudMouseExited
        this.RegistroEstudiante.setBackground(new Color(37, 40, 80));
    }//GEN-LAST:event_iconoEstudMouseExited

    private void RegistroLibroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistroLibroMouseEntered
        this.RegistroLibro.setBackground(Color.red);
    }//GEN-LAST:event_RegistroLibroMouseEntered

    private void RegistroLibroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistroLibroMouseExited
        this.RegistroLibro.setBackground(new Color(37, 40, 80));
    }//GEN-LAST:event_RegistroLibroMouseExited

    private void btnLibTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLibTxtMouseEntered
        this.RegistroLibro.setBackground(Color.red);
    }//GEN-LAST:event_btnLibTxtMouseEntered

    private void btnLibTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLibTxtMouseExited
        this.RegistroLibro.setBackground(new Color(37, 40, 80));
    }//GEN-LAST:event_btnLibTxtMouseExited

    private void iconLibMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconLibMouseEntered
        this.RegistroLibro.setBackground(Color.red);
    }//GEN-LAST:event_iconLibMouseEntered

    private void iconLibMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconLibMouseExited
        this.RegistroLibro.setBackground(new Color(37, 40, 80));
    }//GEN-LAST:event_iconLibMouseExited

    private void PrestamoMultaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrestamoMultaMouseEntered
        this.PrestamoMulta.setBackground(Color.red);
    }//GEN-LAST:event_PrestamoMultaMouseEntered

    private void PrestamoMultaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrestamoMultaMouseExited
        this.PrestamoMulta.setBackground(new Color(37, 40, 80));
    }//GEN-LAST:event_PrestamoMultaMouseExited

    private void btnPrestamoTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrestamoTxtMouseEntered
        this.PrestamoMulta.setBackground(Color.red);
    }//GEN-LAST:event_btnPrestamoTxtMouseEntered

    private void btnPrestamoTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrestamoTxtMouseExited
        this.PrestamoMulta.setBackground(new Color(37, 40, 80));
    }//GEN-LAST:event_btnPrestamoTxtMouseExited

    private void iconoPrestamoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconoPrestamoMouseEntered
        this.PrestamoMulta.setBackground(Color.red);
    }//GEN-LAST:event_iconoPrestamoMouseEntered

    private void iconoPrestamoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconoPrestamoMouseExited
        this.PrestamoMulta.setBackground(new Color(37, 40, 80));
    }//GEN-LAST:event_iconoPrestamoMouseExited

    private void SobreNosotrosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SobreNosotrosMouseEntered
        this.SobreNosotros.setBackground(Color.red);
    }//GEN-LAST:event_SobreNosotrosMouseEntered

    private void SobreNosotrosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SobreNosotrosMouseExited
        this.SobreNosotros.setBackground(new Color(37, 40, 80));
    }//GEN-LAST:event_SobreNosotrosMouseExited

    private void btnSobreUsTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSobreUsTxtMouseEntered
        this.SobreNosotros.setBackground(Color.red);
    }//GEN-LAST:event_btnSobreUsTxtMouseEntered

    private void btnSobreUsTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSobreUsTxtMouseExited
        this.SobreNosotros.setBackground(new Color(37, 40, 80));
    }//GEN-LAST:event_btnSobreUsTxtMouseExited

    private void iconoSobreNosotrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconoSobreNosotrosMouseClicked

    }//GEN-LAST:event_iconoSobreNosotrosMouseClicked

    private void iconoSobreNosotrosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconoSobreNosotrosMouseEntered
        this.SobreNosotros.setBackground(Color.red);
    }//GEN-LAST:event_iconoSobreNosotrosMouseEntered

    private void iconoSobreNosotrosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconoSobreNosotrosMouseExited
        this.SobreNosotros.setBackground(new Color(37, 40, 80));
    }//GEN-LAST:event_iconoSobreNosotrosMouseExited

    private void btnEstudTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstudTxtMouseClicked
        this.PEstudiantes.setVisible(true);
        this.PInicio.setVisible(false);
        this.PLibros.setVisible(false);
        this.PAboutUs.setVisible(false);
        this.PPrestamos.setVisible(false);
    }//GEN-LAST:event_btnEstudTxtMouseClicked

    private void btnIniciotxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciotxtMouseClicked
        this.PInicio.setVisible(true);
        this.PEstudiantes.setVisible(false);
        this.PLibros.setVisible(false);
        this.PAboutUs.setVisible(false);
        this.PPrestamos.setVisible(false);
    }//GEN-LAST:event_btnIniciotxtMouseClicked

    private void btnLibTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLibTxtMouseClicked
        this.PLibros.setVisible(true);
        this.PEstudiantes.setVisible(false);
        this.PInicio.setVisible(false);
        this.PAboutUs.setVisible(false);
        this.PPrestamos.setVisible(false);
    }//GEN-LAST:event_btnLibTxtMouseClicked

    private void btnPrestamoTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrestamoTxtMouseClicked
        this.PPrestamos.setVisible(true);
        this.PEstudiantes.setVisible(false);
        this.PInicio.setVisible(false);
        this.PAboutUs.setVisible(false);
        this.PLibros.setVisible(false);
    }//GEN-LAST:event_btnPrestamoTxtMouseClicked

    private void btnSobreUsTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSobreUsTxtMouseClicked
        this.PAboutUs.setVisible(true);
        this.PEstudiantes.setVisible(false);
        this.PInicio.setVisible(false);
        this.PPrestamos.setVisible(false);
        this.PLibros.setVisible(false);
    }//GEN-LAST:event_btnSobreUsTxtMouseClicked

    private void jTEstudiantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTEstudiantesMouseClicked
//        int fila = this.jTEstudiantes.getSelectedRow();
//        if (fila == -1) {
//            JOptionPane.showMessageDialog(null, "Ninguna fila a sido seleccionada");
//        } else {
//            
//            jfeditestudiante.setVisible(true);
//
//        }
    }//GEN-LAST:event_jTEstudiantesMouseClicked

    private void EtxtBusquedaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EtxtBusquedaMouseEntered

    }//GEN-LAST:event_EtxtBusquedaMouseEntered

    private void EtxtBusquedaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EtxtBusquedaMousePressed
        if (this.EtxtBusqueda.getText().equals("Busqueda")) {
            this.EtxtBusqueda.setText("");
            this.EtxtBusqueda.setForeground(Color.black);
        }
    }//GEN-LAST:event_EtxtBusquedaMousePressed

    private void EtxtBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EtxtBusquedaMouseClicked

    }//GEN-LAST:event_EtxtBusquedaMouseClicked

    private void EtxtBusquedaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EtxtBusquedaMouseExited

    }//GEN-LAST:event_EtxtBusquedaMouseExited

    private void EPanelAñadirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EPanelAñadirMouseEntered
        this.EPanelAñadir.setBorder(new LineBorder(Color.red));
        this.btnAñadirEstuxt.setForeground(Color.red);

    }//GEN-LAST:event_EPanelAñadirMouseEntered

    private void EPanelAñadirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EPanelAñadirMouseExited
//        this.EPanelAñadir.setBorder(new LineBorder(Color.black));
        this.EPanelAñadir.setBorder(null);
        this.btnAñadirEstuxt.setForeground(Color.black);
    }//GEN-LAST:event_EPanelAñadirMouseExited

    private void EPanelModifMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EPanelModifMouseEntered
        this.EPanelModif.setBorder(new LineBorder(Color.red));
        this.btnModificarEstuTxt.setForeground(Color.red);
    }//GEN-LAST:event_EPanelModifMouseEntered

    private void EPanelModifMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EPanelModifMouseExited
        this.EPanelModif.setBorder(null);
        this.btnModificarEstuTxt.setForeground(Color.black);
    }//GEN-LAST:event_EPanelModifMouseExited

    private void LtxtBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LtxtBusquedaMouseClicked
        if (this.LtxtBusqueda.getText().equals("Busqueda")) {
            this.LtxtBusqueda.setText("");
            this.LtxtBusqueda.setForeground(Color.black);
        }
    }//GEN-LAST:event_LtxtBusquedaMouseClicked

    private void LtxtBusquedaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LtxtBusquedaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_LtxtBusquedaMouseEntered

    private void LtxtBusquedaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LtxtBusquedaMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_LtxtBusquedaMouseExited

    private void LtxtBusquedaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LtxtBusquedaMousePressed

    }//GEN-LAST:event_LtxtBusquedaMousePressed

    private void LPanelAñadirLibMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LPanelAñadirLibMouseEntered
        this.LPanelAñadirLib.setBorder(new LineBorder(Color.red));
        this.btnAñadirLibTxt.setForeground(Color.red);

    }//GEN-LAST:event_LPanelAñadirLibMouseEntered

    private void LPanelAñadirLibMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LPanelAñadirLibMouseExited
        this.LPanelAñadirLib.setBorder(null);
        this.btnAñadirLibTxt.setForeground(Color.black);
    }//GEN-LAST:event_LPanelAñadirLibMouseExited

    private void LPanelElimiLibMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LPanelElimiLibMouseEntered
        this.LPanelElimiLib.setBorder(new LineBorder(Color.red));
        this.btnModificarLibrTxt.setForeground(Color.red);
    }//GEN-LAST:event_LPanelElimiLibMouseEntered

    private void LPanelElimiLibMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LPanelElimiLibMouseExited
        this.LPanelElimiLib.setBorder(null);
        this.btnModificarLibrTxt.setForeground(Color.black);
    }//GEN-LAST:event_LPanelElimiLibMouseExited

    private void EPanelAñadirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EPanelAñadirMouseClicked
        jfaddestudiante.setVisible(true);
    }//GEN-LAST:event_EPanelAñadirMouseClicked

    private void EPanelModifMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EPanelModifMouseClicked
        jfeditestudiante.setVisible(true);
    }//GEN-LAST:event_EPanelModifMouseClicked

    private void LPanelAñadirLibMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LPanelAñadirLibMouseClicked
        jfaddlibro.setVisible(true);
    }//GEN-LAST:event_LPanelAñadirLibMouseClicked

    private void LPanelElimiLibMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LPanelElimiLibMouseClicked
        jfmodificarlibro.setVisible(true);
    }//GEN-LAST:event_LPanelElimiLibMouseClicked

    private void LtxtBusquedaPrestamosMultasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LtxtBusquedaPrestamosMultasMousePressed
        if (this.LtxtBusquedaPrestamosMultas.getText().equals("Busqueda")) {
            this.LtxtBusquedaPrestamosMultas.setText("");
            this.LtxtBusquedaPrestamosMultas.setForeground(Color.black);
        }
    }//GEN-LAST:event_LtxtBusquedaPrestamosMultasMousePressed

    private void LtxtBusquedaPrestamosMultasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LtxtBusquedaPrestamosMultasMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_LtxtBusquedaPrestamosMultasMouseExited

    private void LtxtBusquedaPrestamosMultasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LtxtBusquedaPrestamosMultasMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_LtxtBusquedaPrestamosMultasMouseEntered

    private void LtxtBusquedaPrestamosMultasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LtxtBusquedaPrestamosMultasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_LtxtBusquedaPrestamosMultasMouseClicked

    private void PPEliminarPrestamoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PPEliminarPrestamoMouseExited
        this.PPEliminarPrestamo.setBorder(null);
        this.btnEliminarPrestamoLibTxt.setForeground(Color.black);
    }//GEN-LAST:event_PPEliminarPrestamoMouseExited

    private void PPEliminarPrestamoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PPEliminarPrestamoMouseEntered
        this.PPEliminarPrestamo.setBorder(new LineBorder(Color.red));
        this.btnEliminarPrestamoLibTxt.setForeground(Color.red);
    }//GEN-LAST:event_PPEliminarPrestamoMouseEntered

    private void PPEliminarPrestamoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PPEliminarPrestamoMouseClicked
        jfelimprestamo.setVisible(true);
    }//GEN-LAST:event_PPEliminarPrestamoMouseClicked

    private void PPanelPrestamoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PPanelPrestamoMouseExited
        this.PPanelPrestamo.setBorder(null);
        this.btnPrestamoLibTxt.setForeground(Color.black);
    }//GEN-LAST:event_PPanelPrestamoMouseExited

    private void PPanelPrestamoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PPanelPrestamoMouseEntered
        this.PPanelPrestamo.setBorder(new LineBorder(Color.red));
        this.btnPrestamoLibTxt.setForeground(Color.red);
    }//GEN-LAST:event_PPanelPrestamoMouseEntered

    private void PPanelPrestamoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PPanelPrestamoMouseClicked
        jfaddprestamo.setVisible(true);
    }//GEN-LAST:event_PPanelPrestamoMouseClicked

    private void btnModificarLibrTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarLibrTxtMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarLibrTxtMouseClicked

    private void iconoCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconoCerrarSesionMouseClicked

        int x = JOptionPane.showConfirmDialog(null, "¿Está seguro que quiere Cerrar Sesion?");
        if (x == 0) {
            this.dispose();
            JFLogin jflog = new JFLogin();
            jflog.setVisible(true);
        } else {

        }

    }//GEN-LAST:event_iconoCerrarSesionMouseClicked

    public void contarEstud() {
        for (int x = 0; x <= jTEstudiantes.getRowCount(); x++) {
            lblCountEstud.setText("" + x);
        }
    }

    public void contarLib() {
        for (int x = 0; x <= jTLibros.getRowCount(); x++) {
            lblCountLib.setText("" + x);
        }
    }
    
     public void contarMult() {
        for (int x = 0; x <= jTPrestamos.getRowCount(); x++) {
            lblCountMult.setText("" + x);
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFBiblioteca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Container;
    private javax.swing.JLayeredPane Contenido;
    private javax.swing.JPanel EPN;
    private javax.swing.JPanel EPanelAñadir;
    private javax.swing.JPanel EPanelModif;
    private javax.swing.JLabel EiconoAñadir;
    private javax.swing.JLabel EiconoLupa;
    private javax.swing.JLabel EiconoModificar;
    private javax.swing.JTextField EtxtBusqueda;
    private javax.swing.JLabel IMAGEBOOK;
    private javax.swing.JPanel Inicio;
    private javax.swing.JPanel LPanelAñadirLib;
    private javax.swing.JPanel LPanelElimiLib;
    private javax.swing.JLabel LiconoAñadir;
    private javax.swing.JLabel LiconoEliminar;
    private javax.swing.JLabel LiconoLupa;
    private javax.swing.JTextField LtxtBusqueda;
    private javax.swing.JTextField LtxtBusquedaPrestamosMultas;
    private javax.swing.JPanel Opciones;
    private javax.swing.JPanel PAboutUs;
    private javax.swing.JPanel PEstudiantes;
    private javax.swing.JPanel PInicio;
    private javax.swing.JPanel PLibros;
    private javax.swing.JLabel PMiconoLupa;
    private javax.swing.JPanel PPEliminarPrestamo;
    private javax.swing.JPanel PPanelPrestamo;
    private javax.swing.JPanel PPrestamos;
    private javax.swing.JLabel PiconoElimiPrest;
    private javax.swing.JLabel PiconoPrestamo;
    private javax.swing.JPanel PrestamoMulta;
    private javax.swing.JPanel RegistroEstudiante;
    private javax.swing.JPanel RegistroLibro;
    private javax.swing.JPanel SobreNosotros;
    private javax.swing.JPanel TolBar;
    private javax.swing.JPanel TopBar;
    private javax.swing.JLabel btnAñadirEstuxt;
    private javax.swing.JLabel btnAñadirLibTxt;
    private javax.swing.JLabel btnEliminarPrestamoLibTxt;
    private javax.swing.JLabel btnEstudTxt;
    private javax.swing.JLabel btnIniciotxt;
    private javax.swing.JLabel btnLibTxt;
    private javax.swing.JLabel btnModificarEstuTxt;
    private javax.swing.JLabel btnModificarLibrTxt;
    private javax.swing.JLabel btnPrestamoLibTxt;
    private javax.swing.JLabel btnPrestamoTxt;
    private javax.swing.JLabel btnSobreUsTxt;
    private javax.swing.JLabel iconHome;
    private javax.swing.JLabel iconLib;
    private javax.swing.JLabel iconoAdmin;
    private javax.swing.JLabel iconoAdmin0;
    private javax.swing.JLabel iconoAngel;
    private javax.swing.JLabel iconoCalendarioHora;
    private javax.swing.JLabel iconoCerrarSesion;
    private javax.swing.JLabel iconoEstud;
    private javax.swing.JLabel iconoGary;
    private javax.swing.JLabel iconoJohan;
    private javax.swing.JLabel iconoLibro;
    private javax.swing.JLabel iconoLogoEpn;
    private javax.swing.JLabel iconoPaul;
    private javax.swing.JLabel iconoPrestamo;
    private javax.swing.JLabel iconoSobreNosotros;
    private javax.swing.JLabel iconoWilliam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTEstudiantes;
    private javax.swing.JTable jTLibros;
    private javax.swing.JTable jTPrestamos;
    private javax.swing.JLabel lblCountEstud;
    private javax.swing.JLabel lblCountLib;
    private javax.swing.JLabel lblCountMult;
    private javax.swing.JLabel lblFechaHora;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblUsers;
    // End of variables declaration//GEN-END:variables
}
