import java.util.*;

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
    
    private static ArrayList<String> colors = new ArrayList<>();
    private ArrayList<String> mainTower = new ArrayList<>();
    
    private static int grid = 40;
    
    private HashMap<Integer,Cup> cups = new HashMap<>();
    private HashMap<Integer,Lid> lids = new HashMap<>();
    
    private void createColors(){
        colors.add("red");
        colors.add("orange");
        colors.add("pink");
        colors.add("blue");
        colors.add("yellow");
        colors.add("green");
        colors.add("magenta");
    }
    
    private void creaTorre(){
        createColors();
        
        for (int i=1 ; i<=n ; i++) {
            cups.put(i, new Cup(colors.get(i-1),2*i - 1));
            lids.put(i, new Lid(colors.get(i-1),2*i - 1));
        }
    }
    
    public Tower(int width, int maxHeight)
    {
        this.width = width;
        this.maxHeight = maxHeight;
        
        if (this.width > 13) {
            this.width = 13;
        }
        
        if (this.maxHeight > 22) {
            this.maxHeight = 22;
        }
        
        this.isOk = true;
        this.cups = new HashMap<>();
        this.n = (this.width + 1)/2;
        
        canvasSize(this.width * grid,this.maxHeight * grid);

        creaTorre();
    }
    
    public Tower(int cups)
    {
        this.n = cups;
        this.cups = new HashMap<>();
        
        if (this.n > 7) {
            this.n = 7;
        }
        
        this.width = (2 * cups) - 1;
        this.maxHeight = 22;
        
        canvasSize(width*grid,maxHeight*grid);
        
        creaTorre();
    }
    
    private void cambiaPosicion(String tool, int place) {
        int cupNum = Integer.parseInt(String.valueOf(tool.charAt(5)));
        if (tool.substring(0,5).equals("taza:")) {
            Cup taza = cups.get(cupNum);
            taza.changePosition(place);
        } else {
            Lid tapa = lids.get(cupNum);
            tapa.changePosition(place);
        }
    }
    
    private void canvasSize(int newWidth,int newHeight){
        Canvas.canvasSize(newWidth,newHeight);
    }
    
    public void pushCup(int i) {
        if (!cups.get(i).equals(null)) {
            removeCup(i);
            
            if (mainTower.size() == 0) {
               cups.get(i).changePosition(0);
            }
            
            mainTower.add("taza:"+i);
        }
    }
    
    public void pushLid(int i) {
        if (!lids.get(i).equals(null)) {
            removeLid(i);
            
            if (mainTower.size() == 0) {
               lids.get(i).changePosition(0);
            }
            
            mainTower.add("tapa:"+i);  
        }
    }
    
    public void removeCup(int i) {
        for (int j = 0 ; j < mainTower.size() ; j++) {
            if (mainTower.get(j).equals("taza:"+i)) {
                mainTower.remove(j);
                break;
            }
        }  
    }
    
    public void removeLid(int i) {
        for (int j = 0 ; j < mainTower.size() ; j++) {
            if (mainTower.get(j).equals("tapa:"+i)) {
                mainTower.remove(j);
                break;
            }
        }  
    }
    
    public void popLid() {
        
    }
    
    public void popCup() {
        
    }
    
    public void orderTower() {
        
    }
    
    public void reverseTower() {
        
    }
    
    public int height() {
        return width;
    }
    
    public int[] lidedCups() {
        ArrayList<Integer> stacked = new ArrayList<>();
        int mayor = 0;
        
        for (int i = 0; i<cups.size();i++) {
            Cup taza = cups.get(0);
            if (taza.isClosed()) {
               stacked.add(taza.getHeight());
               if (taza.getHeight() > mayor) {
                   mayor = taza.getHeight();
               }
            }
        }
        
        Collections.sort(stacked);
        
        int [] numbers = new int[stacked.size()];
        
        for (int i = 0; i <= mayor;i++) {
            numbers[i] = stacked.get(i);
        }
        
        return new int[0];
    }
    
    public String[][] stackingItems() {
        return new String[0][0];
    }
    
    public void makeVisible() {
        for (int i = 0 ; i < mainTower.size() ; i++) {
            int cupNum = Integer.parseInt(String.valueOf(mainTower.get(i).charAt(5)));
            if (mainTower.get(i).substring(0,5).equals("taza:")) {
                Cup taza = cups.get(cupNum);
                taza.makeVisible();
            } else {
                Lid tapa = lids.get(cupNum);
                tapa.makeVisible();
            }
        }
    }
    
    public void makeInvisible() {
        for (int i = 1 ; i <= lids.size() ; i++) {
            lids.get(i).makeInvisible();
        }
        for (int i = 1 ; i <= cups.size() ; i++) {
            cups.get(i).makeInvisible();
        }
    }
    
    public void exit() {
        
    }
    
    public boolean ok() {
        return isOk;
    }
}
