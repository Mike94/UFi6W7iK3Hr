/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import clases.*;
import java.awt.BorderLayout;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author sergio crisologo
 */
public class dlgUsuariosMantenimiento extends javax.swing.JDialog {

    private ClsDatabase bd = new ClsDatabase();
    private ClsSeguridad seguridad = new ClsSeguridad();
    private ClsSesion sesion = new ClsSesion();
    private ClsMetodos metodos = new ClsMetodos();
    DefaultComboBoxModel mlb = new DefaultComboBoxModel();
    /**
     * Creates new form dlgUsuarios
     *
     * @param parent
     * @param modal
     */
    String idusuario = "";
    String nombre_usuario = "";
    int transaccion = 1;

    public dlgUsuariosMantenimiento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jPanel1.setVisible(false);
        cargar_usuario("");
        metodos.comboboxLlenar(jComboBox1, mlb, "SELECT idusuario_tipo,descripcion FROM usuario_tipo where estado='A'");
    }

    public void cargar_usuario(String nombre) {
        metodos.tablaLlenaSql(jTable1, "SELECT u.nombre,u.nombre_usuario,ut.descripcion,u.estado FROM usuario u, usuario_tipo ut where u.idusuario_tipo=ut.idusuario_tipo and u.nombre like '" + nombre + "%' ", 4);
    }

    public void usuario_formulario() {
        int fila_seleccionada = jTable1.getSelectedRow();
        if (fila_seleccionada != -1) {

            //System.out.println( array_id_usuario_tipo[fila_seleccionada][0]);
            String descripcion_tipo_usuario = jTable1.getValueAt(fila_seleccionada, 0).toString();
            jTextField1.setText(descripcion_tipo_usuario);
            /*lista de formularios faltantes*/


//            metodos.tablaLlenaSql(jTable2, "SELECT nombre FROM formulario", 1);

        }
    }

    public void ver_nuevo() {

        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jComboBox1.setSelectedIndex(-1);
        jCheckBox1.setSelected(false);
        mostrar(0);
    }

    public void ver_editar() {
        int fila = jTable1.getSelectedRow();
        if (fila != -1) {
            Object[][] array_datos_usuario = bd.select("usuario", "idusuario,nombre, nombre_usuario, password,email,idusuario_tipo,fecha,estado", "nombre_usuario='" + jTable1.getValueAt(fila, 1) + "'");
            //System.out.println(array_datos_usuario);
            idusuario = array_datos_usuario[0][0].toString();
            jTextField2.setText(array_datos_usuario[0][1].toString());
            nombre_usuario = array_datos_usuario[0][2].toString();
            jTextField3.setText(array_datos_usuario[0][2].toString());
            jTextField4.setText(array_datos_usuario[0][3].toString());
            jTextField5.setText(array_datos_usuario[0][4].toString());
            jComboBox1.setSelectedIndex(mlb.getIndexOf(array_datos_usuario[0][5].toString()));
            jCheckBox1.setSelected(false);
            if (array_datos_usuario[0][7].toString().equals("A")) {
                jCheckBox1.setSelected(true);
            }
            transaccion = 2;
            mostrar(0);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Seleccione el usuario a editar");
        }
    }

    public void mostrar(int opcion) {
        switch (opcion) {
            case 0:
                jPanel1.setVisible(true);
                panelFondo1.setVisible(false);
                break;
            case 1:
                jPanel1.setVisible(false);
                panelFondo1.setVisible(true);
                break;
        }
    }

    public void transaccion_datos() {

        if (jTextField2.getText().length() == 0 || jTextField3.getText().length() == 0 || jTextField4.getText().length() == 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese los datos");
            return;
        }

        if (jComboBox1.getSelectedIndex() == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Seleccione un tipo de usuario");
            return;
        }
        String estado = "I";
        if (jCheckBox1.isSelected()) {
            estado = "A";
        }


        if (transaccion == 1) {
            if (bd.verif_repite("select * from usuario where nombre_usuario='" + jTextField3.getText().toUpperCase() + "'")) {
                javax.swing.JOptionPane.showMessageDialog(this, "Ya existe el nombre de usuario");
                return;
            }
            bd.insert("usuario", "nombre,nombre_usuario,password,email,idusuario_tipo,fecha,estado",
                    "'" + jTextField2.getText().toUpperCase() + "','" + jTextField3.getText().toUpperCase() + "','" + jTextField4.getText().toUpperCase() + "','" + jTextField5.getText().toUpperCase() + "','" + mlb.getElementAt(jComboBox1.getSelectedIndex()) + "',sysdate(),'" + estado + "'");

        } else if (transaccion == 2) {
            if (nombre_usuario.equals(jTextField3.getText().toUpperCase()) == false) {
                if (bd.verif_repite("select * from usuario where nombre_usuario='" + jTextField3.getText().toUpperCase() + "'")) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Ya esta ocupado el nombre del usuario");
                    return;
                }
            }

            bd.update("usuario", "nombre='" + jTextField2.getText().toUpperCase() + "',nombre_usuario='" + jTextField3.getText().toUpperCase() + "',password='" + jTextField4.getText().toUpperCase() + "',email='" + jTextField5.getText().toUpperCase() + "',idusuario_tipo='" + mlb.getElementAt(jComboBox1.getSelectedIndex()) + "',estado='" + estado + "'", "idusuario='" + idusuario + "'");

        }
        mostrar(1);
        cargar_usuario("");

    }

    public void eliminar() {
        int fila = jTable1.getSelectedRow();
        if (fila != -1) {
            bd.delete("usuario", " nombre_usuario='" + jTable1.getValueAt(fila, 1) + "'");
            cargar_usuario("");
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Seleccione el usuario a editar");
        }
    }

    public void limpiar() {
        jTextField1.setText("");
        cargar_usuario("");
    }

    public void buscar() {
        cargar_usuario(jTextField1.getText());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        shapeTabbedPaneUI1 = new util.shapeTabbedPaneUI();
        shapeTabbedPaneUI2 = new util.shapeTabbedPaneUI();
        panelFondo1 = new util.PanelFondo();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTextField1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Roles");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelFondo1.setBackground(new java.awt.Color(204, 204, 204));
        panelFondo1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Mantenimiento de usuarios");
        panelFondo1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Usuario", "Tipo", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jTable1.setOpaque(false);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable1MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        panelFondo1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 147, -1, 250));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/agregar.png"))); // NOI18N
        jButton1.setText("Agregar");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelFondo1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 11, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/editar.png"))); // NOI18N
        jButton2.setText("Editar");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panelFondo1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 11, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/borrar.png"))); // NOI18N
        jButton3.setText("Eliminar");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panelFondo1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 11, -1, -1));

        jLabel2.setText("Filtro:");
        panelFondo1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 101, -1, -1));
        panelFondo1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 81, 464, 10));
        panelFondo1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 98, 180, -1));

        jButton4.setText("Buscar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        panelFondo1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 97, -1, -1));

        jButton5.setText("Limpiar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        panelFondo1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 97, -1, -1));

        getContentPane().add(panelFondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 440));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos generales"));

        jLabel3.setText("Nombre:");

        jLabel4.setText("Usuario:");

        jLabel5.setText("Password:");

        jLabel7.setText("Correo:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField5)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 104, Short.MAX_VALUE))))
                .addGap(1, 1, 1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos extras"));

        jLabel6.setText("Tipo usuario:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jCheckBox1.setText("Usuario activo");

        jLabel8.setText("Estado:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jCheckBox1))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 420, -1));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/cancelar.png"))); // NOI18N
        jButton6.setText("Cancelar");
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, -1, -1));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/guardar.png"))); // NOI18N
        jButton7.setText("Guardar");
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 440));

        setBounds(0, 0, 506, 477);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
    }//GEN-LAST:event_jTable1KeyReleased

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
    }//GEN-LAST:event_jTable1MousePressed

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
    }//GEN-LAST:event_jTable1MouseEntered

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        buscar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ver_nuevo();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ver_editar();


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        mostrar(1);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        transaccion_datos();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        eliminar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        limpiar();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {
//      JTable target = (JTable)evt.getSource();
//      int row = target.getSelectedRow();
//      ...
            ver_editar();

        }
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(dlgUsuariosMantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgUsuariosMantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgUsuariosMantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgUsuariosMantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgUsuariosMantenimiento dialog = new dlgUsuariosMantenimiento(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private util.PanelFondo panelFondo1;
    private util.shapeTabbedPaneUI shapeTabbedPaneUI1;
    private util.shapeTabbedPaneUI shapeTabbedPaneUI2;
    // End of variables declaration//GEN-END:variables
}
