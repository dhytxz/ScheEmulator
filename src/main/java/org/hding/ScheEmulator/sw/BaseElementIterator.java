package org.hding.ScheEmulator.sw;

import org.hding.ScheEmulator.base.Pair;

import java.util.Iterator;

/**
 * Created by hding on 1/10/16.
 */
public class BaseElementIterator implements Iterator<BaseElementCollection> {
    private Pair start;
    private Pair step;
    private Pair maxRange;
    private Pair nextPair;
    private Pair absRange;
    public BaseElementIterator(Pair start, Pair step, Pair maxRange) {
        this.start = start;
        this.step = step;
        this.maxRange = maxRange;
        this.nextPair = null;
        this.absRange = new Pair(this.start.getX() + this.maxRange.getX(),
                                 this.start.getY() + this.maxRange.getY());
    }
    @Override
    public boolean hasNext() {
        if (nextPair == null) {
            nextPair = start;
            return true;
        }
        nextPair = new Pair(start);
        if (nextPair.getX() + step.getX() >= absRange.getX() &&
                nextPair.getY() + step.getY() >= absRange.getY()) {
            return false;
        }
        if (nextPair.getY() + step.getY() >= absRange.getY()) {
            nextPair.setY(0);
            nextPair.setX(nextPair.getX() + step.getX());
        } else {
            nextPair.setY(nextPair.getY() + step.getY());
        }
        return true;
    }
    @Override
    public BaseElementCollection next() {
        start = nextPair;
        int lengthX = Math.min(step.getX(), absRange.getX() - nextPair.getX());
        int lengthY = Math.min(step.getY(), absRange.getY() - nextPair.getY());
        BaseElementCollection res = new BaseElementCollection(nextPair, new Pair(lengthX, lengthY));
        return res;
    }
}
