package mk.icelabs.gwt.polymer.client.ui.widgets;

import mk.icelabs.gwt.polymer.client.ui.util.Size;

import com.google.gwt.dom.client.Document;
import com.google.gwt.uibinder.client.UiChild;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;


/**
 * SimpleContainer takes one child and sizes it to match the container size.
 * 
 * <p/>
 * Code Snippet:
 * 
 * <pre>
  public void onModuleLoad() {
    SimpleContainer c = new SimpleContainer();
    c.add(new Label("Hello world"));
    RootPanel.get().add(c);
  }
 * </pre>
 */
public class SimpleContainer extends ResizeContainer<Widget> implements HasOneWidget {

  protected Widget widget;
  protected boolean resize = true;

  /**
   * Creates a simple container.
   */
  public SimpleContainer() {
    this(false);
  }

  protected SimpleContainer(boolean deferElement) {
    if (!deferElement) {
      setElement(Document.get().createDivElement());
    }
  }

  @Override
	protected void add(Widget child) {
	  throw new IllegalArgumentException("Methos should not be used, just set and get methods need to be used");
		//super.add(child);
	}

  @Override
  public Widget getWidget() {
    return widget;
  }

  /**
   * Returns true if the child widget is resized to container size.
   * 
   * @return true if resizing
   */
  public boolean isResize() {
    return resize;
  }

  /**
   * True to resize the child widget to match the container size (defaults to
   * true).
   * 
   * @param resize true to resize
   */
  public void setResize(boolean resize) {
    this.resize = resize;
  }

  @Override
  public void setWidget(IsWidget w) {
    setWidget(asWidgetOrNull(w));
  }

  @Override
  @UiChild(limit = 1, tagname = "widget")
  public void setWidget(Widget w) {
    if (widget != null) {
    	remove(widget);
    }
    widget = w;
    if (widget != null) {
      insert(widget, 0);
    }

  }

  @Override
  protected void doLayout() {
    if (widget != null && resize) {
      Size size = getContainerTarget().getSize();


      int width = -1;
      if (!isAutoWidth()) {
        width = size.getWidth();
      }
      int height = -1;
      if (!isAutoHeight()) {
        height = size.getHeight();
      }
      applyLayout(widget, width, height);
    }
  }

  @Override
  protected void onRemove(Widget child) {
    super.onRemove(child);
    if (widget == child) {
      widget = null;
    }
  }
}
