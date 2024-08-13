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
 * La clase GestionarClientes representa una ventana para gestionar los clientes
 * registrados. Muestra una tabla con los datos de los clientes y permite abrir
 * la ventana de información del cliente seleccionado para actualizar su
 * información.
 *
 * @author Lizarraga
 */
public class GestionarClientes extends javax.swing.JFrame {

    // Variables para almacenar el nombre de usuario y el ID del cliente a actualizar
    String user;
    public static int IDcliente_update = 0;
    DefaultTableModel model = new DefaultTableModel();

    /**
     * Constructor de la clase GestionarClientes. Configura los componentes
     * iniciales y establece la información de la tabla de clientes.
     */
    public GestionarClientes() {

        // Inicializa los componentes de la interfaz gráfica
        initComponents();
        // Obtiene el nombre de usuario desde la clase Login
        user = Login.user;

        // Configura las propiedades de la ventana
        setSize(645, 330);
        setResizable(false);
        setTitle("Capturista - Sesión de " + user);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        // Establece el fondo de pantalla de la ventana
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));

        jLabel_Wallpaper.setIcon(icono);
        this.repaint();

        // Conecta a la base de datos y llena la tabla con los datos de los clientes
        try {

            Connection cn = Conexion.conectar();

            PreparedStatement pst = cn.prepareStatement(
                    "select id_cliente, nombre_cliente, mail_cliente, tel_cliente, ultima_modificacion from clientes");

            ResultSet rs = pst.executeQuery();

            // Configura la tabla para mostrar los clientes
            jTable_clientes = new JTable(model);
            jScrollPane1.setViewportView(jTable_clientes);

            // Añade las columnas a la tabla
            model.addColumn(" ");
            model.addColumn("Nombre");
            model.addColumn("em@il");
            model.addColumn("Teléfono");
            model.addColumn("Modificado por");

            // Añade los datos de los clientes a la tabla
            while (rs.next()) {
                Object[] fila = new Object[5];
                for (int i = 0; i < 5; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error en el llenado de la tabla.");
        }

        // Añade un evento de clic a la tabla para abrir la ventana de información del cliente seleccionado
        jTable_clientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_clientes.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    // Obtiene el ID del cliente seleccionado
                    IDcliente_update = (int) model.getValueAt(fila_point, columna_point);

                    // Abre la ventana de información del cliente
                    Informacion_Cliente informacion_cliente = new Informacion_Cliente();
                    informacion_cliente.setVisible(true);

                }
            }
        });

    }

    /**
     * Sobrescribe el método para obtener el icono de la ventana.
     *
     * @return El icono de la ventana.
     */
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

    /**
     * Este método es llamado dentro del constructor para inicializar los
     * componentes de la interfaz. ¡Advertencia! No modifiques este código. El
     * contenido de este método es siempre regenerado por el Editor de
     * Formularios.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_clientes = new javax.swing.JTable();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Clientes registrados");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jTable_clientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_clientes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 630, 180));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método principal que inicia la aplicación.
     *
     * @param args Los argumentos de la línea de comandos.
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
            java.util.logging.Logger.getLogger(GestionarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Crea y muestra la ventana */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_clientes;
    // End of variables declaration//GEN-END:variables
}
