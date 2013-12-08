

package painter;

import java.awt.*;

enum Status {drawLine,freeDraw,idle}

public class Painter {
    //public boolean drawline = false;
    public Status status = Status.idle;
    MainWindows mainWin  = new MainWindows(this,"Painter",new Dimension(600,500));    
}
