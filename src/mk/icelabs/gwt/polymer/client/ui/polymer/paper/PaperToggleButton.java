package mk.icelabs.gwt.polymer.client.ui.polymer.paper;

import mk.icelabs.gwt.polymer.client.dom.polymer.paper.PaperToggleButtonElement;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

public class PaperToggleButton extends PaperCheckableBase {

	public static final String STYLE = "";

	protected PaperToggleButton(Element elem) {
		super(elem);
	}

	public PaperToggleButton() {
		this(Document.get().createElement(PaperToggleButtonElement.TAG), STYLE);
	}

	public PaperToggleButton(Element element, String styleName) {
		this(element);
		if (styleName != null && !styleName.equalsIgnoreCase(STYLE)) {
			styleName = STYLE + " " + styleName;
		}
		setStyleName(styleName);
	}

	@Override
	public PaperToggleButtonElement getElement() {
		return super.getElement().cast();
	}

}
