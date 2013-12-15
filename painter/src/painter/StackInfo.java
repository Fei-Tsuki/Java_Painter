
package painter;

import java.io.Serializable;

public class StackInfo implements Serializable{
        private Sharp StackType;
        private Line TempForLine;
        private Object TempForObj;
        public StackInfo(Sharp Stype,Line Temp)
        {
                StackType=Stype;
                TempForLine=Temp;
        }
        
        public StackInfo(Sharp Stype,Object Temp)
        {
            StackType=Stype;
            TempForObj=Temp;
        }
        
        public Sharp getType()
        {
                return StackType;
        }
        
        public Line getLine()
        {
                return TempForLine;
        }
        
        public Object getObject()
        {
                return TempForObj;
        }
}
