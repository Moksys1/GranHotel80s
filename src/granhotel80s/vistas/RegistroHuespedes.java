package granhotel80s.vistas;

import granhotel80s.accesoADatos.HuespedData;
import granhotel80s.entidades.Huesped;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RegistroHuespedes extends javax.swing.JInternalFrame {

    private HuespedData huespedData;
    private static boolean confirmado = false;
    private List<Huesped> listaHuesped;
    private DefaultTableModel modelo;
    private HuespedData huesData;
    private List<Huesped> verHuespedes;
    private Huesped buscarHues;

    public RegistroHuespedes() {
        initComponents();
        huespedData = new HuespedData();
        listaHuesped = huespedData.listarHuesped();
        modelo = new DefaultTableModel();
        modelo = (DefaultTableModel) jTablehuespedes.getModel();

        armarCabeceraTabla();
        cargaDatosInscriptos();
    }

    private void cargaHuespedes(Huesped hues) {
        HuespedData verHuesped = new HuespedData();
//      System.out.println((String)hues.toString());
        modelo.addRow(new Object[]{hues.getDni(), hues.getApellido(), hues.getNombre(), hues.getTelefono(), hues.isEstado()});

    }

    private void armarCabeceraTabla() {
        ArrayList<Object> filaCabecera = new ArrayList<>();
        filaCabecera.add("DNI");
        filaCabecera.add("Apellido");
        filaCabecera.add("Nombre");
        filaCabecera.add("Telefono");
        filaCabecera.add("Estado");
        for (Object it : filaCabecera) {
            modelo.addColumn(it);
        }
        jTablehuespedes.setModel(modelo);
    }

    private void borrarFilaTabla() {
        int indice = modelo.getRowCount() - 1;
        for (int i = indice; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    private void cargaDatosInscriptos() {
        borrarFilaTabla();
        for (Huesped h : listaHuesped) {
            modelo.addRow(new Object[]{h.getDni(), h.getApellido(), h.getNombre(), h.getTelefono(), h.isEstado()});
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTDni = new javax.swing.JTextField();
        jTNombre = new javax.swing.JTextField();
        jTApellido = new javax.swing.JTextField();
        jTEmail = new javax.swing.JTextField();
        jTDomicilio = new javax.swing.JTextField();
        jTelefono = new javax.swing.JTextField();
        jBBuscar = new javax.swing.JButton();
        jBGuardarNuevo = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBActualizar = new javax.swing.JButton();
        jCheckBoxActivo = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablehuespedes = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTFbuscaHuepedXDni = new javax.swing.JTextField();
        jBreservaBuscar = new javax.swing.JButton();
        jBasignarReserva = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();

        setTitle("Registro de Huespedes");

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setForeground(new java.awt.Color(153, 153, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Huespedes");

        jLabel2.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("DNI:");

        jLabel3.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nombre:");

        jLabel4.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Apellido:");

        jLabel5.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("E-Mail:");

        jLabel6.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Domicilio:");

        jLabel7.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Telefono:");

        jLabel8.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Estado:");

        jTDni.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jTNombre.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jTApellido.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jTEmail.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jTDomicilio.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jTelefono.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jBBuscar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jBBuscar.setText("Buscar Huesped");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        jBGuardarNuevo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jBGuardarNuevo.setText("Guardar Nuevo");
        jBGuardarNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarNuevoActionPerformed(evt);
            }
        });

        jBEliminar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jBEliminar.setText("Eliminar");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jBActualizar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jBActualizar.setText("Actualizar");
        jBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarActionPerformed(evt);
            }
        });

        jCheckBoxActivo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jCheckBoxActivo.setText("Activo\n");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jBGuardarNuevo)
                                .addGap(63, 63, 63)
                                .addComponent(jBActualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                                .addComponent(jBEliminar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jCheckBoxActivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBBuscar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel2)
                                    .addComponent(jTDni, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jTEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(jTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(57, 57, 57))))
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBBuscar)
                    .addComponent(jCheckBoxActivo))
                .addGap(82, 82, 82)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBGuardarNuevo)
                    .addComponent(jBActualizar)
                    .addComponent(jBEliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 153));

        jTablehuespedes.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTablehuespedes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTablehuespedes);

        jLabel10.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Busqueda de Huespedes");

        jLabel11.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Inserte DNI del Huesped a buscar:");

        jTFbuscaHuepedXDni.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jBreservaBuscar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jBreservaBuscar.setText("Buscar");
        jBreservaBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBreservaBuscarActionPerformed(evt);
            }
        });

        jBasignarReserva.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jBasignarReserva.setText("Asignar Reserva");
        jBasignarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBasignarReservaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBasignarReserva)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTFbuscaHuepedXDni))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBreservaBuscar))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(35, 35, 35)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFbuscaHuepedXDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBreservaBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jBasignarReserva)
                .addGap(68, 68, 68))
        );

        jBSalir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(547, 547, 547)
                .addComponent(jBSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jBSalir)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//----------------------------------------------------------------------------------------------------------------------
