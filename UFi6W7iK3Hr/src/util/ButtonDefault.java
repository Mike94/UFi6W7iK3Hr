/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;

/**
 *
 * @author MK
 */
public class ButtonDefault extends JButton{
    private Font font = new Font("Arial", Font.BOLD, 12);
    private Dimension dimension= new Dimension(114, 36);
    
    public ButtonDefault(){
        setPreferredSize(dimension);
        setFont(font);
        setOpaque(false);
    }
}
