package mk.icelabs.gwt.polymer.client.ui.polymer.core;

import mk.icelabs.gwt.polymer.client.dom.polymer.core.CoreFocusableElement;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.FocusWidget;

public class CoreFocusable extends FocusWidget{

	protected CoreFocusable(Element elem) {
		super(elem);
	}

	public CoreFocusableElement getElement(){
		return super.getElement().cast();
	}

	public boolean isActive() {
		return getElement().isActive();
	}


	public void setFocused(boolean status) {
		getElement().setFocused(status);
	}

	
	public boolean isDisabled() {
		return getElement().isDisabled();
	}

	public void setDisabled(boolean status) {
		getElement().setDisabled(status);
	}

}
