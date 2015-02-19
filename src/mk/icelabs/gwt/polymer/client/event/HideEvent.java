/**
 * Sencha GXT 3.1.1 - Sencha for GWT
 * Copyright(c) 2007-2014, Sencha, Inc.
 * licensing@sencha.com
 *
 * http://www.sencha.com/products/gxt/license/
 */
package mk.icelabs.gwt.polymer.client.event;

import mk.icelabs.gwt.polymer.client.event.HideEvent.HideHandler;
import mk.icelabs.gwt.polymer.client.ui.widgets.Component;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;

/**
 * Fires after a widget is hidden.
 */
public class HideEvent extends GwtEvent<HideHandler> {

  /**
   * Handler type.
   */
  private static Type<HideHandler> TYPE;

  /**
   * Gets the type associated with this event.
   * 
   * @return returns the handler type
   */
  public static Type<HideHandler> getType() {
    if (TYPE == null) {
      TYPE = new Type<HideHandler>();
    }
    return TYPE;
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  @Override
  public Type<HideHandler> getAssociatedType() {
    return (Type) TYPE;
  }

  public Component getSource() {
    return (Component) super.getSource();
  }

  @Override
  protected void dispatch(HideHandler handler) {
    handler.onHide(this);
  }
  
  /**
   * Handler for {@link HideEvent} events.
   */
  public interface HideHandler extends EventHandler {

    /**
     * Called after a widget is hidden.
     * 
     * @param event the {@link HideEvent} that was fired
     */
    void onHide(HideEvent event);

  }
  
  /**
   * A widget that implements this interface is a public source of
   * {@link HideEvent} events.
   */
  public interface HasHideHandlers {

    /**
     * Adds a {@link HideHandler} handler for {@link HideEvent} events.
     * 
     * @param handler the handler
     * @return the registration for the event
     */
    public HandlerRegistration addHideHandler(HideHandler handler);

  }

}
