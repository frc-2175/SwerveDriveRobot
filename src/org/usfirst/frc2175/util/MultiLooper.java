package org.usfirst.frc2175.util;

import java.util.Vector;

public class MultiLooper implements Loopable {
    private Looper looper;
    private Vector<Loopable> loopables = new Vector<Loopable>();

    public MultiLooper(long period) {
        looper = new Looper(this, period);
    }

    @Override
    public void update() {
        int i;
        for (i = 0; i < loopables.size(); ++i) {
            Loopable loopable = loopables.elementAt(i);
            if (loopable != null) {
                loopable.update();
            }
        }
    }

    public void enable() {
        looper.enable();
    }

    public void disable() {
        looper.disable();
    }

    public void addLoopable(Loopable loopable) {
        loopables.addElement(loopable);
    }

}
