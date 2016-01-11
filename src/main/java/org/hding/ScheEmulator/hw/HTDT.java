package org.hding.ScheEmulator.hw;

import org.hding.ScheEmulator.base.HTStatus;
import org.hding.ScheEmulator.sw.Kernel;
import org.hding.ScheEmulator.sw.WorkGroup;

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
    public int getEnterTimeStamp() {
        return this.enterTimeStamp;
    }
    @Override
    public int compareTo(HTDT o) {
        if (this.priority == o.priority) {
            return this.enterTimeStamp - o.enterTimeStamp;
        }
        return o.priority - this.priority;
    }
}
