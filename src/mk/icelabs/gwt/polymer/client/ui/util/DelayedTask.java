package mk.icelabs.gwt.polymer.client.ui.util;


import com.google.gwt.user.client.Timer;

/**
 * A <code>Timer</code> that is canceled if a new request is made.
 */
public abstract class DelayedTask {

  private Timer timer;

  /**
   * Creates a new delayed task.
   */
  public DelayedTask() {
    timer = new Timer() {
      public void run() {
        onExecute();
      }
    };
  }

  /**
   * Cancels the task.
   */
  public void cancel() {
    timer.cancel();
  }

  /**
   * Cancels any running timers and starts a new one.
   * 
   * @param delay the delay in ms
   */
  public void delay(int delay) {
    timer.cancel();
    if (delay > 0) {
      timer.schedule(delay);
    } else {
      timer.run();
    }
  }

  /**
   * Called when the task should execute.
   */
  public abstract void onExecute();

}
