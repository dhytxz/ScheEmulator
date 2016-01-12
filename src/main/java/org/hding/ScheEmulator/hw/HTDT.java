package org.hding.ScheEmulator.hw;

import org.hding.ScheEmulator.base.HTStatus;
import org.hding.ScheEmulator.sw.Kernel;
import org.hding.ScheEmulator.sw.WorkGroup;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by hding on 1/11/16.
 */
public class HTDT implements Comparable<HTDT> {
    Kernel kernel;
    int enterTimeStamp;
    int priority;
    HTStatus status;
    WorkGroup currWorkGroup;
    Queue<WorkGroup> groupQueue;
    public HTDT(Kernel kernel, int enterTimeStamp, int priority) {
        this.kernel = kernel;
        this.enterTimeStamp = enterTimeStamp;
        this.priority = priority;
        this.status = HTStatus.READY;
        currWorkGroup = null;
        groupQueue = new PriorityQueue<WorkGroup>();
    }
    @Override
    public int compareTo(HTDT o) {
        if (this.priority == o.priority) {
            return this.enterTimeStamp - o.enterTimeStamp;
        }
        return o.priority - this.priority;
    }
    @Override
    public String toString() {
        return "(" + enterTimeStamp + ";" + kernel.toString() + ";" + priority + ")";
    }
}
