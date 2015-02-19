package mk.icelabs.gwt.polymer.client.ui.polymer.core;

import mk.icelabs.gwt.polymer.client.dom.polymer.core.CoreItemElement;
import mk.icelabs.gwt.polymer.client.ui.widgets.ContainerExt;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

public class CoreItem extends ContainerExt<Widget> {

	public static final String STYLE = "";

	public CoreItem() {
		this(Document.get().createElement(CoreItemElement.TAG), STYLE);
	}
	
	protected CoreItem(Element element) {
		setElement(element);
	}

	protected CoreItem(Element element, String styleName) {
		this(element);
		if (styleName != null && !styleName.equalsIgnoreCase(STYLE)) {
			styleName = STYLE + " " + styleName;
		}
		setStyleName(styleName);
	}

	public String getLabel() {
		return getElement().getLabel();
	}

	public void setLabel(String lbl) {
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
	public CoreItemElement getElement() {
		return super.getElement().cast();
	}

}
