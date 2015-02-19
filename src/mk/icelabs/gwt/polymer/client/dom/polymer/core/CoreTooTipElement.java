package mk.icelabs.gwt.polymer.client.dom.polymer.core;

import mk.icelabs.gwt.polymer.client.dom.ElementBase;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.TagName;

@TagName(CoreTooTipElement.TAG)
public class CoreTooTipElement extends ElementBase {

	public static final String TAG = "core-tooltip";

	/**
	 * Assert that the given {@link Element} is compatible with this class and
	 * automatically typecast it.
	 */
	public static CoreTooTipElement as(Element elem) {
		assert elem.getTagName().equalsIgnoreCase(TAG);
		return (CoreTooTipElement) elem;
	}

	protected CoreTooTipElement() {}

	public final native String getLabel() /*-{
		return this.label;
	}-*/;

	public final native void setLabel(String lbl) /*-{
		this.tipAttribute = null;
		this.label = lbl;
	}-*/;


	public final native void setShow(boolean status) /*-{
		this.show = status;
	}-*/;

	public final native boolean isShow() /*-{
		return this.show;
	}-*/;

	public final native void setPosition(String position) /*-{
		this.position = position;
	}-*/;

	public final native String getPosition() /*-{
		return this.position;
	}-*/;
	
	public final native void setTipAttribute(String tipAttribute) /*-{
		this.label = null;
		this.tipAttribute = tipAttribute;
	}-*/;

	public final native String getTipAttribute() /*-{
		return this.tipAttribute;
	}-*/;
	
	public final native void setNoarrow(boolean status) /*-{
		this.noarrow = status;
	}-*/;

	public final native boolean isNoarrow() /*-{
		return this.noarrow;
	}-*/;

}
