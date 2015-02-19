/**
 * Sencha GXT 3.1.1 - Sencha for GWT
 * Copyright(c) 2007-2014, Sencha, Inc.
 * licensing@sencha.com
 *
 * http://www.sencha.com/products/gxt/license/
 */
package mk.icelabs.gwt.polymer.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import mk.icelabs.gwt.polymer.client.event.UnregisterEvent.UnregisterHandler;

/**
 * Fires after an item is unregistered.
 */
public class UnregisterEvent<T> extends GwtEvent<UnregisterHandler<T>> {

  /**
   * Handler type.
   */
  private static Type<UnregisterHandler<?>> TYPE;

  /**
   * Gets the type associated with this event.
   * 
   * @return returns the handler type
   */
  public static Type<UnregisterHandler<?>> getType() {
    return TYPE != null ? TYPE : (TYPE = new Type<UnregisterHandler<?>>());
  }

  private T item;
  
  public UnregisterEvent(T item) {
    this.item = item;
  }
  
  @SuppressWarnings({"unchecked", "rawtypes"})
  @Override
  public Type<UnregisterHandler<T>> getAssociatedType() {
    return (Type) TYPE;
  }
  
  public T getItem() {
    return item;
  }

  @Override
  protected void dispatch(UnregisterHandler<T> handler) {
    handler.onUnregister(this);

  }
  
  /**
   * Handler class for {@link UnregisterEvent} events.
   */
  public interface UnregisterHandler<T> extends EventHandler {

    /**
     * Called after the object has been unregistered.
     */
    void onUnregister(UnregisterEvent<T> event);
  }
  
  /**
   * A widget that implements this interface is a public source of
   * {@link UnregisterEvent} events.
   */
  public interface HasUnregisterHandlers<T> {

    /**
     * Adds a {@link UnregisterEvent} handler.
     * 
     * @param handler the handler
     * @return the registration for the event
     */
    public HandlerRegistration addUnregisterHandler(UnregisterHandler<T> handler);

  }

}
