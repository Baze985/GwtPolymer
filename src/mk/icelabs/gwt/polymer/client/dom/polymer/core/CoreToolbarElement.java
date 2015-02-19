package mk.icelabs.gwt.polymer.client.dom.polymer.core;

import mk.icelabs.gwt.polymer.client.dom.ElementBase;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.TagName;

@TagName(CoreToolbarElement.TAG)
public class CoreToolbarElement extends ElementBase {

	public static final String TAG = "core-toolbar";

	/**
	 * Assert that the given {@link Element} is compatible with this class and
	 * automatically typecast it.
	 */
	public static CoreToolbarElement as(Element elem) {
		assert elem.getTagName().equalsIgnoreCase(TAG);
		return (CoreToolbarElement) elem;
	}

	protected CoreToolbarElement() {}

	public final native void setJustify(String justify) /*-{
		return this.justify=justify;
	}-*/;

	public final native String getJustify() /*-{
		return this.justify;
	}-*/;

	public final native void setMiddleJustify(String middleJustify) /*-{
		this.middleJustify = middleJustify;
	}-*/;

	public final native String getMiddleJustify() /*-{
		return this.middleJustify;
	}-*/;

	public final native void setBottomJustify(String middleJustify) /*-{
		this.bottomJustify = middleJustify;
	}-*/;

	public final native String getBottomJustify() /*-{
		return this.bottomJustify;
	}-*/;
}
