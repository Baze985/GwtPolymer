package mk.icelabs.gwt.polymer.client.dom.polymer.paper;

import mk.icelabs.gwt.polymer.client.dom.ElementBase;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.TagName;

@TagName(PaperTabElement.TAG)
public class PaperTabElement extends ElementBase{

	public static final String TAG = "paper-tab";

	/**
	 * Assert that the given {@link Element} is compatible with this class and
	 * automatically typecast it.
	 */
	public static PaperTabElement as(Element elem) {
		assert elem.getTagName().equalsIgnoreCase(TAG);
		return (PaperTabElement) elem;
	}

	protected PaperTabElement(){}

	public final native boolean isNoink() /*-{
		return this.noink;
	}-*/;

	public final native void setNoink(boolean status) /*-{
		this.noink = status;
	}-*/;

	public final native boolean setLabel(String label) /*-{
		this.label = label;
	}-*/;

	public final native String getLabel() /*-{
		return this.label;
	}-*/;

}
