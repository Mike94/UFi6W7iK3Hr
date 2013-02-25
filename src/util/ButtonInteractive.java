package util;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 * @author MK
 */
public class ButtonInteractive extends JButton implements MouseListener{
    /** Color para el fondo del boton*/
    private Color button_pressed = new Color(0,0,0);
    private Color button_released = new Color(153, 153, 153);
    private Color button_entered = new Color(255,0,0);
    private Color button_exited = new Color(227, 162, 26);
    private Color button_clicked = new Color(0,0,0);
    private Font font = new Font("Tahoma", Font.ITALIC, 13);
    private Dimension dimension= new Dimension(190, 100);
    
    public ButtonInteractive(){
        this.setFont(font);
        this.setText("ButtonInt");
//        this.setContentAreaFilled(true);
//        this.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        this.setCursor(Cursor.getPredefinedCursor( Cursor.HAND_CURSOR ));
//        this.setBackground( this.button_released );
//        setOpaque(false);
        setPreferredSize(dimension);
        this.setVisible(true);
//        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
        setBackground(button_clicked);
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
        setBackground(button_pressed);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
        setBackground(button_released);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
        setBackground(button_entered);
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
        setBackground(button_exited);
    }
    //___________________________________________________________________________________ Soy una barra separadora :)
    public void setColorClicked(Color color){
        this.button_clicked=color;
    }
    public void setColorPressed(Color color){
        this.button_pressed=color;
    }
    public void setColorReleased(Color color){
        this.button_released=color;
    }
    public void setColorEntered(Color color){
        this.button_entered=color;
    }
    public void setColorExited(Color color){
        this.button_exited=color;
    }
    //___________________________________________________________________________________ Soy una barra separadora :)
    public Color getColorClicked(){
        return button_clicked;
    }
    public Color getColorPressed(){
        return button_clicked;
    }
    public Color getColorReleased(){
        return button_clicked;
    }
    public Color getColorEntered(){
        return button_clicked;
    }
    public Color getColorExited(){
        return button_clicked;
    }
}
