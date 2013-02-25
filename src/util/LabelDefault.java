package util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author Usuario
 */
public class LabelDefault extends JLabel{

//    private Color colorLabel=new Color(255,255,255);
    private Color foreground = Color.WHITE;
    private Font font = new Font("Arial", Font.BOLD, 14);
    private Dimension labelDimension= new Dimension(100, 30);
    
    public LabelDefault(){
        setForeground(foreground);
        setFont(font);
        setPreferredSize(labelDimension);
    }
}
