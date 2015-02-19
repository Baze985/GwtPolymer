package mk.icelabs.gwt.polymer.client.ui.polymer.paper;

import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreOverlay;

import com.google.gwt.dom.client.Element;

public class PaperDialogBase extends CoreOverlay {

	public static final String STYLE = "";

	
//	protected PaperDialogBase() {
//		this(Document.get().createElement("paper-dialog-base"), STYLE);
//	}

	protected PaperDialogBase(Element element, String styleName) {
		super(element, styleName);
		if (styleName != null && !styleName.equalsIgnoreCase(STYLE)) {
			styleName = STYLE + " " + styleName;
		}
		setStyleName(styleName);
	}
	
	public String getHeading() {
		return getElement().getAttribute("heading");
	}

	public void setHeading(String text) {
		getElement().setAttribute("heading", text);
	}
	

}
