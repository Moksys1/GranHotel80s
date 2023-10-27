package granhotel80s.vistas;

import com.toedter.calendar.JDateChooser;
import static granhotel80s.accesoADatos.Conexion.conexion;
import granhotel80s.accesoADatos.HabitacionData;
import granhotel80s.accesoADatos.HuespedData;
import granhotel80s.accesoADatos.ReservaData;
import granhotel80s.accesoADatos.TipoHabitacionData;
import granhotel80s.entidades.Habitacion;
import granhotel80s.entidades.Huesped;
import granhotel80s.entidades.Reserva;
import granhotel80s.entidades.TipoHabitacion;
import java.awt.Dimension;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import static java.util.concurrent.TimeUnit.DAYS;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class menuReserva extends javax.swing.JInternalFrame {

    private LocalDate fechaEE;
    private LocalDate fechaSS;
    private DefaultTableModel modelo;
    private HuespedData huData;
    private HabitacionData habData;
    private ReservaData reData;
    private List<Habitacion> listaH;
    private List<TipoHabitacion> listaTH;
    private TipoHabitacionData tipoHdata;
    private TipoHabitacion tipoH;
    private Huesped hue;
    private TipoHabitacion tiphab;
    private static int idHab;
    private static String fecha1;
    private static String fecha2;
    private static String cantP;
    private static long diasR;
    private static double precioFinal;
    private static String tipoHabS;

    public menuReserva() {
        initComponents();
        tipoHdata = new TipoHabitacionData();
        huData = new HuespedData();
        habData = new HabitacionData();
        reData = new ReservaData();
        modelo = (DefaultTableModel) jTreserva.getModel();
//        listaH = habData.obtenerHabitacionesDesocupadas();
        listaH = habData.obtenerHabitaciones();
        listaTH=tipoHdata.listarTipoHabitacion();

        // Con esto le doy formato dia, mes, año a la fecha
        jDfechaE.setDateFormatString("dd-MM-yyyy");
        jDfechaS.setDateFormatString("dd-MM-yyyy");

        // Y con estas lineas de aca hago que no me muestre los dias anteriores a la fecha actual
        LocalDate fechaMinimaSeleccionable = LocalDate.now();
        Date fechaMinimaSeleccionableDate = java.sql.Date.valueOf(fechaMinimaSeleccionable);
        jDfechaE.setMinSelectableDate(fechaMinimaSeleccionableDate);

        LocalDate fechaMinimaSeleccionable1 = LocalDate.now().plusDays(1); // Obtiene el día siguiente al día de hoy
        Date fechaMinimaSeleccionableDate1 = java.sql.Date.valueOf(fechaMinimaSeleccionable1);
        jDfechaS.setMinSelectableDate(fechaMinimaSeleccionableDate1);
        armarCabeceraDeLaTabla();
        cargarHabitaciones();
    }
//
//    private void cargarHabitaciones() {
//
//        jCtipoH.addItem("StdSimple");
//        jCtipoH.addItem("StdDoble");
//        jCtipoH.addItem("StdTriple");
//        jCtipoH.addItem("Suite Lujo");
//    }

    private void cargarHabitaciones() {
       
        for (TipoHabitacion thab : listaTH) {
      
            jCtipoH.addItem(thab);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jBbuscar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jDfechaS = new com.toedter.calendar.JDateChooser();
        jDfechaE = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jCtipoH = new javax.swing.JComboBox<>();
        TfCantidadP = new java.awt.TextField();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTreserva = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jButtonReservar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTprecio2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTprecio1 = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setTitle("Reservacion de habitaciones");
        setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));

        jBbuscar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jBbuscar.setText("Buscar");
        jBbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBbuscarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cantidad de personas ");

        jDfechaS.setDateFormatString("dd-MM-yyyy");
        jDfechaS.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jDfechaE.setDateFormatString("dd-MM-yyyy");
        jDfechaE.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fecha de Entrada");

        jLabel3.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha de Salida");

        jLabel6.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tipo de habitacion");

        jLabel8.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Busqueda de habitaciones");

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));

        jButton2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton2.setText("Buscar Reserva");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jCtipoH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCtipoHActionPerformed(evt);
            }
        });

        TfCantidadP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TfCantidadPActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton4.setText("Salir al menu principal");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBbuscar)
                .addGap(101, 101, 101))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jDfechaE, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TfCantidadP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(jLabel5)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(22, 22, 22))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(78, 78, 78))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCtipoH, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(jLabel3))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jDfechaS, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel8)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2))
                        .addGap(21, 21, 21)
                        .addComponent(jDfechaE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDfechaS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TfCantidadP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCtipoH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(64, 64, 64))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(242, 242, 242)
                            .addComponent(jLabel1)
                            .addGap(172, 172, 172))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(217, 217, 217)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton2)
                                .addComponent(jBbuscar))
                            .addGap(157, 157, 157)))))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));

        jTreserva.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTreserva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTreservaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTreserva);

        jLabel9.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Habitaciones disponibles");

        jButtonReservar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonReservar.setText("Reservar");
        jButtonReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReservarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Precio total");

        jTprecio2.setEditable(false);
        jTprecio2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTprecio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTprecio2ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Precio (Por Noche)");

        jTprecio1.setEditable(false);
        jTprecio1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTprecio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTprecio1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addComponent(jTprecio1)
                            .addComponent(jTprecio2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonReservar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel9)
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTprecio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTprecio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonReservar))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReservarActionPerformed

        int filaSeleccionada = jTreserva.getSelectedRow();

        if (filaSeleccionada != -1) {
            Object idHabitacionH = jTreserva.getValueAt(filaSeleccionada, 0);

            idHab = (int) idHabitacionH;

            double precio = tipoHdata.buscarPrecioTHab(idHab);
            jTprecio1.setText(String.valueOf(precio));

//            JOptionPane.showMessageDialog(null, "ID habitación: " + idHab + "\nPrecio habitación: " );
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una fila primero.");
        }

        RegistroHuespedes regHues = new RegistroHuespedes();
        MainMenu.escritorio.add(regHues);
        regHues.toFront();
        regHues.setVisible(true);
        Dimension desktopSize = MainMenu.escritorio.getSize();
        Dimension FrameSize = regHues.getSize();
        regHues.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
    }//GEN-LAST:event_jButtonReservarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTprecio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTprecio2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTprecio2ActionPerformed

    private void jCtipoHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCtipoHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCtipoHActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        BusquedaReservacion busqres = new BusquedaReservacion();
        MainMenu.escritorio.add(busqres);
        busqres.toFront();
        busqres.setVisible(true);
        Dimension desktopSize = MainMenu.escritorio.getSize();
        Dimension FrameSize = busqres.getSize();
        busqres.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jBbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBbuscarActionPerformed
         
            
