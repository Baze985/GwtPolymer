package mk.icelabs.gwt.polymer.client.dom.polymer.paper;

import mk.icelabs.gwt.polymer.client.dom.ElementBase;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.TagName;

@TagName(PaperInputElement.TAG)
public class PaperInputElement extends ElementBase {

	public static final String TAG = "paper-input";

	/**
	 * Assert that the given {@link Element} is compatible with this class and
	 * automatically typecast it.
	 */
	public static PaperInputElement as(Element elem) {
		assert elem.getTagName().equalsIgnoreCase(TAG);
		return (PaperInputElement) elem;
	}

	protected PaperInputElement(){}

	
	public final native String getLabel() /*-{
		return this.label;
	}-*/;

	public final native void setLabel(String lbl) /*-{
		this.label = lbl;
	}-*/;

	public final native boolean isFloatingLabel() /*-{
		return this.floatingLabel;
	}-*/;

	public final native void setFloatingLabel(boolean status) /*-{
		this.floatingLabel = status;
	}-*/;


	public final native void setDisabled(boolean status) /*-{
		this.disabled = status;
	}-*/;

	public final native boolean isDisabled() /*-{
		return this.disabled;
	}-*/;
	
	public final native void setValue(String value) /*-{
		this.value = value;
	}-*/;

	public final native String getValue() /*-{
		return this.value;
	}-*/;
	
	public final native void setCommittedValue(String committedValue) /*-{
		this.committedValue = committedValue;
	}-*/;

	public final native String getCommittedValue() /*-{
		return this.committedValue;
	}-*/;
		
}
