package mk.icelabs.gwt.polymer.client.ui.polymer.core;

import mk.icelabs.gwt.polymer.client.dom.polymer.core.CoreIconButtonElement;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

public class CoreIconButton extends CoreFocusable {

	public static final String STYLE = "";

	protected CoreIconButton(Element elem){
		super(elem);
	}

	public CoreIconButton() {
		this(Document.get().createElement(CoreIconButtonElement.TAG), STYLE);
	}

	protected CoreIconButton(Element element, String styleName) {
		this(element);
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

	@Override
	public CoreIconButtonElement getElement() {
		return super.getElement().cast();
	}

}
