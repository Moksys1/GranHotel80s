package granhotel80s.vistas;

import granhotel80s.accesoADatos.HabitacionData;
import granhotel80s.accesoADatos.HuespedData;
import granhotel80s.accesoADatos.ReservaData;
import granhotel80s.entidades.Huesped;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class BusquedaReservacion extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel();
    private HuespedData huesData;
    private ReservaData resData;
    private HabitacionData habiData;
    private List<Object[]> ReservasHuesped;
    private LocalDate nuevaFecha;
    private int idReserva;
    private Huesped buscarHues;

    public BusquedaReservacion() {
        initComponents();
        huesData = new HuespedData();
        resData = new ReservaData();
        habiData = new HabitacionData();

        armarCabeceraTabla();
        cargaDatosReserva();

        jBCancelarReserva.setEnabled(false);

        // Agregar un ListSelectionListener a la tabla
        jTableReservas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    // Verificar si se ha seleccionado una fila
                    if (jTableReservas.getSelectedRow() != -1) {
                        jBCancelarReserva.setEnabled(true);
                    } else {
                        jBCancelarReserva.setEnabled(false);
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableReservas = new javax.swing.JTable();
        jTDNIhuesped = new javax.swing.JTextField();
        jBSalir = new javax.swing.JButton();
        jBModificarReserva = new javax.swing.JButton();
        jBCancelarReserva = new javax.swing.JButton();
        jBActualizarTabla = new javax.swing.JButton();

        setTitle("Busqueda de Reservacion\n");

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Busqueda por Dni");

        jLabel2.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel2.setText("Ingrese DNI de Husped");

        jTableReservas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTableReservas.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        jTableReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reserva", "Dni del cliente", "Entrada", "Salida", "Habitacion", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableReservas);

        jTDNIhuesped.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTDNIhuesped.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTDNIhuespedKeyReleased(evt);
            }
        });

        jBSalir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jBModificarReserva.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jBModificarReserva.setText("Modificar Reserva");
        jBModificarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificarReservaActionPerformed(evt);
            }
        });

        jBCancelarReserva.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jBCancelarReserva.setText("Cambiar Estado");
        jBCancelarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarReservaActionPerformed(evt);
            }
        });

        jBActualizarTabla.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jBActualizarTabla.setText("Actualizar tabla");
        jBActualizarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarTablaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jTDNIhuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jBModificarReserva)
                                .addGap(46, 46, 46)
                                .addComponent(jBActualizarTabla)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBCancelarReserva))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(jBSalir)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jTDNIhuesped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCancelarReserva)
                    .addComponent(jBModificarReserva)
                    .addComponent(jBActualizarTabla))
                .addGap(60, 60, 60)
                .addComponent(jBSalir)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jTDNIhuespedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTDNIhuespedKeyReleased
        filtrarHuespedConElDni();
    }//GEN-LAST:event_jTDNIhuespedKeyReleased

    private void jBCancelarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarReservaActionPerformed
        int filaSeleccionada = jTableReservas.getSelectedRow();
        if (filaSeleccionada != -1) {
            int idReserva = (Integer) modelo.getValueAt(filaSeleccionada, 0);
            int idHabitacion = (Integer) modelo.getValueAt(filaSeleccionada, 4);
            resData.cambiarEstadoReserva(idReserva);
            habiData.cambiarEstadoHabitacion(idHabitacion);
            JOptionPane.showMessageDialog(null, "Cambio de reserva con exito.");
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla.");
        }
    }//GEN-LAST:event_jBCancelarReservaActionPerformed

    private void jBModificarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificarReservaActionPerformed
        try {
            cambioDeFecha();
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Seleccione la columna correcta para modificar la fecha..");
        }
    }//GEN-LAST:event_jBModificarReservaActionPerformed

    private void jBActualizarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarTablaActionPerformed
        borrarFilasTabla();
        cargaDatosReserva();
    }//GEN-LAST:event_jBActualizarTablaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBActualizarTabla;
    private javax.swing.JButton jBCancelarReserva;
    private javax.swing.JButton jBModificarReserva;
    private javax.swing.JButton jBSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTDNIhuesped;
    private javax.swing.JTable jTableReservas;
    // End of variables declaration//GEN-END:variables

    private void armarCabeceraTabla() {
        modelo.addColumn("Reserva");
        modelo.addColumn("Dni del cliente");
        modelo.addColumn("Entrada");
        modelo.addColumn("Salida");
        modelo.addColumn("Habitacion");
        modelo.addColumn("Estado");

        jTableReservas.setModel(modelo);
    }

    public void borrarFilasTabla() {
        if (modelo != null) {
            int a = modelo.getRowCount() - 1;
            if (modelo.getRowCount() > 0) {
                for (int i = a; i >= 0; i--) {
                    modelo.removeRow(i);
                }
            }
        }
    }

    private void filtrarHuespedConElDni() {
        String dni = jTDNIhuesped.getText();
        modelo.setRowCount(0);
        // Filtrar las reservas por el DNI
        ArrayList<Object[]> lista = resData.filtrarHuespedPorDni(dni);

        // Agregar las filas filtradas al modelo de la tabla
        for (Object[] fila : lista) {
            modelo.addRow(fila);
        }
    }

    private void cargaDatosReserva() {
        ArrayList<Object[]> lista = (ArrayList) resData.obtenerReservasDelHuesped();
        for (Object[] fila : lista) {
            modelo.addRow(fila);
        }
    }

    public void cambioDeFecha() {
        //Obtiene la fila seleccionada
        int fila = jTableReservas.getSelectedRow();

        //Obtiene el valor de la columna 0 de la fila seleccionada, lo convierte a un entero y lo asigna a la variable id
        int id = Integer.parseInt(this.jTableReservas.getValueAt(fila, 0).toString());

        //Obtiene el valor de la columna 3 de la fila seleccionada y lo convierte a una cadena de texto
        String fechaString = jTableReservas.getValueAt(fila, 3).toString();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            //Convierte la cadena fechaString en un date.
            Date nuevaFecha = new Date(dateFormat.parse(fechaString).getTime());
            resData.modificarFecha(nuevaFecha, id);
            JOptionPane.showMessageDialog(null, "Fecha modificada con éxito.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede modificar esta parte..");
        }
    }
}
