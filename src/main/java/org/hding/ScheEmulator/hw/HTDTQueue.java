package org.hding.ScheEmulator.hw;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by hding on 1/11/16.
 */
public class HTDTQueue {
    Queue<HTDT> runnableQueue;
    Queue<HTDT> finishedQueue;
    public HTDTQueue() {
        runnableQueue = new PriorityQueue<HTDT>();
        finishedQueue = new PriorityQueue<HTDT>();
    }
}
