package Simulation;

/**
 * Klasa reprezentująca pojedynczy punkt na planszy
 */
public class Point {
    private int x;
    private int y;

    /**
     * Konstruktor punktu z koordynatami x i y
     * @param x
     * @param y
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Obliczanie odległości dwóch punktów od siebie
     * @param other punkt do którego mierzymy odległość
     * @return Odległość do drugiego punktu
     */
    public double distance(Point other) {
        return Math.sqrt(Math.pow(other.x - this.x, 2) + Math.pow(other.y - this.y, 2));
    }

    public int getX() { return x; }
    public int getY() { return y; }

}
