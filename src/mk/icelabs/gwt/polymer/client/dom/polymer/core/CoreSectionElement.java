package mk.icelabs.gwt.polymer.client.dom.polymer.core;

import mk.icelabs.gwt.polymer.client.dom.ElementBase;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.TagName;

@TagName(CoreSectionElement.TAG)
public class CoreSectionElement extends ElementBase {

	public static final String TAG = "section";

	/**
	 * Assert that the given {@link Element} is compatible with this class and
	 * automatically typecast it.
	 */
	public static CoreSectionElement as(Element elem) {
		assert elem.getTagName().equalsIgnoreCase(TAG);
		return (CoreSectionElement) elem;
	}

	protected CoreSectionElement() {}

}
