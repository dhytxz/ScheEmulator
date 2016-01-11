package org.hding.ScheEmulator.sw;

import org.hding.ScheEmulator.base.Pair;
import org.junit.Test;
import org.junit.Assert;


/**
 * Created by hding on 1/10/16.
 */
public class BaseElementCollectionTest {
    @Test(timeout = 200)
    public void testBaseElementCollection() {
        BaseElementCollection<BaseElement> groups =
                new BaseElementCollection<BaseElement>(new Pair(0, 0), new Pair(2, 2), new Pair(3, 7));
        for (BaseElement be : groups) {
            System.out.println(be);
        }
        Assert.assertTrue(true);
    }
}