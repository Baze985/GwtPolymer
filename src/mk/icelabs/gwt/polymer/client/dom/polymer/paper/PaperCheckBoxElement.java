package mk.icelabs.gwt.polymer.client.dom.polymer.paper;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.TagName;

@TagName(PaperCheckBoxElement.TAG)
public class PaperCheckBoxElement extends PaperRadioButtonElement{

	public static final String TAG = "paper-checkbox";

	/**
	 * Assert that the given {@link Element} is compatible with this class and
	 * automatically typecast it.
	 */
	public static PaperCheckBoxElement as(Element elem) {
		assert elem.getTagName().equalsIgnoreCase(TAG);
		return (PaperCheckBoxElement) elem;
	}

	protected PaperCheckBoxElement(){}

}
