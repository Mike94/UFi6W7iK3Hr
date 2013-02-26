/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import util.acordionmenu.AccordionItem;
import util.acordionmenu.AccordionLeafItem;
import util.acordionmenu.AccordionMenu;
//asad

/**
 *
 * @author Miguel
 */
public final class FrmPrincipal1 extends javax.swing.JFrame {

    private AccordionMenu menuAcordion;
    private AccordionMenu menu1;
    /**
     * Creates new form FrmPrincipal1
     */
    public FrmPrincipal1() {
        initComponents();
        //menu 1. Creates a standard menu, gray background, Center Alignment of Roots and Leafs, small monospaced font.
        menu1 = new AccordionMenu(getSampleMenuDescriptor());
        menu1.setBackground(new Color(204, 204, 204));
        menu1.setMenuHorizontalAlignment(AccordionItem.CENTER);
        menu1.setLeafHorizontalAlignment(AccordionItem.CENTER);
        menu1.setFont(new Font("monospaced", Font.PLAIN, 13));
        setMouseAdapter(menu1);
        menu1.setVisible(true);
        cont1.add(menu1);
        cont1.setVisible(true);
        //___________________________________________________________________________________ Soy una barra separadora :)
         //menu 3. Creates a simple menu, white bacground and dark blue foreground, a lightGray selection backgroun on mouseover, Right Alignment for leafs
        //two icon for all Root Items, and two icon for Leaf of second menu only
//        menuAcordion = new AccordionMenu(getSampleMenuDescriptor());
//        createSampleMenuStructure(menuAcordion);
//        menuAcordion.setBackground(Color.white);
//        menuAcordion.setForeground(Color.blue.darker().darker().darker());
//        menuAcordion.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 15));
//        menuAcordion.setSelectionColor(Color.lightGray);
//        menuAcordion.setLeafHorizontalAlignment(AccordionItem.RIGHT);
//        ImageIcon icon3 = new ImageIcon(this.getClass().getResource("/resource/blu_arrow_right.png"));
//        ImageIcon icon4 = new ImageIcon(this.getClass().getResource("/resource/blu_arrow_down.png"));
//        ImageIcon icon5 = new ImageIcon(this.getClass().getResource("/resource/gray_arrow_right.png"));
//        ImageIcon icon6 = new ImageIcon(this.getClass().getResource("/resource/green_arrow_right.png"));
//        menuAcordion.setMenuIcons(icon3, icon4);
//        menuAcordion.setLeafIcons("menu2", icon5, icon6);
//        setMouseAdapter(menuAcordion);
//        pnlMenuAcordion.add(menuAcordion);
        //___________________________________________________________________________________ Soy una barra separadora :)
    }
//___________________________________________________________________________________ Soy una barra separadora :)
    /**
     * <code>First method to create an AccordionMenu: create a description string of menu tree.</code>
     * It creates a Standard Description String to create an AccordionMenu. This is
     * the full structure of a correct description string. 
     * @return description String.
     */
    public String getSampleMenuDescriptor() {
        String menuDescriptor = ""
                + "Menu One,menu1:"
                + "Sub Menu 1,submenu1.1;"
                + "Sub Menu 2,submenu1.2;"
                + "Exit Button,exit;"
                + "!"
                + "Menu Two,menu2:"
                + "Sub Menu 1,submenu2.1;"
                + "Sub Menu 2,submenu2.2;"
                + "Sub Menu 3,submenu2.3;"
                + "!"
                + "Menu Three,menu3:"
                + "Sub Menu 1,submenu3.1;"
                + "Sub Menu 2,submenu3.2;"
                + "Sub Menu 3,submenu3.3;"
                + "!"
                + "Menu Four,menu4:"
                + "Sub Menu 1,submenu4.1;"
                + "Sub Menu 2,submenu4.2;"
                + "Sub Menu 3,submenu4.3;";
        return menuDescriptor;
    }
    
    /**
     * <code>Second method to create an AccordionMenu: add manually each menu with its leafs to AccordionMenu.</code>
     * It creates manually a structure like one created before with a description String. First method is better when
     * menu structure is static. Use this method instead if you want to create structure dinamically.
     * @param target Target AccordionMenu to modify.
     */
    public void createSampleMenuStructure(AccordionMenu target) {
        target.addNewMenu("menu1", "Menu One");
        target.addNewLeafTo("menu1", "submenu1.1", "Sub Menu 1");
        target.addNewLeafTo("menu1", "submenu1.2", "Sub Menu 2");
        target.addNewLeafTo("menu1", "submenu1.3", "Sub Menu 3");

        target.addNewMenu("menu2", "Menu Two");
        target.addNewLeafTo("menu2", "submenu2.1", "Sub Menu 1");
        target.addNewLeafTo("menu2", "submenu2.2", "Sub Menu 2");
        target.addNewLeafTo("menu2", "submenu2.3", "Sub Menu 3");

        target.addNewMenu("menu3", "Menu Three");
        target.addNewLeafTo("menu3", "submenu3.1", "Sub Menu 1");
        target.addNewLeafTo("menu3", "submenu3.2", "Sub Menu 2");
        target.addNewLeafTo("menu3", "submenu3.3", "Sub Menu 3");

        target.addNewMenu("menu4", "Menu Four");
        target.addNewLeafTo("menu4", "submenu4.1", "Sub Menu 1");
        target.addNewLeafTo("menu4", "submenu4.2", "Sub Menu 2");
        target.addNewLeafTo("menu4", "submenu4.3", "Sub Menu 3");
        target.calculateAvaiableSpace();
    }

