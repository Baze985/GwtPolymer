package mk.icelabs.gwt.polymer.client.ui.polymer.core;

import mk.icelabs.gwt.polymer.client.ui.widgets.Container;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

public class CoreDropdownBase<T extends Widget> extends Container<T> {
	
	public CoreDropdownBase() {
		this(Document.get().createElement("core-dropdown-base"));
	}

	protected CoreDropdownBase(Element element) {
		setElement(element);
		
	}


	public boolean isOpened() {
		return getElement().hasAttribute("opened");
	}

	public void setOpened(boolean opened) {
		getElement().setAttribute("opened", "");
	}


}
