package org.hding.ScheEmulator.sw;

import org.hding.ScheEmulator.base.Pair;

/**
 * Created by hding on 1/10/16.
 */
public class Kernel extends BaseElement {
    int id;
    int enterTime;
    Pair range;
    public Kernel(Pair topLeft, Pair length) {
        super(topLeft, length);
    }
}
