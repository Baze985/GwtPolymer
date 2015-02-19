package mk.icelabs.gwt.polymer.client.dom.polymer.core;

import mk.icelabs.gwt.polymer.client.dom.ElementBase;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.TagName;

@TagName(CoreCollapseElement.TAG)
public class CoreCollapseElement extends ElementBase {

	public static final String TAG = "core-collapse";

	/**
	 * Assert that the given {@link Element} is compatible with this class and
	 * automatically typecast it.
	 */
	public static CoreCollapseElement as(Element elem) {
		assert elem.getTagName().equalsIgnoreCase(TAG);
		return (CoreCollapseElement) elem;
		
	}

	protected CoreCollapseElement() {}

	public final native String getTarget() /*-{
		return this.target;
	}-*/;

	public final native void setTarget(String targetElement) /*-{
		this.target = lbl;
	}-*/;


	public final native void setHorizontal(boolean horizontal) /*-{
		this.horizontal = horizontal;
	}-*/;

	public final native boolean isHorizontal() /*-{
		return this.horizontal;
	}-*/;

	public final native void setFixedSize(boolean status) /*-{
		this.fixedSize = status;
	}-*/;

	public final native boolean isFixedSize() /*-{
		return this.fixedSize;
	}-*/;
	
	public final native void setAllowOverflow(boolean status) /*-{
		this.allowOverflow = status;
	}-*/;

	public final native boolean isAllowOverflow() /*-{
		return this.allowOverflow;
	}-*/;
	
	public final native void setDuration(Integer durationSec) /*-{
		this.duration = durationSec;
	}-*/;

	public final native Integer getDuration() /*-{
		return this.duration;
	}-*/;
	
	public final native void setOpened(boolean status) /*-{
		this.opened = opened;
	}-*/;

	public final native boolean isOpened() /*-{
		return this.opened;
	}-*/;
	
	
	public final native void toggle() /*-{
		this.toggle();
	}-*/;

}
