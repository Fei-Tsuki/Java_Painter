
package painter;

import java.awt.*;
import javax.swing.*;       // Second of awt 



public class MainWindows extends JFrame{
    Dimension size ;
    ToolBar tbar;
    Page page;
    
    
    MainWindows(String s, Dimension size)
    {
        super(s);       // use the Function from JFrame to inputt the title
        
        this.size = size;
        this.setSize(size);     // set the size to frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // set close of the title
        
        Dimension scrsize = Toolkit.getDefaultToolkit().getScreenSize();    // Get the size of screen
        this.setLocation(scrsize.width / 2 - size.width / 2 , scrsize.height / 2 - size.height / 2);    // set the Frame's position
        
        this.getContentPane().setBackground(Color.WHITE);   // set the background color
        this.getContentPane().setLayout(new BorderLayout());    // set this ,and then you can do what you want
        
        tbar = new ToolBar();
        this.getContentPane().add(tbar, BorderLayout.NORTH);    // set the toolbar up
        
        page = new Page();
        this.getContentPane().add(page,BorderLayout.CENTER);    // set the paintpage center
        
        this.setVisible(true);  // use this can be see
    }
    
}
