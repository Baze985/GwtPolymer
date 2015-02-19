package mk.icelabs.gwt.polymer.client.ui.polymer.paper;

import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreDropdown;
import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreFocusable;
import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreMenuButton;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

public class PaperMenuButton extends CoreMenuButton<PaperItem> {
	
	public PaperMenuButton() {
		this(Document.get().createElement("paper-menu-button"));
	}

	protected PaperMenuButton(Element element) {
		super(element);
			
	}

	public PaperDropdown getDropDown() {
		return (PaperDropdown) super.getDropDown();
	}

	@Override
	protected Widget checkAdoptInstance(Widget w) {
		if (w instanceof CoreDropdown)
			assert (w instanceof PaperDropdown);
		
		return super.checkAdoptInstance(w);
	}
	
	protected CoreFocusable createIconButton(){	
		PaperIconButton iconButton = new PaperIconButton();
		iconButton.setIcon("menu");
		
		return iconButton;
	}
}
