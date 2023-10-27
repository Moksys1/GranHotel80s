package granhotel80s.vistas;

import granhotel80s.accesoADatos.Conexion;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class MainMenu extends javax.swing.JFrame {

    private static boolean confirmado = false;

    public MainMenu() {
        initComponents();
        // Realizo la coneccion a la DB, si fue exitosa agrego al titulo
        // conectado para no tener ese molesto dialogo de conexion ;)
        Connection con = Conexion.getConnection();
        // Si la conexion fue exitosa cambio el titulo del Frame del menu
        if (con != null) {
            this.setTitle("Sistema de Reserva de Habitaciones y Gestión de Ventas - Gran Hotel 80s - Estado: Conectado");
        } else {
            this.setTitle("Sistema de Reserva de Habitaciones y Gestión de Ventas - Gran Hotel 80s - Estado: Error");
        }
        
        // Calcular el centro de la pantalla y establecer la ubicación de la ventana
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) (screenSize.getWidth() - this.getWidth()) / 2;
        int centerY = (int) (screenSize.getHeight() - this.getHeight()) / 2;
        this.setLocation(centerX, centerY);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuHuesped = new javax.swing.JMenu();
        jMenuRegistroHuespedes = new javax.swing.JMenuItem();
        jMenuReserva = new javax.swing.JMenu();
        jMenuRegistroReserva = new javax.swing.JMenuItem();
        jMenuConsultaReserva = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jTiposHabitacion = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jSobreNosotros = new javax.swing.JMenuItem();
        jSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("2023 - Elaborado y diseñado por el Grupo 80");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("@Moksys1 - @KevinSepulveda93 - @orli1208 - @Herny74");

        escritorio.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                .addContainerGap(611, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18))
        );

        jMenuBar1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jMenuHuesped.setText("Registro de Huespedes");
        jMenuHuesped.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jMenuRegistroHuespedes.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jMenuRegistroHuespedes.setText("Huespedes y Busquedas");
        jMenuRegistroHuespedes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRegistroHuespedesActionPerformed(evt);
            }
        });
        jMenuHuesped.add(jMenuRegistroHuespedes);

        jMenuBar1.add(jMenuHuesped);

        jMenuReserva.setText("Reservas");
        jMenuReserva.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jMenuRegistroReserva.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jMenuRegistroReserva.setText("Registro de reservas");
        jMenuRegistroReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRegistroReservaActionPerformed(evt);
            }
        });
        jMenuReserva.add(jMenuRegistroReserva);

        jMenuConsultaReserva.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jMenuConsultaReserva.setText("Consulta de Reserva");
        jMenuConsultaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuConsultaReservaActionPerformed(evt);
            }
        });
        jMenuReserva.add(jMenuConsultaReserva);

        jMenuBar1.add(jMenuReserva);

        jMenu3.setText("Habitaciones");
        jMenu3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jTiposHabitacion.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTiposHabitacion.setText("Tipos de habitaciones");
        jTiposHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTiposHabitacionActionPerformed(evt);
            }
        });
        jMenu3.add(jTiposHabitacion);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Más Información");
        jMenu2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jSobreNosotros.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jSobreNosotros.setText("Sobre nosotros");
        jSobreNosotros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSobreNosotrosActionPerformed(evt);
            }
        });
        jMenu2.add(jSobreNosotros);

        jMenuBar1.add(jMenu2);

        jSalir.setText("Salir");
        jSalir.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSalirMouseClicked(evt);
            }
        });
        jMenuBar1.add(jSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSalirMouseClicked
        // TODO add your handling code here:
        if (!confirmado) {
            //int opcion = JOptionPane.showConfirmDialog(jMenu1, "¿Estas seguro de que quieres salir?", "Confirmar salida", JOptionPane.YES_NO_CANCEL_OPTION);
            int opcion = JOptionPane.showOptionDialog(null, "¿Está seguro de que desea salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (opcion == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        } else {
            confirmado = true;
        }
    }//GEN-LAST:event_jSalirMouseClicked

    private void jSobreNosotrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSobreNosotrosActionPerformed

    }//GEN-LAST:event_jSobreNosotrosActionPerformed

    private void jMenuConsultaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuConsultaReservaActionPerformed
        BusquedaReservacion busqRes = new BusquedaReservacion();
        MainMenu.escritorio.add(busqRes);
        busqRes.toFront();
        busqRes.setVisible(true);
        Dimension desktopSize = MainMenu.escritorio.getSize();
        Dimension FrameSize = busqRes.getSize();
        busqRes.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
    }//GEN-LAST:event_jMenuConsultaReservaActionPerformed

    private void jMenuRegistroReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRegistroReservaActionPerformed
        menuReserva menRes = new menuReserva();
        MainMenu.escritorio.add(menRes);
        menRes.toFront();
        menRes.setVisible(true);
        Dimension desktopSize = MainMenu.escritorio.getSize();
        Dimension FrameSize = menRes.getSize();
        menRes.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
    }//GEN-LAST:event_jMenuRegistroReservaActionPerformed

    private void jMenuRegistroHuespedesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRegistroHuespedesActionPerformed
        RegistroHuespedes regHues = new RegistroHuespedes();
        MainMenu.escritorio.add(regHues);
        regHues.toFront();
        regHues.setVisible(true);
        Dimension desktopSize = MainMenu.escritorio.getSize();
        Dimension FrameSize = regHues.getSize();
        regHues.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
    }//GEN-LAST:event_jMenuRegistroHuespedesActionPerformed

    private void jTiposHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTiposHabitacionActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTiposHabitacionActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuConsultaReserva;
    private javax.swing.JMenu jMenuHuesped;
    private javax.swing.JMenuItem jMenuRegistroHuespedes;
    private javax.swing.JMenuItem jMenuRegistroReserva;
    private javax.swing.JMenu jMenuReserva;
    private javax.swing.JMenu jSalir;
    private javax.swing.JMenuItem jSobreNosotros;
    private javax.swing.JMenuItem jTiposHabitacion;
    // End of variables declaration//GEN-END:variables
}
