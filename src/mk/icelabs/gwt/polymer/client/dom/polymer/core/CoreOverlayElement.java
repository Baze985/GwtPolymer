package mk.icelabs.gwt.polymer.client.dom.polymer.core;

import mk.icelabs.gwt.polymer.client.dom.ElementBase;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.TagName;

@TagName(CoreOverlayElement.TAG)
public class CoreOverlayElement extends ElementBase {

	public static final String TAG = "core-overlay";

	/**
	 * Assert that the given {@link Element} is compatible with this class and
	 * automatically typecast it.
	 */
	public static CoreOverlayElement as(Element elem) {
		assert elem.getTagName().equalsIgnoreCase(TAG);
		return (CoreOverlayElement) elem;
	}

	protected CoreOverlayElement() {}

	public final native String getTarget() /*-{
		return this.target;
	}-*/;

	public final native void setTarget(String targetElement) /*-{
		this.target = lbl;
	}-*/;

	public final native void setBackdrop(boolean status) /*-{
		this.backdrop = status;
	}-*/;

	public final native boolean isBackdrop() /*-{
		return this.backdrop;
	}-*/;
	
	public final native void setLayered(boolean status) /*-{
		this.layered = status;
	}-*/;

	public final native boolean isLayered() /*-{
		return this.layered;
	}-*/;
	
	public final native void setAutoCloseDisabled(boolean status) /*-{
		this.autoCloseDisabled = status;
	}-*/;

	public final native boolean isAutoCloseDisabled() /*-{
		return this.autoCloseDisabled;
	}-*/;
	
	public final native void setAutoFocusDisabled(boolean status) /*-{
		this.autoFocusDisabled = status;
	}-*/;

	public final native boolean isAutoFocusDisabled() /*-{
		return this.autoFocusDisabled;
	}-*/;
	
	public final native void setOpened(boolean status) /*-{
		this.opened = opened;
	}-*/;

	public final native boolean isOpened() /*-{
		return this.opened;
	}-*/;
	
	public final native void setCloseAttribute(String closeAttribute) /*-{
		this.closeSelector = null;
		this.closeAttribute = closeAttribute;
	}-*/;

	public final native String getCloseAttribute() /*-{
		return this.closeAttribute;
	}-*/;
	
	public final native void setCloseSelector(String closeSelector) /*-{
		this.closeAttribute = null;
		this.closeSelector = closeSelector;
	}-*/;

	public final native String getCloseSelector() /*-{
		return this.closeSelector;
	}-*/;
	
	public final native void setTransition(String transition) /*-{
		this.transition = transition;
	}-*/;

	public final native String getTransition() /*-{
		return this.transition;
	}-*/;
	
	public final native void toggle() /*-{
		this.toggle();
	}-*/;
	
	public final native void open() /*-{
		this.open();
	}-*/;

	public final native void close() /*-{
		this.close();
	}-*/;

}
