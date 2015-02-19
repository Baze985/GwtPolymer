package mk.icelabs.gwt.polymer.client.dom.polymer.core;

import mk.icelabs.gwt.polymer.client.dom.ElementBase;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.TagName;

@TagName(CoreHeaderPanelElement.TAG)
public class CoreHeaderPanelElement extends ElementBase {

	public static final String TAG = "core-header-panel";

	/**
	 * Assert that the given {@link Element} is compatible with this class and
	 * automatically typecast it.
	 */
	public static CoreHeaderPanelElement as(Element elem) {
		assert elem.getTagName().equalsIgnoreCase(TAG);
		return (CoreHeaderPanelElement) elem;
	}

	protected CoreHeaderPanelElement() {}

	
	public final native String getMode() /*-{
		return this.mode;
	}-*/;

	public final native void setMode(String mode) /*-{
		this.mode = mode;
	}-*/;
	
	public final native String getTallClass() /*-{
		return this.tallClass;
	}-*/;

	public final native void setTallClass(String tallClass) /*-{
		this.tallClass = tallClass;
	}-*/;

	
	public final native void setShadow(boolean status) /*-{
		this.shadow = status;
		
	}-*/;

	public final native boolean isShadow() /*-{
		return this.shadow;
	}-*/;

	public final native void setDefaultSelectedPanel(String defaultSelectedPanel) /*-{
		this.defaultSelected = defaultSelectedPanel;
	}-*/;
	
	public final native Element getScrollerElement() /*-{
		return this.scroller;
	}-*/;

}
