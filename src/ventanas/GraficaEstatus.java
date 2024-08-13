package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 * La clase GraficaEstatus permite generar y mostrar una gráfica de barras que
 * representa los distintos estados de los equipos registrados en el sistema. La
 * gráfica es generada en base a la cantidad de equipos en cada estatus.
 *
 * @author Lizarraga
 */
public class GraficaEstatus extends javax.swing.JFrame {

    String user; // Nombre del usuario que ha iniciado sesión
    int NuevoIngreso, NoReparado, EnRevision, Reparado, Entregado; // Contadores para los diferentes estados

    // Arreglos para almacenar los nombres y cantidades de los estados
    String[] vector_estatus_nombre = new String[5];
    int[] vector_estatus_cantidad = new int[5];

    /**
     * Constructor de la clase GraficaEstatus. Inicializa la interfaz gráfica y
     * carga los datos necesarios para la gráfica.
     */
    public GraficaEstatus() {
        initComponents();

        user = Login.user;

        setSize(550, 450);
        setResizable(false);
        setTitle("Técnico - Sesión de " + user);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        // Configuración del fondo de la ventana
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));

        jLabel_Wallpaper.setIcon(icono);
        this.repaint();

        // Consulta a la base de datos para obtener los diferentes estatus y sus cantidades
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select estatus, count(estatus) as Cantidad from equipos group by estatus");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int posicion = 0;
                do {
                    vector_estatus_nombre[posicion] = rs.getString(1);
                    vector_estatus_cantidad[posicion] = rs.getInt(2);

                    // Asignación de los contadores según el estatus
                    if (vector_estatus_nombre[posicion].equalsIgnoreCase("En revisión")) {
                        EnRevision = vector_estatus_cantidad[posicion];
                    } else if (vector_estatus_nombre[posicion].equalsIgnoreCase("Entregado")) {
                        Entregado = vector_estatus_cantidad[posicion];
                    } else if (vector_estatus_nombre[posicion].equalsIgnoreCase("No reparado")) {
                        NoReparado = vector_estatus_cantidad[posicion];
                    } else if (vector_estatus_nombre[posicion].equalsIgnoreCase("Nuevo ingreso")) {
                        NuevoIngreso = vector_estatus_cantidad[posicion];
                    } else if (vector_estatus_nombre[posicion].equalsIgnoreCase("Reparado")) {
                        Reparado = vector_estatus_cantidad[posicion];
                    }

                    posicion++;

                } while (rs.next());
            }
        } catch (SQLException e) {
            System.err.println("Error en conectar con la Base de datos.");
            JOptionPane.showMessageDialog(null, "¡¡ERROR!!, contacte al administrador.");
        }

        // Redibuja la ventana para mostrar la gráfica
        repaint();

    }

    /**
     * Obtiene el ícono de la aplicación.
     *
     * @return El ícono de la aplicación.
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
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gráfica de estatus");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GraficaEstatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraficaEstatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraficaEstatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraficaEstatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Crea y muestra el formulario */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraficaEstatus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Wallpaper;
    // End of variables declaration//GEN-END:variables

    /**
     * Método para determinar cuál es el estatus con la mayor cantidad de
     * registros.
     *
     * @param NuevoIngreso Cantidad de equipos con estatus "Nuevo ingreso".
     * @param NoReparado Cantidad de equipos con estatus "No reparado".
     * @param EnRevision Cantidad de equipos con estatus "En revisión".
     * @param Reparado Cantidad de equipos con estatus "Reparado".
     * @param Entregado Cantidad de equipos con estatus "Entregado".
     * @return La mayor cantidad entre todos los estatus.
     */
    public int EstatusMasRepetido(int NuevoIngreso, int NoReparado, int EnRevision, int Reparado, int Entregado) {
        if (NuevoIngreso > NoReparado && NuevoIngreso > EnRevision && NuevoIngreso > Reparado && NuevoIngreso > Entregado) {
            return NuevoIngreso;
        } else if (NoReparado > EnRevision && NoReparado > Reparado && NoReparado > Entregado) {
            return NoReparado;
        } else if (EnRevision > Reparado && EnRevision > Entregado) {
            return EnRevision;
        } else if (Reparado > Entregado) {
            return Reparado;
        } else {
            return Entregado;
        }
    }

    /**
     * Método que sobrescribe el método paint de la clase JFrame. Este método es
     * utilizado para dibujar la gráfica de barras en la ventana.
     *
     * @param g Objeto de la clase Graphics utilizado para dibujar en la
     * ventana.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Determina cuál es el estatus con la mayor cantidad de registros
        int Estatus_Mas_Repetido = EstatusMasRepetido(NuevoIngreso, NoReparado, EnRevision, Reparado, Entregado);

        // Cálculo de las longitudes de las barras según la cantidad de cada estatus
        int largo_NuevoIngreso = NuevoIngreso * 400 / Estatus_Mas_Repetido;
        int largo_NoReparado = NoReparado * 400 / Estatus_Mas_Repetido;
        int largo_EnRevision = EnRevision * 400 / Estatus_Mas_Repetido;
        int largo_Reparado = Reparado * 400 / Estatus_Mas_Repetido;
        int largo_Entregado = Entregado * 400 / Estatus_Mas_Repetido;

        // Dibuja la barra y el texto correspondiente para cada estatus
        g.setColor(new Color(240, 248, 0));//amarillo
        g.fillRect(100, 100, largo_NuevoIngreso, 40);
        g.drawString("Nuevo Ingreso", 10, 118);
        g.drawString("Cantidad:" + NuevoIngreso, 10, 133);

        g.setColor(new Color(255, 0, 0));//rojo
        g.fillRect(100, 150, largo_NoReparado, 40);
        g.drawString("No Reparado", 10, 168);
        g.drawString("Cantidad:" + NoReparado, 10, 183);

        g.setColor(new Color(0, 0, 0));//negro
        g.fillRect(100, 200, largo_EnRevision, 40);
        g.drawString("En Revisión", 10, 218);
        g.drawString("Cantidad:" + EnRevision, 10, 233);

        g.setColor(new Color(255, 255, 255));//blanco
        g.fillRect(100, 250, largo_Reparado, 40);
        g.drawString("Reparado", 10, 268);
        g.drawString("Cantidad:" + Reparado, 10, 283);

        g.setColor(new Color(0, 85, 0));//verde
        g.fillRect(100, 300, largo_Entregado, 40);
        g.drawString("Entregado", 10, 318);
        g.drawString("Cantidad:" + Entregado, 10, 333);
    }

}
