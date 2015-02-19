package mk.icelabs.gwt.polymer.client.ui.polymer.core;

import mk.icelabs.gwt.polymer.client.dom.polymer.core.CoreIconElement;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.ButtonBase;

public class CoreIcon extends ButtonBase {

	public static final String STYLE = "";

	protected CoreIcon(Element elem){
		super(elem);
	}

	public CoreIcon() {
		this(Document.get().createElement(CoreIconElement.TAG), STYLE);
	}

	protected CoreIcon(Element element, String styleName) {
		this(element);
		if (styleName != null && !styleName.equalsIgnoreCase(STYLE)) {
			styleName = STYLE + " " + styleName;
		}
		setStyleName(styleName);
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
	public CoreIconElement getElement() {
		return super.getElement().cast();
	}

}
