package mk.icelabs.gwt.polymer.client.dom.polymer.paper;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.TagName;

@TagName(PaperRadioButtonElement.TAG)
public class PaperRadioButtonElement extends PaperCheckableElementBase {

	public static final String TAG = "paper-radio-button";

	/**
	 * Assert that the given {@link Element} is compatible with this class and
	 * automatically typecast it.
	 */
	public static PaperRadioButtonElement as(Element elem) {
		assert elem.getTagName().equalsIgnoreCase(TAG);
		return (PaperRadioButtonElement) elem;
	}

	protected PaperRadioButtonElement(){}

	public final native String getLabel() /*-{
		return this.label;
	}-*/;

	public final native void setLabel(String lbl) /*-{
		this.label = lbl;
	}-*/;

	public final native String getName() /*-{
		return this.hasAttribute('name') ? this.getAttribute('name') : null;
	}-*/;

	public final native void setName(String name) /*-{
		this.setAttribute('name', name);
	}-*/;

	public final native boolean isDisabled() /*-{
		return this.disabled;
	}-*/;

	public final native void setDisabled(boolean status) /*-{
		this.disabled = status;
	}-*/;

	public final native boolean isToggleable () /*-{
		return this.toggles;
	}-*/;

	public final native void setToggleable (boolean status) /*-{
		this.toggles = status;
	}-*/;

}
