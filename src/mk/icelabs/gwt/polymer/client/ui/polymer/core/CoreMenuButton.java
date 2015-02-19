package mk.icelabs.gwt.polymer.client.ui.polymer.core;

import mk.icelabs.gwt.polymer.client.ui.widgets.Container;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

public class CoreMenuButton<T extends CoreItem> extends Container<Widget> {
	
	public CoreMenuButton() {
		this(Document.get().createElement("core-menu-button"));
	}

	protected CoreMenuButton(Element element) {
		setElement(element);
		
		add(createIconButton());		
	}
	

	public void setDropDown(CoreDropdown<T> dropDown) {
		if (getWidgetCount() > 1)
			getWidget(1).removeFromParent();
		
		dropDown.setStyleName("dropdown");	
		dropDown.getElement().setAttribute("layered", "true");
		add(dropDown);
	}
	
	
	@SuppressWarnings("unchecked")
	public CoreDropdown<T> getDropDown() {
		assert (getWidgetCount() > 1);
		
		return (CoreDropdown<T>) getWidget(1);
	}

	protected CoreFocusable createIconButton(){
		CoreIconButton iconButton = new CoreIconButton();
		iconButton.setIcon("menu");
		
		return iconButton;
	}
}
