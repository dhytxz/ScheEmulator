package org.hding.ScheEmulator.hw;

import org.hding.ScheEmulator.sw.WorkItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by hding on 1/11/16.
 */
public class HardwareThread {
    int numHST;
    List<HardwareSubthread> listHST;
    Queue<WorkItem> queueItem;
    public HardwareThread(int numHST) {
        this.numHST = numHST;
        listHST = new ArrayList<HardwareSubthread>(numHST);
        for (HardwareSubthread hst : listHST) {
            hst = new HardwareSubthread();
        }
    }
}
