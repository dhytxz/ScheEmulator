package org.hding.ScheEmulator.hw;

import org.hding.ScheEmulator.sw.WorkItem;

import java.util.*;

/**
 * Created by hding on 1/11/16.
 */
public class HardwareThread extends BaseThread<HardwareSubthread> {
    int numHST;
    Queue<WorkItem> queueItem;
    public HardwareThread(int numHST) {
        super(numHST);
        this.numHST = numHST;
        for (HardwareSubthread hst : list) {
            hst = new HardwareSubthread();
        }
        queueItem = new PriorityQueue<WorkItem>();
    }
    public Queue<WorkItem> getQueueItem() {
        return queueItem;
    }
}
