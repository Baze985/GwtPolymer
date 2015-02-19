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
import com.google.gwt.user.client.ui.RootPanel;
import mk.icelabs.gwt.polymer.client.event.SubmitEvent.SubmitHandler;

/**
 * Fired when the form is submitted.
 */
public class SubmitEvent extends GwtEvent<SubmitHandler> {
  /**
   * A widget that implements this interface is a public source of
   * {@link SubmitEvent} events.
   */
  public interface HasSubmitHandlers {

    /**
     * Adds a {@link SubmitHandler} handler for {@link SubmitEvent} events.
     * 
     * @param handler the handler
     * @return the registration for the event
     */
    public HandlerRegistration addSubmitHandler(SubmitHandler handler);

  }

  /**
   * Handler for {@link SubmitEvent} events.
   */
  public interface SubmitHandler extends EventHandler {
    /**
     * Fired when the form is submitted.
     * 
     * <p>
     * The FormPanel must <em>not</em> be detached (i.e. removed from its parent
     * or otherwise disconnected from a {@link RootPanel}) until the submission
     * is complete. Otherwise, notification of submission will fail.
     * </p>
     * 
     * @param event the event
     */
    void onSubmit(SubmitEvent event);
  }

  /**
   * The event type.
   */
  private static Type<SubmitHandler> TYPE = new Type<SubmitHandler>();

  /**
   * Handler hook.
   * 
   * @return the handler hook
   */
  public static Type<SubmitHandler> getType() {
    if (TYPE == null) {
      TYPE = new Type<SubmitHandler>();
    }
    return TYPE;
  }

  private boolean canceled = false;

  /**
   * Cancel the form submit. Firing this will prevent a subsequent
   * {@link SubmitCompleteEvent} from being fired.
   */
  public void cancel() {
    this.canceled = true;
  }

  @Override
  public final Type<SubmitHandler> getAssociatedType() {
    return TYPE;
  }

  /**
   * Gets whether this form submit will be canceled.
   * 
   * @return <code>true</code> if the form submit will be canceled
   */
  public boolean isCanceled() {
    return canceled;
  }

  @Override
  protected void dispatch(SubmitHandler handler) {
    handler.onSubmit(this);
  }

}
