package mk.icelabs.gwt.polymer.client.ui.polymer.core;

import mk.icelabs.gwt.polymer.client.dom.polymer.core.CoreIconElement;
import mk.icelabs.gwt.polymer.client.ui.widgets.Component;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

public class CoreIcon extends Component {

	public static final String STYLE = "";

	protected CoreIcon(Element elem){
		setElement(elem);
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
