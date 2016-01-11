package org.hding.ScheEmulator.emulator;

import org.hding.ScheEmulator.hw.*;

/**
 * Created by hding on 1/11/16.
 */
public class Executor {
    TaskPool taskPool;
    ComputeDevice computeDevice;
    HTDTQueue hwQueue;
    Scheduler scheduler;
    int timeStamp;
    public Executor(TaskPool taskPool, int numHT, int numHSTPerHT) {
        this.taskPool = taskPool;
        this.computeDevice = new ComputeDevice(numHT, numHSTPerHT);
        this.hwQueue = new HTDTQueue();
        this.scheduler = new Scheduler();
        timeStamp = 0;
    }
    public void run() {
        while (true) {
            while (!taskPool.isEmpty() && taskPool.peekTask().getEnterTimeStamp() == timeStamp) {
                hwQueue.addToRunnable(taskPool.getTask());
            }
            boolean isAllFinished = true;
            for (HardwareThread ht : computeDevice) {
                isAllFinished = isAllFinished && scheduler.schedule(hwQueue, ht);
            }
            if (taskPool.isEmpty() && isAllFinished) {
                break;
            }
        }
    }
}
