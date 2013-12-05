package painter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Page extends JPanel{   
    MainWindows parent = null;
    int x,y;                // set the first  (x,y)
    boolean fir = true;    // check the start or final
    
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
                                if(Page.this.fir==true)
                                {
                                    Page.this.x = e.getX();
                                    Page.this.y = e.getY();
                                    Page.this.fir = false;
                                }
                                else
                                {
                                     //System.out.println("NOW ( " + e.getX() + " : " + e.getY() + ")");       // print now position
                                    java.awt.Graphics g = Page.this.getGraphics();      // Get the Paint pen
                                    g.setPaintMode();                       // Draw mode
                                    g.setColor(Color.RED);                  // The color of pen is Red
                                    g.drawLine(Page.this.x, Page.this.y, e.getX(), e.getY());   // draw the line from (0,0) ~ (Now x, Now y)
                                    Page.this.fir = true;
                                }
                               
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
