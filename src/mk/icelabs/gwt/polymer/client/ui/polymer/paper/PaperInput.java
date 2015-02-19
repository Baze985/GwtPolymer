package mk.icelabs.gwt.polymer.client.ui.polymer.paper;

import mk.icelabs.gwt.polymer.client.dom.polymer.paper.PaperInputElement;
import mk.icelabs.gwt.polymer.client.ui.widgets.Component;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

public class PaperInput extends Component {

	public static final String STYLE = "";

	public PaperInput() {
		this(Document.get().createElement(PaperInputElement.TAG), STYLE);
	}

	public PaperInput(Element element, String styleName) {
		setElement(element);
		if (styleName != null && !styleName.equalsIgnoreCase(STYLE)) {
			styleName = STYLE + " " + styleName;
		}
		setStyleName(styleName);
	}

	public void focus() {
		getElement().focus();
	}
	
	public String getLabel() {
		return getElement().getLabel();
	}

	public void setLabel(String lbl) {
		getElement().setLabel(lbl);
	}

	public boolean isFloatingLabel() {
		return getElement().isFloatingLabel();
	}

	public void setFloatingLabel(boolean status) {
		getElement().setFloatingLabel(status);
	}

	public final void setDisabled(boolean status) {
		getElement().setDisabled(status);
	};

	public final boolean isDisabled() {
		return getElement().isDisabled();
	};

	public final void setValue(String value) {
		getElement().setValue(value);
	};

	public final String getValue() {
		return getElement().getValue();
	};

	public final void setCommittedValue(String committedValue) {
		getElement().setCommittedValue(committedValue);
	};

	public final String getCommittedValue() {
		return getElement().getCommittedValue();
	}

	public PaperInputElement getElement() {
		return super.getElement().cast();
	}

}
