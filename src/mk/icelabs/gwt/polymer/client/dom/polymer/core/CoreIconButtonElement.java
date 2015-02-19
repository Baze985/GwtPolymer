package mk.icelabs.gwt.polymer.client.dom.polymer.core;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.TagName;

@TagName(CoreIconButtonElement.TAG)
public class CoreIconButtonElement extends CoreFocusableElement {

	public static final String TAG = "core-icon-button";

	/**
	 * Assert that the given {@link Element} is compatible with this class and
	 * automatically typecast it.
	 */
	public static CoreIconButtonElement as(Element elem) {
		assert elem.getTagName().equalsIgnoreCase(TAG);
		return (CoreIconButtonElement) elem;
	}

	protected CoreIconButtonElement() {
	}

	public final native String getLabel() /*-{
		return this.label;
	}-*/;

	public final native void setLabel(String lbl) /*-{
		this.label = lbl;
	}-*/;

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
