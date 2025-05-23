package us.codecraft.webmagic;

/**
 * Listener for spider ending event.
 * Allows custom actions when the spider finishes its job, is stopped, or encounters an unhandled exception.
 */
public interface SpiderEndListener {

    /**
     * Called when the spider completes all its tasks normally.
     * This is typically invoked when `exitWhenComplete` is true,
     * the scheduler is empty, and all worker threads have finished.
     *
     * @param spider The spider instance that completed.
     */
    void onSpiderCompleted(Spider spider);

    /**
     * Called when the spider is explicitly stopped by an external call to `spider.stop()`.
     *
     * @param spider The spider instance that was stopped.
     */
    void onSpiderForceStopped(Spider spider);

    /**
     * Called when the spider's main run loop is terminated due to an unhandled exception
     * or an interruption that wasn't gracefully handled as a normal stop/completion.
     *
     * @param spider The spider instance that was abnormally terminated.
     * @param throwable The throwable that caused the termination, can be null if termination was due to simple interruption.
     */
    void onSpiderAborted(Spider spider, Throwable throwable);
}
