/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.vtrabajador;
import Files.ftrabajador;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Silvia
 */
public class frmtrabajador extends javax.swing.JFrame {

    /**
     * Creates new form frmtrabajador
     */
    public frmtrabajador() {
        initComponents();
        mostrar("");
        inhabilitar();
    }
    
    private String accion = "guardar"; 
    
    void ocultar_columnas() {
        tablalistado.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    void inhabilitar() {
        txtidpersona.setVisible(false);
        
        txtnombre.setEnabled(false);
        txtapaterno.setEnabled(false);
        txtamaterno.setEnabled(false);
        cbotipo_documento.setEnabled(false);
        txtnum_documento.setEnabled(false);
        txtdireccion.setEnabled(false);
        txttelefono.setEnabled(false);
        txtemail.setEnabled(false);
        txtsueldo.setEnabled(false);
        cboacceso.setEnabled(false);
        txtlogin.setEnabled(false);
        txtpassword.setEnabled(false);
        cboestado.setEnabled(false);

        btnguardar.setEnabled(false);
        btncancelar.setEnabled(false);
        btneliminar.setEnabled(false);
        txtidpersona.setText("");
        txtnombre.setText("");
        txtapaterno.setText("");
        txtamaterno.setText("");
        txtnum_documento.setText("");
        txtdireccion.setText("");
        txttelefono.setText("");
        txtemail.setText("");
        txtsueldo.setText("");
        txtlogin.setText("");
        txtpassword.setText("");
    }

    void habilitar() {
        txtidpersona.setVisible(false);
        
        txtnombre.setEnabled(true);
        txtapaterno.setEnabled(true);
        txtamaterno.setEnabled(true);
        cbotipo_documento.setEnabled(true);
        txtnum_documento.setEnabled(true);
        txtdireccion.setEnabled(true);
        txttelefono.setEnabled(true);
        txtemail.setEnabled(true);
        txtsueldo.setEnabled(true);
        cboacceso.setEnabled(true);
        txtlogin.setEnabled(true);
        txtpassword.setEnabled(true);
        cboestado.setEnabled(true);

        btnguardar.setEnabled(true);
        btncancelar.setEnabled(true);
        btneliminar.setEnabled(true);
        txtidpersona.setText("");
        txtnombre.setText("");
        txtapaterno.setText("");
        txtamaterno.setText("");
        txtnum_documento.setText("");
        txtdireccion.setText("");
        txttelefono.setText("");
        txtemail.setText("");
        txtsueldo.setText("");
        txtlogin.setText("");
        txtpassword.setText("");
        

    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            ftrabajador func = new ftrabajador();
            modelo = func.mostrar(buscar);

            tablalistado.setModel(modelo);
            ocultar_columnas();
            lbltotalregistros.setText("Total Registros " + Integer.toString(func.totalregistros));

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtidpersona = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtnum_documento = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbotipo_documento = new javax.swing.JComboBox();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtapaterno = new javax.swing.JTextField();
        txtamaterno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtsueldo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cboacceso = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtlogin = new javax.swing.JTextField();
        txtpassword = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cboestado = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        lbltotalregistros = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Trabajadores"));

        tablalistado.setModel(new javax.swing.table.DefaultTableModel(
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
        tablalistado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablalistado);

        jLabel9.setText("Buscar");

        btnbuscar.setBackground(new java.awt.Color(204, 204, 204));
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btneliminar.setBackground(new java.awt.Color(204, 204, 204));
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnsalir.setBackground(new java.awt.Color(204, 204, 204));
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar)
                    .addComponent(btneliminar)
                    .addComponent(btnsalir))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 204, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de Trabajadores"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtidpersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 124, -1));

        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 50, 20));

        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 263, -1));

        jLabel6.setText("Num doc:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 60, 20));

        txtnum_documento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnum_documentoActionPerformed(evt);
            }
        });
        jPanel1.add(txtnum_documento, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 184, -1));

        jLabel7.setText("Tipo Doc:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        cbotipo_documento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DNI", "LM", "CE", "Otros" }));
        cbotipo_documento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbotipo_documentoActionPerformed(evt);
            }
        });
        jPanel1.add(cbotipo_documento, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 148, -1));

        btnnuevo.setBackground(new java.awt.Color(204, 204, 204));
        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 90, -1));

        btnguardar.setBackground(new java.awt.Color(204, 204, 204));
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 90, -1));

        btncancelar.setBackground(new java.awt.Color(204, 204, 204));
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 440, 90, -1));

        jLabel3.setText("Apaterno:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txtapaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapaternoActionPerformed(evt);
            }
        });
        jPanel1.add(txtapaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 242, -1));

        txtamaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtamaternoActionPerformed(evt);
            }
        });
        jPanel1.add(txtamaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 263, -1));

        jLabel4.setText("AMaterno:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel8.setText("Dirección:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        txtdireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdireccionActionPerformed(evt);
            }
        });
        jPanel1.add(txtdireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 184, -1));

        jLabel10.setText("Teléfono:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        txttelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoActionPerformed(evt);
            }
        });
        jPanel1.add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 184, -1));

        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });
        jPanel1.add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 184, -1));

        jLabel11.setText("Email:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        txtsueldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsueldoActionPerformed(evt);
            }
        });
        jPanel1.add(txtsueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 184, -1));

        jLabel12.setText("Sueldo:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        cboacceso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Digitador" }));
        jPanel1.add(cboacceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 110, -1));

        jLabel5.setText("Acceso:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jLabel13.setText("Login:");
        jLabel13.setToolTipText("");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        txtlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtloginActionPerformed(evt);
            }
        });
        jPanel1.add(txtlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 110, -1));
        jPanel1.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 110, -1));

        jLabel14.setText("password:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        cboestado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "D" }));
        jPanel1.add(cboestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 73, -1));

        jLabel15.setText("Estado:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        lbltotalregistros.setText("Registros");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(931, Short.MAX_VALUE)
                .addComponent(lbltotalregistros)
                .addGap(85, 85, 85))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(302, Short.MAX_VALUE)
                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        // TODO add your handling code here:
        btnguardar.setText("Editar");
        habilitar();
        btneliminar.setEnabled(true);
        accion="editar";

        int fila = tablalistado.rowAtPoint(evt.getPoint());

        txtidpersona.setText(tablalistado.getValueAt(fila, 0).toString());
        txtnombre.setText(tablalistado.getValueAt(fila, 1).toString());

        txtapaterno.setText(tablalistado.getValueAt(fila, 2).toString());
        txtamaterno.setText(tablalistado.getValueAt(fila, 3).toString());
        cbotipo_documento.setSelectedItem(tablalistado.getValueAt(fila, 4).toString());
        txtnum_documento.setText(tablalistado.getValueAt(fila, 5).toString());
        txtdireccion.setText(tablalistado.getValueAt(fila, 6).toString());
        txttelefono.setText(tablalistado.getValueAt(fila, 7).toString());
        txtemail.setText(tablalistado.getValueAt(fila, 8).toString());

        txtsueldo.setText(tablalistado.getValueAt(fila, 9).toString());
        cboacceso.setSelectedItem(tablalistado.getValueAt(fila, 10).toString());
        txtlogin.setText(tablalistado.getValueAt(fila, 11).toString());
        txtpassword.setText(tablalistado.getValueAt(fila, 12).toString());
        cboestado.setSelectedItem(tablalistado.getValueAt(fila, 13).toString());
    }//GEN-LAST:event_tablalistadoMouseClicked

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        mostrar(txtbuscar.getText());
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        if (!txtidpersona.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estás seguro de Eliminar el Trabajador?","Confirmar",2);

            if (confirmacion==0) {
                ftrabajador func = new ftrabajador();
                vtrabajador dts= new vtrabajador();

                dts.setIdpersona(Integer.parseInt(txtidpersona.getText()));
                func.eliminar(dts);
                mostrar("");
                inhabilitar();

            }

        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
        txtnombre.transferFocus();
    }//GEN-LAST:event_txtnombreActionPerformed

    private void txtnum_documentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnum_documentoActionPerformed
        // TODO add your handling code here:
        txtnum_documento.transferFocus();
    }//GEN-LAST:event_txtnum_documentoActionPerformed

    private void cbotipo_documentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbotipo_documentoActionPerformed
        // TODO add your handling code here:
        cbotipo_documento.transferFocus();
    }//GEN-LAST:event_cbotipo_documentoActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        habilitar();
        btnguardar.setText("Guardar");
        accion = "guardar";
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        if (txtnombre.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un Nombre para el Trabajador");
            txtnombre.requestFocus();
            return;
        }
        if (txtapaterno.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un apellido para el Trabajador");
            txtapaterno.requestFocus();
            return;
        }

        if (txtamaterno.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un apellido para el Trabajador");
            txtamaterno.requestFocus();
            return;
        }

        if (txtnum_documento.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un Número de Doc para el Trabajador");
            txtnum_documento.requestFocus();
            return;
        }

        if (txtsueldo.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un Sueldo para el trabajador");
            txtsueldo.requestFocus();
            return;
        }
        if (txtlogin.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un login para el trabajador");
            txtlogin.requestFocus();
            return;
        }
        if (txtpassword.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un password para el trabajador");
            txtpassword.requestFocus();
            return;
        }

        vtrabajador dts = new vtrabajador();
        ftrabajador func = new ftrabajador();

        dts.setNombre(txtnombre.getText());

        dts.setApaterno(txtapaterno.getText());
        dts.setAmaterno(txtamaterno.getText());

        int seleccionado = cbotipo_documento.getSelectedIndex();
        dts.setTipo_documento((String) cbotipo_documento.getItemAt(seleccionado));
        dts.setNum_documento(txtnum_documento.getText());
        dts.setDireccion(txtdireccion.getText());
        dts.setTelefono(txttelefono.getText());
        dts.setEmail(txtemail.getText());

        dts.setSueldo(Double.parseDouble(txtsueldo.getText()));
        seleccionado=cboacceso.getSelectedIndex();
        dts.setAcceso((String)cboacceso.getItemAt(seleccionado));
        dts.setLogin(txtlogin.getText());
        dts.setPassword(txtpassword.getText());

       seleccionado=cboestado.getSelectedIndex();
        dts.setEstado((String)cboestado.getItemAt(seleccionado));
        
        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "el trabajador fue registrado satisfactoriamente");
                mostrar("");
                inhabilitar();

            }

        }
        else if (accion.equals("editar")){
            dts.setIdpersona(Integer.parseInt(txtidpersona.getText()));

            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El Trabajador fue Editado satisfactoriamente");
                mostrar("");
                inhabilitar();
            }
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void txtapaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapaternoActionPerformed
        // TODO add your handling code here:
        txtapaterno.transferFocus();
    }//GEN-LAST:event_txtapaternoActionPerformed

    private void txtamaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtamaternoActionPerformed
        // TODO add your handling code here:
        txtamaterno.transferFocus();
    }//GEN-LAST:event_txtamaternoActionPerformed

    private void txtdireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdireccionActionPerformed
        // TODO add your handling code here:
        txtdireccion.transferFocus();
    }//GEN-LAST:event_txtdireccionActionPerformed

    private void txttelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoActionPerformed
        // TODO add your handling code here:
        txttelefono.transferFocus();
    }//GEN-LAST:event_txttelefonoActionPerformed

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
        txtemail.transferFocus();
    }//GEN-LAST:event_txtemailActionPerformed

    private void txtsueldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsueldoActionPerformed
        // TODO add your handling code here:
        txtsueldo.transferFocus();
    }//GEN-LAST:event_txtsueldoActionPerformed

    private void txtloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtloginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtloginActionPerformed

    /**
     * @param args the command line arguments
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
            java.util.logging.Logger.getLogger(frmtrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmtrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmtrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmtrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmtrabajador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox cboacceso;
    private javax.swing.JComboBox cboestado;
    private javax.swing.JComboBox cbotipo_documento;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTextField txtamaterno;
    private javax.swing.JTextField txtapaterno;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtidpersona;
    private javax.swing.JTextField txtlogin;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtnum_documento;
    private javax.swing.JTextField txtpassword;
    private javax.swing.JTextField txtsueldo;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
