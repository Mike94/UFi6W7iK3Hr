/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
/**
 * @web http://www.jc-mouse.net
 * @author Mouse
 */
public class ButtonMUI extends JButton implements MouseListener{

    /** Icono por el boton */
    private Icon icono = new ImageIcon(getClass().getResource("/resources/Icons/004.png"));
    ImageIcon imagenIcon = (ImageIcon) icono;
    private Image image = imagenIcon.getImage();
    private Image image_default = image;
    /** Color para el fondo del boton*/
    private Color button_pressed = new Color(0,0,0);
    private Color button_released = new Color(227, 162, 26);
    /** Color para el texto */
    private Color texto_released = new Color(0,0,0);
    private Color texto_pressed = new Color(255,255,255);

    /**
 * Constructor de clase
 */
    @SuppressWarnings("LeakingThisInConstructor")
    public ButtonMUI()
    {
        this.setText("ModernUIButton");
        this.setPreferredSize( new Dimension(140,32 ) );
        this.setSize( new Dimension(140,32 ) );
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        this.setCursor(Cursor.getPredefinedCursor( Cursor.HAND_CURSOR ));
        this.setBackground( this.button_released );
        this.setOpaque(true);
        this.setVisible(true);
        this.addMouseListener(this);
    }

     /**
 * se pinta la imagen con dimensiones de ancho y alto iguales al alto del jbutton
 */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,  getWidth() - this.getHeight(), 0 , this.getHeight() , this.getHeight() , this);
    }

    /**
 * Se sobreescribe el metodo SETICON para utilizar el mismo metodo para colocar el icono
 */
    @Override
    public void setIcon(Icon icon)
    {
        if( icon != null )
        {
            this.icono = icon;
            imagenIcon = (ImageIcon) icono;
            this.image = imagenIcon.getImage();
        }
        else
        {
            this.image = this.image_default;
        }
        this.repaint();
    }

     public void mouseClicked(MouseEvent e) {}

    /** Cuando se presiona el boton se cambian los colores de fondo y de texto */
    public void mousePressed(MouseEvent e) {
        //capturamos valores iniciales
        this.button_released = this.getBackground();
        this.texto_released = this.getForeground();
        //se colocan los nuevos colores
        this.setForeground( this.texto_pressed );
        this.setBackground( this.button_pressed );
    }

    /** Cuando se leventa el mouse del jbutton se retoman los colores originales */
    public void mouseReleased(MouseEvent e) {
        this.setBackground( this.button_released);
        this.setForeground( this.texto_released );
    }

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

}