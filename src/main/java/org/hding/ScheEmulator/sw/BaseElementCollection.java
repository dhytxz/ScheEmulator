package org.hding.ScheEmulator.sw;

import org.hding.ScheEmulator.base.Pair;

import java.util.Iterator;

/**
 * Created by hding on 1/10/16.
 */
public class BaseElementCollection<E extends BaseElement> implements Iterable<E> {
    private Pair start;
    private Pair step;
    private Pair maxRange;
    public BaseElementCollection(Pair start, Pair step, Pair maxRange) {
        this.start = start;
        this.step = step;
        this.maxRange = maxRange;
    }
    @Override
    public Iterator<E> iterator() {
        return new BaseElementIterator<E>(start, step, maxRange);
    }
}
