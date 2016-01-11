package org.hding.ScheEmulator.sw;

import org.hding.ScheEmulator.base.Pair;

import java.util.Iterator;

/**
 * Created by hding on 1/10/16.
 */
public class BaseElementIterator<E extends BaseElement> implements Iterator<E> {
    private Pair start;
    private Pair step;
    private Pair maxRange;
    private Pair nextPair;
    public BaseElementIterator(Pair start, Pair step, Pair maxRange) {
        this.start = start;
        this.step = step;
        this.maxRange = maxRange;
        this.nextPair = null;
    }
    @Override
    public boolean hasNext() {
        if (nextPair == null) {
            nextPair = start;
            return true;
        }
        nextPair = new Pair(start);
        if (nextPair.getX() + step.getX() >= maxRange.getX() &&
                nextPair.getY() + step.getY() >= maxRange.getY()) {
            return false;
        }
        if (nextPair.getY() + step.getY() >= maxRange.getY()) {
            nextPair.setY(0);
            nextPair.setX(nextPair.getX() + step.getX());
        } else {
            nextPair.setY(nextPair.getY() + step.getY());
        }
        return true;
    }
    @Override
    public E next() {
        start = nextPair;
        int lengthX = Math.min(step.getX(), maxRange.getX() - nextPair.getX());
        int lengthY = Math.min(step.getY(), maxRange.getY() - nextPair.getY());
        BaseElement res = new BaseElement(nextPair, new Pair(lengthX, lengthY));
        return (E)res;
    }
    @Override
    public void remove() {
        // throws new UnsupportedOperationException();
    }
}