//       
////        String tipoHCB = (String) jCtipoH.getSelectedItem();
////        listaH = habData.obtenerHabitacionesDesocupadas(tipoHCB);
//        borrarFilasTabla();
//
//        try {
//
//            String cantidadP = TfCantidadP.getText();
//            cantP=cantidadP;
//            String selTipoH = jCtipoH.getSelectedItem().toString();
//            int numIng = Integer.parseInt(cantidadP);
//            
//           
//
//            if (cantidadP != "" && selTipoH != "" && fechaIn != null && fechaOut != null) {
//
//                for (Habitacion habitacion : listaH) {
//                    modelo.addRow(new Object[]{
//                        habitacion.getIdHabitacion(),
//                        habitacion.getIdTipoHabitacion(),
//                        habitacion.getCategoria(),
//                        habitacion.getPiso(),
//                        habitacion.getNroHabitacion()
//                    });
//                }
//               // System.out.println("cantidadP" + " " + "selTipoH" + " " + "fechae" + " " + "fechas");
//                //System.out.println(cantidadP + " " + selTipoH + " " + fechaIn + " " + fechaOut);

////==================================================================================================== 
//
//            } else {
//                JOptionPane.showMessageDialog(null, "Por favor completar todos los campos ");
//            }
//
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(null, "Cantidad de personas no válidas.");
//        } catch (DateTimeParseException e) {
//            JOptionPane.showMessageDialog(null, "Error en el formato de fecha/\"Por favor, seleccione ambas fechas.\"");
//
//        }
        
        borrarFilasTabla();
