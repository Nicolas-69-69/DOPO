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
    
    private Rectangle shape;
    
    public Lid(int id, String color, int width, int position)
    {
        this.color = color;
        this.width = width;
        this.position = position;
    }
    
    public int getHeight() {
        return height;
    }
}
