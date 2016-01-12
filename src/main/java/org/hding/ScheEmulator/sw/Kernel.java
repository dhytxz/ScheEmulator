package org.hding.ScheEmulator.sw;

import org.hding.ScheEmulator.base.Pair;

/**
 * Created by hding on 1/10/16.
 */
public class Kernel extends BaseElementCollection {
    int id;
    public Kernel(Pair start, Pair groupSize, Pair maxRange) {
        super(start, groupSize, maxRange);
    }
    public Kernel(BaseElementCollection baseElementCollection) {
        super(baseElementCollection);
    }
    public Kernel(Pair groupSize, Pair maxRange) {
        super(new Pair(0, 0), groupSize, maxRange);
    }
    public Pair getGroupSize() {
        return this.step;
    }
}
