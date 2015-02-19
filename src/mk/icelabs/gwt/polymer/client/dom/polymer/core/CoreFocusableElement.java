package mk.icelabs.gwt.polymer.client.dom.polymer.core;

import mk.icelabs.gwt.polymer.client.dom.ElementBase;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.TagName;

@TagName(CoreFocusableElement.TAG)
public class CoreFocusableElement extends ElementBase{

	public static final String TAG = "paper-focusable";

	/**
	 * Assert that the given {@link Element} is compatible with this class and
	 * automatically typecast it.
	 */
	public static CoreFocusableElement as(Element elem) {
		assert elem.getTagName().equalsIgnoreCase(TAG);
		return (CoreFocusableElement) elem;
	}

	protected CoreFocusableElement(){}

	public final native boolean isActive() /*-{
		return this.active;
	}-*/;

	public final native void setActive(boolean status) /*-{
		this.active = status;
	}-*/;

	public final native boolean isFocused() /*-{
		return this.focused;
	}-*/;

	public final native void setFocused(boolean status) /*-{
		this.focused = status;
	}-*/;

	public final native boolean isPressed() /*-{
		return this.pressed;
	}-*/;

	public final native void setPressed(boolean status) /*-{
		this.pressed = status;
	}-*/;

	public final native boolean isDisabled() /*-{
		return this.disabled;
	}-*/;

	public final native void setDisabled(boolean status) /*-{
		this.disabled = status;
	}-*/;

	public final native boolean isToggle() /*-{
		return this.isToggle;
	}-*/;

	public final native void setToggle(boolean status) /*-{
		this.isToggle = status;
	}-*/;

}
