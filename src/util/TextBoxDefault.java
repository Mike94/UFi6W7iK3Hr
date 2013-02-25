package util;

import java.awt.Font;
import javax.swing.JTextField;

/**
 *
 * @author MK
 */
public class TextBoxDefault extends JTextField{
//    private Color foreground = Color.WHITE;
    private Font font = new Font("Arial", Font.BOLD, 12);
//    private Dimension labelDimension= new Dimension(100, 30);
    
    public TextBoxDefault(){
//        setForeground(foreground);
        setFont(font);
//        setPreferredSize(labelDimension);
    }
}
