package mk.icelabs.gwt.polymer.client.dom.polymer.paper;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.TagName;

@TagName(PaperIconButtonElement.TAG)
public class PaperFabElement extends PaperIconButtonElement{

	public static final String TAG = "paper-fab";

	/**
	 * Assert that the given {@link Element} is compatible with this class and
	 * automatically typecast it.
	 */
	public static PaperFabElement as(Element elem) {
		assert elem.getTagName().equalsIgnoreCase(TAG);
		return (PaperFabElement) elem;
	}

	protected PaperFabElement(){}

}
