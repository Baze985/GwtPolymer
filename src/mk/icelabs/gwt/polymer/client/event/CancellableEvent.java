package mk.icelabs.gwt.polymer.client.event;


/**
 * Interface for events that can be cancelled.
 */
public interface CancellableEvent {

  /**
   * Returns true if the event is cancelled.
   * 
   * @return true for cancelled
   */
  public boolean isCancelled();

  /**
   * True to cancel the event.
   * 
   * @param cancel true to cancel
   */
  public void setCancelled(boolean cancel);

}