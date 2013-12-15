

package painter;

import java.awt.*;
import java.util.*;

enum Status {drawLine,freeDraw,idle,creatingOBJ,Ready2CreatingOBJ,Ready2DrawLine,Ready2FreeDraw,undo,redo}
enum Sharp{IDLE,FREE,LINE,RECT}



public class Painter {
    //public boolean drawline = false;

    public Status status = Status.idle;
    
    public Status tempStatus = Status.idle;
    public Sharp sharp = Sharp.FREE;
    
    Stack <StackInfo>UndoStack;
    Stack <StackInfo>RedoStack;
    
    boolean fir = true;
    boolean CorN = true;
    Vector <Line>vLine;
    Vector <Line>Pencil;
    
    Vector <Object>obj;
    Painter()
    {
        vLine = new Vector<Line>();
        Pencil = new Vector<Line>();
        UndoStack = new Stack<StackInfo>();
        RedoStack = new Stack<StackInfo>();
        obj = new Vector<Object>();   
        MainWindows mainWin  = new MainWindows(this,"Painter",new Dimension(800,600));    
}
}
