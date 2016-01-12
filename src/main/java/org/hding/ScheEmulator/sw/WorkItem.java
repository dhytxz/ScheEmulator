package org.hding.ScheEmulator.sw;

import org.hding.ScheEmulator.base.Pair;

/**
 * Created by hding on 1/10/16.
 */
public class WorkItem extends BaseElementCollection {
    int id;
    WorkGroup belongsTo;
    public WorkItem(Pair topLeft) {
        super(topLeft);
    }
    public WorkItem(BaseElementCollection baseElementCollection) {
        super(baseElementCollection);
    }
}
