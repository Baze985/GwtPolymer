package mk.icelabs.gwt.polymer.client.dom.polymer.core;

import mk.icelabs.gwt.polymer.client.dom.ElementBase;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.TagName;

@TagName(CoreDrawerPanelElement.TAG)
public class CoreDrawerPanelElement extends ElementBase {

	public static final String TAG = "core-drawer-panel";

	/**
	 * Assert that the given {@link Element} is compatible with this class and
	 * automatically typecast it.
	 */
	public static CoreDrawerPanelElement as(Element elem) {
		assert elem.getTagName().equalsIgnoreCase(TAG);
		return (CoreDrawerPanelElement) elem;
	}

	protected CoreDrawerPanelElement() {}

	
	private final native String getDrawerWidthPx() /*-{
		return this.drawerWidth;
	}-*/;
	
	public final int getDrawerWidth() {
		return new Integer(this.getDrawerWidthPx().replace("px", ""));
	};

	public final native void setDrawerWidth(int drawerWidth) /*-{
		this.drawerWidth = drawerWidth + "px";
	}-*/;
	
	private final native String getResponsiveWidthPx() /*-{
		return this.responsiveWidth;
	}-*/;

	public final int getResponsiveWidth() {
		return new Integer(this.getResponsiveWidthPx().replace("px", ""));
	};

	public final native void setResponsiveWidth(int responsiveWidth) /*-{
		this.responsiveWidth = responsiveWidth + "px";
	}-*/;


	public final native void setSelectedPanel(String panelToSelect) /*-{
		this.selected = panelToSelect;
	}-*/;

	public final native String getSelectedPanel() /*-{
		return this.selected;
	}-*/;

	public final native void setDefaultSelectedPanel(String defaultSelectedPanel) /*-{
		this.defaultSelected = defaultSelectedPanel;
	}-*/;
	
	public final native String getDefaultSelectedPanel() /*-{
		return this.defaultSelected;
	}-*/;

	public final native boolean isNarrow() /*-{
		return this.narrow;
	}-*/;
	
	public final native void setNarrow(boolean narrow) /*-{
		this.narrow = narrow;
	}-*/;

	public final native boolean isRightDrawer() /*-{
		return this.rightDrawer;
	}-*/;
	
	public final native void setRightDrawer(boolean status) /*-{
		this.rightDrawer = status;
	}-*/;

	public final native void setDisableSwipe(boolean status) /*-{
		this.disableSwipe = status;
	}-*/;

	public final native boolean isDisableSwipe() /*-{
		return this.disableSwipe;
	}-*/;

	public final native void setForceNarrow(boolean status) /*-{
		this.forceNarrow = status;
	}-*/;

	public final native boolean isForceNarrow() /*-{
		return this.forceNarrow;
	}-*/;
	
	public final native void setDisableEdgeSwipe(boolean status) /*-{
		this.disableEdgeSwipe = status;
	}-*/;

	public final native boolean isDisableEdgeSwipe() /*-{
		return this.disableEdgeSwipe;
	}-*/;
	
	
	public final native String togglePanel() /*-{
		this.togglePanel();
	}-*/;

	public final native String openDrawer() /*-{
		this.openDrawer();
	}-*/;

	public final native String closeDrawer() /*-{
		this.closeDrawer();
	}-*/;
		
	
}
