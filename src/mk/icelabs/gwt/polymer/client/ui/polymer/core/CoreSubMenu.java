package mk.icelabs.gwt.polymer.client.ui.polymer.core;

import mk.icelabs.gwt.polymer.client.dom.polymer.core.CoreItemElement;
import mk.icelabs.gwt.polymer.client.dom.polymer.core.CoreSubMenuElement;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

public class CoreSubMenu extends CoreItem{

	public static final String STYLE = "";
	
	public CoreSubMenu() {
		this(Document.get().createElement(CoreSubMenuElement.TAG), STYLE);
	}

	protected CoreSubMenu(Element element, String styleName) {
		super(element);
		
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
	
	@Override
	protected CoreItem checkAdoptInstance(Widget w) {
		w = super.checkAdoptInstance(w);
		if (w instanceof CoreItem)
			return (CoreItem) w;
		
		throw new IllegalArgumentException("The chiled widget must be of type CoreItem");

	}

}
