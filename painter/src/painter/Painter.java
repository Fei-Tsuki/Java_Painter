

package painter;

import java.awt.*;
import java.util.*;

enum Status {drawLine,freeDraw,idle,creatingOBJ,Ready2CreatingOBJ,Ready2DrawLine,Ready2FreeDraw}




public class Painter {
    //public boolean drawline = false;

    public Status status = Status.idle;
    boolean fir = true;
    boolean CorN = true;
    Vector <Line>vLine;
    Vector <Object>obj;
    Painter()
    {
        vLine = new Vector<Line>();
        obj = new Vector<Object>();   
        MainWindows mainWin  = new MainWindows(this,"Painter",new Dimension(600,500));    
}
}
