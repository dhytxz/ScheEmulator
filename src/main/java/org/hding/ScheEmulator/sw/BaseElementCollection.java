package org.hding.ScheEmulator.sw;

import org.hding.ScheEmulator.base.Pair;

import java.util.Iterator;

/**
 * Created by hding on 1/10/16.
 */
public class BaseElementCollection
        implements Iterable<BaseElementCollection>, Comparable<BaseElementCollection> {
    Pair start;
    Pair step;
    Pair maxRange;
    public BaseElementCollection(BaseElementCollection o) {
        this.start = new Pair(o.start);
        this.step = new Pair(o.step);
        this.maxRange = new Pair(o.maxRange);
    }
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
    public Iterator<BaseElementCollection> iterator() {
        return new BaseElementIterator(start, step, maxRange);
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
