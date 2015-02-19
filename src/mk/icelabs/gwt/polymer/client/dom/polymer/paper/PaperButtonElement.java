package mk.icelabs.gwt.polymer.client.dom.polymer.paper;

import mk.icelabs.gwt.polymer.client.dom.polymer.core.CoreFocusableElement;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.TagName;

@TagName(PaperButtonElement.TAG)
public class PaperButtonElement extends CoreFocusableElement{

	public static final String TAG = "paper-button";

	/**
	 * Assert that the given {@link Element} is compatible with this class and
	 * automatically typecast it.
	 */
	public static PaperButtonElement as(Element elem) {
		assert elem.getTagName().equalsIgnoreCase(TAG);
		return (PaperButtonElement) elem;
	}

	protected PaperButtonElement(){}

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

	public final native boolean isRaisedButton() /*-{
		return this.raised;
	}-*/;

	public final native void setRaisedButton(boolean status) /*-{
		this.raised = status;
	}-*/;

}
