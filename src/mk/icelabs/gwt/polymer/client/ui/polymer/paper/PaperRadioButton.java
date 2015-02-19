package mk.icelabs.gwt.polymer.client.ui.polymer.paper;

import mk.icelabs.gwt.polymer.client.dom.polymer.paper.PaperRadioButtonElement;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

public class PaperRadioButton extends PaperCheckableBase {

	public static final String STYLE = "";

	public PaperRadioButton() {
		this(Document.get().createElement(PaperRadioButtonElement.TAG));
	}

	public PaperRadioButton(Element elem) {
		this(elem, STYLE);
	}

	public PaperRadioButton(Element element, String styleName) {
		super(element);
		if (styleName != null && !styleName.equalsIgnoreCase(STYLE)) {
			styleName = STYLE + " " + styleName;
		}
		setStyleName(styleName);
	}

	public String getLabel() {
		return getElement().getLabel();
	}

	public void setLabel(String lbl){
		getElement().setLabel(lbl);
	}

	public boolean isDisabled() {
		return getElement().isDisabled();
	}

	public void setDisabled(boolean status) {
		getElement().setDisabled(status);
	}

	public boolean isToggleable () {
		return getElement().isToggleable();
	}

	public void setToggleable (boolean status) {
		getElement().setToggleable(status);
	}

	public String getName() {
		return getElement().getName();
	}

	public void setName(String name) {
		getElement().setName(name);
	}

	@Override
	public PaperRadioButtonElement getElement() {
		return super.getElement().cast();
	}

}
