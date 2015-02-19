package mk.icelabs.gwt.polymer.client.ui.polymer.paper;

import mk.icelabs.gwt.polymer.client.dom.polymer.core.CoreFocusableElement;
import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreFocusable;

import com.google.gwt.dom.client.Element;

public class PaperButtonBase extends CoreFocusable{

	protected PaperButtonBase(Element elem) {
		super(elem);
	}

	public CoreFocusableElement getElement(){
		return super.getElement().cast();
	}

	public boolean isActive() {
		return getElement().isActive();
	}

	public void setActive(boolean status) {
		getElement().setActive(status);
	}

	public boolean isPressed() {
		return getElement().isPressed();
	}

	public void setPressed(boolean status) {
		getElement().setPressed(status);
	}

	public boolean isToggle() {
		return getElement().isToggle();
	}

	public void setToggle(boolean status) {
		getElement().setToggle(status);
	}

}
