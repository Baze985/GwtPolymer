/**
 * Sencha GXT 3.1.1 - Sencha for GWT
 * Copyright(c) 2007-2014, Sencha, Inc.
 * licensing@sencha.com
 *
 * http://www.sencha.com/products/gxt/license/
 */
package mk.icelabs.gwt.polymer.client.event;

import java.text.ParseException;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import mk.icelabs.gwt.polymer.client.event.ParseErrorEvent.ParseErrorHandler;

public class ParseErrorEvent extends GwtEvent<ParseErrorHandler> {

  /**
   * A widget that implements this interface is a public source of
   * {@link ParseErrorEvent} events.
   */
  public interface HasParseErrorHandlers {

    /**
     * Adds a {@link ParseErrorHandler} handler for {@link ParseErrorEvent}
     * events.
     * 
     * @param handler the handler
     * @return the registration for the event
     */
    HandlerRegistration addParseErrorHandler(ParseErrorHandler handler);
  }

  /**
   * Handler for {@link ParseErrorEvent} events.
   */
  public interface ParseErrorHandler extends EventHandler {

    void onParseError(ParseErrorEvent event);

  }

  /**
   * Handler type.
   */
  private static Type<ParseErrorHandler> TYPE;

  private ParseException exception;
  private String value;

  public ParseErrorEvent(String errorValue, ParseException exception) {
    this.value = errorValue;
    this.exception = exception;
  }

  /**
   * Returns the parse exception.
   * 
   * @return the exception
   */
  public ParseException getException() {
    return exception;
  }

  /**
   * Returns the value that could not be parsed.
   * 
   * @return the value
   */
  public String getErrorValue() {
    return value;
  }

  /**
   * Gets the type associated with this event.
   * 
   * @return returns the handler type
   */
  public static Type<ParseErrorHandler> getType() {
    return TYPE != null ? TYPE : (TYPE = new Type<ParseErrorHandler>());
  }

  @SuppressWarnings({"rawtypes", "unchecked"})
  @Override
  public Type<ParseErrorHandler> getAssociatedType() {
    return (Type) TYPE;
  }

  @Override
  protected void dispatch(ParseErrorHandler handler) {
    handler.onParseError(this);
  }

}
