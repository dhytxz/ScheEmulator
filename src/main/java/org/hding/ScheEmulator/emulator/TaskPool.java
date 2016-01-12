package org.hding.ScheEmulator.emulator;

import org.hding.ScheEmulator.hw.HTDT;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by hding on 1/11/16.
 */
public class TaskPool {
    Queue<Task> taskQueue;
    public TaskPool() {
        taskQueue = new PriorityQueue<Task>();
    }
    public void addTask(Task task) {
        taskQueue.offer(task);
    }
    public boolean isEmpty() {
        return taskQueue.isEmpty();
    }
    public Task getTask() {
        return taskQueue.poll();
    }
    public Task peekTask() {
        return taskQueue.peek();
    }
}
