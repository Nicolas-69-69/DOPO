public class Lid {

    private Rectangle top;

    public Lid(int size) {
        top = new Rectangle();
        top.changeSize(size, 10);
        top.changeColor("red");
        top.makeVisible();
    }

    public void moveVertical(int distance) {
        top.moveVertical(distance);
    }

    public void makeInvisible() {
        top.makeInvisible();
    }
}