//        
//        try {
//             
//            String cantidadP = TfCantidadP.getText();
//            cantP=cantidadP;
//            int numIng = Integer.parseInt(cantidadP);
////            Calendar fechae = Calendar.getInstance();
////            Calendar fechas = Calendar.getInstance();
//            String fechae = ((JTextField) jDfechaE.getDateEditor().getUiComponent()).getText();
//            String fechas = ((JTextField) jDfechaS.getDateEditor().getUiComponent()).getText();
//            fecha1=fechae;
//            fecha2=fechas;
//            if (TfCantidadP != null && fechae != "" && fechas != "") {
//                for (Habitacion habitacion : listaH) {
//
//                    modelo.addRow(new Object[]{
//                        habitacion.getIdHabitacion(),
//                        habitacion.getIdTipoHabitacion(),
//                        habitacion.getCategoria(),
//                        habitacion.getPiso(),
//                        habitacion.getNroHabitacion()
//                    });
//
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "Completar todos los campos ");
//            }
            ////====================================================================================================
////  ====================================== Calculo de dias =========================================
////====================================================================================================
                
                 
//                  fechae = jDfechaE.getCalendar();
//                  fechas = jDfechaS.getCalendar();
//                 
//            if (fechae.getTimeInMillis() < fechas.getTimeInMillis()) {
//
//                    long startTime = fechae.getTimeInMillis();
//                    long endTime = fechas.getTimeInMillis();
//                    long diasDesde = (long) Math.floor(startTime / (1000 * 60 * 60 * 24)); // convertimos a dias, para que no afecten cambios de hora 
//                    long diasHasta = (long) Math.floor(endTime / (1000 * 60 * 60 * 24)); // convertimos a dias, para que no afecten cambios de hora
//                    long diaDif = diasHasta - diasDesde;
//                    diasR=diaDif;
//                    SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy"); 
//
//
//                    String fecha1 = formato.format(fechae.getTime());
//                    String fecha2 = formato.format(fechas.getTime());
//                  
//                    
//                    JOptionPane.showMessageDialog(null, "Cantidad de dias: " + diaDif);
//                } else {
//                    JOptionPane.showMessageDialog(null, "La fecha de salida NO puede ser anterior a la de ingreso");
//                }
//            if (fechae != null && fechas != null) {
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//                LocalDate jDfechaE = LocalDate.parse(fechae, formatter);
//                LocalDate jDfechaS = LocalDate.parse(fechas, formatter);
//               
//                long diasReserva = jDfechaE.until(jDfechaS, ChronoUnit.DAYS);
//                diasR=diasReserva;
//              
//            } else {
//                JOptionPane.showMessageDialog(null, "Por favor, seleccione ambas fechas.");
//            }
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(null, "Cantidad de personas no válidas.");
//        } catch (DateTimeParseException e) {
//            JOptionPane.showMessageDialog(null, "Error en el formato de fecha/\"Por favor, seleccione ambas fechas.\"");
//        }
     try {
            String cantidadP = TfCantidadP.getText();
            cantP = cantidadP;

            if (cantidadP != null && !cantidadP.isEmpty()) {
                int numIng = Integer.parseInt(cantidadP);

                String fechae = ((JTextField) jDfechaE.getDateEditor().getUiComponent()).getText();
                String fechas = ((JTextField) jDfechaS.getDateEditor().getUiComponent()).getText();

                fecha1 = fechae;
                fecha2 = fechas;

                if (!fechae.isEmpty() && !fechas.isEmpty()) {
                    for (Habitacion habitacion : listaH) {
                        modelo.addRow(new Object[]{
                            habitacion.getIdHabitacion(),
                            habitacion.getIdTipoHabitacion(),
                            habitacion.getCategoria(),
                            habitacion.getPiso(),
                            habitacion.getNroHabitacion()
                        });
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Completar todos los campos ");
                }

                // Cálculo de la diferencia de días
                SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                java.util.Date date1 = formato.parse(fechae);
                java.util.Date date2 = formato.parse(fechas);

                if (date1.before(date2)) {
                    long startTime = date1.getTime();
                    long endTime = date2.getTime();
                    long diasDesde = (long) Math.floor(startTime / (1000 * 60 * 60 * 24));
                    long diasHasta = (long) Math.floor(endTime / (1000 * 60 * 60 * 24));
                    long diaDif = diasHasta - diasDesde;
                    diasR = diaDif;
                }
            } else {
                JOptionPane.showMessageDialog(null, "La cantidad de personas no es válida.");
            }
        } catch ( ParseException  e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocurrió un error: " + e.getMessage());
}
           JComboBox<String> jCtipoH = new JComboBox<>();


           String tipoHabS = (String) jCtipoH.getSelectedItem();

    }//GEN-LAST:event_jBbuscarActionPerformed


    private void TfCantidadPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfCantidadPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TfCantidadPActionPerformed

    private void jTprecio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTprecio1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTprecio1ActionPerformed

    private void jTreservaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTreservaMouseClicked
        // TODO add your handling code here:
        int filaSeleccionada = jTreserva.getSelectedRow();

        if (filaSeleccionada != -1) {
            Object idHabitacionH = jTreserva.getValueAt(filaSeleccionada, 1);
            idHab = (int) idHabitacionH;
            double precio = tipoHdata.buscarPrecioTHab(idHab);
            jTprecio1.setText(String.valueOf(precio));
            double cantPDouble = (double) diasR;
            double precioo = precio * cantPDouble;
            jTprecio2.setText(String.valueOf(precioo));
            precioFinal = precioo;
        } else {
            JOptionPane.showMessageDialog(null, "seleccione una fila");
        }

    }//GEN-LAST:event_jTreservaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextField TfCantidadP;
    private javax.swing.JButton jBbuscar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonReservar;
    private javax.swing.JComboBox<TipoHabitacion> jCtipoH;
    private com.toedter.calendar.JDateChooser jDfechaE;
    private com.toedter.calendar.JDateChooser jDfechaS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTprecio1;
    private javax.swing.JTextField jTprecio2;
    private javax.swing.JTable jTreserva;
    // End of variables declaration//GEN-END:variables

    public void armarCabeceraDeLaTabla() {

        modelo.addColumn("idHabitacion");
        modelo.addColumn("tipo de Habitacion");
        modelo.addColumn("categoria");
        modelo.addColumn("piso");
        modelo.addColumn("numero Habitacion");
        jTreserva.setModel(modelo);

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

    public static void setVariables(String var1, String var2, String var3, int var4, long var5, double var6, String var7) {

        fecha1 = var1;
        fecha2 = var2;
        cantP = var3;
        idHab = var4;
        diasR = var5;
        precioFinal = var6;
        tipoHabS = var7;
    }

    public static String getfecha1() {
        return fecha1;
    }

    public static String getfecha2() {
        return fecha2;
    }

    public static String getcantP() {
        return cantP;
    }

    public static int getidHab() {
        return idHab;
    }

    public static long getdiasR() {
        return diasR;
    }

    public static double getprecioFinal() {
        return precioFinal;
    }

    public static String gettipoHaString() {
        return tipoHabS;
    }
    //ariel
//   reservation = new Reserva();
//            reservation.setIdHuesped(idHuespedSeleccionado);
//            idHabitacionSeleccionada = (int) jTreserva.getValueAt(filaSeleccionada, 0); //Obtengo IdHabitacion
//            reservation.setIdHabitacion(idHabitacionSeleccionada);
//            reservation.setFechaEntrada(jDfechaE.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()); //Obtengo la fecha de entrada
//            reservation.setFechaSalida(jDfechaS.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()); //Obtengo la fecha de salida
//            reservation.setCantPersonas(Integer.parseInt(TfCantidadP.getText())); //Obtengo la cantidad de personas
}