    /**
     * Simple example to browse all Leaf of menu. In this case for each leaf it adds a new Mouse Adapter.
     * @param menu Target Menu to modify.
     */
    public void setMouseAdapter(AccordionMenu menu) {
        for (AccordionLeafItem leaf : menu.getAllLeafs()) {
            leaf.addMouseListener(getSimpleMouseAdapter());
        }
    }

    /**
     * Creates a simple MouseAdapter binded to an AccordionItem. On mouse Pressed it writes on a textBox the source of event.
     * @return {@link MouseAdapter} object.
     */
    public MouseAdapter getSimpleMouseAdapter() {
        return new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                AccordionItem item = (AccordionItem) e.getSource();
//                message.setText("Source name: " + item.getName() + "; Source Title: " + item.getText());
            }
        };
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

        panelFondo1 = new util.PanelFondo();
        labelTitle1 = new util.LabelTitle();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        buttonInteractive1 = new util.ButtonInteractive();
        buttonInteractive2 = new util.ButtonInteractive();
        buttonInteractive4 = new util.ButtonInteractive();
        buttonInteractive5 = new util.ButtonInteractive();
        buttonInteractive6 = new util.ButtonInteractive();
        buttonInteractive7 = new util.ButtonInteractive();
        buttonInteractive8 = new util.ButtonInteractive();
        buttonInteractive9 = new util.ButtonInteractive();
        buttonInteractive10 = new util.ButtonInteractive();
        pnlMenuAcordion = new javax.swing.JPanel();
        cont1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelTitle1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/004.png"))); // NOI18N
        labelTitle1.setText("SISTEMA DE CONTROL DE AGUA  Y SANEAMIENTO [SICAS]");

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setOpaque(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.white));
        jPanel2.setOpaque(false);

        buttonInteractive1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/004.png"))); // NOI18N
        buttonInteractive1.setText("Presupuestos");

        buttonInteractive2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/Gnome-document-open.png"))); // NOI18N
        buttonInteractive2.setText("Proyectos");

        buttonInteractive4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/114.png"))); // NOI18N
        buttonInteractive4.setText("Insumos");
        buttonInteractive4.setColorEntered(new java.awt.Color(0, 102, 255));
        buttonInteractive4.setColorExited(new java.awt.Color(255, 0, 0));

        buttonInteractive5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/013.png"))); // NOI18N
        buttonInteractive5.setText("Plantillas");

        buttonInteractive6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/201.png"))); // NOI18N
        buttonInteractive6.setText("Reportes");

        buttonInteractive7.setText("Ayuda");

        buttonInteractive8.setText("Usuarios");

        buttonInteractive9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/006.png"))); // NOI18N
        buttonInteractive9.setText("Configuración");

        buttonInteractive10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/022.png"))); // NOI18N
        buttonInteractive10.setText("Portadas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(buttonInteractive1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonInteractive2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonInteractive10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(buttonInteractive4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonInteractive5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(buttonInteractive8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonInteractive9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonInteractive7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonInteractive6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonInteractive1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonInteractive2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonInteractive10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonInteractive4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonInteractive5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonInteractive6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonInteractive7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonInteractive8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonInteractive9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pnlMenuAcordion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.white));
        pnlMenuAcordion.setOpaque(false);

        javax.swing.GroupLayout cont1Layout = new javax.swing.GroupLayout(cont1);
        cont1.setLayout(cont1Layout);
        cont1Layout.setHorizontalGroup(
            cont1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 263, Short.MAX_VALUE)
        );
        cont1Layout.setVerticalGroup(
            cont1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlMenuAcordionLayout = new javax.swing.GroupLayout(pnlMenuAcordion);
        pnlMenuAcordion.setLayout(pnlMenuAcordionLayout);
        pnlMenuAcordionLayout.setHorizontalGroup(
            pnlMenuAcordionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuAcordionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cont1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlMenuAcordionLayout.setVerticalGroup(
            pnlMenuAcordionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuAcordionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cont1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(pnlMenuAcordion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMenuAcordion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelFondo1Layout = new javax.swing.GroupLayout(panelFondo1);
        panelFondo1.setLayout(panelFondo1Layout);
        panelFondo1Layout.setHorizontalGroup(
            panelFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondo1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelFondo1Layout.setVerticalGroup(
            panelFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondo1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(panelFondo1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FrmPrincipal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal1().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private util.ButtonInteractive buttonInteractive1;
    private util.ButtonInteractive buttonInteractive10;
    private util.ButtonInteractive buttonInteractive2;
    private util.ButtonInteractive buttonInteractive4;
    private util.ButtonInteractive buttonInteractive5;
    private util.ButtonInteractive buttonInteractive6;
    private util.ButtonInteractive buttonInteractive7;
    private util.ButtonInteractive buttonInteractive8;
    private util.ButtonInteractive buttonInteractive9;
    private javax.swing.JPanel cont1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private util.LabelTitle labelTitle1;
    private util.PanelFondo panelFondo1;
    private javax.swing.JPanel pnlMenuAcordion;
    // End of variables declaration//GEN-END:variables
}
