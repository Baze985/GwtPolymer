package mk.icelabs.gwt.polymer.client.event;


import mk.icelabs.gwt.polymer.client.event.BeforeAddEvent.BeforeAddHandler;
import mk.icelabs.gwt.polymer.client.ui.widgets.Container;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;

/**
 * Fires before a widget is added to a container.
 */
public class BeforeAddEvent extends GwtEvent<BeforeAddHandler> implements CancellableEvent {

  /**
   * Handler type.
   */
  private static Type<BeforeAddHandler> TYPE;

  /**
   * Gets the type associated with this event.
   * 
   * @return returns the handler type
   */
  public static Type<BeforeAddHandler> getType() {
    if (TYPE == null) {
      TYPE = new Type<BeforeAddHandler>();
    }
    return TYPE;
  }

  private Widget widget;
  private int index;
  private boolean cancelled;

  public BeforeAddEvent(Widget widget, int index) {
    this.widget = widget;
  }

  @Override
  @SuppressWarnings({"unchecked", "rawtypes"})
  public Type<BeforeAddHandler> getAssociatedType() {
    return (Type) TYPE;
  }

  /**
   * Returns the insert index of the widget to be added.
   * 
   * @return the insert index
   */
  public int getIndex() {
    return index;
  }

  public Container getSource() {
    return (Container) super.getSource();
  }

  /**
   * Returns the widget to be added.
   * 
   * @return the widget to be added
   */
  public Widget getWidget() {
    return widget;
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
  protected void dispatch(BeforeAddHandler handler) {
    handler.onBeforeAdd(this);
  }
  
  /**
   * Handler for {@link BeforeAddEvent} events.
   */
  public interface BeforeAddHandler extends EventHandler {

    /**
     * Called before a widget is added to a container. The action can be cancelled
     * using {@link BeforeAddEvent#setCancelled(boolean)}.
     * 
     * @param event the {@link BeforeAddEvent} that was fired
     */
    void onBeforeAdd(BeforeAddEvent event);

  }
  
  /**
   * A widget that implements this interface is a public source of
   * {@link BeforeAddEvent} events.
   */
  public interface HasBeforeAddHandlers {

    /**
     * Adds a {@link BeforeAddEvent} handler.
     * 
     * @param handler the handler
     * @return the registration for the event
     */
    HandlerRegistration addBeforeAddHandler(BeforeAddHandler handler);
  }

}
