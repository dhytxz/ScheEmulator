package org.hding.ScheEmulator.hw;

import org.hding.ScheEmulator.base.HTStatus;
import org.hding.ScheEmulator.sw.BaseElementCollection;
import org.hding.ScheEmulator.sw.WorkGroup;

/**
 * Created by hding on 1/11/16.
 */
public class QueueManager {
    HTDTQueue hwQueue;
    public QueueManager() {
        this.hwQueue = new HTDTQueue();
    }
    public void add(HTDT table) {
        hwQueue.runnableQueue.offer(table);
    }
    public boolean isQueueEmpty() {
        return hwQueue.runnableQueue.size() == 0;
    }
    public WorkGroup getWorkGroup() {
        while (!hwQueue.runnableQueue.isEmpty()){
            HTDT temp = hwQueue.runnableQueue.peek();
            if (temp.status == HTStatus.RUNNING && temp.groupQueue.size() == 0) {
                if (hwQueue.runnableQueue.remove(temp)) {
                    hwQueue.finishedQueue.offer(temp);
                }
                temp.status = HTStatus.FINISHED;
            } else if (temp.status == HTStatus.READY) {
                for (BaseElementCollection baseElementCollection : temp.kernel) {
                    temp.groupQueue.offer(new WorkGroup(baseElementCollection));
                }
                temp.status = HTStatus.RUNNING;
                return temp.groupQueue.poll();
            } else {
                return temp.groupQueue.poll();
            }
        }
        return null;
    }
}
