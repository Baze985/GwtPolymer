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

	
	public final native boolean isRaisedButton() /*-{
		return this.raised;
	}-*/;

	public final native void setRaisedButton(boolean status) /*-{
		this.raised = status;
	}-*/;

}
