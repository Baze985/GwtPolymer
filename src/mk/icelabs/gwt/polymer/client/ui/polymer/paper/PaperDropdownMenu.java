package mk.icelabs.gwt.polymer.client.ui.polymer.paper;

import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreDropdown;
import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreDropdownMenu;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

public class PaperDropdownMenu extends CoreDropdownMenu<PaperItem> {
	
	public static final String STYLE = "";

	public PaperDropdownMenu() {
		this(Document.get().createElement("paper-dropdown-menu"), STYLE);
	}

	protected PaperDropdownMenu(Element element, String styleName) {
		super(element, styleName);
		
		if (styleName != null && !styleName.equalsIgnoreCase(STYLE)) {
			styleName = STYLE + " " + styleName;
		}
		setStyleName(styleName);
		
	}
	
	
	public PaperDropdown getDropDown() {
		return (PaperDropdown) super.getDropDown();
	}
	
	
	@Override
	protected CoreDropdown<PaperItem> checkAdoptInstance(Widget w) {
		assert (w instanceof PaperDropdown);
		
		return super.checkAdoptInstance(w);
		
	}
	

}
