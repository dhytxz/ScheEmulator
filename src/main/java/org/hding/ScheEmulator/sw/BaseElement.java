package org.hding.ScheEmulator.sw;

import org.hding.ScheEmulator.base.Pair;

/**
 * Created by hding on 1/10/16.
 */
public class BaseElement implements Comparable<BaseElement> {
    Pair topLeft;
    Pair length;
    public BaseElement(Pair topLeft) {
        this.topLeft = topLeft;
        this.length = new Pair(1, 1);
    }
    public BaseElement(Pair topLeft, Pair length) {
        this.topLeft = topLeft;
        this.length = length;
    }
    public BaseElement(BaseElement o) {
        this.topLeft = new Pair(o.topLeft);
        this.length = new Pair(o.length);
    }
    @Override
    public int compareTo(BaseElement o) {
        if (this.topLeft.getX() == o.topLeft.getX()) {
            return this.topLeft.getY() - o.topLeft.getY();
        }
        return this.topLeft.getX() - o.topLeft.getX();
    }
    @Override
    public String toString() {
        return topLeft.toString() + ";" + length.toString();
    }
}