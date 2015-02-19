package mk.icelabs.gwt.polymer.client.dom.polymer.core;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.TagName;

@TagName(CoreAnimatedPagesElement.TAG)
public class CoreAnimatedPagesElement extends CoreSelectorElement {

	public static final String TAG = "core-animated-pages";

	/**
	 * Assert that the given {@link Element} is compatible with this class and
	 * automatically typecast it.
	 */
	public static CoreAnimatedPagesElement as(Element elem) {
		assert elem.getTagName().equalsIgnoreCase(TAG);
		return (CoreAnimatedPagesElement) elem;
	}

	protected CoreAnimatedPagesElement() {}

	public final native void setTransitions(String transitions) /*-{
		return this.transitions=transitions;
	}-*/;

	public final native String getTransitions() /*-{
		return this.transitions;
	}-*/;

	public final native void setLastSelected(String lastSelected) /*-{
		this.lastSelected = lastSelected;
	}-*/;

	public final native String getLastSelected() /*-{
		return this.lastSelected;
	}-*/;

	public final native void setBottomJustify(String middleJustify) /*-{
		this.bottomJustify = middleJustify;
	}-*/;

	public final native String getBottomJustify() /*-{
		return this.bottomJustify;
	}-*/;
}
