

package painter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ToolBar extends JPanel{    // JPanel is in the " javax.swing "
        ToolBar()
        {
            this.setBackground(Color.RED);      // Toolbar's backgorund is Red
            this.setLayout(new FlowLayout(FlowLayout.LEFT));   // when you move the window , it can free to chage its size
            //this.setLayout(new BorderLayout());
            
            JButton exitBtn= new JButton("Exit");   // The button of the effect is Close
            
        
            exitBtn.addMouseListener (      // Set the Listener
                    new MouseAdapter ()     // in the java.awt.event , it just a module contain Event
                    {
                        public void mouseClicked(MouseEvent e)      // when you click the mouse
                        {
                            System.exit(0);     // The window will Close
                        }
                    }           
             );
            
            
            this.add(exitBtn);      // add a new Button
        }

                   
}
