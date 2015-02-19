package mk.icelabs.gwt.polymer.client.dom.polymer.core;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.TagName;

@TagName(CoreScaffoldElement.TAG)
public class CoreScaffoldElement extends CoreDrawerPanelElement {

	public static final String TAG = "core-scaffold";

	/**
	 * Assert that the given {@link Element} is compatible with this class and
	 * automatically typecast it.
	 */
	public static CoreScaffoldElement as(Element elem) {
		assert elem.getTagName().equalsIgnoreCase(TAG);
		return (CoreScaffoldElement) elem;
	}

	protected CoreScaffoldElement() {
	}
}
