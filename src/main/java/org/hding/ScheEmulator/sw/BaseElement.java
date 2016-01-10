package org.hding.ScheEmulator.sw;



import org.hding.ScheEmulator.base.Pair;

import java.util.Iterator;

/**
 * Created by hding on 1/10/16.
 */
public class BaseElement implements Iterable<BaseElement> {
    Pair topLeft;
    Pair step;
    Pair max;
    private Pair nextPair;
    public BaseElement() {
        topLeft = new Pair(0, 0);
        step = new Pair(0, 0);
        max = new Pair(0, 0);
        nextPair = null;
    }
    public BaseElement(Pair topLeft, Pair step, Pair max) {
        topLeft = new Pair(topLeft);
        step = new Pair(step);
        max = new Pair(max);
    }
    public BaseElement(BaseElement o) {
        topLeft = new Pair(o.topLeft);
        step = new Pair(o.step);
        max = new Pair(o.max);
    }
    class Itr implements Iterator<BaseElement> {
        @Override
        public boolean hasNext() {
            nextPair = new Pair(topLeft);
            if (nextPair.getX() + step.getX() >= max.getX() &&
                nextPair.getY() + step.getY() >= max.getY()) {
                return false;
            }
            if (nextPair.getY() + step.getY() >= max.getY()) {
                nextPair.setX(0);
                nextPair.setY(nextPair.getY() + step.getY());
            } else {
                nextPair.setX(nextPair.getX() + step.getX());
            }
            return true;
        }
        @Override
        public BaseElement next() {
            topLeft = nextPair;
            return new BaseElement(topLeft, step,
                                   new Pair(Math.min(topLeft.getX() + step.getX(), max.getX()),
                                            Math.min(topLeft.getY() + step.getY(), max.getY())))
        }
        @Override
        public void remove() {

        }
    }
    public Iterator<BaseElement> iterator() {
        return new Itr();
    }
}
