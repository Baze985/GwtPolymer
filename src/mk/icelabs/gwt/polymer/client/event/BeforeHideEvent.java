/**
 * Sencha GXT 3.1.1 - Sencha for GWT
 * Copyright(c) 2007-2014, Sencha, Inc.
 * licensing@sencha.com
 *
 * http://www.sencha.com/products/gxt/license/
 */
package mk.icelabs.gwt.polymer.client.event;

import mk.icelabs.gwt.polymer.client.event.BeforeHideEvent.BeforeHideHandler;
import mk.icelabs.gwt.polymer.client.ui.widgets.Component;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;

/**
 * Fires before a widget is hidden.
 */
public class BeforeHideEvent extends GwtEvent<BeforeHideHandler> implements CancellableEvent {

  /**
   * Handler type.
   */
  private static Type<BeforeHideHandler> TYPE;

  /**
   * Gets the type associated with this event.
   * 
   * @return returns the handler type
   */
  public static Type<BeforeHideHandler> getType() {
    if (TYPE == null) {
      TYPE = new Type<BeforeHideHandler>();
    }
    return TYPE;
  }

  private boolean cancelled;

  @SuppressWarnings({"unchecked", "rawtypes"})
  @Override
  public Type<BeforeHideHandler> getAssociatedType() {
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
  protected void dispatch(BeforeHideHandler handler) {
    handler.onBeforeHide(this);
  }
  
  /**
   * Handler for {@link BeforeHideEvent} events.
   */
  public interface BeforeHideHandler extends EventHandler {

    /**
     * Called before a widget is hidden. The action can be cancelled using
     * {@link BeforeHideEvent#setCancelled(boolean)}.
     * 
     * @param event the {@link BeforeHideEvent} that was fired
     */
    void onBeforeHide(BeforeHideEvent event);

  }
  
  /**
   * A widget that implements this interface is a public source of
   * {@link BeforeHideEvent} events.
   */
  public interface HasBeforeHideHandlers {

    /**
     * Adds a {@link BeforeHideHandler} handler for {@link BeforeHideEvent}
     * events.
     * 
     * @param handler the handler
     * @return the registration for the event
     */
    public HandlerRegistration addBeforeHideHandler(BeforeHideHandler handler);

  }

}
