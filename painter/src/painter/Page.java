package painter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.util.ArrayList;
import java.math.*;

import java.io.Serializable;

public class Page extends JPanel implements Serializable{   
    MainWindows parent = null;
    Point lp;                   
    Point ep;
    Point LineStart;            // Strat of Position
    Point LineEnd;              // End of Position
    Color cl;
    
    ArrayList<Line> lines = null;
    ArrayList<Object> obj = null;

    
    Page(MainWindows p)
    {
        parent = p;                     // It's a reference to MainWindows
        lp = new Point(-1,-1);          // Set the start point
        //lines = new ArrayList<Line>();  // It's a stack about lines
        obj = new ArrayList<Object>();
        
        this.setBackground(Color.yellow);   // Set the background of the color is yellow
        this.setLayout(null);               // Painter_Page don't use the Layout
        
        this.addMouseMotionListener(
                new MouseAdapter()
                {
                    public void mouseDragged(MouseEvent e)
                    {
                      
                        if(parent.parent.status == Status.freeDraw)    
                        {    
                            if(lp.x != -1)
                            {
                                    parent.parent.sharp = parent.parent.sharp.FREE;
                                    java.awt.Graphics g = Page.this.getGraphics();      // Get the Paint pen
                                    g.setPaintMode();                                   // Draw mode
                                    cl = parent.tbar.setPenColorBtn.getBackground();    // remember now pen color
                                    g.setColor(cl);                                     // The color of pen is The btn's backgroundcolor
                                    g.drawLine(lp.x, lp.y , e.getX(), e.getY());        // draw the line from (lp.x , lp.y) ~ (Now x, Now y)
                                    
                                    parent.parent.Pencil.add(new Line(lp,e.getPoint(),cl));            // push the line into stack
                                    parent.parent.UndoStack.push(new StackInfo(parent.parent.sharp,new Line(lp,e.getPoint(),cl)));
                                    parent.tbar.UndoBtn.setEnabled(true);                       
                                    parent.tbar.RedoBtn.setEnabled(true);
                            }
                            lp = e.getPoint();              // set the current point
                        }
                        else if(parent.parent.status == Status.drawLine)
                        {
                            lp = e.getPoint();
                            repaint();
                        }
                        else if(parent.parent.status == Status.creatingOBJ)
                        {
                            ep = e.getPoint();                                             
                            repaint();
                        }
                    }
                }
        );
        
        this.addMouseListener(
              new MouseAdapter ()     // in the java.awt.event , it just a module contain Event
              {                                         
                        public void mousePressed(MouseEvent e)
                        {                
                            if(parent.parent.status == Status.Ready2FreeDraw)       // change the state
                                parent.parent.status = Status.freeDraw;                                                    
                            else if(parent.parent.status == Status.Ready2DrawLine)       // change the state
                                parent.parent.status = Status.drawLine;                 
                            else if(parent.parent.status == Status.Ready2CreatingOBJ)
                                parent.parent.status = Status.creatingOBJ;
                            
                            if(parent.parent.status == Status.freeDraw)             // recode current position
                                lp = e.getPoint();
                            
                            if(parent.parent.status == Status.drawLine)
                            {                               
                                if(parent.parent.CorN == true)                       // if we want to continue to drawLine
                                    LineStart = e.getPoint();                       // recode the current start posint
                                else                                                // this line can change the type with below (*)
                                    LineStart = LineEnd;            
                            }
                            
                            if(parent.parent.status == Status.creatingOBJ)
                                lp = e.getPoint();
                        }
                        
                        public void mouseReleased(MouseEvent e)
                        {
                            if(parent.parent.status == Status.freeDraw)
                            {
                                // do nothing
                            }    
                            
                            if(parent.parent.status == Status.drawLine)
                            {
                                LineEnd = e.getPoint();                                 // Recode the end of position
                                java.awt.Graphics pen = Page.this.getGraphics();      // Get the Paint pen
                                pen.setPaintMode();                                   // Draw mode
                                cl = parent.tbar.setPenColorBtn.getBackground();     // remember now pen color
                                pen.setColor(cl);                                       // The color of pen is Red
                                pen.drawLine(LineStart.x, LineStart.y , LineEnd.x, LineEnd.y);   // draw the line from (0,0) ~ (Now x, Now y)
                                
                                if(parent.parent.CorN==false)
                                    parent.parent.fir = true;                           // this line set true then it can produce the first Point (*)
                                else
                                    parent.parent.fir = false;                          // this line set false then it could continue to draw (*)
                                
                                parent.parent.vLine.add(new Line(LineStart,LineEnd,cl)); 
                                parent.parent.UndoStack.push(new StackInfo(parent.parent.sharp,new Line(LineStart,LineEnd,cl)));
                                parent.tbar.UndoBtn.setEnabled(true);
                            }
                            
                            if(parent.parent.status == Status.creatingOBJ)
                            {
                                java.awt.Graphics pen = Page.this.getGraphics();      // Get the Paint pen
                                pen.setPaintMode();                                   // Draw mode
                                cl = parent.tbar.setPenColorBtn.getBackground();     // remember now pen color
                                pen.setColor(cl);                                       // The color of pen is Red
                                
                                int wid = Math.abs(e.getX()-lp.x);
                                int hei = Math.abs(e.getY()-lp.y);
                                
                                if((e.getX()<lp.x)&&(e.getY()<lp.y))
                                {
                                    lp.x = e.getX();
                                    lp.y = e.getY();
                                }    
                                else if(e.getX()<lp.x)
                                    lp.x = e.getX();
                                else if(e.getY()<lp.y)
                                    lp.y = e.getY();
                                
                                pen.drawRect(lp.x, lp.y,wid,hei);
                                
                                parent.parent.obj.add((new Object(lp,wid,hei,cl)));
                                parent.parent.UndoStack.push(new StackInfo(parent.parent.sharp,new Object(lp,wid,hei,cl)));
                                parent.tbar.UndoBtn.setEnabled(true);
                            
                            }
                        }
              }
         );       
    }
    
