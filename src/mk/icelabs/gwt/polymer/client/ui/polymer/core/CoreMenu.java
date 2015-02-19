package mk.icelabs.gwt.polymer.client.ui.polymer.core;

import mk.icelabs.gwt.polymer.client.dom.polymer.core.CoreMenuElement;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

public class CoreMenu extends CoreSelector<CoreItem> {

	public static final String STYLE = "";


	public CoreMenu() {
		this(Document.get().createElement(CoreMenuElement.TAG), STYLE);
	}

	protected CoreMenu(Element element, String styleName) {
		super(element);
		if (styleName != null && !styleName.equalsIgnoreCase(STYLE)) {
			styleName = STYLE + " " + styleName;
		}
		setStyleName(styleName);
	}



	@Override
	public CoreMenuElement getElement() {
		return (CoreMenuElement) super.getElement();
	}
	
	@Override
	protected CoreItem checkAdoptInstance(Widget w) {
		w = super.checkAdoptInstance(w);
		if (w instanceof CoreItem)
			return (CoreItem) w;
		
		throw new IllegalArgumentException("The chiled widget must be of type CoreItem");

	}

}
