package mk.icelabs.gwt.polymer.client.dom.polymer.core;

import mk.icelabs.gwt.polymer.client.dom.ElementBase;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.TagName;

@TagName(CoreIconElement.TAG)
public class CoreIconElement extends ElementBase {

	public static final String TAG = "core-icon";

	/**
	 * Assert that the given {@link Element} is compatible with this class and
	 * automatically typecast it.
	 */
	public static CoreIconElement as(Element elem) {
		assert elem.getTagName().equalsIgnoreCase(TAG);
		return (CoreIconElement) elem;
	}

	protected CoreIconElement() {
	}

	public final native String getIconSrc() /*-{
		return this.src;
	}-*/;

	public final native void setIconSrc(String iconsrc) /*-{
		this.icon = null;
		this.src = iconsrc;
	}-*/;

	public final native String getIcon() /*-{
		return this.icon;
	}-*/;

	public final native void setIcon(String ico) /*-{
		this.iconSrc = null;
		this.icon = ico;
	}-*/;
}
