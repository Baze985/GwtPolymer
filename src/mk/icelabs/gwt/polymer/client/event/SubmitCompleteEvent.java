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
import mk.icelabs.gwt.polymer.client.event.SubmitCompleteEvent.SubmitCompleteHandler;

/**
 * Fired when a form has been submitted successfully.
 */
public class SubmitCompleteEvent extends GwtEvent<SubmitCompleteHandler> {
  /**
   * A widget that implements this interface is a public source of
   * {@link SubmitCompleteEvent} events.
   */
  public interface HasSubmitCompleteHandlers {

    /**
     * Adds a {@link SubmitCompleteHandler} handler for
     * {@link SubmitCompleteEvent} events.
     * 
     * @param handler the handler
     * @return the registration for the event
     */
    public HandlerRegistration addSubmitCompleteHandler(SubmitCompleteHandler handler);

  }

  /**
   * Handler for {@link SubmitCompleteEvent} events.
   */
  public interface SubmitCompleteHandler extends EventHandler {
    /**
     * Fired when a form has been submitted successfully.
     * 
     * @param event the event
     */
    void onSubmitComplete(SubmitCompleteEvent event);
  }

  /**
   * The event type.
   */
  private static Type<SubmitCompleteHandler> TYPE;

  /**
   * Handler hook.
   * 
   * @return the handler hook
   */
  public static Type<SubmitCompleteHandler> getType() {
    if (TYPE == null) {
      TYPE = new Type<SubmitCompleteHandler>();
    }
    return TYPE;
  }

  private String resultHtml;

  /**
   * Create a submit complete event.
   * 
   * @param resultsHtml the results from submitting the form
   */
  public SubmitCompleteEvent(String resultsHtml) {
    this.resultHtml = resultsHtml;
  }

  @Override
  public final Type<SubmitCompleteHandler> getAssociatedType() {
    return TYPE;
  }

  /**
   * Gets the result text of the form submission.
   * 
   * @return the result html, or <code>null</code> if there was an error reading
   *         it. The result html can be <code>null</code> as a result of
   *         submitting a form to a different domain.
   */
  public String getResults() {
    return resultHtml;
  }

  @Override
  protected void dispatch(SubmitCompleteHandler handler) {
    handler.onSubmitComplete(this);
  }
}
