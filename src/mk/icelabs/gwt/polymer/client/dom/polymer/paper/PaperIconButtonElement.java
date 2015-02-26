package mk.icelabs.gwt.polymer.client.dom.polymer.paper;

import mk.icelabs.gwt.polymer.client.dom.polymer.core.CoreFocusableElement;
import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreFocusable;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.TagName;

@TagName(PaperIconButtonElement.TAG)
public class PaperIconButtonElement extends CoreFocusableElement{

	public static final String TAG = "paper-icon-button";

	/**
	 * Assert that the given {@link Element} is compatible with this class and
	 * automatically typecast it.
	 */
	public static PaperIconButtonElement as(Element elem) {
		assert elem.getTagName().equalsIgnoreCase(TAG);
		return (PaperIconButtonElement) elem;
	}

	protected PaperIconButtonElement(){}

	public final native String getLabel() /*-{
	return this.label;
}-*/;

public final native void setLabel(String lbl) /*-{
	this.label = lbl;
}-*/;

public final native String getIconSrc() /*-{
	return this.iconSrc;
}-*/;

public final native void setIconSrc(String iconsrc) /*-{
	this.icon = null;
	this.iconSrc = iconsrc;
}-*/;

public final native String getIcon() /*-{
	return this.icon;
}-*/;

public final native void setIcon(String ico) /*-{
	this.iconSrc = null;
	this.icon = ico;
}-*/;

	public final native boolean isFill() /*-{
		return this.fill;
	}-*/;

	public final native void setFill(boolean status) /*-{
		this.fill = status;
	}-*/;

}
