package mk.icelabs.gwt.polymer.client.ui.polymer.paper;

import mk.icelabs.gwt.polymer.client.dom.polymer.paper.PaperInputElement;
import mk.icelabs.gwt.polymer.client.ui.widgets.SimpleContainer;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.TextBoxBase;

public class PaperInputDecorator extends SimpleContainer {

	public static final String STYLE = "";

	public PaperInputDecorator(TextBoxBase input) {
		this(input, Document.get().createElement("paper-input-decorator"), STYLE);
	}

	protected PaperInputDecorator(TextBoxBase input, Element element, String styleName) {
		super(true);
		setElement(element);
		setWidget(input);
		
		if (styleName != null && !styleName.equalsIgnoreCase(STYLE)) {
			styleName = STYLE + " " + styleName;
		}
		setStyleName(styleName);
	}
	
	@Override
	public TextBoxBase getWidget() {
		return (TextBoxBase) super.getWidget();
	}

	public String getLabel() {
		return getElement().getLabel();
	}

	public void setLabel(String lbl){
		getElement().setLabel(lbl);
	}

	public boolean isFloatingLabel() {
		return getElement().isFloatingLabel();
	}

	public void setFloatingLabel(boolean status) {
		getElement().setFloatingLabel(status);
	}
	
	public boolean isLabelVisible() {
		return getElement().hasAttribute("labelVisible");
	}

	public void setLabelVisible(boolean status) {
		getElement().setRemoveAttribute("labelVisible", status);
	}

	public void setDisabled(boolean status) {
		getElement().setDisabled(status);
	}

	public boolean isDisabled() {
		return getElement().isDisabled();
	}
	
	
	public void setInvalid(boolean status) {
		getElement().setRemoveAttribute("isInvalide", status);
	}

	public boolean isInvalid() {
		return getElement().hasAttribute("isInvalide");
	}
	
	public void setAutoValidate(boolean status) {
		getElement().setRemoveAttribute("autoValidate", status);
	}

	public boolean isAutoValidate() {
		return getElement().hasAttribute("autoValidate");
	}

	public void setError(String errMsg) {
		getElement().setAttribute("error", errMsg);
	}

	public String getError() {
		return getElement().getAttribute("error");
	}
	
	public String getValue(){
		return getWidget().getValue();
	}
	
	public void setValue(String val){
		getWidget().setValue(val);
	}
	
	public void validate() {
		callValidate(getElement());
	}
	
	public void updateLabelVisibility() {
		callUpdateLabelVisibility(getElement());
	}
	
	private final native String callValidate(JavaScriptObject jso) /*-{
		jso.validate();
	}-*/;

	private final native String callUpdateLabelVisibility(JavaScriptObject jso) /*-{
		jso.updateLabelVisibility();
	}-*/;
	
	
	public PaperInputElement getElement(){
		return super.getElement().cast();
	}

}
