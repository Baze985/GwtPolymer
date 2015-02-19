package mk.icelabs.gwt.polymer.client.dom.polymer.core;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.TagName;

@TagName(CoreMenuElement.TAG)
public class CoreMenuElement extends CoreSelectorElement {

	public static final String TAG = "core-menu";

	/**
	 * Assert that the given {@link Element} is compatible with this class and
	 * automatically typecast it.
	 */
	public static CoreMenuElement as(Element elem) {
		assert elem.getTagName().equalsIgnoreCase(TAG);
		return (CoreMenuElement) elem;
	}

	protected CoreMenuElement() {}

}
