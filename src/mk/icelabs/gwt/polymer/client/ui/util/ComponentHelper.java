package mk.icelabs.gwt.polymer.client.ui.util;


import mk.icelabs.gwt.polymer.client.dom.PDOM;
import mk.icelabs.gwt.polymer.client.ui.widgets.Component;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.ui.Widget;

/**
 * Provides access to package protected methods of widget and convenience methods for easier
 * widget bookkeeping.
 */
public class ComponentHelper {
  
  /**
   * Find a the nearest widget that contains the given element.
   * 
   * @param element the element to start at
   * @return the containing element, or null if there is no widget
   */
  public static Widget getWidgetWithElement(Element element) {
    assert element != null : "Cannot find a widget for a null element";
    do {
      EventListener eventListener = DOM.getEventListener(element);
      if (eventListener instanceof Widget) {
        return (Widget) eventListener;
      }
      element = element.getParentElement();
    } while (element != null);
    return null;
  }

  /**
   * Attach a widget
   *
   * @param widget the widget to attach
   */
  public static native void doAttach(Widget widget)/*-{
    if (!!widget
        && !widget.@com.google.gwt.user.client.ui.Widget::isAttached()()) {
      widget.@com.google.gwt.user.client.ui.Widget::onAttach()();
    }
  }-*/;

  /**
   * Detaches a widget
   *
   * @param widget the widget to detach
   */
  public static native void doDetach(Widget widget) /*-{
    if (!!widget
        && widget.@com.google.gwt.user.client.ui.Widget::isAttached()()) {
      widget.@com.google.gwt.user.client.ui.Widget::onDetach()();
    }
  }-*/;

  /**
   * Returns the handler manager for the specified widget, creating it if
   * necessary.
   *
   * @param widget the widget
   * @return the handler manager
   */
  public static native HandlerManager ensureHandlers(Widget widget) /*-{
    if (!!widget) {
      return widget.@com.google.gwt.user.client.ui.Widget::ensureHandlers()();
    }
    return null;
  }-*/;

  /**
   * Retrieves the ID that has been set on a widget's element. If the widget's
   * element does not already have an ID, one will be automatically generated,
   * and that generated ID will be returned.
   *
   * @param widget The widget whose element's ID is to be retrieved. Must not be
   *          {@code null}.
   * @return The ID on the widget's element
   */
  public static String getWidgetId(Widget widget) {
    if (widget == null) {
      throw new IllegalArgumentException("Target widget must not be null.");
    }
    String id;
    if (widget instanceof Component) {
      id = ((Component) widget).getId();
    } else {
      // Non-Ext-GWT widget
      Element element = widget.getElement();
      id = element.getId();
      if (id.isEmpty()) {
        id = PDOM.getUniqueId();
        element.setId(id);
      }
    }
    return id;
  }

  /**
   * Determines if the widget has an Element
   *
   * @param widget the target Element
   * @return true if has an Element
   */
  public static native boolean hasElement(Widget widget) /*-{
    if (!!widget) {
      return widget.@com.google.gwt.user.client.ui.UIObject::element != null;
    }
    return false;
  }-*/;

  /**
   * Removes a handler from the widget
   *
   * @param widget the target widget
   * @param type the type
   * @param handler the handler to remove
   */
  public static native <H extends EventHandler> void removeHandler(Widget widget, Type<H> type, H handler) /*-{
    if (!!widget) {
      var h = widget.@com.google.gwt.user.client.ui.Widget::ensureHandlers()();
      h.@com.google.gwt.event.shared.HandlerManager::removeHandler(Lcom/google/gwt/event/shared/GwtEvent$Type;Lcom/google/gwt/event/shared/EventHandler;)(type,handler);
    }
  }-*/;

  /**
   * Sets the child to the parent widget
   *
   * @param parent the parent widget
   * @param child the child widget
   */
  public static native void setParent(Widget parent, Widget child) /*-{
    if (!!child) {
      child.@com.google.gwt.user.client.ui.Widget::setParent(Lcom/google/gwt/user/client/ui/Widget;)(parent);
    }
  }-*/;
  
  /**
   * Sets the child to the parent widget
   *
   * @param parent the parent widget
   * @param child the child widget
   */
  public static native Widget getParent(Widget child) /*-{
    if (!!child) {
      	return child.@com.google.gwt.user.client.ui.Widget::parent;
    }else
    	return null;
  }-*/;

}
