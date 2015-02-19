/**
 * Sencha GXT 3.1.1 - Sencha for GWT
 * Copyright(c) 2007-2014, Sencha, Inc.
 * licensing@sencha.com
 *
 * http://www.sencha.com/products/gxt/license/
 */
package mk.icelabs.gwt.polymer.client.event;

import mk.icelabs.gwt.polymer.client.event.CloseEvent.CloseHandler;
import mk.icelabs.gwt.polymer.client.ui.widgets.Component;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;

/**
 * Fires after a item is closed.
 */
public class CloseEvent<T> extends GwtEvent<CloseHandler<T>> {

  /**
   * Handler type.
   */
  private static Type<CloseHandler<?>> TYPE;

  /**
   * Gets the type associated with this event.
   * 
   * @return returns the handler type
   */
  public static Type<CloseHandler<?>> getType() {
    if (TYPE == null) {
      TYPE = new Type<CloseHandler<?>>();
    }
    return TYPE;
  }
  
  private T item;
  
  public CloseEvent(T item) {
    this.item = item;
  }
  
  @SuppressWarnings({"unchecked", "rawtypes"})
  @Override
  public Type<CloseHandler<T>> getAssociatedType() {
    return (Type) TYPE;
  }

  public T getItem() {
    return item;
  }

  public Component getSource() {
    return (Component) super.getSource();
  }

  @Override
  protected void dispatch(CloseHandler<T> handler) {
    handler.onClose(this);
  }
  
  /**
   * Handler class for {@link CloseEvent} events.
   * 
   * @param <T> the type being closed
   */
  public interface CloseHandler<T> extends EventHandler {

    /**
     * Called after tab item is closed.
     */
    void onClose(CloseEvent<T> event);
  }
  
  /**
   * A widget that implements this interface is a public source of
   * {@link CloseEvent} events.
   */
  public interface HasCloseHandlers<T> {

    /**
     * Adds a {@link CloseHandler} handler for {@link CloseEvent} events.
     * 
     * @param handler the handler
     * @return the registration for the event
     */
    HandlerRegistration addCloseHandler(CloseHandler<T> handler);
  }

}
