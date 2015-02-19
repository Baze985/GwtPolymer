package mk.icelabs.gwt.polymer.client.ui.util;


import mk.icelabs.gwt.polymer.client.ui.PGWT;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;

/**
 * Provides a convenient wrapper for normalized keyboard navigation. Provides an
 * easy way to implement custom navigation schemes for any UI widget.
 */
public class KeyNav {

  class KeyNavHandler implements KeyDownHandler, KeyPressHandler {

    @Override
    public void onKeyDown(KeyDownEvent event) {
      handleEvent(event.getNativeEvent());
    }

    @Override
    public void onKeyPress(KeyPressEvent event) {
      handleEvent(event.getNativeEvent());
    }

  }

  private static int keyEvent;
  private Widget component;
  private boolean cancelBubble;

  private boolean preventDefault;

  static {
    if (PGWT.isIE() || PGWT.isGecko() || PGWT.isWebKit()) {
      keyEvent = Event.ONKEYDOWN;
    } else {
      keyEvent = Event.ONKEYPRESS;
    }
  }

  /**
   * Returns the key event type which varies by browser.
   * 
   * @return the key event type
   */
  public static int getKeyEvent() {
    return keyEvent;
  }

  private KeyNavHandler handler = new KeyNavHandler();
  private HandlerRegistration registration;

  /**
   * Creates a new KeyNav without a target widget. Events must be passed to the
   * {@link #handleEvent(NativeEvent)} method.
   */
  public KeyNav() {

  }

  /**
   * Creates a new key nav for the specified target. The KeyNav will listen for
   * the key events.
   * 
   * @param target the target widget
   */
  public KeyNav(Widget target) {
    bind(target);
  }

  /**
   * Binds the key nav to the widget.
   * 
   * @param target the target widget
   */
  public void bind(final Widget target) {
    if (this.component != null) {
      registration.removeHandler();
    }
    if (target != null) {
      if (keyEvent == Event.ONKEYDOWN) {
        registration = target.addDomHandler(handler, KeyDownEvent.getType());
      } else {
        registration = target.addDomHandler(handler, KeyPressEvent.getType());
      }
    }
    this.component = target;
  }

  /**
   * Returns the cancel bubble state.
   * 
   * @return true if bubbling is cancelled
   */
  public boolean getCancelBubble() {
    return cancelBubble;
  }

  /**
   * Returns the target widget.
   * 
   * @return the target widget
   */
  public Widget getComponent() {
    return component;
  }

  /**
   * Returns true if the default event action is being cancelled.
   * 
   * @return true if preventing default
   */
  public boolean getPreventDefault() {
    return preventDefault;
  }

  public void handleEvent(NativeEvent event) {
    int code = event.getKeyCode();

    NativeEvent e = event;

    String type = event.getType();

    if ("keydown".equals(type) && keyEvent == Event.ONKEYDOWN || "keypress".equals(type)
        && keyEvent == Event.ONKEYPRESS) {

    } else {
      return;
    }

    if (component != null && component.getElement() != (Element) e.getCurrentEventTarget().cast()) {
      return;
    }

    if (cancelBubble) {
      event.stopPropagation();
    }
    if (preventDefault) {
      event.preventDefault();
    }

    onKeyPress(e);

    switch (code) {
      case KeyCodes.KEY_ALT:
        onAlt(e);
        break;
      case KeyCodes.KEY_BACKSPACE:
        onBackspace(e);
        break;
      case KeyCodes.KEY_CTRL:
        onControl(e);
        break;
      case KeyCodes.KEY_DELETE:
        onDelete(e);
        break;
      case KeyCodes.KEY_DOWN:
        onDown(e);
        break;
      case KeyCodes.KEY_END:
        onEnd(e);
        break;
      case KeyCodes.KEY_ENTER:
        onEnter(e);
        break;
      case KeyCodes.KEY_ESCAPE:
        onEsc(e);
        break;
      case KeyCodes.KEY_HOME:
        onHome(e);
        break;
      case KeyCodes.KEY_LEFT:
        onLeft(e);
        break;
      case KeyCodes.KEY_PAGEDOWN:
        onPageDown(e);
        break;
      case KeyCodes.KEY_PAGEUP:
        onPageUp(e);
        break;
      case KeyCodes.KEY_SHIFT:
        onShift(e);
        break;
      case KeyCodes.KEY_TAB:
        onTab(e);
        break;
      case KeyCodes.KEY_RIGHT:
        onRight(e);
        break;
      case KeyCodes.KEY_UP:
        onUp(e);
        break;
    }
  }

  public void onAlt(NativeEvent evt) {

  }

  public void onBackspace(NativeEvent evt) {

  }

  public void onControl(NativeEvent evt) {

  }

  public void onDelete(NativeEvent evt) {

  }

  public void onDown(NativeEvent evt) {

  }

  public void onEnd(NativeEvent evt) {

  }

  public void onEnter(NativeEvent evt) {

  }

  public void onEsc(NativeEvent evt) {

  }

  public void onHome(NativeEvent evt) {

  }

  public void onKeyPress(NativeEvent evt) {

  }

  public void onLeft(NativeEvent evt) {

  }

  public void onPageDown(NativeEvent evt) {

  }

  public void onPageUp(NativeEvent evt) {

  }

  public void onRight(NativeEvent evt) {

  }

  public void onShift(NativeEvent evt) {

  }

  public void onTab(NativeEvent evt) {

  }

  public void onUp(NativeEvent evt) {

  }

  /**
   * True to stop event bubbling when the key nav intercepts a key (defaults to
   * false).
   * 
   * @param cancelBubble the cancel bubble state
   */
  public void setCancelBubble(boolean cancelBubble) {
    this.cancelBubble = cancelBubble;
  }

  /**
   * True to prevent the default action of the key event when the key nav
   * intercepts a key (defaults to false).
   * 
   * @param preventDefault true to prevent the default
   */
  public void setPreventDefault(boolean preventDefault) {
    this.preventDefault = preventDefault;
  }

}
