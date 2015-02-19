/**
 * Sencha GXT 3.1.1 - Sencha for GWT
 * Copyright(c) 2007-2014, Sencha, Inc.
 * licensing@sencha.com
 *
 * http://www.sencha.com/products/gxt/license/
 */
package mk.icelabs.gwt.polymer.client.event;

import mk.icelabs.gwt.polymer.client.event.DeactivateEvent.DeactivateHandler;
import mk.icelabs.gwt.polymer.client.ui.widgets.Component;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;

/**
 * Fires after a widget is deactivated.
 */
public class DeactivateEvent<T> extends GwtEvent<DeactivateHandler<T>> {

  /**
   * Handler type.
   */
  private static Type<DeactivateHandler<?>> TYPE;

  /**
   * Gets the type associated with this event.
   * 
   * @return returns the handler type
   */
  public static Type<DeactivateHandler<?>> getType() {
    return TYPE != null ? TYPE : (TYPE = new Type<DeactivateHandler<?>>());
  }

  private T item;
  
  public DeactivateEvent(T item) {
    this.item = item;
  }
  
  @SuppressWarnings({"unchecked", "rawtypes"})
  @Override
  public Type<DeactivateHandler<T>> getAssociatedType() {
    return (Type) TYPE;
  }
  
  public T getItem() {
    return item;
  }

  @Override
  public Component getSource() {
    return (Component) super.getSource();
  }

  @Override
  protected void dispatch(DeactivateHandler<T> handler) {
    handler.onDeactivate(this);
  }
  
  /**
   * Handler class for {@link DeactivateEvent} events.
   */
  public interface DeactivateHandler<T> extends EventHandler {

    /**
     * Called after the widget has been deactivated.
     */
    void onDeactivate(DeactivateEvent<T> event);
  }
  
  /**
   * A widget that implements this interface is a public source of
   * {@link DeactivateEvent} events.
   */
  public interface HasDeactivateHandlers<T> {

    /**
     * Adds a {@link DeactivateEvent} handler.
     * 
     * @param handler the handler
     * @return the registration for the event
     */
    public HandlerRegistration addDeactivateHandler(DeactivateHandler<T> handler);

  }

}
