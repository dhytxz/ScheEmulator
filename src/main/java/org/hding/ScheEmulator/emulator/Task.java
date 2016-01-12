package org.hding.ScheEmulator.emulator;

import org.hding.ScheEmulator.hw.HTDT;
import org.hding.ScheEmulator.sw.Kernel;

/**
 * Created by hding on 1/11/16.
 */
public class Task implements Comparable<Task> {
    int enterTimeStamp;
    HTDT table;
    public Task(int enterTimeStamp, Kernel kernel, int priority) {
        this.enterTimeStamp = enterTimeStamp;
        this.table = new HTDT(kernel, enterTimeStamp, priority);
    }
    @Override
    public int compareTo(Task o) {
        return this.enterTimeStamp - o.enterTimeStamp;
    }
}
