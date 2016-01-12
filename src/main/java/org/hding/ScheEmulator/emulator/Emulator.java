package org.hding.ScheEmulator.emulator;

import org.hding.ScheEmulator.base.Pair;
import org.hding.ScheEmulator.sw.Kernel;

/**
 * Created by hding on 1/11/16.
 */
public class Emulator {
    public static void main(String[] args) {
        TaskPool taskPool = new TaskPool();
        Executor executor = new Executor(taskPool, 2, 2);
        taskPool.addTask(new Task(0,
                                  new Kernel(new Pair(1, 3), new Pair(1, 9)),
                                  50));
        taskPool.addTask(new Task(1,
                                  new Kernel(new Pair(1, 3), new Pair(1, 9)),
                                  50));
        taskPool.addTask(new Task(4,
                                  new Kernel(new Pair(1, 3), new Pair(1, 9)),
                                  100));
        executor.run();
        System.out.print(executor.timeStamp);
    }
}
