package mk.icelabs.gwt.polymer.client.dom.polymer.paper;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.TagName;

@TagName(PaperIconButtonElement.TAG)
public class PaperIconButtonElement extends PaperButtonElement{

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

	public final native boolean isFill() /*-{
		return this.fill;
	}-*/;

	public final native void setFill(boolean status) /*-{
		this.fill = status;
	}-*/;

}
