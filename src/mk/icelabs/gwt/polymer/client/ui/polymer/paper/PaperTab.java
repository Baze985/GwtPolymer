package mk.icelabs.gwt.polymer.client.ui.polymer.paper;

import mk.icelabs.gwt.polymer.client.dom.polymer.paper.PaperTabElement;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.SimplePanel;

public class PaperTab extends SimplePanel {

	public static final String STYLE = "";

	
	public PaperTab() {
		this(Document.get().createElement(PaperTabElement.TAG), STYLE);
	}

	public PaperTab(Element element, String styleName) {
		super(element);
		if (styleName != null && !styleName.equalsIgnoreCase(STYLE)) {
			styleName = STYLE + " " + styleName;
		}
		setStyleName(styleName);
	}
	
	

	public boolean isNoink() {
		return getElement().isNoink();
	}

	public void setNoink(boolean status) {
		getElement().setNoink(status);
	}
	
	

	public boolean isFlex() {
		return getElement().hasAttribute("flex");
	}

	public void setFlex(boolean status) {
		if (status)
			getElement().setAttribute("flex", "");
		else
			getElement().removeAttribute("flex");
	}
	
	
	public String getLabel() {
		return getElement().getInnerText();
	}

	public void setLabel(String text) {
		getElement().setInnerText(text);
	}
	

	public PaperTabElement getElement() {
		return super.getElement().cast();
	}
	

}
