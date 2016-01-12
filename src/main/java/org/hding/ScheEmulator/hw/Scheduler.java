package org.hding.ScheEmulator.hw;

import org.hding.ScheEmulator.sw.WorkGroup;
import org.hding.ScheEmulator.sw.WorkItem;

/**
 * Created by hding on 1/11/16.
 */
public class Scheduler {
    public Scheduler() {
    }
    public boolean schedule(QueueManager queueManager, HardwareThread ht) {
        if (ht.getQueueItem().size() == 0 && queueManager.isQueueEmpty()) {
            return true;
        }
        if (ht.getQueueItem().size() == 0) {
            WorkGroup temp = queueManager.getWorkGroup();
            for (WorkItem wi : temp) {
                ht.getQueueItem().offer(wi);
            }
        }
        //consume remaining work items
        return false;
    }
}
