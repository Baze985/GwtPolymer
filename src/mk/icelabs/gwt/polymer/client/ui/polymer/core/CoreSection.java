package mk.icelabs.gwt.polymer.client.ui.polymer.core;

import mk.icelabs.gwt.polymer.client.dom.polymer.core.CoreSectionElement;
import mk.icelabs.gwt.polymer.client.ui.widgets.ContainerExt;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

public class CoreSection extends ContainerExt<Widget> {

	public static final String STYLE = "";


	public CoreSection(Widget sectionWidget) {
		this(sectionWidget, Document.get().createElement(CoreSectionElement.TAG), STYLE);
	}

	protected CoreSection(Widget sectionWidget, Element element, String styleName) {
		setElement(element);
		add(sectionWidget);
		if (styleName != null && !styleName.equalsIgnoreCase(STYLE)) {
			styleName = STYLE + " " + styleName;
		}
		setStyleName(styleName);
	}


	public CoreSectionElement getElement() {
		return super.getElement().cast();
	}

}
