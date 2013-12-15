
package painter;

import  java.awt.*;

public class Object {
    private Point start;
    private int width;
    private int height;
    private Color color; // = Color.RED;
    
    public Object(Point s,int w,int h,Color c)
    {
        start = s;
        width = w;
        height = h;
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

    public int getWidth()
    {
        return width;
    }
    
    public int getHeight()
    {
        return height;
    }
}