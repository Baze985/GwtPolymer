package mk.icelabs.gwt.polymer.client.ui.polymer.paper;

import mk.icelabs.gwt.polymer.client.dom.ElementBase;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.SimplePanel;

public class PaperSpiner extends SimplePanel {
	public static final String TAG = "paper-spinner";

	public static final String STYLE = "";

	
	public PaperSpiner() {
		this(Document.get().createElement(TAG), STYLE);
	}

	public PaperSpiner(Element element, String styleName) {
		super(element);
		if (styleName != null && !styleName.equalsIgnoreCase(STYLE)) {
			styleName = STYLE + " " + styleName;
		}
		setStyleName(styleName);
	}
	
	

	public boolean isActive() {
		return getElement().hasAttribute("active");
	}

	public void setActive(boolean status) {
		getElement().setRemoveAttribute("active", status);
	}
	

	
	public String getAlt() {
		return getElement().getAttribute("alt");
	}

	public void setAlt(String text) {
		getElement().setAttribute("alt", text);
	}
	

	public ElementBase getElement() {
		return super.getElement().cast();
	}
	

}
