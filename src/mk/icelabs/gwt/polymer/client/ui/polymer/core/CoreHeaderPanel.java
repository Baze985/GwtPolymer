package mk.icelabs.gwt.polymer.client.ui.polymer.core;

import mk.icelabs.gwt.polymer.client.dom.polymer.core.CoreHeaderPanelElement;
import mk.icelabs.gwt.polymer.client.event.polymer.EventCoreBase;
import mk.icelabs.gwt.polymer.client.event.polymer.EventHandlerCore;
import mk.icelabs.gwt.polymer.client.ui.widgets.Container;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

public class CoreHeaderPanel extends Container<Widget> {

	
	
	public static final String STYLE = "";
	

	public static enum HeaderMode {
		STANDARD("standard"), SEAMED("seamed"),
		WATERFULL("waterfall"), WATERFULL_TALL("waterfall-tall"),
		SCROLL("scroll"), COVER("cover");

		private String mode;

		HeaderMode(String mode) {
			this.mode = mode;
		}
		
		private static HeaderMode calcPanel(String pn){
			for (HeaderMode p : values())
				if (p.mode.equals(pn))
					return p;
			
			return HeaderMode.STANDARD;
		}

	}
	
	/**
	 * Responsiveness change event fired when the state narrow for DrawerPanel is changed!
	 */
	public static class CoreHeaderPanelScrollEvent extends EventCoreBase<CoreHeaderPanelScrollEvent> {

		private static final Type<EventHandlerCore<CoreHeaderPanelScrollEvent>> TYPE = new Type<EventHandlerCore<CoreHeaderPanelScrollEvent>>(
				"scroll", new CoreHeaderPanelScrollEvent());

		public static Type<EventHandlerCore<CoreHeaderPanelScrollEvent>> getType() {
			return TYPE;
		}
		
		public Element getScrollerElement(){
			return getScroller(getNativeEvent());
		}
		
		private final native Element getScroller(JavaScriptObject evtJso) /*-{
			evtJso.detail.target;
		}-*/; 

		@Override
		public com.google.gwt.event.dom.client.DomEvent.Type<EventHandlerCore<CoreHeaderPanelScrollEvent>> getAssociatedType() {
			return getType();
		}
	}
	
		
	private Widget headerWidget;
	private Widget contentWidget;
	
	
	public CoreHeaderPanel(Widget header, Widget content) {
		this(Document.get().createElement(CoreHeaderPanelElement.TAG), header, content, STYLE);
	}
	
	public CoreHeaderPanel(Widget header, Widget content, String styleName) {
		this(Document.get().createElement(CoreHeaderPanelElement.TAG), header, content, styleName);
	}

	protected CoreHeaderPanel(Element element, Widget header, Widget content, String styleName) {
		setElement(element);
		if (styleName != null && !styleName.equalsIgnoreCase(STYLE)) {
			styleName = STYLE + " " + styleName;
		}
		setStyleName(styleName);
		
		if (!(header instanceof CoreToolbar))
			header.addStyleName("core-header");
		
		add(header);
		add(content);
		
		this.headerWidget = header;
		this.contentWidget = content;
	}

	
	public void addCoreHeaderPanelScrollerChangeHandler(EventHandlerCore<CoreHeaderPanelScrollEvent> rensponsiveChangeHandler){
		addDomHandler(rensponsiveChangeHandler, CoreHeaderPanelScrollEvent.getType());
	}
	

	public HeaderMode getMode() {
		return HeaderMode.calcPanel(getElement().getMode());
	}

	public void setMode(HeaderMode headerMode) {
		//getElement().setAttribute("mode", headerMode.mode);
		getElement().setMode(headerMode.mode);
	}

	public String getTallClass() {
		return getElement().getTallClass();
	}

	public void setTallClass(String styleClass) {
		//getElement().setAttribute("tallClass", styleClass);
		getElement().setTallClass(styleClass);
	}

	public boolean isShadow() {
		return getElement().isShadow();
	}

	public void setShadow(boolean status) {
		getElement().setShadow(status);
	}

	public Element getScrollerElement() {
		return getElement().getScrollerElement();
	}

	
	public Widget getHeaderWidget() {
		return headerWidget;
	}

	public Widget getContentWidget() {
		return contentWidget;
	}
	

	public void setContentFitWindowSize(boolean status) {
		if (status)
			contentWidget.getElement().setAttribute("fit", "");
		else
			contentWidget.getElement().removeAttribute("fit");
	}

	@Override
	public CoreHeaderPanelElement getElement() {
		return super.getElement().cast();
	}


	@Override
	protected Widget checkAdoptInstance(Widget w) {
		if (getChildren().size() == 0 || getChildren().size() == 1)
			return w;
		
			
		throw new IllegalArgumentException("The related DrawerPanel can have 2 panels as children from which one is DRAWER, and other MAIN");
	}
}
