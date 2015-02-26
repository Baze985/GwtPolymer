package mk.icelabs.gwt.polymer.client.dom.polymer.paper;

import mk.icelabs.gwt.polymer.client.dom.ElementBase;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.TagName;

@TagName(PaperToastElement.TAG)
public class PaperToastElement extends ElementBase {

	public static final String TAG = "paper-toast";

	/**
	 * Assert that the given {@link Element} is compatible with this class and
	 * automatically typecast it.
	 */
	public static PaperToastElement as(Element elem) {
		assert elem.getTagName().equalsIgnoreCase(TAG);
		return (PaperToastElement) elem;
	}

	protected PaperToastElement() {
	}

	public final native void setAutoCloseDisabled(boolean status) /*-{
		this.autoCloseDisabled = status;
	}-*/;

	public final native boolean isAutoCloseDisabled() /*-{
		return this.autoCloseDisabled;
	}-*/;

	public final native void setOpened(boolean status) /*-{
		this.opened = opened;
	}-*/;

	public final native boolean isOpened() /*-{
		return this.opened;
	}-*/;

	public final native void setDurationMilis(int duration) /*-{
		this.duration = duration;

	}-*/;

	public final native int getDurationMilis() /*-{
		return this.duration;
	}-*/;

	public final native void setResponsiveWidth(int responsiveWidth) /*-{
		this.responsiveWidth = responsiveWidth + "px";
	}-*/;

	public final int getResponsiveWidth() {
		return new Integer(getResponsiveWidthpx().replace("px", ""));
	}

	private final native String getResponsiveWidthpx() /*-{
		return this.responsiveWidth;
	}-*/;

	public final native boolean isSwipeDisabled() /*-{
		return this.swipeDisabled;
	}-*/;

	public final native void setSwipeDisabled(boolean status) /*-{
		this.swipeDisabled = status;
	}-*/;

	public final native String getText() /*-{
		return this.text;
	}-*/;

	public final native void setText(String text) /*-{
		this.text = text;
	}-*/;

	public final native void toggle() /*-{
		this.toggle();
	}-*/;

	public final native void open() /*-{
		this.show();
	}-*/;

	public final native void dismiss() /*-{
		this.dismiss();
	}-*/;

}
