package mk.icelabs.gwt.polymer.client.ui.widgets;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import mk.icelabs.gwt.polymer.client.dom.ElementBase;
import mk.icelabs.gwt.polymer.client.event.AddEvent;
import mk.icelabs.gwt.polymer.client.event.AddEvent.AddHandler;
import mk.icelabs.gwt.polymer.client.event.BeforeAddEvent;
import mk.icelabs.gwt.polymer.client.event.BeforeAddEvent.BeforeAddHandler;
import mk.icelabs.gwt.polymer.client.event.BeforeRemoveEvent;
import mk.icelabs.gwt.polymer.client.event.BeforeRemoveEvent.BeforeRemoveHandler;
import mk.icelabs.gwt.polymer.client.event.ContainerHandler;
import mk.icelabs.gwt.polymer.client.event.ContainerHandler.HasContainerHandlers;
import mk.icelabs.gwt.polymer.client.event.GroupingHandlerRegistration;
import mk.icelabs.gwt.polymer.client.event.HideEvent;
import mk.icelabs.gwt.polymer.client.event.HideEvent.HasHideHandlers;
import mk.icelabs.gwt.polymer.client.event.HideEvent.HideHandler;
import mk.icelabs.gwt.polymer.client.event.RemoveEvent;
import mk.icelabs.gwt.polymer.client.event.RemoveEvent.RemoveHandler;
import mk.icelabs.gwt.polymer.client.event.ShowEvent;
import mk.icelabs.gwt.polymer.client.event.ShowEvent.HasShowHandlers;
import mk.icelabs.gwt.polymer.client.event.ShowEvent.ShowHandler;
import mk.icelabs.gwt.polymer.client.ui.HasItemId;
import mk.icelabs.gwt.polymer.client.ui.util.ComponentHelper;
import mk.icelabs.gwt.polymer.client.ui.util.HasMargins;
import mk.icelabs.gwt.polymer.client.ui.util.Margins;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.AttachDetachException;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.WidgetCollection;


/**
 * Abstract base for components that can contain child widgets.
 */
