package mk.icelabs.gwt.polymer.client.dom.polymer.core;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.TagName;

@TagName(CoreSubMenuElement.TAG)
public class CoreSubMenuElement extends CoreItemElement {

	public static final String TAG = "core-submenu";

	/**
	 * Assert that the given {@link Element} is compatible with this class and
	 * automatically typecast it.
	 */
	public static CoreSubMenuElement as(Element elem) {
		assert elem.getTagName().equalsIgnoreCase(TAG);
		return (CoreSubMenuElement) elem;
	}

	protected CoreSubMenuElement() {
	}

}
