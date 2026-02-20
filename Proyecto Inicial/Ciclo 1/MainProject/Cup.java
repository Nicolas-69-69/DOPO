import java.util.ArrayList;

/**
 * Write a description of class Cup here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cup
{
    private String color;
    private int height;
    private int position;
    
    private ArrayList<Rectangle> shape;
    
    public Cup(String color, int height, int position)
    {
        this.color = color;
        this.height = height;
        this.position = position;
        
        System.out.println("Altura: "+height+", Posicion:"+position);
    }
    
    public int getHeight() {
        return height;
    }
}
