package mk.icelabs.gwt.polymer.client.ui.widgets;

import mk.icelabs.gwt.polymer.client.dom.ElementBase;
import mk.icelabs.gwt.polymer.client.ui.util.Rectangle;
import mk.icelabs.gwt.polymer.client.ui.util.Size;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.ProvidesResize;
import com.google.gwt.user.client.ui.RequiresResize;
import com.google.gwt.user.client.ui.Widget;


/**
 * A base class for layout containers that require resize support.
 */
public abstract class ResizeContainer<W extends IsWidget> extends Container<W> implements RequiresResize, ProvidesResize {


  public void onResize() {
    if (isAttached()) {
      Size s = ElementBase.as(getElement().getParentElement()).getSize(true);
      setPixelSize(s.getWidth(), s.getHeight());
    }
  }

  protected void applyLayout(final Widget widget, int width, int height) {
    if (widget instanceof Component) {
      int ww = width == -1 ? Integer.MIN_VALUE : width;
      int hh = height == -1 ? Integer.MIN_VALUE : height;
      ((Component) widget).setPixelSize(ww, hh);
    } else {
      ElementBase.as(widget.getElement()).setSize(width, height, true);
      if (widget instanceof RequiresResize) {
        Scheduler.get().scheduleDeferred(new ScheduledCommand() {
          @Override
          public void execute() {
            ((RequiresResize) widget).onResize();
          }
        });
      }
    }
  }

  protected void applyLayout(final Widget component, Rectangle box) {
    if (component instanceof Component) {
      Component c = (Component) component;
      c.setPosition(box.getX(), box.getY());
      applyLayout(c, box.getWidth(), box.getHeight());
    } else {
      ElementBase.as(component.getElement()).setLeftTop(box.getX(), box.getY());
      applyLayout(component, box.getWidth(), box.getHeight());
    }
  }

  protected abstract void doLayout();


  
//  protected boolean isWidgetVisible(Widget w) {
//    return !ElementBase.as(w.getElement()).isStyleAttribute("display", "none");
//  }

  protected void onBeforeDoLayout() {
  }

  @Override
  protected void onLoad() {
    super.onLoad();
    
  }

  @Override
  protected void onResize(int width, int height) {
    super.onResize(width, height);
    
  }

 }
