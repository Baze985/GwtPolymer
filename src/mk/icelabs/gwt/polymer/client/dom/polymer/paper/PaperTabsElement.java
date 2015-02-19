package mk.icelabs.gwt.polymer.client.dom.polymer.paper;

import mk.icelabs.gwt.polymer.client.dom.polymer.core.CoreSelectorElement;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.TagName;

@TagName(PaperTabsElement.TAG)
public class PaperTabsElement extends CoreSelectorElement {

	public static final String TAG = "paper-tabs";

	/**
	 * Assert that the given {@link Element} is compatible with this class and
	 * automatically typecast it.
	 */
	public static PaperTabsElement as(Element elem) {
		assert elem.getTagName().equalsIgnoreCase(TAG);
		return (PaperTabsElement) elem;
	}

	protected PaperTabsElement(){}
	
	public final native boolean isNoink() /*-{
		return this.noink;
	}-*/;

	public final native void setNoink(boolean status) /*-{
		this.noink = status;
	}-*/;

	public final native boolean isNobar() /*-{
		return this.nobar;
	}-*/;

	public final native void setNobar(boolean status) /*-{
		this.nobar = status;
	}-*/;

	public final native boolean isNoslide() /*-{
		return this.noslide;
	}-*/;

	public final native void setNoslide(boolean status) /*-{
		this.noslide = status;
	}-*/;

	public final native boolean isScrollableTabs() /*-{
		return this.scrollable;
	}-*/;

	public final native void setScrollableTabs(boolean status) /*-{
		this.scrollable = status;
	}-*/;

	public final native boolean isHideScrollButton() /*-{
		return this.hideScrollButton;
	}-*/;

	public final native void setHideScrollButton(boolean status) /*-{
		this.hideScrollButton = status;
	}-*/;


}
