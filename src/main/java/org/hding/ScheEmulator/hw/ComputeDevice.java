package org.hding.ScheEmulator.hw;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hding on 1/11/16.
 */
public class ComputeDevice implements Iterable<HardwareThread> {
    List<HardwareThread> listHT;
    int numHT;
    int numHSTPerHT;
    public ComputeDevice(int numHT, int numHSTPerHT) {
        this.numHT = numHT;
        this.numHSTPerHT = numHSTPerHT;
        listHT = new ArrayList<HardwareThread>(numHT);
        for (HardwareThread ht : listHT) {
            ht = new HardwareThread(numHSTPerHT);
        }
    }
    class ComputeDeviceIterator implements Iterator<HardwareThread> {
        @Override
        public boolean hasNext() {
            return false;
        }
        @Override
        public HardwareThread next() {
            return null;
        }
        @Override
        public void remove() {

        }
    }
    @Override
    public Iterator<HardwareThread> iterator() {
        return new ComputeDeviceIterator();
    }

}
