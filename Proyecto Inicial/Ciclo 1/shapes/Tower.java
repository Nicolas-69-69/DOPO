public class Tower {

    private Cup[] cups;
    private int count;

    public Tower(int max) {
        cups = new Cup[max];
        count = 0;
    }

    public void pushCup(int size) {
        if (count < cups.length) {
            cups[count] = new Cup(size);
            count++;
        }
    }

    public void popCup() {
        if (count > 0) {
            cups[count - 1].makeInvisible();
            cups[count - 1] = null;
            count--;
        }
    }
}

