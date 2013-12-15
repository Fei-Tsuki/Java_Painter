

package painter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class ToolBar extends JPanel{    // JPanel is in the " javax.swing "
    
        MainWindows parent = null;      // It's a reference to Maindows
        JButton drawLineBtn;            // draw a straight line
        JButton stopDrawLineBtn;        // stop to draw
        JButton freeDrawBtn;            // free to draw
        JButton setPenColorBtn;         // select the pen color
        JButton DrawRectangleBtn;          // draw the rectangle
        JButton NeworContinue;          // change the type about drawLIne
        //JButton showColor;
        
        
        ToolBar(MainWindows p)
        {
            parent = p;
            parent.parent.fir = true;
            this.setBackground(Color.RED);      // Toolbar's backgorund is Red
            this.setLayout(new FlowLayout(FlowLayout.LEFT));   // when you move the window , it can free to chage its size
            
            
            JButton exitBtn= new JButton("Exit");   // The button of the effect is Close
            drawLineBtn= new JButton("DrawLine");   // The button of the Draw a Line
            stopDrawLineBtn = new JButton("StopDrawLine");  // The button of the Stop to drawline
            freeDrawBtn = new JButton("Draw");          // The button of the Free Draw 
            setPenColorBtn = new JButton(" ");
            DrawRectangleBtn = new JButton("DrawRectangle");
            NeworContinue = new JButton("C");
            //showColor = new JButton(" ");
            
                        
            
            setPenColorBtn.setBackground(Color.BLUE);   // original is blue
            setPenColorBtn.setEnabled(false);            // this btn just look
            
            exitBtn.addMouseListener (      // Set the Listener
                    new MouseAdapter ()     // in the java.awt.event , it just a module contain Event
                    {
                        public void mouseClicked(MouseEvent e)      // when you click the mouse
                        {
                            System.exit(0);     // The window will Close
                        }
                    }           
             );
            
            NeworContinue.addMouseListener(
                    new MouseAdapter ()
                    {
                        public void mouseClicked(MouseEvent e)
                        {
                            if (parent.parent.CorN == true)
                            {
                                ToolBar.this.NeworContinue.setLabel("N");
                                parent.parent.CorN = false;
                            }
                            else
                            {
                                ToolBar.this.NeworContinue.setLabel("C"); 
                                parent.parent.CorN = true;
                            }
                        }
                    }
            );
            
            freeDrawBtn.addMouseListener(
                    new MouseAdapter ()
                    {
                        public void mouseClicked(MouseEvent e)
                        {
                            if(parent.parent.status == Status.idle)
                            {
                                parent.parent.status = Status.Ready2FreeDraw; 
                                //parent.parent.status = Status.freeDraw;
                                ToolBar.this.freeDrawBtn.setEnabled(false);     // now freeDrawbtn can't use
                                ToolBar.this.drawLineBtn.setEnabled(false);     // now drawlinebtn can't use
                                ToolBar.this.stopDrawLineBtn.setEnabled(true);  // now stopdrawlinebtn can use
                                ToolBar.this.DrawRectangleBtn.setEnabled(false);
                            }
                        }
                    }
            );
            
            drawLineBtn.addMouseListener (      // Set the Listener
                    new MouseAdapter ()     // in the java.awt.event , it just a module contain Event
                    {
                        public void mouseClicked(MouseEvent e)      // when you click the mouse
                        {           
                            if(parent.parent.status == Status.idle)
                            {
                                parent.parent.status = Status.Ready2DrawLine;
                                parent.page.lp = new Point(-1,-1);      // reset the first point
                                //parent.parent.status = Status.drawLine;
                                ToolBar.this.freeDrawBtn.setEnabled(false);     // now freeDrawBtn can't use
                                ToolBar.this.stopDrawLineBtn.setEnabled(true);  // now stopdrawlinebtn can use
                                ToolBar.this.drawLineBtn.setEnabled(false);     // now drawlinebtn can't use
                                ToolBar.this.DrawRectangleBtn.setEnabled(false);
                            }
                       }
                    }           
             );
            
            stopDrawLineBtn.addMouseListener (      // Set the Listener
                    new MouseAdapter ()     // in the java.awt.event , it just a module contain Event
                    {
                        public void mouseClicked(MouseEvent e)      // when you click the mouse
                        {
                            parent.parent.fir = true;
                            parent.parent.status = Status.idle;
                            ToolBar.this.freeDrawBtn.setEnabled(true);          // now freeDrawBtn can use
                            ToolBar.this.stopDrawLineBtn.setEnabled(false);     // now stopdrawlinebtn can't use
                            ToolBar.this.drawLineBtn.setEnabled(true);     // now drawlinebtn can use
                            ToolBar.this.DrawRectangleBtn.setEnabled(true);
                            ToolBar.this.NeworContinue.setLabel("C");
                            parent.parent.CorN = true;
                            parent.parent.fir = true;
                        }
                    }           
             );
            
            DrawRectangleBtn.addMouseListener(
                    new MouseAdapter()
                    {
                        public void mouseClicked(MouseEvent e)
                        {
                            if(parent.parent.status == Status.idle)
                            {
                                parent.parent.status = Status.Ready2CreatingOBJ;
                                 ToolBar.this.stopDrawLineBtn.setEnabled(true);     // now drawlinebtn can't use
                                ToolBar.this.DrawRectangleBtn.setEnabled(false);
                                ToolBar.this.freeDrawBtn.setEnabled(false);     // now freeDrawbtn can't use
                                ToolBar.this.drawLineBtn.setEnabled(false);     // now drawlinebtn can't use
                            }
                        }
                    }
            );
            
            setPenColorBtn.addMouseListener(
                    new MouseAdapter()
                    {
                        public void mouseClicked(MouseEvent e)
                        {
                            Color c = null;
                            c = JColorChooser.showDialog(setPenColorBtn,"SelectColor",setPenColorBtn.getBackground());
                            System.out.print(c);
                            setPenColorBtn.setBackground(c);     // update the at least color
                        }
                    }
            );
            
            
            this.stopDrawLineBtn.setEnabled(false);     // set stopdrawlinebtn can't use
            this.add(drawLineBtn);    // add a new Button
            this.add(NeworContinue);
            this.add(stopDrawLineBtn);  // add a new Button
            this.add(freeDrawBtn);   // add a new Button
            this.add(setPenColorBtn);
            this.add(DrawRectangleBtn);
            //this.add(showColor);
            this.add(exitBtn);      // add a new Button
        }

                   
}
