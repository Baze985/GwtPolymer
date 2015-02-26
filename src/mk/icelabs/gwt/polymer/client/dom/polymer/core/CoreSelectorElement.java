package mk.icelabs.gwt.polymer.client.dom.polymer.core;

import mk.icelabs.gwt.polymer.client.dom.ElementBase;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.TagName;

@TagName(CoreSelectorElement.TAG)
public class CoreSelectorElement extends ElementBase {

	public static final String TAG = "core-selector";

	/**
	 * Assert that the given {@link Element} is compatible with this class and
	 * automatically typecast it.
	 */
	public static CoreSelectorElement as(Element elem) {
		assert elem.getTagName().equalsIgnoreCase(TAG);
		return (CoreSelectorElement) elem;
	}

	protected CoreSelectorElement() {}

	public final native String getSelected() /*-{
		return this.selected;
	}-*/;

	public final native void setSelected(String selection) /*-{
		this.selected = selection;
	}-*/;

	public final native boolean isMulti() /*-{
		return this.multi;
	}-*/;

	public final native void setMulti(boolean status) /*-{
		this.multi = status;
	}-*/;

	public final native String getValueAttribute() /*-{
		return this.valueattr;
	}-*/;

	public final native void setValueAttribute(String attr) /*-{
		this.valueattr = attr;
	}-*/;

	public final native String getSelectedClass() /*-{
		return this.selectedClass;
	}-*/;

	public final native void setSelectedClass(String cls) /*-{
		this.selectedClass = cls;
	}-*/;

	public final native String getSelectedProperty() /*-{
		return this.selectedProperty;
	}-*/;

	public final native void setSelectedProperty(String prop) /*-{
		this.selectedProperty = prop;
	}-*/;

	public final native String getSelectedAttribute() /*-{
		return this.selectedAttribute;
	}-*/;

	public final native void setSelectedAttribute(String attr) /*-{
		this.selectedAttribute = attr;
	}-*/;

	public final native int getSelectedIndex() /*-{
		return this.selectedIndex;
	}-*/;

	public final native void setSelectedIndex(int index) /*-{
		this.selectedIndex = index;
	}-*/;

	public final native Element getTarget() /*-{
		return this.target;
	}-*/;

	public final native void setTarget(Element target) /*-{
		this.target = target;
	}-*/;

	public final native String getItemSelector() /*-{
		return this.itemSelector;
	}-*/;

	public final native void setItemSelector(String selector) /*-{
		this.itemSelector = selector;
	}-*/;

	public final native String getActivateEvent() /*-{
		return this.activateEvent;
	}-*/;

	public final native void setActivateEvent(String evt) /*-{
		this.activateEvent = evt;
	}-*/;

	public final native void setExcludedLocalNames(String tagNames) /*-{
		this.excludedLocalNames = tagNames;
	}-*/;

	public final native String getExcludedLocalNames() /*-{
		return this.excludedLocalNames;
	}-*/;

	public final native boolean isNotap() /*-{
		return this.notap;
	}-*/;

	public final native void setNotap(boolean status) /*-{
		this.notap = status;
	}-*/;

}
