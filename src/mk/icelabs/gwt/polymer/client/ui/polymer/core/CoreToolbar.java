package mk.icelabs.gwt.polymer.client.ui.polymer.core;

import mk.icelabs.gwt.polymer.client.dom.polymer.core.CoreToolbarElement;
import mk.icelabs.gwt.polymer.client.ui.widgets.ContainerExt;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

public class CoreToolbar extends ContainerExt<Widget> {

	public static final String STYLE = "";

	public static enum Justify{
		
		START, CENTER, END, BETWEEN, AROUND;
		
		String getValue(){
			return name().toLowerCase();
		}
	}
	
	public CoreToolbar() {
		this(Document.get().createElement(CoreToolbarElement.TAG), STYLE);
	}

	protected CoreToolbar(Element element, String styleName) {
		setElement(element);
		if (styleName != null && !styleName.equalsIgnoreCase(STYLE)) {
			styleName = STYLE + " " + styleName;
		}
		setStyleName(styleName);
	}
	
	public Justify getJustify() {
		return Justify.valueOf(getElement().getJustify());
	}

	public void setJustify(Justify justify) {
		getElement().setJustify(justify.getValue());
	}

	public Justify getMiddleJustify() {
		return Justify.valueOf(getElement().getMiddleJustify());
	}

	public void setMiddleJustify(Justify middleJustify) {
		getElement().setMiddleJustify(middleJustify.getValue());;
	}

	public Justify getBottomJustify() {
		return Justify.valueOf(getElement().getBottomJustify());
	}

	public void setBottomJustify(Justify bottomJustify) {
		getElement().setBottomJustify(getElement().getBottomJustify());
	}

	@Override
	public CoreToolbarElement getElement() {
		return super.getElement().cast();
	}
	

}
