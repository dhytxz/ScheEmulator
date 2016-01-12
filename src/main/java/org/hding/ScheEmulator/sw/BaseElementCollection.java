package org.hding.ScheEmulator.sw;

import org.hding.ScheEmulator.base.Pair;

import java.util.Iterator;

/**
 * Created by hding on 1/10/16.
 */
public class BaseElementCollection<E extends BaseElementCollection>
        implements Iterable<E>, Comparable<BaseElementCollection> {
    Pair start;
    Pair step;
    Pair maxRange;
    public BaseElementCollection(Pair start, Pair step, Pair maxRange) {
        this.start = start;
        this.step = step;
        this.maxRange = maxRange;
    }
    public BaseElementCollection(Pair start, Pair maxRange) {
        this.start = start;
        this.step = new Pair(1, 1);
        this.maxRange = maxRange;
    }
    public BaseElementCollection(Pair start) {
        this.start = start;
        this.step = new Pair(1, 1);
        this.maxRange = new Pair(1, 1);
    }
    @Override
    public Iterator<E> iterator() {
        return new BaseElementIterator<E>(start, step, maxRange);
    }
    @Override
    public int compareTo(BaseElementCollection o) {
        if (this.start.getX() == o.start.getX()) {
            return this.start.getY() - o.start.getY();
        }
        return this.start.getX() - o.start.getX();
    }
    @Override
    public String toString() {
        return "(" + start.toString() + ";" + step.toString() + ";" + maxRange.toString() + ")";
    }
}
