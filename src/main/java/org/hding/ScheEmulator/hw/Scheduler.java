package org.hding.ScheEmulator.hw;

import org.hding.ScheEmulator.sw.BaseElementCollection;
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
            for (BaseElementCollection baseElementCollection : temp) {
                hardwareThread.getQueueItem().offer(new WorkItem(baseElementCollection));
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
