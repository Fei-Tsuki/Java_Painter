
package painter;
import java.awt.*;
import javax.swing.*;

public class Page extends JPanel{
    Page()
    {
        this.setBackground(Color.yellow);
        this.setLayout(null);
    }
    
    public void paintComponent(Graphics pen)
    {
        super.paintComponent(pen);
        pen.setPaintMode();
        pen.setColor(Color.black);
        pen.drawLine(0, 0, 200, 200);
    }
    
    
}
