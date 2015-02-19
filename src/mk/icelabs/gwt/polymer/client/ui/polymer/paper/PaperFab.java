package mk.icelabs.gwt.polymer.client.ui.polymer.paper;

import mk.icelabs.gwt.polymer.client.dom.polymer.paper.PaperFabElement;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

public class PaperFab extends PaperIconButton {

	public static final String STYLE = "";

	public PaperFab() {
		this(Document.get().createElement(PaperFabElement.TAG), STYLE);
	}

	public PaperFab(Element element, String styleName){
		super(element, styleName);
	}

	@Override
	public PaperFabElement getElement() {
		return super.getElement().cast();
	}

}
