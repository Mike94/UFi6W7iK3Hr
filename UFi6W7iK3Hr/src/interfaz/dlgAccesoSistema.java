package interfaz;

import clases.ClsDatabase;
import clases.ClsMetodos;
import clases.ClsSeguridad;
import clases.ClsSesion;
import java.awt.Color;

/**
 *
 * @author MK
 */
public class dlgAccesoSistema extends javax.swing.JDialog {

    private ClsDatabase bd = new ClsDatabase();
    private ClsSeguridad seguridad = new ClsSeguridad();
    private ClsSesion sesion = new ClsSesion();
    private ClsMetodos metodos=new ClsMetodos();
    private int intentos=1;
    private boolean accesoSistema=false;
    private Color colorError=new Color(204,0,0);
    private Color colorNormal=new Color(51,51,51);
    
    /**
     * Creates new form dlgAccesoSistema
     * @param parent
     * @param modal  
     */
    public dlgAccesoSistema(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.txtUsuario.setText("");
        this.pswPassword.setText("");
        this.txtUsuario.requestFocus();
        //Configuramos la clase bd
        bd.setDataBase("bd_prueba2");
        bd.setUser("root");
        bd.setPassword("admin");
        this.setLocationRelativeTo(null);
    }
    
    //___________________________________________________________________________________ Soy una barra separadora :)

    /**
     * @descripcion Se ejecuta cuando se realiza click sobre el boton Aceptar de
     * la interfaz
     */
    public void _aceptar() {
        if (intentos<4) {
            //Obtenemos los valores de los jtextfield
            String userString = this.txtUsuario.getText().toString();
            String passString = this.pswPassword.getText().toString();
            //Encriptamos el passString a MD5
    //        passString = seguridad.encriptar(passString, seguridad.getMD5());
            
            //Verificamos en la BD el acceso de usuario
            Object[][] datos = bd.select("usuarios", "uuser,idusuarios", "uuser='" + userString + "' and upassword='" + passString + "'");
            if (datos != null) {
                System.out.println("dato:"+datos[0][0].toString());
                sesion._getPermisosTabla(datos[0][0].toString(),userString, bd);
                accesoSistema=true;
    //            frmPrincipal frame = new frmPrincipal(bd);
                frmPrincipal frame = new frmPrincipal();
                this.dispose();
                frame.setVisible(true);
            }else{
                lblTitulo.setBackground(colorError);
                pnlContenedorPrincipal.setBackground(colorError);
                intentos++;
            }
        }else{
            metodos._cerrarSistema();
        }
    }    
//___________________________________________________________________________________ Soy una barra separadora :)
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContenedorPrincipal = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        labelDefault1 = new util.LabelDefault();
        labelDefault2 = new util.LabelDefault();
        pswPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        pnlContenedorPrincipal.setBackground(new java.awt.Color(51, 51, 51));

        lblTitulo.setBackground(new java.awt.Color(51, 51, 51));
        lblTitulo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Acceso al Sistema SICAS");
        lblTitulo.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(65, 64, 64));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtUsuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtUsuario.setText("jTextField1");
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyReleased(evt);
            }
        });

        btnAceptar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.setOpaque(false);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        labelDefault1.setText("Usuario:");

        labelDefault2.setText("Password:");

        pswPassword.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        pswPassword.setText("jPasswordField1");
        pswPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pswPasswordKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelDefault1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(labelDefault2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(pswPassword))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDefault1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDefault2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pswPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout pnlContenedorPrincipalLayout = new javax.swing.GroupLayout(pnlContenedorPrincipal);
        pnlContenedorPrincipal.setLayout(pnlContenedorPrincipalLayout);
        pnlContenedorPrincipalLayout.setHorizontalGroup(
            pnlContenedorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContenedorPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContenedorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlContenedorPrincipalLayout.setVerticalGroup(
            pnlContenedorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenedorPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(pnlContenedorPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyReleased
        lblTitulo.setBackground(colorNormal);
        pnlContenedorPrincipal.setBackground(colorNormal);
        if (evt.getKeyCode() == 10) {//el 10 Corresponde a ENTER
            this.pswPassword.requestFocus();
        }
    }//GEN-LAST:event_txtUsuarioKeyReleased

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        _aceptar();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (!accesoSistema) {
            metodos._cerrarSistema();
        }
    }//GEN-LAST:event_formWindowClosed

    private void pswPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pswPasswordKeyReleased
        lblTitulo.setBackground(colorNormal);
        pnlContenedorPrincipal.setBackground(colorNormal);
        if (evt.getKeyCode() == 10) {//el 10 Corresponde a ENTER
            _aceptar();
        }
    }//GEN-LAST:event_pswPasswordKeyReleased

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
            java.util.logging.Logger.getLogger(dlgAccesoSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgAccesoSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgAccesoSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgAccesoSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgAccesoSistema dialog = new dlgAccesoSistema(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAceptar;
    private javax.swing.JPanel jPanel2;
    private util.LabelDefault labelDefault1;
    private util.LabelDefault labelDefault2;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlContenedorPrincipal;
    private javax.swing.JPasswordField pswPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
