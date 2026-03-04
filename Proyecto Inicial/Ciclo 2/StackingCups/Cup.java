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
    private Lid tapa;
    private int [] canvas_size;
    
    private ArrayList<Rectangle> shape;
    
    private static int grid = 40;
    
    public Cup(String color, int height)
    {
        this.color = color;
        this.height = height;
        this.position = 0;
        shape = new ArrayList<>();
        
        canvas_size = Canvas.getSize();
        
        Rectangle down = new Rectangle(height*grid,grid,(canvas_size[0]/2) - ((height * grid)/2),canvas_size[1] - (grid * (position + 1)),color);
        Rectangle left = new Rectangle(grid,height*grid,down.getPlace()[0],down.getPlace()[1] - ((height - 1) * grid),color);
        Rectangle right = new Rectangle(grid,height*grid,down.getPlace()[0]+ ((height - 1)*grid),down.getPlace()[1] - ((height - 1) * grid),color);
        
        shape.add(down);
        shape.add(left);
        shape.add(right);
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getPosition() {
        return position;
    }
    
    public void makeVisible() {
        for (int i = 0; i < shape.size() ; i++) {
            shape.get(i).makeVisible();
        }
    }
    
    public void makeInvisible() {
        for (int i = 0 ; i < shape.size() ; i++) {
            shape.get(i).makeInvisible();
        }
    }
    
    public boolean isClosed() {
        if (tapa == null) {
            return false;
        } else {
            return true;
        }
    }
    
    public void changePosition(int newPosition) {
        position = newPosition;
        
        Rectangle down = shape.get(0);
        Rectangle left = shape.get(1);
        Rectangle right = shape.get(2);
        
        down.changePlace(canvas_size[1] - (grid * (position + 1)));
        left.changePlace(down.getPlace()[1] - ((height - 1) * grid));
        right.changePlace(down.getPlace()[1] - ((height - 1) * grid));
    }
    
    public void taparTaza(Lid tapa){
        this.tapa = tapa;
        this.tapa.creaTaza(this);
    }
}
