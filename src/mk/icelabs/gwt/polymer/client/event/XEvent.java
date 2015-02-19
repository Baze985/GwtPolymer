/**
 * Sencha GXT 3.1.1 - Sencha for GWT
 * Copyright(c) 2007-2014, Sencha, Inc.
 * licensing@sencha.com
 *
 * http://www.sencha.com/products/gxt/license/
 */
package mk.icelabs.gwt.polymer.client.event;

import mk.icelabs.gwt.polymer.client.dom.ElementBase;
import mk.icelabs.gwt.polymer.client.ui.PGWT;
import mk.icelabs.gwt.polymer.client.ui.util.Point;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.Event;

public class XEvent extends Event {

  protected XEvent() {

  }

  /**
   * Returns true if the control or meta key was depressed.
   * 
   * @return true if control or meta
   */
  public final boolean getCtrlOrMetaKey() {
    return getCtrlKey() || getMetaKey();
  }

  /**
   * Returns the event target element.
   * 
   * @return the target element
   */
  public final ElementBase getEventTargetEl() {
    return getEventTarget().<ElementBase> cast();
  }

  /**
   * Returns the matching parent using the specified selector.
   * 
   * @param selector the CSS selector
   * @param maxDepth the maximum number of parents to search
   * @return the matching element or null
   */
  public final ElementBase getTargetEl(String selector, int maxDepth) {
    return getEventTargetEl().findParent(selector, maxDepth);
  }

  /**
   * Returns the mouse location.
   * 
   * @return the mouse location
   */
  public final Point getXY() {
    return new Point(getClientX(), getClientY());
  }

  /**
   * Returns true if the key is a "navigation" key.
   * 
   * @return the nav state
   */
  public final boolean isNavKeyPress() {
    return isNavKeyPress(getKeyCode());
  }

  /**
   * Returns true if the key is a "navigation" key.
   * 
   * @param k the key code
   * @return the nav state
   */
  public final boolean isNavKeyPress(int k) {
    return (k >= 33 && k <= 40) || k == KeyCodes.KEY_ESCAPE || k == KeyCodes.KEY_ENTER || k == KeyCodes.KEY_TAB;
  }

  /**
   * Returns <code>true</code> if the event is a right click.
   * 
   * @return the right click state
   */
  public final boolean isRightClick() {
    if (getButton() == Event.BUTTON_RIGHT || (PGWT.isMac() && getCtrlKey())) {
      return true;
    }
    return false;
  }

  /**
   * Returns true if the key is a "special" key.
   * 
   * @return the special state
   */
  public final boolean isSpecialKey() {
    return isSpecialKey(getKeyCode());
  }

  /**
   * Returns true if the key is a "special" key.
   * 
   * @param k the key code
   * @return the special state
   */
  public final boolean isSpecialKey(int k) {
    return isNavKeyPress(k) || k == KeyCodes.KEY_BACKSPACE || k == KeyCodes.KEY_CTRL || k == KeyCodes.KEY_SHIFT
        || k == KeyCodes.KEY_ALT || (k >= 19 && k <= 20) || (k >= 45 && k <= 46);
  }

  /**
   * Stops the event (stopPropagation and preventDefault).
   */
  public final void stopEvent() {
    stopPropagation();
    preventDefault();
  }

  /**
   * Returns <code>true</code> if the target of this event equals or is a child
   * of the given element.
   * 
   * @param element the element
   * @return the within state
   */
  public final boolean within(Element element) {
    return within(element, false);
  }

  /**
   * Returns <code>true</code> if the target of this event equals or is a child
   * of the given element.
   * 
   * @param element the element
   * @param toElement true to use {@link Event#getRelatedEventTarget()}
   * @return the within state
   */
  public final boolean within(Element element, boolean toElement) {
    if (Element.is(element)) {
      EventTarget target = toElement ? getRelatedEventTarget() : getEventTarget();
      if (Element.is(target)) {
        return element.isOrHasChild((Element) target.cast());
      }
    }
    return false;
  }
}
