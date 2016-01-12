package org.hding.ScheEmulator.hw;

import org.hding.ScheEmulator.sw.WorkItem;

import java.util.*;

/**
 * Created by hding on 1/11/16.
 */
public class HardwareThread extends BaseThread<HardwareSubthread> {
    Queue<WorkItem> queueItem;
    public HardwareThread(int numHST) {
        super(numHST);
        for (int i = 0; i < numHST; i++) {
            list.add(new HardwareSubthread());
        }
        queueItem = new PriorityQueue<WorkItem>();
    }
    public Queue<WorkItem> getQueueItem() {
        return queueItem;
    }
    public int getNumHST() {
        return listSize;
    }
}
