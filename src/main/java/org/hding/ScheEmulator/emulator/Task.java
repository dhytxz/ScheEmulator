package org.hding.ScheEmulator.emulator;

import org.hding.ScheEmulator.hw.HTDT;

/**
 * Created by hding on 1/11/16.
 */
public class Task implements Comparable<Task> {
    int enterTimeStamp;
    HTDT table;
    @Override
    public int compareTo(Task o) {
        return this.enterTimeStamp - o.enterTimeStamp;
    }
}
