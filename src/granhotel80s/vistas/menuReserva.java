package granhotel80s.vistas;

import granhotel80s.accesoADatos.HabitacionData;
import granhotel80s.accesoADatos.HuespedData;
import granhotel80s.accesoADatos.ReservaData;
import granhotel80s.accesoADatos.TipoHabitacionData;
import granhotel80s.entidades.Habitacion;
import granhotel80s.entidades.Huesped;
import granhotel80s.entidades.TipoHabitacion;
import java.awt.Dimension;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class menuReserva extends javax.swing.JInternalFrame {           //ERROR

    private LocalDate fechaEE;
    private LocalDate fechaSS;
    private DefaultTableModel modelo;
    private Huesped hue;
    private HuespedData huData;
    private HabitacionData habData;
    private ReservaData reData;
    private List<Habitacion> listaH;
    private List<TipoHabitacion> listaTH;
    private TipoHabitacion tiphab;
    private TipoHabitacion tipoH;
    private TipoHabitacionData tipoHdata;
    private TipoHabitacionData verCantPer;
    private static String fecha1;
    private static String fecha2;
    private static String cantP;
    private static String tipoHabS;
    private static int idHab;
    public static int numIng;
    private static long diasR;
    private static double precioFinal;

    public menuReserva() {
        initComponents();
        tipoHdata = new TipoHabitacionData();
        huData = new HuespedData();
        habData = new HabitacionData();
        reData = new ReservaData();
        modelo = (DefaultTableModel) jTreserva.getModel();
        verCantPer = new TipoHabitacionData();
        jButtonReservar.setEnabled(false);

        // Agregar un ListSelectionListener a la tabla
        jTreserva.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    // Verificar si se ha seleccionado una fila
                    if (jTreserva.getSelectedRow() != -1) {
                        jButtonReservar.setEnabled(true);
                    } else {
                        jButtonReservar.setEnabled(false);
                    }
                }
            }
        });

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

    private void cargarHabitaciones() {
        jCtipoH.addItem("StdSimple");
        jCtipoH.addItem("StdDoble");
        jCtipoH.addItem("StdTriple");
        jCtipoH.addItem("Suite Lujo");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jBbuscar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jDfechaS = new com.toedter.calendar.JDateChooser();
        jDfechaE = new com.toedter.calendar.JDateChooser();
        jLFechaEntrada = new javax.swing.JLabel();
        jLFechaSalida = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLBusquedaHabitaciones = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jBbuscarReserva = new javax.swing.JButton();
        jCtipoH = new javax.swing.JComboBox<>();
        TfCantidadP = new java.awt.TextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTreserva = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jButtonReservar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTprecio2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTprecio1 = new javax.swing.JTextField();
        jBSalir = new javax.swing.JButton();

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

        jLFechaEntrada.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLFechaEntrada.setForeground(new java.awt.Color(255, 255, 255));
        jLFechaEntrada.setText("Fecha de Entrada");

        jLFechaSalida.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLFechaSalida.setForeground(new java.awt.Color(255, 255, 255));
        jLFechaSalida.setText("Fecha de Salida");

        jLabel6.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tipo de habitacion");

        jLBusquedaHabitaciones.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLBusquedaHabitaciones.setForeground(new java.awt.Color(255, 255, 255));
        jLBusquedaHabitaciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLBusquedaHabitaciones.setText("Busqueda de habitaciones");

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));

        jBbuscarReserva.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jBbuscarReserva.setText("Buscar Reserva");
        jBbuscarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBbuscarReservaActionPerformed(evt);
            }
        });

        jCtipoH.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        TfCantidadP.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("¿Ya tenes una reservacion? ¡Podes buscarla!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLBusquedaHabitaciones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jDfechaS, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBbuscar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addComponent(jBbuscarReserva))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDfechaE, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(TfCantidadP, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLFechaEntrada))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLFechaSalida)
                                            .addComponent(jLabel6))
                                        .addGap(91, 91, 91))
                                    .addComponent(jCtipoH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLBusquedaHabitaciones)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLFechaEntrada)
                    .addComponent(jLFechaSalida))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDfechaE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDfechaS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCtipoH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TfCantidadP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBbuscar)
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBbuscarReserva)
                    .addComponent(jLabel4))
                .addGap(128, 128, 128))
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

        jButtonReservar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
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

        jLabel10.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Precio (Por Noche)");

        jTprecio1.setEditable(false);
        jTprecio1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(jTprecio1))
                        .addGap(86, 86, 86)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addComponent(jTprecio2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonReservar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTprecio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTprecio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonReservar))))
                .addGap(117, 117, 117))
        );

        jBSalir.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jBSalir.setText("Salir al menu principal");
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jBSalir)
                .addGap(533, 533, 533))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBSalir)
                .addGap(0, 40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReservarActionPerformed
        int cantMaxPer;
        int filaSeleccionada = jTreserva.getSelectedRow();
        if (filaSeleccionada != -1) {
            Object idHabitacionH = jTreserva.getValueAt(filaSeleccionada, 0);
            Object idTipoHabitacionH = jTreserva.getValueAt(filaSeleccionada, 1);
            idHab = (int) idHabitacionH;
            int idTHab = (int) idTipoHabitacionH;
            cantMaxPer = verCantPer.buscarCantidadMaximaPersonas(idTHab);
            if (numIng <= cantMaxPer) {
                double precio = tipoHdata.buscarPrecioTHab(idHab) * numIng;
                jTprecio1.setText(String.valueOf(precio));
                RegistroHuespedes regHues = new RegistroHuespedes();
                MainMenu.escritorio.add(regHues);
                regHues.toFront();
                regHues.setVisible(true);
                Dimension desktopSize = MainMenu.escritorio.getSize();
                Dimension FrameSize = regHues.getSize();
                regHues.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            } else {
                JOptionPane.showMessageDialog(null, "Cant. de personas incorrecta, debe ser " + cantMaxPer + " maximo");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una fila primero.");
        }
        borrarFilasTabla();
        jDfechaE.setDate(null);
        jDfechaS.setDate(null);
        TfCantidadP.setText("");
        jTprecio1.setText("");
        jTprecio2.setText("");
    }//GEN-LAST:event_jButtonReservarActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jBbuscarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBbuscarReservaActionPerformed
        BusquedaReservacion busqres = new BusquedaReservacion();
        MainMenu.escritorio.add(busqres);
        busqres.toFront();
        busqres.setVisible(true);
        Dimension desktopSize = MainMenu.escritorio.getSize();
        Dimension FrameSize = busqres.getSize();
        busqres.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
    }//GEN-LAST:event_jBbuscarReservaActionPerformed

    private void jBbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBbuscarActionPerformed
        borrarFilasTabla();
        String tipoHCB = (String) jCtipoH.getSelectedItem();
        listaH = habData.obtenerHabitacionesDesocupadas(tipoHCB);
        JComboBox<String> jCtipoH = new JComboBox<>();
        String tipoHabS = (String) jCtipoH.getSelectedItem();
        try {
            String cantidadP = TfCantidadP.getText();
            cantP = cantidadP;
            if (cantidadP != null && !cantidadP.isEmpty()) {
                numIng = Integer.parseInt(cantidadP);
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
        } catch (ParseException e) {
            borrarFilasTabla();
            JOptionPane.showMessageDialog(null, "Coloque fechas correctas.");
            jDfechaE.setDate(null);
            jDfechaS.setDate(null);
            TfCantidadP.setText("");
        } catch (NumberFormatException e) {
            borrarFilasTabla();
            JOptionPane.showMessageDialog(null, "Coloque cantidad de personas validas.");
            jDfechaE.setDate(null);
            jDfechaS.setDate(null);
            TfCantidadP.setText("");
        }
    }//GEN-LAST:event_jBbuscarActionPerformed

    private void jTreservaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTreservaMouseClicked
        int filaSeleccionada = jTreserva.getSelectedRow();
        if (filaSeleccionada != -1) {
            Object idHabitacionH = jTreserva.getValueAt(filaSeleccionada, 1);
            idHab = (int) idHabitacionH;
            double precio = tipoHdata.buscarPrecioTHab(idHab) * numIng;
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
    private javax.swing.JButton jBSalir;
    private static javax.swing.JButton jBbuscar;
    private javax.swing.JButton jBbuscarReserva;
    private javax.swing.JButton jButtonReservar;
    private javax.swing.JComboBox<String> jCtipoH;
    private com.toedter.calendar.JDateChooser jDfechaE;
    private com.toedter.calendar.JDateChooser jDfechaS;
    private javax.swing.JLabel jLBusquedaHabitaciones;
    private javax.swing.JLabel jLFechaEntrada;
    private javax.swing.JLabel jLFechaSalida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
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
}
