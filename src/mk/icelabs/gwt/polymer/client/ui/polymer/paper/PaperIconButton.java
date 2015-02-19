package mk.icelabs.gwt.polymer.client.ui.polymer.paper;

import mk.icelabs.gwt.polymer.client.dom.polymer.paper.PaperIconButtonElement;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

public class PaperIconButton extends PaperButton{

	public static final String STYLE = "";

	public PaperIconButton() {
		this(Document.get().createElement(PaperIconButtonElement.TAG), STYLE);
	}

	public PaperIconButton(Element element, String styleName){
		super(element, styleName);
	}

	public boolean isFill() {
		return getElement().isFill();
	}

	public void setFill(boolean status){
		getElement().setFill(status);
	}

	@Override
	public PaperIconButtonElement getElement() {
		return super.getElement().cast();
	}

}
