package painter;
import java.awt.*;
import javax.swing.*;

public class Page extends JPanel{   
    Page()
    {
        this.setBackground(Color.yellow);   // Set the background of the color is yellow
        this.setLayout(null);               // Painter_Page don't use the Layout
    }
    
    public void paintComponent(Graphics pen)
    {
        super.paintComponent(pen);          // Get the pen from System
        pen.setPaintMode();                 // Set the Painter Mode
        pen.setColor(Color.black);          // The pen's color is black
        pen.drawLine(0, 0, 200, 200);       // draw a line (0,0) ~ (200,200)
    }
    
    
}
