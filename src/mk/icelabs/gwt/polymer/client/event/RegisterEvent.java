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
import mk.icelabs.gwt.polymer.client.event.RegisterEvent.RegisterHandler;

/**
 * Fires after an item is registered.
 */
public class RegisterEvent<T> extends GwtEvent<RegisterHandler<T>> {

  /**
   * Handler type.
   */
  private static Type<RegisterHandler<?>> TYPE;

  /**
   * Gets the type associated with this event.
   * 
   * @return returns the handler type
   */
  public static Type<RegisterHandler<?>> getType() {
    return TYPE != null ? TYPE : (TYPE = new Type<RegisterHandler<?>>());
  }

  private T item;
  
  public RegisterEvent(T item) {
    this.item = item;
  }
  
  @SuppressWarnings({"unchecked", "rawtypes"})
  @Override
  public Type<RegisterHandler<T>> getAssociatedType() {
    return (Type) TYPE;
  }
  
  public T getItem() {
    return item;
  }

  @Override
  protected void dispatch(RegisterHandler<T> handler) {
    handler.onRegister(this);

  }
  
  /**
   * Handler class for {@link RegisterEvent} events.
   */
  public interface RegisterHandler<T> extends EventHandler {

    /**
     * Called after the object has been registered.
     */
    void onRegister(RegisterEvent<T> event);
  }
  
  /**
   * A widget that implements this interface is a public source of
   * {@link RegisterEvent} events.
   */
  public interface HasRegisterHandlers<T> {

    /**
     * Adds a {@link RegisterEvent} handler.
     * 
     * @param handler the handler
     * @return the registration for the event
     */
    public HandlerRegistration addRegisterHandler(RegisterHandler<T> handler);

  }

}
