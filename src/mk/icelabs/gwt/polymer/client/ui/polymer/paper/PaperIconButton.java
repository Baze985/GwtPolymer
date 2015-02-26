package mk.icelabs.gwt.polymer.client.ui.polymer.paper;

import mk.icelabs.gwt.polymer.client.dom.polymer.paper.PaperIconButtonElement;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

public class PaperIconButton extends PaperButtonBase{

	public static final String STYLE = "";

	public PaperIconButton() {
		this(Document.get().createElement(PaperIconButtonElement.TAG), STYLE);
	}

	public PaperIconButton(Element element, String styleName){
		super(element);
		if (styleName != null && !styleName.equalsIgnoreCase(STYLE)) {
			styleName = STYLE + " " + styleName;
		}
		setStyleName(styleName);
	}

	public String getLabel() {
		return getElement().getInnerText();
	}

	public void setLabel(String lbl){
		getElement().setInnerText(lbl);
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

	public boolean isFill() {
		return getElement().isFill();
	}

	public void setFill(boolean status){
		getElement().setFill(status);
	}

	@Override
	public PaperIconButtonElement getElement() {
		return super.getElement().cast();
	}

}
