package ventanas;

import clases.Conexion;
import java.sql.*;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

/**
 * Esta clase define una ventana para la interfaz del técnico. Permite al
 * usuario gestionar equipos, ver gráficas de estatus y marcas. Muestra el
 * nombre del usuario y ajusta la ventana según el tipo de sesión.
 *
 * @author Lizarraga
 */
public class Tecnico extends javax.swing.JFrame {

    String user, nombre_usuario;
    int sesion_usuario;

    /**
     * Crea una nueva instancia de la ventana de técnico. Inicializa los
     * componentes y configura la interfaz gráfica.
     *
     * También establece el título de la ventana, ajusta su tamaño y apariencia,
     * y consulta el nombre del usuario para mostrar en la interfaz.
     */
    public Tecnico() {

        initComponents();
        user = Login.user;
        sesion_usuario = Administrador.sesion_usuario;

        setSize(563, 300);
        setResizable(false);
        setTitle("Técnico - Sesión de " + user);
        setLocationRelativeTo(null);

        if (sesion_usuario == 1) {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        } else {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }

        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));

        jLabel_Wallpaper.setIcon(icono);
        this.repaint();

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select nombre_usuario from usuarios where username = '" + user + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                nombre_usuario = rs.getString("nombre_usuario");
                jLabel_NombreUsuario.setText("Bienvenido " + nombre_usuario);
            }
        } catch (SQLException e) {
            System.err.println("Error en consultar nombre de técnico.");
        }

    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

    /**
     * Inicializa los componentes de la interfaz gráfica de usuario. Este método
     * es generado automáticamente por el editor de formularios.
     *
     * @see javax.swing.JFrame#initComponents()
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_NombreUsuario = new javax.swing.JLabel();
        jButton_GestionarEquipos = new javax.swing.JButton();
        jButton_GraficaEstatus = new javax.swing.JButton();
        jButton_GraficaMarcas = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_NombreUsuario.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel_NombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NombreUsuario.setText("jLabel1");
        getContentPane().add(jLabel_NombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jButton_GestionarEquipos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/apoyo-tecnico.png"))); // NOI18N
        jButton_GestionarEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GestionarEquiposActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_GestionarEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 120, 100));

        jButton_GraficaEstatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/grafica.png"))); // NOI18N
        jButton_GraficaEstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GraficaEstatusActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_GraficaEstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 120, 100));

        jButton_GraficaMarcas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/grafica.png"))); // NOI18N
        jButton_GraficaMarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GraficaMarcasActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_GraficaMarcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 120, 100));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Gestión de equipo");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Gráfica de estatus");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Gráfica de marcas");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Maneja el evento de clic en el botón de gestionar equipos. Muestra la
     * ventana para gestionar equipos.
     *
     * @param evt El evento de acción del botón de gestionar equipos.
     */
    private void jButton_GestionarEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GestionarEquiposActionPerformed

        GestionarEquipos gestionarEquipos = new GestionarEquipos();
        gestionarEquipos.setVisible(true);

    }//GEN-LAST:event_jButton_GestionarEquiposActionPerformed

    /**
     * Maneja el evento de clic en el botón de gráfica de estatus. Muestra la
     * ventana de gráfica de estatus.
     *
     * @param evt El evento de acción del botón de gráfica de estatus.
     */
    private void jButton_GraficaEstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GraficaEstatusActionPerformed

        GraficaEstatus graficaEstatus = new GraficaEstatus();
        graficaEstatus.setVisible(true);

    }//GEN-LAST:event_jButton_GraficaEstatusActionPerformed

    /**
     * Maneja el evento de clic en el botón de gráfica de marcas. Muestra la
     * ventana de gráfica de marcas.
     *
     * @param evt El evento de acción del botón de gráfica de marcas.
     */
    private void jButton_GraficaMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GraficaMarcasActionPerformed

        GraficarMarcas graficarMarcas = new GraficarMarcas();
        graficarMarcas.setVisible(true);

    }//GEN-LAST:event_jButton_GraficaMarcasActionPerformed

    /**
     * Crea y muestra la ventana de técnico.
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
            java.util.logging.Logger.getLogger(Tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tecnico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_GestionarEquipos;
    private javax.swing.JButton jButton_GraficaEstatus;
    private javax.swing.JButton jButton_GraficaMarcas;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_NombreUsuario;
    private javax.swing.JLabel jLabel_Wallpaper;
    // End of variables declaration//GEN-END:variables
}
