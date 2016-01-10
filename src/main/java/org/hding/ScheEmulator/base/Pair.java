package org.hding.ScheEmulator.base;

/**
 * Created by hding on 1/10/16.
 */
public class Pair {
    int x;
    int y;
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Pair(Pair o) {
        if (o == null) {
            return;
        }
        this.x = o.x;
        this.y = o.y;
    }
}
