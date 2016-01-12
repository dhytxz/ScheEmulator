package org.hding.ScheEmulator.hw;


/**
 * Created by hding on 1/11/16.
 */
public class ComputeDevice extends BaseThread<HardwareThread> {
    int numHSTPerHT;
    public ComputeDevice(int numHT, int numHSTPerHT) {
        super(numHT);
        this.numHSTPerHT = numHSTPerHT;
        for (int i = 0; i < numHT; i++) {
            list.add(new HardwareThread(numHSTPerHT));
        }
    }
    public int getNumHT() {
        return listSize;
    }
}
