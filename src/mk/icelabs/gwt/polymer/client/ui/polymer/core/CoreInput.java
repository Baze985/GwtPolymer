package mk.icelabs.gwt.polymer.client.ui.polymer.core;

import mk.icelabs.gwt.polymer.client.dom.polymer.core.CoreInputElement;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.TextBoxBase;

public class CoreInput extends TextBoxBase {

	public static final String STYLE = "";

	protected CoreInput(Element elem){
		super(elem);
	}

	public CoreInput() {
		this(Document.get().createElement(CoreInputElement.TAG), STYLE);
	}

	public CoreInput(Element element, String styleName) {
		this(element);
		if (styleName != null && !styleName.equalsIgnoreCase(STYLE)) {
			styleName = STYLE + " " + styleName;
		}
		setStyleName(styleName);
		
		// define it as a core input
		getElement().setAttribute("is", "core-input");
	}


	protected void commit() {
		getElement().commit();
	}

	public boolean isDisabled() {
		return getElement().isDisabled();
	}

	public void setDisabled(boolean status) {
		getElement().setDisabled(status);
	}

	public String getType() {
		return getElement().getType();
	}

	public boolean isReadOnly() {
		return getElement().isReadOnly();
	}

	public void setReadOnly(boolean status) {
		getElement().setReadOnly(status);
	}

	
	@Override
	public String getValue() {
		return getElement().getValue();
	}

	@Override
	public void setValue(String val) {
		getElement().setValue(val);
	}

	
	public CoreInputElement getElement() {
		return super.getElement().cast();
	}

}
