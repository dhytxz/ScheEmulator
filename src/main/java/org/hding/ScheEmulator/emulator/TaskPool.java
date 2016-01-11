package org.hding.ScheEmulator.emulator;

import org.hding.ScheEmulator.hw.HTDT;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by hding on 1/11/16.
 */
public class TaskPool {
    Queue<HTDT> taskQueue;
    public TaskPool() {
        taskQueue = new PriorityQueue<HTDT>(new TaskComparator());
    }
    class TaskComparator implements Comparator<HTDT> {
        @Override
        public int compare(HTDT o0, HTDT o1) {
            return o0.getEnterTimeStamp() - o1.getEnterTimeStamp();
        }
    }
    public void addTask(HTDT table) {
        taskQueue.offer(table);
    }
    public boolean isEmpty() {
        return taskQueue.isEmpty();
    }
    public HTDT getTask() {
        return taskQueue.poll();
    }
    public HTDT peekTask() {
        return taskQueue.peek();
    }
}
