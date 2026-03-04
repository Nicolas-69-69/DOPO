import java.util.ArrayList;

/**
 * Write a description of class Lid here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lid
{
    private String color;
    private static int height = 1;
    private int position;
    private int width;
    private int [] canvas_size;
    private Cup taza;
    
    private Rectangle shape;
    
    private static int grid = 40;
    
    public Lid(String color, int width)
    {
        this.color = color;
        this.width = width;
        this.position = 0;
        
        canvas_size = Canvas.getSize();
        
        shape = new Rectangle(width * grid,grid,(canvas_size[0]/2) - ((width * grid)/2),canvas_size[1] - (grid * (position + 1)), color);
    }
    
    public int getHeight() {
        return width;
    }
    
    public int getPosition() {
        return position;
    }
    
    public void makeVisible() {
        shape.makeVisible();
    }
    
    public void makeInvisible() {
        shape.makeInvisible();
    }
    
    public void changePosition(int newPosition) {
        position = newPosition;
        shape.changePlace(canvas_size[1] - (grid * (position + 1)));
    }
    
    public void creaTaza(Cup taza){
        this.taza = taza;
    }
}
