package util;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author MK
 */
public class PanelDefault extends JPanel{
 
    private Color background=new Color(65,64,64);
    
    public PanelDefault(){
        setBackground(background);
        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
    }
}