public abstract class Container<T extends IsWidget> extends Component implements 
    HasContainerHandlers {

  private native static AttachDetachException.Command getAttachException() /*-{
		return @com.google.gwt.user.client.ui.AttachDetachException::attachCommand;
  }-*/;

  private native static AttachDetachException.Command getDetachException() /*-{
		return @com.google.gwt.user.client.ui.AttachDetachException::detachCommand;
  }-*/;

  private WidgetCollection children = new WidgetCollection(new HasWidgets() {
	
	@Override
	public boolean remove(Widget w) {
		return Container.this.remove(w);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Iterator<Widget> iterator() {
		return (Iterator<Widget>) Container.this.iterator();
	}
	
	@Override
	public void clear() {
		Container.this.clear();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void add(final Widget w) {
		Container.this.add((T) new IsWidget() {
			
			@Override
			public Widget asWidget() {
				return w;
			}
		});
	}
});

  private Map<Widget, GroupingHandlerRegistration> widgetMap = new HashMap<Widget, GroupingHandlerRegistration>();


  /**
   * Adds the specified widget to the container.
   * <p/>
   * If you override this method, please see {@link Panel#add(Widget)} for a
   * number of things you must take into consideration.
   * 
   * @param child the child widget to be added.
   * @throws UnsupportedOperationException if the derived class has not properly
   *           overridden the method. See {@link Panel#add(Widget)} for more
   *           information.
   */
  protected void add(T child) {
    insert(child, getWidgetCount());
  }
  
	@Override
	public void removeFromParent() {
		try {
			super.removeFromParent();
		} catch (IllegalStateException e) {
			callRemoveFromParentOnExp(this, e);
		}

	}
	
	@SuppressWarnings("unchecked")
	private void callRemoveFromParentOnExp(Widget w, IllegalStateException e){
		if (w.getParent() != null && w.getParent() instanceof Container)
			((Container<T>) w.getParent()).remove(this);
		else
			throw e;
	}

  /**
   * Adds the {@link AddHandler} to the Container
   * 
   * @param handler the handler
   * @return {@link HandlerRegistration}
   */
  public HandlerRegistration addAddHandler(AddHandler handler) {
    return addHandler(handler, AddEvent.getType());
  }

  /**
   * Adds the {@link BeforeAddHandler} to the Container
   * 
   * @param handler the handler
   * @return {@link HandlerRegistration}
   */
  public HandlerRegistration addBeforeAddHandler(BeforeAddHandler handler) {
    return addHandler(handler, BeforeAddEvent.getType());
  }

  /**
   * Adds the {@link BeforeRemoveHandler} to the Container
   * 
   * @param handler the handler
   * @return {@link HandlerRegistration}
   */
  public HandlerRegistration addBeforeRemoveHandler(BeforeRemoveHandler handler) {
    return addHandler(handler, BeforeRemoveEvent.getType());
  }

  /**
   * Adds the {@link ContainerHandler} to the Container
   * 
   * @param handler the handler
   * @return {@link HandlerRegistration}
   */
  public HandlerRegistration addContainerHandler(ContainerHandler handler) {
    GroupingHandlerRegistration reg = new GroupingHandlerRegistration();
    reg.add(addHandler(handler, BeforeAddEvent.getType()));
    reg.add(addHandler(handler, BeforeRemoveEvent.getType()));
    reg.add(addHandler(handler, AddEvent.getType()));
    reg.add(addHandler(handler, RemoveEvent.getType()));
    return reg;
  }

  /**
   * Adds the {@link RemoveHandler} to the Container
   * 
   * @param handler the handler
   * @return {@link HandlerRegistration}
   */
  public HandlerRegistration addRemoveHandler(RemoveHandler handler) {
    return addHandler(handler, RemoveEvent.getType());
  }

  /**
   * Clears the container's children
   * 
   */
  protected void clear() {
    Iterator<T> it = iterator();
    while (it.hasNext()) {
      it.next();
      it.remove();
    }
  }

  @Override
  public void disable() {
    super.disable();
    Iterator<T> it = iterator();
    while (it.hasNext()) {
      T w = it.next();
      if (w instanceof Component) {
        ((Component) w).disable();
      }
    }
  }

  @Override
  public void enable() {
    super.enable();
    Iterator<T> it = iterator();
    while (it.hasNext()) {
      T w = it.next();
      if (w instanceof Component) {
        ((Component) w).enable();
      }
    }
  }

  /**
   * Returns the widget whose element, or child element, matches the given
   * element.
   * 
   * @param elem the element
   * @return the matching widget or <code>null</code> if no match
   */
  public Widget findWidget(Element elem) {
    for (Widget w : children) {
      if (w.getElement().isOrHasChild(elem)) {
        return w;
      }
    }
    return null;
  }

  /**
   * Returns the child widget with the specified item id.
   * 
   * @param itemId the item id
   * @return the widget or <code>null</code> if no match
   */
  public Widget getItemByItemId(String itemId) {
    if (itemId == null) {
      return null;
    }
    for (Widget w : children) {
      if (w instanceof HasItemId) {
        if (itemId.equals(((HasItemId) w).getItemId())) {
          return w;
        }
      }
    }
    return null;
  }

  @SuppressWarnings("unchecked")
  protected T getWidget(int index) {
    return (T) getChildren().get(index);
  }

  protected int getWidgetCount() {
    return getChildren().size();
  }

  protected int getWidgetIndex(IsWidget child) {
    return getWidgetIndex(asWidgetOrNull(child));
  }

//  protected int getWidgetIndex(Widget child) {
//    return getChildren().indexOf(child);
//  }

  @SuppressWarnings("unchecked")
  protected Iterator<T> iterator() {
    return (Iterator<T>) getChildren().iterator();
  }

  protected boolean remove(int index) {
    return remove(getWidget(index));
  }

  protected boolean remove(IsWidget childInt) {
	  
	Widget child = asWidgetOrNull(childInt);
    // Validate.
    if (child.getParent() != this) {
      return false;
    }
    if (!fireCancellableEvent(new BeforeRemoveEvent(child))) {
      return false;
    }
    // Orphan.
    try {
      orphan(child);
    } finally {
      // Physical detach.
      doPhysicalDetach(child);

      // Logical detach.
      getChildren().remove(child);
      
      widgetMap.remove(child).removeHandler();

      onRemove(child);
    }

    fireEvent(new RemoveEvent(child));
    return true;
  }
  
  protected int adjustIndex(Widget child, int beforeIndex) {
    checkIndexBoundsForInsertion(beforeIndex);

    // Check to see if this widget is already a direct child.
    if (child.getParent() == this) {
      // If the Widget's previous position was left of the desired new
      // position
      // shift the desired position left to reflect the removal
      int idx = getWidgetIndex(child);
      if (idx < beforeIndex) {
        beforeIndex--;
      }
    }

    return beforeIndex;
  }

  protected final void adopt(Widget child) {
    assert (child.getParent() == null);
    ComponentHelper.setParent(this, child);
  }

  protected void checkIndexBoundsForInsertion(int index) {
    if (index < 0 || index > getWidgetCount()) {
      throw new IndexOutOfBoundsException();
    }
  }

  @Override
  protected void doAttachChildren() {
    AttachDetachException.tryCommand(children, getAttachException());
  }

  @Override
  protected void doDetachChildren() {
    AttachDetachException.tryCommand(children, getDetachException());
  }

  protected void doPhysicalAttach(Widget child, int beforeIndex) {
    getContainerTarget().insertChild(child.getElement(), beforeIndex);
  }

  protected void doPhysicalDetach(Widget child) {
    child.getElement().removeFromParent();
  }

  protected GroupingHandlerRegistration ensureGroupingHandlerRegistration(Widget widget) {
    GroupingHandlerRegistration g = widgetMap.get(widget);
    if (g == null) {
      g = new GroupingHandlerRegistration();
      widgetMap.put(widget, g);
    }
    return g;
  }

  /**
   * Gets the list of children contained in this panel.
   * 
   * @return a collection of child widgets
   */
  protected WidgetCollection getChildren() {
    return children;
  }

  protected ElementBase getContainerTarget() {
    return getElement();
  }

  /**
   * Insert a new child Widget into this Panel at a specified index, attaching
   * its Element to the specified container Element. The child Element will
   * either be attached to the container at the same index, or simply appended
   * to the container, depending on the value of <code>domInsert</code>.
   * 
   * @param child the child Widget to be added
   * @param beforeIndex the index before which <code>child</code> will be
   *          inserted
   **/
  protected void insert(T isW, int beforeIndex) {
	Widget child = asWidgetOrNull(isW);
	checkAdoptInstance(child);
    // Validate index; adjust if the widget is already a child of this
    // panel.
    beforeIndex = adjustIndex(child, beforeIndex);

    if (!fireCancellableEvent(new BeforeAddEvent(child, beforeIndex))) {
      return;
    }

   // GWT.log("parrent: " + child.getParent());
    // Detach new child.
	try {
		child.removeFromParent();
	} catch (IllegalStateException e) {
		callRemoveFromParentOnExp(child, e);
	}

	
 
    // Logical attach.
    getChildren().insert(child, beforeIndex);

    GroupingHandlerRegistration g = ensureGroupingHandlerRegistration(child);
    if (child instanceof HasShowHandlers) {
      g.add(((HasShowHandlers) child).addShowHandler(new ShowHandler() {
        @Override
        public void onShow(ShowEvent event) {
          onWidgetShow(event.getSource());
        }
      }));
    }

    if (child instanceof HasHideHandlers) {
      g.add(((HasHideHandlers) child).addHideHandler(new HideHandler() {
        @Override
        public void onHide(HideEvent event) {
          onWidgetHide(event.getSource());
        }
      }));
    }

    // Physical attach.
    doPhysicalAttach(child, beforeIndex);

    // Adopt.
    adopt(child);

    onInsert(beforeIndex, child);

    fireEvent(new AddEvent(child, beforeIndex));
  }

  protected void onInsert(int index, Widget child) {
    if (child.getLayoutData() instanceof HasMargins) {
      HasMargins m = (HasMargins) child.getLayoutData();
      Margins margins = m.getMargins();
      if (margins != null) {
        child.getElement().getStyle().setMarginTop(margins.getTop(), Unit.PX);
        child.getElement().getStyle().setMarginBottom(margins.getBottom(), Unit.PX);
        child.getElement().getStyle().setMarginLeft(margins.getLeft(), Unit.PX);
        child.getElement().getStyle().setMarginRight(margins.getRight(), Unit.PX);

      }
    }
  }

  
  protected void onRemove(Widget child) {
    child.getElement().getStyle().clearMarginBottom();
    child.getElement().getStyle().clearMarginTop();
    child.getElement().getStyle().clearMarginLeft();
    child.getElement().getStyle().clearMarginRight();
  }

  protected void onWidgetHide(Widget source) {

  }

  protected void onWidgetShow(Widget source) {

  }

  protected final void orphan(Widget child) {
    assert (child.getParent() == this);
    ComponentHelper.setParent(null, child);
  }
  
  protected T checkAdoptInstance(Widget w) {
		if (getChildren().contains(w)) {
			throw new IllegalArgumentException("Duplicate value: " + w);
		}
		return (T)w;
	}
}
