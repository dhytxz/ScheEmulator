package org.hding.ScheEmulator.emulator;

import org.hding.ScheEmulator.hw.*;

/**
 * Created by hding on 1/11/16.
 */
public class Executor {
    TaskPool taskPool;
    ComputeDevice computeDevice;
    QueueManager queueManager;
    Scheduler scheduler;
    int timeStamp;
    public Executor(TaskPool taskPool, int numHT, int numHSTPerHT) {
        this.taskPool = taskPool;
        this.computeDevice = new ComputeDevice(numHT, numHSTPerHT);
        this.queueManager = new QueueManager();
        this.scheduler = new Scheduler();
        timeStamp = 0;
    }
    public void run() {
        while (true) {
            while (!taskPool.isEmpty() && taskPool.peekTask().enterTimeStamp == timeStamp) {
                queueManager.add(taskPool.getTask().table);
            }
            boolean isAllFinished = true;
            for (HardwareThread hardwareThread : computeDevice) {
                isAllFinished = isAllFinished && scheduler.schedule(queueManager, hardwareThread);
            }
            if (taskPool.isEmpty() && isAllFinished) {
                break;
            }
            timeStamp++;
        }
    }
}
