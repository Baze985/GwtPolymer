package mk.icelabs.gwt.polymer.client.ui.polymer.core;

import mk.icelabs.gwt.polymer.client.dom.polymer.core.CoreDrawerPanelElement;
import mk.icelabs.gwt.polymer.client.event.polymer.EventCoreBase;
import mk.icelabs.gwt.polymer.client.event.polymer.EventHandlerCore;
import mk.icelabs.gwt.polymer.client.ui.widgets.Container;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

public class CoreDrawerPanel extends Container<Widget> {

	
	
	public static final String STYLE = "";
	

	public static enum PanelType {
		DRAWER("drawer"), MAIN("main");

		private String attr;

		PanelType(String panel) {
			this.attr = panel;
		}
		
		private static PanelType calcPanel(String pn){
			for (PanelType p : values())
				if (p.attr.equals(pn))
					return p;
			
			return PanelType.DRAWER;
		}

	}
	
	/**
	 * Responsiveness change event fired when the state narrow for DrawerPanel is changed!
	 */
	public static class CoreDrawerResponsiveEvent extends EventCoreBase<CoreDrawerResponsiveEvent> {

		private static final Type<EventHandlerCore<CoreDrawerResponsiveEvent>> TYPE = new Type<EventHandlerCore<CoreDrawerResponsiveEvent>>(
				"core-responsive-change", new CoreDrawerResponsiveEvent());

		public static Type<EventHandlerCore<CoreDrawerResponsiveEvent>> getType() {
			return TYPE;
		}
		
		public boolean isNarrow(){
			return getNarrow(getNativeEvent());
		}
		
		private final native boolean getNarrow(JavaScriptObject evtJso) /*-{
			evtJso.detail.narrow;
		}-*/; 

		@Override
		public com.google.gwt.event.dom.client.DomEvent.Type<EventHandlerCore<CoreDrawerResponsiveEvent>> getAssociatedType() {
			return getType();
		}
	}
	
	/**
	 * State change event fired when the state of the collapse is changed!
	 */
	public static class CoreDrawerPanelSelectEvent extends EventCoreBase<CoreDrawerPanelSelectEvent> {

		private static final Type<EventHandlerCore<CoreDrawerPanelSelectEvent>> TYPE = new Type<EventHandlerCore<CoreDrawerPanelSelectEvent>>(
				"core-select", new CoreDrawerPanelSelectEvent());

		public static Type<EventHandlerCore<CoreDrawerPanelSelectEvent>> getType() {
			return TYPE;
		}
		
		public boolean isSelected(){
			return getSelected(getNativeEvent());
		}
		
		
		
		public PanelType getPanelType(){
			return getElement(getNativeEvent()).hasAttribute(PanelType.DRAWER.attr) ? PanelType.DRAWER : PanelType.MAIN;
		}
		
		private final native boolean getSelected(JavaScriptObject evtJso) /*-{
			evtJso.detail.isSelected;
		}-*/; 
		
		private final native Element getElement(JavaScriptObject evtJso) /*-{
			evtJso.detail.item;
		}-*/; 

		@Override
		public com.google.gwt.event.dom.client.DomEvent.Type<EventHandlerCore<CoreDrawerPanelSelectEvent>> getAssociatedType() {
			return getType();
		}
	}
	
	private Widget drawerWidget;
	private Widget mainWidget;
	
	
	public CoreDrawerPanel(Widget drawer, Widget main) {
		this(Document.get().createElement(CoreDrawerPanelElement.TAG), drawer, main, STYLE);
	}
	
	public CoreDrawerPanel(Widget drawer, Widget main, String styleName) {
		this(Document.get().createElement(CoreDrawerPanelElement.TAG), drawer, main, styleName);
	}

