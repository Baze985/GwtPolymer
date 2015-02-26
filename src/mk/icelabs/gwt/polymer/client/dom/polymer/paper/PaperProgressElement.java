package mk.icelabs.gwt.polymer.client.dom.polymer.paper;

import mk.icelabs.gwt.polymer.client.dom.polymer.core.CoreRangeElement;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.TagName;

@TagName(PaperProgressElement.TAG)
public class PaperProgressElement extends CoreRangeElement{


	public static final String TAG = "paper-progress";

	/**
	 * Assert that the given {@link Element} is compatible with this class and
	 * automatically typecast it.
	 */
	public static PaperProgressElement as(Element elem) {
		assert elem.getTagName().equalsIgnoreCase(TAG);
		return (PaperProgressElement) elem;
	}

	protected PaperProgressElement() {}

	public final native boolean isIndeterminate() /*-{
		return this.indeterminate;
	}-*/;

	public final native void setIndeterminate(boolean status) /*-{
		this.indeterminate = status;
	}-*/;

	public final native int getSecondaryProgress() /*-{
		return this.secondaryProgress;
	}-*/;

	public final native void setSecondaryProgress(int secondaryProgress) /*-{
		this.secondaryProgress = secondaryProgress;
	}-*/;
	
}
