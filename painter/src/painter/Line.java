
package painter;

import  java.awt.*;
import java.io.Serializable;

public class Line implements Serializable{
    Point start;
    Point end;
    Color color; // = Color.RED;
    
    Line(Point s,Point e,Color c)
    {
        start = s;
        end = e;
        color = c;
    }        
    
    
    public Color getColor()
    {
        return color;
    }
    
    public Point getStart()
    {
        return start;
    }
    
    public  Point getEnd()
    {
        return end;
    }
}
