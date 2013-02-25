package util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author MK
 */
public class LabelTitle extends JLabel{
    private Color foreground = Color.WHITE;
    private Font font = new Font("Arial", Font.BOLD, 16);
    private Dimension labelDimension= new Dimension(100, 30);
    
    public LabelTitle(){
        setForeground(foreground);
        setFont(font);
        setPreferredSize(labelDimension);
        setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    }
}
