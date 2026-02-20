import java.util.ArrayList;

/**
 * Write a description of class Tower here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tower
{
    private int width;
    private int maxHeight;
    private boolean isOk;
    private int n;
    
    private ArrayList<Cup> cups = new ArrayList<>();
    private ArrayList<Lid> lids = new ArrayList<>();
    
    public Tower(int width, int maxHeight)
    {
        this.width = width;
        this.maxHeight = maxHeight;
        cups = new ArrayList<>();
        n = (width+1)/2;
    }
    
    public void pushCup(int i) {
        width = 2*i - 1;
        boolean existe = false;
        
        for (int j = 0 ; j < cups.size() ; j++) {
            if (cups.get(j).getHeight() == width) {
                existe = true;
            }
        }
        
        if (!existe) {
            Cup taza = new Cup("Black",width,n-i);
        }
    }
    
    public void popCup() {
        
    }
    
    public void removeCup(int i) {
        
    }
    
    public void pushLid(int i) {
        
    }
    
    public void popLid() {
        
    }
    
    public void removeLid(int i) {
        
    }
    
    public void orderTower() {
        
    }
    
    public void reverseTower() {
        
    }
    
    public int height() {
        return width;
    }
    
    public int[] lidedCups() {
        return new int[0];
    }
    
    public String[][] stackingItems() {
        return new String[0][0];
    }
    
    public void makeVisible() {
        
    }
    
    public void makeInvisible() {
        
    }
    
    public void exit() {
        
    }
    
    public boolean ok() {
        return false;
    }
}
