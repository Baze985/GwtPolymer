package mk.icelabs.gwt.polymer.client.dom.polymer.paper;

import mk.icelabs.gwt.polymer.client.dom.ElementBase;

import com.google.gwt.dom.client.Element;

public abstract class PaperCheckableElementBase extends ElementBase {

	/**
	 * Assert that the given {@link Element} is compatible with this class and
	 * automatically typecast it.
	 */
	public static PaperCheckableElementBase as(Element elem) {
		return (PaperCheckableElementBase) elem;
	}

	protected PaperCheckableElementBase(){}

	public final native boolean isChecked() /*-{
		return this.checked;
	}-*/;

	public final native void setChecked(boolean status) /*-{
		this.checked = status;
	}-*/;

	public final native boolean isDefaultChecked() /*-{
		return this.hasAttribute("checked");
	}-*/;

}
