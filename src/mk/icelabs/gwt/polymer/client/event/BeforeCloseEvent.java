/**
 * Sencha GXT 3.1.1 - Sencha for GWT
 * Copyright(c) 2007-2014, Sencha, Inc.
 * licensing@sencha.com
 *
 * http://www.sencha.com/products/gxt/license/
 */
package mk.icelabs.gwt.polymer.client.event;

import mk.icelabs.gwt.polymer.client.event.BeforeCloseEvent.BeforeCloseHandler;
import mk.icelabs.gwt.polymer.client.ui.widgets.Component;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;

/**
 * Fires before a item is closed.
 * 
 * * @param <T> the type about to be closed
 */
public class BeforeCloseEvent<T> extends GwtEvent<BeforeCloseHandler<T>> implements CancellableEvent {

  /**
   * Handler type.
   */
  private static Type<BeforeCloseHandler<?>> TYPE;

  /**
   * Gets the type associated with this event.
   * 
   * @return returns the handler type
   */
  public static Type<BeforeCloseHandler<?>> getType() {
    if (TYPE == null) {
      TYPE = new Type<BeforeCloseHandler<?>>();
    }
    return TYPE;
  }

  private T item;
  private boolean cancelled;
  
  public BeforeCloseEvent(T item) {
    this.item = item;
  }
  
  public T getItem() {
    return item;
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  @Override
  public Type<BeforeCloseHandler<T>> getAssociatedType() {
    return (Type) TYPE;
  }

  public Component getSource() {
    return (Component) super.getSource();
  }

  @Override
  public boolean isCancelled() {
    return cancelled;
  }

  @Override
  public void setCancelled(boolean cancelled) {
    this.cancelled = cancelled;
  }

  @Override
  protected void dispatch(BeforeCloseHandler<T> handler) {
    handler.onBeforeClose(this);
  }
  
  /**
   * Handler class for {@link BeforeCloseEvent} events.
   */
  public interface BeforeCloseHandler<T> extends EventHandler {

    /**
     * Called before tab item is closed. Listeners can cancel the action by
     * calling {@link BeforeCloseEvent#setCancelled(boolean)}.
     */
    void onBeforeClose(BeforeCloseEvent<T> event);
  }
  
  /**
   * A widget that implements this interface is a public source of
   * {@link BeforeCloseEvent} events.
   */
  public interface HasBeforeCloseHandlers<T> {

    /**
     * Adds a {@link BeforeCloseHandler} handler for {@link BeforeCloseEvent}
     * events.
     * 
     * @param handler the handler
     * @return the registration for the event
     */
    HandlerRegistration addBeforeCloseHandler(BeforeCloseHandler<T> handler);
  }

}
