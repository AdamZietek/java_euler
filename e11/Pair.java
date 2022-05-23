public class Pair {
    public int x;
    public int y;

    public Pair(int a, int b) {
        x = a;
        y = b;
    }

    public String toString() {
        String output = Integer.toString(x) + ", " + Integer.toString(y);
        return output;
    }
}
