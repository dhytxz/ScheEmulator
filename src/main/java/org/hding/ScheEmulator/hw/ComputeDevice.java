package org.hding.ScheEmulator.hw;


/**
 * Created by hding on 1/11/16.
 */
public class ComputeDevice extends BaseThread<HardwareThread> {
    int numHT;
    int numHSTPerHT;
    public ComputeDevice(int numHT, int numHSTPerHT) {
        super(numHT);
        this.numHT = numHT;
        this.numHSTPerHT = numHSTPerHT;
        for (HardwareThread ht : list) {
            ht = new HardwareThread(numHSTPerHT);
        }
    }
}
