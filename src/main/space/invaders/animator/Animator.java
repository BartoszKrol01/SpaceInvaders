package main.space.invaders.animator;

import main.space.invaders.exception.thread.ThreadSleepException;
import main.space.invaders.exception.thread.ThreadWaitException;

public abstract class Animator implements Runnable {

    public void resumeAnimation() {
        synchronized (this) {
            this.notify();
        }
    }

    protected void pauseAnimation() {
        try {
            synchronized (this) {
                this.wait();
            }
        } catch (InterruptedException e) {
            throw new ThreadWaitException("Exception during wait", e);
        }
    }

    protected void sleepTryCatch(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new ThreadSleepException("Exception during sleep", e);
        }
    }

}
