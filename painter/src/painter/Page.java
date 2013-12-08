package painter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.util.ArrayList;

public class Page extends JPanel{   
    MainWindows parent = null;
    Point lp;    
    ArrayList<Line> lines = null;
    
    Page(MainWindows p)
    {
        parent = p;     // It's a reference to MainWindows
        lp = new Point(-1,-1);          // Set the start point
        lines = new ArrayList<Line>();
        
        this.setBackground(Color.yellow);   // Set the background of the color is yellow
        this.setLayout(null);               // Painter_Page don't use the Layout
        
        this.addMouseMotionListener(
                new MouseAdapter()
                {
                    public void mouseDragged(MouseEvent e)
                    {
                        if(parent.parent.status == Status.freeDraw)
                        {
                            if(lp.x != (-1))
                            {
                                    java.awt.Graphics g = Page.this.getGraphics();      // Get the Paint pen
                                    g.setPaintMode();                       // Draw mode
                                    g.setColor(Color.RED);                  // The color of pen is Red
                                    g.drawLine(lp.x, lp.y , e.getX(), e.getY());   // draw the line from (0,0) ~ (Now x, Now y)
                                    lines.add(new Line(lp,e.getPoint()));
                            }
                            lp = e.getPoint();              // set the current point
                        }
                    }
                }
        );
        
        this.addMouseListener(
              new MouseAdapter ()     // in the java.awt.event , it just a module contain Event
              {
                        public void mouseClicked(MouseEvent e)      
                        {        
                            if(parent.parent.status == Status.drawLine)
                            {
                                if(lp.x != (-1))
                                {
                                    java.awt.Graphics g = Page.this.getGraphics();      // Get the Paint pen
                                    g.setPaintMode();                       // Draw mode
                                    g.setColor(Color.RED);                  // The color of pen is Red
                                    g.drawLine(lp.x, lp.y , e.getX(), e.getY());   // draw the line from (0,0) ~ (Now x, Now y)
                                    lines.add(new Line(lp,e.getPoint()));
                                }
                                lp = e.getPoint();              // set the current point    
                            }
                        }
                        
                        public void mousePressed(MouseEvent e)
                        {
                            if(parent.parent.status == Status.freeDraw)
                                lp = e.getPoint();
                        }
                        
                        public void mouseReleased(MouseEvent e)
                        {
                            if(parent.parent.status == Status.freeDraw)
                            {
                                // do nothing
                            }    
                        }
              }
         );       
    }
    
    public void paintComponent(Graphics pen)
    {
        super.paintComponent(pen);          // Get the pen from System
        pen.setPaintMode();                 // Set the Painter Mode      
        pen.setColor(Color.BLUE);          // The pen's color is black
        pen.drawLine(0, 0, 200, 200);       // draw a line (0,0) ~ (200,200)
        
        Line temp;
        for(int i = 0; i<lines.size();i++)
        {
            temp = lines.get(i);
            pen.setColor(temp.color);
            pen.drawLine(temp.start.x, temp.start.y, temp.end.x, temp.end.y);       // draw a line (0,0) ~ (200,200)
        }
        
    }
    
}