//    Pestaña Huespedes
    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jBGuardarNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarNuevoActionPerformed
        try {
            Huesped persona = new Huesped();

            persona.setDni(Integer.parseInt(jTDni.getText()));
            persona.setNombre(jTNombre.getText());
            persona.setApellido(jTApellido.getText());
            persona.setCorreo(jTEmail.getText());
            persona.setDomicilio(jTDomicilio.getText());
            persona.setTelefono(jTelefono.getText());
            persona.setEstado(true);

            huespedData.guardarHuesped(persona);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.");
        }

        jTDni.setText("");
        jTNombre.setText("");
        jTApellido.setText("");
        jTEmail.setText("");
        jTDomicilio.setText("");
        jTelefono.setText("");
        jCheckBoxActivo.setSelected(false);
    }//GEN-LAST:event_jBGuardarNuevoActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        try {
            Huesped buscarHues = huespedData.BuscarHuespedPorDni(Integer.parseInt(jTDni.getText()));

            if (buscarHues != null) {
                jTApellido.setText(buscarHues.getApellido());
                jTNombre.setText(buscarHues.getNombre());
                jTEmail.setText(buscarHues.getCorreo());
                jTDomicilio.setText(buscarHues.getDomicilio());
                jTelefono.setText(buscarHues.getTelefono());
                jCheckBoxActivo.setSelected(buscarHues.isEstado());
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "No ha ingresado ningun DNI a buscar.");
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "No existe este huesped.");
        }
    }//GEN-LAST:event_jBBuscarActionPerformed

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
        try {
            Huesped persona = huespedData.BuscarHuespedPorDni(Integer.parseInt(jTDni.getText()));
            persona.setDni(Integer.parseInt(jTDni.getText()));
            persona.setNombre(jTNombre.getText());
            persona.setApellido(jTApellido.getText());
            persona.setCorreo(jTEmail.getText());
            persona.setDomicilio(jTDomicilio.getText());
            persona.setTelefono(jTelefono.getText());
            persona.setEstado(true);

            huespedData.modificarHuesped(persona);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.");
        }

        jTDni.setText("");
        jTNombre.setText("");
        jTApellido.setText("");
        jTEmail.setText("");
        jTDomicilio.setText("");
        jTelefono.setText("");
        jCheckBoxActivo.setSelected(false);
    }//GEN-LAST:event_jBActualizarActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        try {
            int dni = Integer.parseInt(jTDni.getText());
            Huesped EliminarPersona = huespedData.BuscarHuespedPorDni(dni);
            if (!confirmado) {
                int opcion = JOptionPane.showOptionDialog(null, "¿Está seguro de que desea eliminar el huesped?", "Confirmar eliminacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (opcion == JOptionPane.YES_OPTION) {
                    huespedData.eliminarHuesped(EliminarPersona.getIdHuesped());
                }
            } else {
                confirmado = true;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Debe buscar un huesped o indicar su DNI.");
        }

        jTDni.setText("");
        jTNombre.setText("");
        jTApellido.setText("");
        jTEmail.setText("");
        jTDomicilio.setText("");
        jTelefono.setText("");
        jCheckBoxActivo.setSelected(false);
    }//GEN-LAST:event_jBEliminarActionPerformed

//-------------------------------------------------------------------------------------------------------
//    Pestaña Busqueda de reserva

    private void jBreservaBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBreservaBuscarActionPerformed
        try {
            buscarHues = huespedData.BuscarHuespedPorDni(Integer.parseInt(jTFbuscaHuepedXDni.getText()));
            if (buscarHues != null) {
                borrarFilaTabla();
                cargaHuespedes(buscarHues);
            } else {
                borrarFilaTabla();
                cargaDatosInscriptos();
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "No ha ingresado ningun DNI a buscar.");
            borrarFilaTabla();
            cargaDatosInscriptos();
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "No existe este huesped.");
        }
        jTFbuscaHuepedXDni.setText("");
    }//GEN-LAST:event_jBreservaBuscarActionPerformed

    private void jBasignarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBasignarReservaActionPerformed
        // TODO add your handling code here:

        borrarFilaTabla();
        cargaDatosInscriptos();
    }//GEN-LAST:event_jBasignarReservaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBGuardarNuevo;
    private javax.swing.JButton jBSalir;
    private javax.swing.JButton jBasignarReserva;
    private javax.swing.JButton jBreservaBuscar;
    private javax.swing.JCheckBox jCheckBoxActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTApellido;
    private javax.swing.JTextField jTDni;
    private javax.swing.JTextField jTDomicilio;
    private javax.swing.JTextField jTEmail;
    private javax.swing.JTextField jTFbuscaHuepedXDni;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JTable jTablehuespedes;
    private javax.swing.JTextField jTelefono;
    // End of variables declaration//GEN-END:variables
}
