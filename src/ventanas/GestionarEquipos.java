package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 * La clase GestionarEquipos permite gestionar los equipos registrados en el
 * sistema. Proporciona una interfaz gráfica para visualizar y filtrar los
 * equipos según su estado, y para acceder a la información detallada de un
 * equipo específico para su actualización.
 *
 * @author Lizarraga
 */
public class GestionarEquipos extends javax.swing.JFrame {

    // Variable para almacenar el nombre de usuario de la sesión actual
    String user;
    // Variable estática para almacenar el ID del equipo seleccionado para su actualización
    public static int IDequipo_update = 0;
    // Modelo de tabla para gestionar los datos de los equipos
    DefaultTableModel model = new DefaultTableModel();

    /**
     * Constructor de la clase GestionarEquipos. Inicializa la interfaz gráfica,
     * configura la tabla de equipos y carga los datos de la base de datos.
     */
    public GestionarEquipos() {
        initComponents();
        user = Login.user;

        // Configuración de la ventana
        setSize(643, 380);
        setResizable(false);
        setTitle("Capturista - Sesión de " + user);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        // Configuración del fondo de la ventana
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));

        jLabel_Wallpaper.setIcon(icono);
        this.repaint();

        // Carga de datos en la tabla desde la base de datos
        try {

            Connection cn = Conexion.conectar();

            PreparedStatement pst = cn.prepareStatement(
                    "select id_equipo, tipo_equipo, marca, estatus from equipos");

            ResultSet rs = pst.executeQuery();

            // Añadir columnas al modelo de la tabla
            jTable_equipos = new JTable(model);
            jScrollPane_equipos.setViewportView(jTable_equipos);

            model.addColumn(" ");
            model.addColumn("Tipo");
            model.addColumn("Marca");
            model.addColumn("Estatus");

            // Añadir filas con datos de los equipos al modelo de la tabla
            while (rs.next()) {
                Object[] fila = new Object[4];
                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error en el llenado de la tabla.");
        }

        // Configuración del evento de clic en la tabla
        ObtenerDatosTabla();

    }

    /**
     * Método para obtener el icono de la ventana.
     *
     * @return El icono de la ventana.
     */
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

    /**
     * Este método es llamado desde dentro del constructor para inicializar los
     * componentes de la interfaz. ¡Advertencia! No modifiques este código. El
     * contenido de este método es siempre regenerado por el Editor de
     * Formularios.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane_equipos = new javax.swing.JScrollPane();
        jTable_equipos = new javax.swing.JTable();
        cmb_estatus = new javax.swing.JComboBox<>();
        Mostrar = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Equipos registrados");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jTable_equipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane_equipos.setViewportView(jTable_equipos);

        getContentPane().add(jScrollPane_equipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 630, 180));

        cmb_estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Nuevo ingreso", "No reparado", "En revisión", "Reparado", "Entregado" }));
        getContentPane().add(cmb_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 130, -1));

        Mostrar.setBackground(new java.awt.Color(153, 153, 255));
        Mostrar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        Mostrar.setForeground(new java.awt.Color(255, 255, 255));
        Mostrar.setText("Mostrar");
        Mostrar.setBorder(null);
        Mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarActionPerformed(evt);
            }
        });
        getContentPane().add(Mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 210, 35));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método para manejar la acción del botón "Mostrar". Filtra los datos de la
     * tabla de equipos según el estatus seleccionado.
     *
     * @param evt El evento de acción.
     */
    private void MostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarActionPerformed

        String seleccion = cmb_estatus.getSelectedItem().toString();
        String query = "";

        model.setRowCount(0);
        model.setColumnCount(0);

        try {
            Connection cn = Conexion.conectar();

            if (seleccion.equalsIgnoreCase("Todos")) {
                query = "select id_equipo, tipo_equipo, marca, estatus from equipos";
            } else {
                query = "select id_equipo, tipo_equipo, marca, estatus from equipos where estatus = '" + seleccion + "'";
            }

            PreparedStatement pst = cn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            jTable_equipos = new JTable(model);
            jScrollPane_equipos.setViewportView(jTable_equipos);

            model.addColumn(" ");
            model.addColumn("Tipo");
            model.addColumn("Marca");
            model.addColumn("Estatus");

            while (rs.next()) {
                Object[] fila = new Object[4];
                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al recuperar los registros de equipos." + e);
        }

        // Configuración del evento de clic en la tabla
        ObtenerDatosTabla();
    }//GEN-LAST:event_MostrarActionPerformed

    /**
     * Método principal para iniciar la aplicación.
     *
     * @param args Argumentos de la línea de comandos.
     */
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
            java.util.logging.Logger.getLogger(GestionarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Crea y muestra el formulario */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarEquipos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Mostrar;
    private javax.swing.JComboBox<String> cmb_estatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JScrollPane jScrollPane_equipos;
    private javax.swing.JTable jTable_equipos;
    // End of variables declaration//GEN-END:variables

    /**
     * Método para manejar el clic en una fila de la tabla. Al hacer clic en una
     * fila, se obtiene el ID del equipo y se abre la ventana de información del
     * equipo.
     */
    public void ObtenerDatosTabla() {
        jTable_equipos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_equipos.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    IDequipo_update = (int) model.getValueAt(fila_point, columna_point);

                    InformacionEquipoTecnico info = new InformacionEquipoTecnico();
                    info.setVisible(true);

                }
            }
        });
    }
}
