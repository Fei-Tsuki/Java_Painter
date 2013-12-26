

package painter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;


public class ToolBar extends JPanel{    // JPanel is in the " javax.swing "
    
        MainWindows parent = null;      // It's a reference to Maindows
        JButton drawLineBtn;            // draw a straight line
        JButton stopDrawBtn;        // stop to draw
        JButton EraserBtn;
        JButton freeDrawBtn;            // free to draw
        JButton setPenColorBtn;         // select the pen color
        JButton DrawRectangleBtn;          // draw the rectangle
        JButton NeworContinue;          // change the type about drawLIne
        JButton UndoBtn;
        JButton RedoBtn;
        JButton SaveBtn;
        JButton LoadBtn;
        int count = 16;
        int now;
        JButton [] cc ;
        
        ToolBar(MainWindows p)
        {
            parent = p;
            parent.parent.fir = true;
            this.setBackground(new Color(40,160,190,60));      // Toolbar's backgorund is Red 
            this.setLayout(new FlowLayout(FlowLayout.LEFT));   // when you move the window , it can free to chage its size
            
            
            JPanel PD = new JPanel(new GridBagLayout());        // Draw 
            PD.setBackground(new Color(40,160,190,0));
            
            
            JLabel space_0 = new JLabel(" ");
            space_0.setPreferredSize(new Dimension(40,80));
            
            JPanel PO = new JPanel(new GridBagLayout());           // Option
            PO.setBackground(new Color(40,160,190,0));
            
            JLabel space_1 = new JLabel(" ");
            space_1.setPreferredSize(new Dimension(40,80));
            
            JPanel PC = new JPanel(new GridBagLayout());        // Color
            PC.setBackground(new Color(40,160,190,0));
            
            //PC.setPreferredSize(new Dimension(217,69));
            
/* ===============================  Layout of DrawLine ==============================*/
            
            drawLineBtn= new JButton();   
            drawLineBtn.setPreferredSize(new Dimension(23,23));
            drawLineBtn.setIcon(new ImageIcon(this.getClass().getResource("pic/drawline.jpg")));
            GridBagConstraints d0 = new GridBagConstraints();
            d0.gridx = 0;
            d0.gridy = 0;
            d0.gridwidth = 1;
            d0.gridheight = 1;
            d0.weightx = 0;
            d0.weighty = 0;
            d0.fill = GridBagConstraints.NONE;
            d0.anchor = GridBagConstraints.CENTER;
            PD.add(drawLineBtn, d0);
          
/* ===============================  Layout of FreeDraw  ==============================*/            
            
            freeDrawBtn = new JButton();          // The button of the Free Draw 
            freeDrawBtn.setPreferredSize(new Dimension(23,23));
            freeDrawBtn.setIcon(new ImageIcon(this.getClass().getResource("pic/freedraw.jpg")));
            GridBagConstraints d1 = new GridBagConstraints();
            d1.gridx = 1;
            d1.gridy = 0;
            d1.gridwidth = 1;
            d1.gridheight = 1;
            d1.weightx = 0;
            d1.weighty = 0;
            d1.fill = GridBagConstraints.NONE;
            d1.anchor = GridBagConstraints.CENTER;
            PD.add(freeDrawBtn, d1);
 
 /* ===============================  Layout of StopDraw ==============================*/           
            
            stopDrawBtn = new JButton();  // The button of the Stop to drawline              
            stopDrawBtn.setPreferredSize(new Dimension(23,23));
            stopDrawBtn.setIcon(new ImageIcon(this.getClass().getResource("pic/stop.jpg")));
            GridBagConstraints d3 = new GridBagConstraints();
            d3.gridx = 2;
            d3.gridy = 0;
            d3.gridwidth = 1;
            d3.gridheight = 1;
            d3.weightx = 0;
            d3.weighty = 0;
            d3.fill = GridBagConstraints.NONE;
            d3.anchor = GridBagConstraints.CENTER;
            PD.add(stopDrawBtn, d3);
   
 /* ===============================  Layout of Create Rectangle ==============================*/    
            
            DrawRectangleBtn = new JButton();
            DrawRectangleBtn.setPreferredSize(new Dimension(23,23));
            DrawRectangleBtn.setIcon(new ImageIcon(this.getClass().getResource("pic/drawretangle.jpg"))); 
            GridBagConstraints d4 = new GridBagConstraints();
            d4.gridx = 1;
            d4.gridy = 1;
            d4.gridwidth = 1;
            d4.gridheight = 1;
            d4.weightx = 0;
            d4.weighty = 0;
            d4.fill = GridBagConstraints.NONE;
            d4.anchor = GridBagConstraints.CENTER;
            PD.add(DrawRectangleBtn,d4);
   
 /* ===============================  Layout of Eraser ==============================*/
            EraserBtn = new JButton();
            EraserBtn.setPreferredSize(new Dimension(23,23));
            EraserBtn.setIcon(new ImageIcon(this.getClass().getResource("pic/eraser.jpg"))); 
            GridBagConstraints d5 = new GridBagConstraints();
            d5.gridx = 0;
            d5.gridy = 1;
            d5.gridwidth = 1;
            d5.gridheight = 1;
            d5.weightx = 0;
            d5.weighty = 0;
            d5.fill = GridBagConstraints.NONE;
            d5.anchor = GridBagConstraints.CENTER;
            PD.add(EraserBtn,d5);           
            
 /* ===============================  Layout of DrawLaBel ==============================*/           
                    
            JLabel ll = new JLabel("draw");
            ll.setHorizontalAlignment(JLabel.CENTER);
            ll.setBackground(new Color(40,160,190,0));
            ll.setOpaque(true);
            ll.setPreferredSize(new Dimension(69,23));
            GridBagConstraints d2 = new GridBagConstraints();
            d2.gridx = 0;
            d2.gridy = 2;
            d2.gridwidth = 3;
            d2.gridheight = 1;
            d2.weightx = 0;
            d2.weighty = 0;
            d2.fill = GridBagConstraints.NONE;
            d2.anchor = GridBagConstraints.CENTER;
            PD.add(ll, d2);
   
/* =============================== Layout of Undo ==============================*/
            
            UndoBtn = new JButton();
            UndoBtn.setPreferredSize(new Dimension(25,25));
            UndoBtn.setIcon(new ImageIcon(this.getClass().getResource("pic/undo.jpg")));
            GridBagConstraints o0 = new GridBagConstraints();
            o0.gridx = 0;
            o0.gridy = 0;
            o0.gridwidth = 1;
            o0.gridheight = 1;
            o0.weightx = 0;
            o0.weighty = 0;
            o0.fill = GridBagConstraints.NONE;
            o0.anchor = GridBagConstraints.CENTER;
            PO.add(UndoBtn,o0);
            
 /*=============================== Layout of Redo ===================================*/
            
            RedoBtn = new JButton();
            RedoBtn.setPreferredSize(new Dimension(25,25));
            RedoBtn.setIcon(new ImageIcon(this.getClass().getResource("pic/redo.jpg")));
            GridBagConstraints o1 = new GridBagConstraints();
            o1.gridx = 1;
            o1.gridy = 0;
            o1.gridwidth = 1;
            o1.gridheight = 1;
            o1.weightx = 0;
            o1.weighty = 0;
            o1.fill = GridBagConstraints.NONE;
            o1.anchor = GridBagConstraints.CENTER;
            PO.add(RedoBtn,o1);
 
/* ===============================  Layout of Continue or New ==============================*/             
            
            NeworContinue = new JButton();
            NeworContinue.setPreferredSize(new Dimension(25,25));
            NeworContinue.setIcon(new ImageIcon(this.getClass().getResource("pic/Continue.jpg")));
            GridBagConstraints o2 = new GridBagConstraints();
            o2.gridx = 2;
            o2.gridy = 0;
            o2.gridwidth = 1;
            o2.gridheight = 1;
            o2.weightx = 0;
            o2.weighty = 0;
            o2.fill = GridBagConstraints.NONE;
            o2.anchor = GridBagConstraints.CENTER;
            PO.add(NeworContinue,o2);
            
/* ===============================  Layout of save ==============================*/             
            
            SaveBtn = new JButton();
            SaveBtn.setPreferredSize(new Dimension(25,25));
            SaveBtn.setIcon(new ImageIcon(this.getClass().getResource("pic/save.jpg")));
            GridBagConstraints o3 = new GridBagConstraints();
            o3.gridx = 0;
            o3.gridy = 1;
            o3.gridwidth = 1;
            o3.gridheight = 1;
            o3.weightx = 0;
            o3.weighty = 0;
            o3.fill = GridBagConstraints.NONE;
            o3.anchor = GridBagConstraints.CENTER;
            PO.add(SaveBtn,o3);            
  
 /* ===============================  Layout of exit ==============================*/             
            
            JButton exitBtn= new JButton("");               // The button of the effect is Close 
            exitBtn.setIcon(new ImageIcon(this.getClass().getResource("pic/exit.jpg")));
            exitBtn.setPreferredSize(new Dimension(25,25));
            GridBagConstraints o4 = new GridBagConstraints();
            o4.gridx = 2;
            o4.gridy = 1;
            o4.gridwidth = 1;
            o4.gridheight = 1;
            o4.weightx = 0;
            o4.weighty = 0;
            o4.fill = GridBagConstraints.NONE;
            o4.anchor = GridBagConstraints.CENTER;
            PO.add(exitBtn,o4); 
            
/* ===============================  Layout of load ==============================*/             
            
            LoadBtn = new JButton();
            LoadBtn.setPreferredSize(new Dimension(25,25));
            LoadBtn.setIcon(new ImageIcon(this.getClass().getResource("pic/load.jpg")));
            GridBagConstraints o5 = new GridBagConstraints();
            o5.gridx = 1;
            o5.gridy = 1;
            o5.gridwidth = 1;
            o5.gridheight = 1;
            o5.weightx = 0;
            o5.weighty = 0;
            o5.fill = GridBagConstraints.NONE;
            o5.anchor = GridBagConstraints.CENTER;
            PO.add(LoadBtn,o5);              
         
 /* ===============================  Layout of OptionLaBel ==============================*/           
                    
            JLabel lo = new JLabel("option");
            lo.setHorizontalAlignment(JLabel.CENTER);
            lo.setBackground(new Color(40,160,190,0));
            lo.setOpaque(true);
            lo.setPreferredSize(new Dimension(75,19));
            GridBagConstraints o6 = new GridBagConstraints();
            o6.gridx = 0;
            o6.gridy = 2;
            o6.gridwidth = 3;
            o6.gridheight = 1;
            o6.weightx = 0;
            o6.weighty = 0;
            o6.fill = GridBagConstraints.NONE;
            o6.anchor = GridBagConstraints.CENTER;
            PO.add(lo, o6);            
         
/* ===============================  Layout of ShowColor ==============================*/ 
  
            setPenColorBtn = new JButton("");
            setPenColorBtn.setBackground(Color.black);   // original is blue
            setPenColorBtn.setEnabled(false);            // this btn just look
            setPenColorBtn.setPreferredSize(new Dimension(30,46));
            
            GridBagConstraints c0 = new GridBagConstraints();
            c0.gridx = 0;
            c0.gridy = 0;
            c0.gridwidth = 1;
            c0.gridheight = 2;
            c0.weightx = 0;
            c0.weighty = 0;
            c0.fill = GridBagConstraints.NONE;
            c0.anchor = GridBagConstraints.CENTER;
            PC.add(setPenColorBtn,c0);
            
 
            cc = new JButton[24];
            int s;
            
            GridBagConstraints c1 = new GridBagConstraints();
            for(s = 0 ;s<cc.length;s++)
            {             
                c1.gridx = 2 + (s%8);
                c1.gridy = s/8;
                c1.gridwidth = 1;
                c1.gridheight = 1;
                c1.weightx = 30;
                c1.weighty = 0;
                c1.fill = GridBagConstraints.NONE;
                c1.anchor = GridBagConstraints.CENTER;
                cc[s] = new JButton("");
                cc[s].setPreferredSize(new Dimension(23,23));
                PC.add(cc[s],c1);    
            }
            
            JLabel ll_c = new JLabel("color");
            ll_c.setHorizontalAlignment(JLabel.CENTER);
            ll_c.setBackground(new Color(40,160,190,0));
            ll_c.setOpaque(true);
            GridBagConstraints c2 = new GridBagConstraints();
            c2.gridx = 0;
            c2.gridy = 2;
            c2.gridwidth = 1;
            c2.gridheight = 1;
            c2.weightx = 0;
            c2.weighty = 0;
            c2.fill = GridBagConstraints.NONE;
            c2.anchor = GridBagConstraints.CENTER;
            PC.add(ll_c, c2);
            
            JLabel ll_space_1 = new JLabel(" "); 
            ll_space_1.setBackground(new Color(40,160,190,0));
            ll_space_1.setOpaque(true);
            GridBagConstraints c3 = new GridBagConstraints();
            c3.gridx = 1;
            c3.gridy = 0;
            c3.gridwidth = 1;
            c3.gridheight = 3;
            c3.weightx = 0;
            c3.weighty = 0;
            c3.fill = GridBagConstraints.NONE;
            c3.anchor = GridBagConstraints.CENTER;
            PC.add(ll_space_1, c3);
          
 /*=================== The Color Reset ===========================*/
            
           for(s = 16;s<cc.length;s++)
           {
               cc[s].setBackground(Color.white);
               cc[s].setEnabled(false);
           }
           
           cc[0].setBackground(Color.BLACK);                       // black
           cc[1].setBackground(new Color(0xFF,0x15,0x5C));          // red
           cc[2].setBackground(new Color(0xFF,0x9C,0x50));          // orange
           cc[3].setBackground(new Color(0xFF,0xFF,0x00));          // yellow
           cc[4].setBackground(new Color(0x0A,0xDE,0x50));          // green
           cc[5].setBackground(new Color(0x80,0xBE,0xFF));          // blue 
           cc[6].setBackground(new Color(0x20,0x2E,0xE9));          // dark_blue
           cc[7].setBackground(new Color(0xBD,0x66,0xC5));          // purple
           cc[8].setBackground(new Color(255,255,255,255));         // white
           cc[9].setBackground(new Color(192,192,192,255));         // bright_gray
           cc[10].setBackground(new Color(128,128,128,255));        // dark_gray
           cc[11].setBackground(new Color(128,0,0,255));            // brown
           cc[12].setBackground(new Color(0xEB,0x1E,0x9C));         // purple_red            
           cc[13].setBackground(new Color(0xCA,0xA2,0x50));         // bright_brown
           cc[14].setBackground(new Color(0xFF,0xA2,0xFF));         // pink
           cc[15].setBackground(new Color(0x07,0xBE,0xB7));         // blue_green 
                   
/*========================================================================*/        
           
           
           
           
           
            
            
            
 
       
            
            
            // 456  <editor-fold defaultsate="collapsed" desc = "Main">
            // 456  </editor-fold>
            
            
            
            
            
            
            
         
            
            
            
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
                                NeworContinue.setIcon(new ImageIcon(this.getClass().getResource("pic/New.jpg")));
                                parent.parent.CorN = false;
                            }
                            else
                            {
                                NeworContinue.setIcon(new ImageIcon(this.getClass().getResource("pic/Continue.jpg"))); 
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
                                parent.parent.sharp = parent.parent.sharp.FREE;
                                //parent.parent.status = Status.freeDraw;
                                //ToolBar.this.freeDrawBtn.setEnabled(false);     // now freeDrawbtn can't use
                                //ToolBar.this.drawLineBtn.setEnabled(false);     // now drawlinebtn can't use
                                ToolBar.this.stopDrawBtn.setEnabled(true);  // now stopdrawlinebtn can use
                                //ToolBar.this.DrawRectangleBtn.setEnabled(false);
                            }
                        }
                    }
            );
            
            EraserBtn.addMouseListener(
                    new MouseAdapter ()
                    {
                        public void mouseClicked(MouseEvent e)
                        {
                            if(parent.parent.status == Status.idle)
                            {
                                parent.parent.status = Status.Ready2Eraser;
                                parent.parent.sharp = parent.parent.sharp.CLR;
                                //parent.parent.status = Status.freeDraw;
                                //ToolBar.this.freeDrawBtn.setEnabled(false);     // now freeDrawbtn can't use
                                //ToolBar.this.drawLineBtn.setEnabled(false);     // now drawlinebtn can't use
                                ToolBar.this.stopDrawBtn.setEnabled(true);  // now stopdrawlinebtn can use
                                //ToolBar.this.DrawRectangleBtn.setEnabled(false);
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
                                parent.parent.sharp = parent.parent.sharp.LINE;
                                parent.page.lp = new Point(-1,-1);      // reset the first point
                                //parent.parent.status = Status.drawLine;
                                //ToolBar.this.freeDrawBtn.setEnabled(false);     // now freeDrawBtn can't use
                                ToolBar.this.stopDrawBtn.setEnabled(true);  // now stopdrawlinebtn can use
                                //ToolBar.this.drawLineBtn.setEnabled(false);     // now drawlinebtn can't use
                                //ToolBar.this.DrawRectangleBtn.setEnabled(false);
                            }
                       }
                    }           
             );
            
            
            
            stopDrawBtn.addMouseListener (      // Set the Listener
                    new MouseAdapter ()     // in the java.awt.event , it just a module contain Event
                    {
                        public void mouseClicked(MouseEvent e)      // when you click the mouse
                        {
                            parent.parent.fir = true;
                            parent.parent.status = Status.idle;
                            //ToolBar.this.freeDrawBtn.setEnabled(true);          // now freeDrawBtn can use
                            //ToolBar.this.stopDrawBtn.setEnabled(false);     // now stopdrawlinebtn can't use
                            //ToolBar.this.drawLineBtn.setEnabled(true);     // now drawlinebtn can use
                            //ToolBar.this.DrawRectangleBtn.setEnabled(true);
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
                                parent.parent.sharp = parent.parent.sharp.RECT;
                                ToolBar.this.stopDrawBtn.setEnabled(true);     // now drawlinebtn can't use
                                //ToolBar.this.DrawRectangleBtn.setEnabled(false);
                                //ToolBar.this.freeDrawBtn.setEnabled(false);     // now freeDrawbtn can't use
                                //ToolBar.this.drawLineBtn.setEnabled(false);     // now drawlinebtn can't use
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
                            
                            if(ToolBar.this.count<24)
                            {
                                cc[count].setEnabled(true);
                                cc[count].setBackground(c);
                                ToolBar.this.count++;
                            }
                        }
                    }
            );
            
            for(int r = 0 ;r<24 ;r++)
            {
                cc[r].addMouseListener(
                    new MouseAdapter()
                    {
                        public void mouseClicked(MouseEvent e)
                        {
                            for(now = 0 ; now < count ; now++)
                                if(e.getSource().equals(cc[now]))
                                    setPenColorBtn.setBackground(ToolBar.this.cc[now].getBackground());    // update the at least color
                        }
                    }
                );
            }
             
             
            UndoBtn.addMouseListener(
                    new MouseAdapter()
                    {
                        StackInfo temp;
                        
                        public void mouseClicked(MouseEvent e)
                        {
                            RedoBtn.setEnabled(true);
                            parent.parent.tempStatus = parent.parent.status;
                            parent.parent.status = Status.undo;
                            if(!parent.parent.UndoStack.empty())
                            {
                                temp = (StackInfo)parent.parent.UndoStack.pop();
                                switch(temp.getType())
                                {
                                    case FREE:
                                        parent.parent.Pencil.remove(parent.parent.Pencil.size()-1);
                                        break;
                                    case LINE:
                                        parent.parent.vLine.remove(parent.parent.vLine.size()-1);
                                        break;
                                    case RECT:
                                        parent.parent.obj.remove(parent.parent.obj.size()-1);
                                        break;
                                    case CLR:
                                        parent.parent.obj.remove(parent.parent.Eraser.size()-1);
                                        break;
                                }
                                
                                parent.parent.RedoStack.push(temp);
                            }                            
                            parent.page.repaint();
                        }
                    }
            );
            
            RedoBtn.addMouseListener(
                new MouseAdapter()
                {
                    public void mouseClicked(MouseEvent e)
                    {
                        StackInfo temp;        
                        parent.parent.tempStatus=parent.parent.status;
                        parent.parent.status=Status.redo;
                        UndoBtn.setEnabled(true);        
                        if(!parent.parent.RedoStack.empty())
                        {
                            temp = (StackInfo)parent.parent.RedoStack.pop();
                            switch(temp.getType())
                            {
                                case FREE:
                                    parent.parent.Pencil.add(temp.getLine());
                                    break;                                                
                                case LINE:
                                    parent.parent.vLine.add(temp.getLine());
                                    break;
                                case RECT:
                                    parent.parent.obj.add(temp.getObject());
                                    break;
                                case CLR:
                                    parent.parent.Eraser.add(temp.getLine());
                                    break;    
                             }
                            
                             parent.parent.UndoStack.push(temp);         
                        }
                                        
                         parent.page.repaint();
                    }
                }
            );
            
            
            this.add(PD);
            this.add(space_0);
            this.add(PO);
            this.add(space_1);
            this.add(PC);
            
            //this.stopDrawBtn.setEnabled(false);     // set stopdrawlinebtn can't use
            //this.add(drawLineBtn);    // add a new Button           
            //this.add(NeworContinue);
            //this.add(stopDrawBtn);  // add a new Button
            //this.add(freeDrawBtn);   // add a new Button
            //this.add(setPenColorBtn);
            //this.add(DrawRectangleBtn);
            //this.add(UndoBtn);
            //this.add(RedoBtn);
            //this.add(exitBtn);      // add a new Button
        }

                   
}
