package painter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Page extends JPanel{   
    MainWindows parent = null;
    
    Page(MainWindows p)
    {
        parent = p;     // It's a reference to MainWindows
        
        this.setBackground(Color.yellow);   // Set the background of the color is yellow
        this.setLayout(null);               // Painter_Page don't use the Layout
        
        this.addMouseListener(
              new MouseAdapter ()     // in the java.awt.event , it just a module contain Event
              {
                        public void mouseClicked(MouseEvent e)      
                        {
                            if(parent.parent.drawline)     // check to do
                            {
                                System.out.println("NOW ( " + e.getX() + " : " + e.getY() + ")");       // print now position
                                java.awt.Graphics g = Page.this.getGraphics();      // Get the Paint pen
                                g.setPaintMode();                       // Draw mode
                                g.setColor(Color.RED);                  // The color of pen is Red
                                g.drawLine(0, 0, e.getX(), e.getY());   // draw the line from (0,0) ~ (Now x, Now y)
                            }                                                
                        }
              }
         );       
    }   
    /*public void paintComponent(Graphics pen)
    {
        super.paintComponent(pen);          // Get the pen from System
        pen.setPaintMode();                 // Set the Painter Mode      
        pen.setColor(Color.black);          // The pen's color is black
        pen.drawLine(0, 0, 200, 200);       // draw a line (0,0) ~ (200,200)
    }*/
    
    
}