    public void paintComponent(Graphics pen)
    {
        super.paintComponent(pen);          // Get the pen from System
        pen.setPaintMode();                 // Set the Painter Mode      
        pen.setColor(parent.tbar.setPenColorBtn.getBackground());          // The pen's color is black
        
        //pen.drawLine(0, 0, 200, 200);       // draw a line (0,0) ~ (200,200)
        
        if(parent.parent.UndoStack.empty())
            parent.tbar.UndoBtn.setEnabled(false);
        else if(parent.parent.RedoStack.empty())
            parent.tbar.RedoBtn.setEnabled(false);

        
        /*
        Line temp;
        for(int i = 0; i<lines.size();i++)
        {
            temp = lines.get(i);    
            pen.setColor(temp.color);
            pen.drawLine(temp.start.x, temp.start.y, temp.end.x, temp.end.y);       // draw a line (0,0) ~ (200,200)
        }*/
               
        
        for(int i = 0; i<parent.parent.vLine.size();i++)                        // repaint the line
        {
            Point temp1 = ((Line)parent.parent.vLine.elementAt(i)).getStart();
            Point temp2 = ((Line)parent.parent.vLine.elementAt(i)).getEnd();
            pen.setColor(parent.parent.vLine.elementAt(i).getColor());
            pen.drawLine(temp1.x, temp1.y, temp2.x, temp2.y);
        }
        
        for(int i = 0; i<parent.parent.Pencil.size();i++)                        // repaint the line
        {
            Point temp1 = ((Line)parent.parent.Pencil.elementAt(i)).getStart();
            Point temp2 = ((Line)parent.parent.Pencil.elementAt(i)).getEnd();
            pen.setColor(parent.parent.Pencil.elementAt(i).getColor());
            pen.drawLine(temp1.x, temp1.y, temp2.x, temp2.y);
        }
        
         for(int i = 0; i<parent.parent.obj.size();i++)                        // repaint the line
        {
            Point temp1 = ((Object)parent.parent.obj.elementAt(i)).getStart();
            int wid = ((Object)parent.parent.obj.elementAt(i)).getWidth();
            int hei = ((Object)parent.parent.obj.elementAt(i)).getHeight();
            pen.setColor(parent.parent.obj.elementAt(i).getColor());
            
            pen.drawRect(temp1.x, temp1.y, wid, hei);
        }
         
        if(parent.parent.status == Status.creatingOBJ)
        {
            cl = parent.tbar.setPenColorBtn.getBackground();     // remember now pen color
            pen.setColor(cl);                                       // The color of pen is Red
            int wid = Math.abs(ep.x-lp.x);
            int hei = Math.abs(ep.y-lp.y);
            
            if((ep.x<lp.x)&&(ep.y<lp.y))
                pen.drawRect(ep.x, ep.y,wid,hei);   
            else if(ep.x<lp.x)
                pen.drawRect(ep.x, lp.y,wid,hei);
            else if(ep.y<lp.y)
                pen.drawRect(lp.x, ep.y,wid,hei);
            else
                pen.drawRect(lp.x, lp.y,wid,hei);
            
            
        } 
        
        if(parent.parent.status == Status.drawLine)                             // repaint the line when you dragged the mouse
        {
            cl = parent.tbar.setPenColorBtn.getBackground();
            pen.setColor(cl);
            pen.drawLine(LineStart.x, LineStart.y, lp.x, lp.y);
        }  
        
        if((parent.parent.status==Status.undo) || (parent.parent.status==Status.redo))
        {        
            parent.parent.status=parent.parent.tempStatus;
        }
        
         
        
    }
    
}