	protected CoreDrawerPanel(Element element, Widget drawer, Widget main, String styleName) {
		setElement(element);
		if (styleName != null && !styleName.equalsIgnoreCase(STYLE)) {
			styleName = STYLE + " " + styleName;
		}
		setStyleName(styleName);
		
		drawer.getElement().setAttribute(PanelType.DRAWER.attr, "");
		main.getElement().setAttribute(PanelType.MAIN.attr, "");
		
		add(drawer);
		add(main);
	}

	
	public void addCoreRensponsiveChangeHandler(EventHandlerCore<CoreDrawerResponsiveEvent> rensponsiveChangeHandler){
		addDomHandler(rensponsiveChangeHandler, CoreDrawerResponsiveEvent.getType());
	}
	
	public void addCorePanelSelectionChangeHandler(EventHandlerCore<CoreDrawerPanelSelectEvent> selectionChangedHandler){
		addDomHandler(selectionChangedHandler, CoreDrawerPanelSelectEvent.getType());
	}
	
	public void toggleDrawer(){
		getElement().togglePanel();
	}
	
	public void closeDrawer(){
		getElement().closeDrawer();
	}
	
	public void openDrawer(){
		getElement().openDrawer();
	}
	
	
	public int getDrawerWidth() {
		return getElement().getDrawerWidth();
	}

	public void setDrawerWidth(int drawerWidth) {
		getElement().setDrawerWidth(drawerWidth);
	}

	public int getResponsiveWidth() {
		return getElement().getResponsiveWidth();
	}

	public void setResponsiveWidth(int responsiveWidth) {
		getElement().setResponsiveWidth(responsiveWidth);
	}

	public PanelType getSelectedPanel() {
		return PanelType.calcPanel(getElement().getSelectedPanel());
	}

	public void setSelectedPanel(PanelType selectedPanel) {
		getElement().setSelectedPanel(selectedPanel.attr);
	}

	public PanelType getDefaultSelectedPanel() {
		return PanelType.calcPanel(getElement().getDefaultSelectedPanel());
	}

	public void setDefaultSelectedPanel(PanelType defaultSelectedPanel) {
		getElement().setDefaultSelectedPanel(defaultSelectedPanel.attr);
	}

	public boolean isNarrow() {
		return getElement().isNarrow();
	}

	public void setNarrow(boolean narrow) {
		getElement().setNarrow(narrow);
	}

	public boolean isRightDrawer() {
		return getElement().isRightDrawer();
	}

	public void setRightDrawer(boolean rightDrawer) {
		getElement().setRightDrawer(rightDrawer);
	}

	public boolean isDisableSwipe() {
		return getElement().isDisableSwipe();
	}

	public void setDisableSwipe(boolean disableSwipe) {
		getElement().setDisableSwipe(disableSwipe);
	}

	public boolean isForceNarrow() {
		return getElement().isForceNarrow();
	}

	public void setForceNarrow(boolean forceNarrow) {
		getElement().setForceNarrow(forceNarrow);
	}

	public boolean isDisableEdgeSwipe() {
		return getElement().isDisableEdgeSwipe();
	}

	public void setDisableEdgeSwipe(boolean disableEdgeSwipe) {
		getElement().setDisableEdgeSwipe(disableEdgeSwipe);
	}

	public Widget getDrawerWidget() {
		return drawerWidget;
	}

	public Widget getMainWidget() {
		return mainWidget;
	}
	
	public void setContentFitWindowSize(boolean status) {
		if (status)
			mainWidget.getElement().setAttribute("fit", "");
		else
			mainWidget.getElement().removeAttribute("fit");
	}

	@Override
	public CoreDrawerPanelElement getElement() {
		return super.getElement().cast();
	}


	@Override
	protected Widget checkAdoptInstance(Widget w) {
		if (getChildren().size() == 0)
			return w;
		
		if (getChildren().size() == 1){
			if (w.getElement().hasAttribute(PanelType.DRAWER.attr) && getChildren().get(0).getElement().hasAttribute(PanelType.MAIN.attr))
				return w;
			
			if (w.getElement().hasAttribute(PanelType.MAIN.attr) && getChildren().get(0).getElement().hasAttribute(PanelType.DRAWER.attr))
				return w;
			
		}
			
		throw new IllegalArgumentException("The related DrawerPanel can have 2 panels as children from which one is DRAWER, and other MAIN");
	}
}
