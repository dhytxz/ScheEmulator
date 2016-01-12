package org.hding.ScheEmulator.hw;

import org.hding.ScheEmulator.sw.WorkGroup;
import org.hding.ScheEmulator.sw.WorkItem;


/**
 * Created by hding on 1/11/16.
 */
public class Scheduler {
    public Scheduler() {
    }
    public boolean schedule(QueueManager queueManager, HardwareThread hardwareThread) {
        if (hardwareThread.getQueueItem().size() == 0 && queueManager.isQueueEmpty()) {
            return true;
        }
        if (hardwareThread.getQueueItem().size() == 0) {
            WorkGroup temp = queueManager.getWorkGroup();
            if (temp == null ) {
                return true;
            }
            for (WorkItem wi : temp) {
                hardwareThread.getQueueItem().offer(wi);
            }
        }
        //consume remaining work items
        for (HardwareSubthread hardwareSubthread : hardwareThread) {
            if (!hardwareThread.getQueueItem().isEmpty()) {
                hardwareSubthread.workItem = hardwareThread.getQueueItem().poll();
            } else {
                break;
            }
        }
        if (hardwareThread.getQueueItem().isEmpty()) {
            return true;
        }
        return false;
    }
}
