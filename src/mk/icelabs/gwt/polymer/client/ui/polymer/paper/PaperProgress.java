package mk.icelabs.gwt.polymer.client.ui.polymer.paper;

import mk.icelabs.gwt.polymer.client.dom.polymer.paper.PaperProgressElement;
import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreRange;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

public class PaperProgress extends CoreRange {

	
	
	public static final String STYLE = "";
	

	public PaperProgress() {
		this(Document.get().createElement(PaperProgressElement.TAG), STYLE);
	}

	protected PaperProgress(Element element, String styleName) {
		super(element, styleName);
		if (styleName != null && !styleName.equalsIgnoreCase(STYLE)) {
			styleName = STYLE + " " + styleName;
		}
		setStyleName(styleName);
	}

	public int getSecondaryProgress() {
		return getElement().getSecondaryProgress();
	}

	public void setSecondaryProgress(int value) {
		getElement().setSecondaryProgress(value);
	}

	public boolean isIndeterminate() {
		return getElement().isIndeterminate();
	}

	public void setIndeterminate(boolean status) {
		getElement().setIndeterminate(status);
	}

	@Override
	public PaperProgressElement getElement() {
		return super.getElement().cast();
	}
}
