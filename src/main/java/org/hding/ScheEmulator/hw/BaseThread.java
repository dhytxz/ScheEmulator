package org.hding.ScheEmulator.hw;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hding on 1/11/16.
 */
public class BaseThread<E> implements Iterable<E> {
    List<E> list;
    int listSize;
    public BaseThread(int listSize) {
        this.listSize = listSize;
        list = new ArrayList<E>(listSize);
    }
    class BaseThreadIterator implements Iterator<E> {
        private List<E> list;
        private int p;
        public BaseThreadIterator(List<E> list) {
            this.list = list;
            this.p = 0;
        }
        @Override
        public boolean hasNext() {
            return p < list.size();
        }
        @Override
        public E next() {
            return list.get(p++);
        }
    }
    @Override
    public Iterator<E> iterator() {
        return new BaseThreadIterator(list);
    }
}
