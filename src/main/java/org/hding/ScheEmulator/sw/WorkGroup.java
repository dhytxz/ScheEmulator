package org.hding.ScheEmulator.sw;

import org.hding.ScheEmulator.base.Pair;

/**
 * Created by hding on 1/10/16.
 */
public class WorkGroup extends BaseElementCollection {
    int id;
    Kernel belongsTo;
    public WorkGroup(Pair topLeft, Pair length) {
        super(topLeft, length);
    }
    public WorkGroup(BaseElementCollection baseElementCollection) {
        super(baseElementCollection);
    }
}
