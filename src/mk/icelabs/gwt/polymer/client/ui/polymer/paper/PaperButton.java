package mk.icelabs.gwt.polymer.client.ui.polymer.paper;

import mk.icelabs.gwt.polymer.client.dom.polymer.paper.PaperButtonElement;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

public class PaperButton extends PaperButtonBase {
	
	public static final String STYLE = "";

	public PaperButton() {
		this(Document.get().createElement(PaperButtonElement.TAG), STYLE);
	}

	public PaperButton(Element element, String styleName){
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

	public String getIconSrc() {
		return getElement().getIconSrc();
	}

	public void setIconSrc(String iconsrc) {
		getElement().setIconSrc(iconsrc);
	}

	public String getIcon() {
		return getElement().getIcon();
	}

	public void setIcon(String ico) {
		getElement().setIcon(ico);
	}

	public boolean isRaisedButton() {
		return getElement().isRaisedButton();
	}

	public void setRaisedButton(boolean status) {
		getElement().setRaisedButton(status);
	}

	@Override
	public PaperButtonElement getElement() {
		return super.getElement().cast();
	}

}
